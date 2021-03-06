from PyQt5 import QtWidgets, QtSql
from tkinter import *
from tkinter import messagebox as MessageBox
import win32api
import Conection
import var


class Customer():
    def verifyDni():
        try:
            dni = var.ui.TxtDni.text()
            var.ui.TxtDni.setText(dni.upper())
            table = 'TRWAGMYFPDXBNJZSQVHLCKE'  # letter DNI
            dig_ext = 'XYZ'
            ree_dig_ext = {'X': '0', 'Y': '1', 'Z': '2'}
            numbers = '1234567890'
            dni = dni.upper()
            if len(dni) == 9:
                dig_control = dni[8]
                dni = dni[:8]
                if dni[0] in dig_ext:
                    dni = dni.replace(dni[0], ree_dig_ext[dni[0]])
                if len(dni) == len([n for n in dni if n in numbers]) and table[int(dni) % 23] == dig_control:
                    var.ui.LbValidar.setStyleSheet('QLabel {color: green;}')
                    var.ui.LbValidar.setText('V')
                else:
                    var.ui.LbValidar.setStyleSheet('QLabel {color: red;}')
                    var.ui.LbValidar.setText('X')
            else:
                var.ui.LbValidar.setStyleSheet('QLabel {color: red;}')
                var.ui.LbValidar.setText('X')
        except Exception as error:
            print('ERROR: Method verify DNI', error)

    def selSexo():
        try:
            if var.ui.RbtMasculino.isChecked():
                var.sex = 'HOMBRE'
            if var.ui.RbtFemenino.isChecked():
                var.sex = 'MUJER'
            return var.sex
        except Exception as error:
            print('Error en módulo seleccionar sexo:', error)

    def selPago():
        try:
            var.pay = []
            for i, data in enumerate(var.ui.ChkPago.buttons()):
                if data.isChecked() and i == 0:
                    var.pay.append('Tarjeta')
                if data.isChecked() and i == 1:
                    var.pay.append('Efectivo')
                if data.isChecked() and i == 2:
                    var.pay.append('Transferencia')
            return var.pay
        except Exception as error:
            print('Error: %s ' % str(error))

    def cargarProv():
        ''' Solución provisional, más adelante lo haremos con una BD'''
        try:
            prov = ['', 'A CORUÑA', 'LUGO', 'OURENSE', 'PONTEVEDRA']
            for i in prov:
                var.ui.CmbProvincia.addItem(i)
        except Exception as error:
            print('Error: %s ' % str(error))

        # Abrir la ventana calendario

    def abrirCalendar():
        try:
            var.dlgCalendar.show()
        except Exception as error:
            print('Error: %s ' % str(error))

        # Este módulo se ejecuta cuando clickeamos es un día del calendar, es decir,
        # cliclekd.connect de calendar.

    def cargarFecha(self):
        try:
            data = ('{0}-{1}-{2}'.format(self.day(), self.month(), self.year()))
            var.ui.TxtFecha.setText(str(data))
            var.dlgCalendar.hide()
        except Exception as error:
            print('Error cargar fecha: %s' % str(error))

    def selProv(prov):
        try:
            global vpro
            vpro = prov
        except Exception as error:
            print('Error: %s ' % str(error))

    def highClients():
        try:
            # Preparamos el registro
            newCli = []
            cliTab = []  # serán los datos que carguemos de la tabla.
            client = [var.ui.TxtDni, var.ui.TxtApellidos, var.ui.TxtNombre, var.ui.TxtFecha, var.ui.TxtDireccion]
            k = 0
            for i in client:
                newCli.append(i.text())
                # carguemos los valores para la tabla que solo tiene tres DNI, apellidos y nombre
                if k < 3:
                    cliTab.append(i.text())
                    k += 1
            newCli.append(var.ui.CmbProvincia.currentText())
            var.sex = Customer.selSexo()
            newCli.append(var.sex)
            var.pay = Customer.selPago()
            newCli.append(var.pay[0])
            if client:
                # Comprobamos que no esté vacía la principal
                # Aquí empieza como trabajar con la TableWidget
                row = 0  # posicion de la fila, problema: coloca al último como primero en cada click
                column = 0  # posición de la columna
                var.ui.cliTable.insertRow(row)
                for registro in cliTab:
                    cell = QtWidgets.QTableWidgetItem(registro)
                    var.ui.cliTable.setItem(row, column, cell)
                    column += 1

                Conection.Conection.loadCustomer(newCli)
            else:
                print('Faltan datos')
            Customer.cleanCustomer()
        except Exception as error:
            print('Error alta cliente: %s ' % str(error))

    def updateClient(self):
        try:
            new_data = []
            client = [var.ui.TxtDni, var.ui.TxtApellidos, var.ui.TxtNombre, var.ui.TxtFecha, var.ui.TxtDireccion]
            for i in client:
                new_data.append(i.text())
            new_data.append(var.ui.CmbProvincia.currentText())
            var.sex = Customer.selSexo()
            new_data.append(var.sex)
            new_data.append(var.pay[0])
            cod = var.ui.TxtCodigo.text()
            Conection.Conection.updateCli(cod, new_data)
            Conection.Conection.showCustomers()
            Customer.cleanCustomer()
        except Exception as error:
            print('Error update customer:  %s ' % str(error))

    def deleteClient(self):
        try:
            dni = var.ui.TxtDni.text()
            Conection.Conection.deleteCus(dni)
            Conection.Conection.showCustomers()
            Customer.cleanCustomer()
        except Exception as error:
            print('Error cargar clientes: %s ' % str(error))

    def searchCustomer():
        cont = 0
        query = QtSql.QSqlQuery()
        query.prepare(
            'SELECT codigo, dni, lastname, name, higthdate, address, province, sex, waytopay FROM customer WHERE dni '
            '=:dni')
        query.bindValue(':dni', var.ui.TxtDni.text())
        if query.exec_():
            while query.next():
                var.ui.TxtCodigo.setText(str(query.value(0)))
                var.ui.TxtDni.setText(query.value(1))
                var.ui.TxtApellidos.setText(str(query.value(2)))
                var.ui.TxtNombre.setText(str(query.value(3)))
                var.ui.TxtFecha.setText(str(query.value(4)))
                var.ui.TxtDireccion.setText(str(query.value(5)))
                var.ui.CmbProvincia.setCurrentText(str(query.value(6)).upper())
                if str(query.value(7)).upper() == 'HOMBRE':
                    var.ui.RbtMasculino.setChecked(True)
                else:
                    var.ui.RbtFemenino.setChecked(True)
                if str(query.value(8)) == 'Efectivo':
                    var.ui.ChkEfectivo.setChecked(True)
                elif str(query.value(8)) == 'Transferencia':
                    var.ui.ChkTransferencia.setChecked(True)
                else:
                    var.ui.ChkTarjeta.setChecked(True)
                cont += 1
            if cont == 0:
                win32api.MessageBox(0, "El dni ingresado es incorrecto", "Error")
        else:
            print("Error search customer: ", query.lastError().text())

    def cleanCustomer():
        var.ui.TxtCodigo.setText("")
        var.ui.TxtDni.setText("")
        var.ui.TxtApellidos.setText("")
        var.ui.TxtNombre.setText("")
        var.ui.TxtFecha.setText("")
        var.ui.TxtDireccion.setText("")
        var.ui.CmbProvincia.setCurrentText("")
        Conection.Conection.showCustomers()
