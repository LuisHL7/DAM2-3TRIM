from PyQt5 import QtWidgets

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

    def selSexo(self):
        try:
            global sex
            if var.ui.RbtMasculino.isChecked():
                sex = 'Hombre'
            if var.ui.RbtFemenino.isChecked():
                sex = 'Mujer'
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
            prov = ['', 'A Coruña', 'Lugo', 'Ourense', 'Pontevedra']
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

    def cargarFecha(qDate):
        try:
            data = ('{0}/{1}/{2}'.format(qDate.day(), qDate.month(), qDate.year()))
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
            var.sex = []
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
            newCli.append(vpro)
            var.pay2 = Customer.selPago()
            newCli.append(sex)
            newCli.append(var.pay2[0])
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
            #Customer.cleanCli(client, var.rbtSex, var.chkPago)
        except Exception as error:
            print('Error alta cliente: %s ' % str(error))

    def deleteClient(self):
        try:
            dni = var.ui.TxtDni.text()
            Conection.Conection.deleteCus(dni)
            Conection.Conection.showCustomers(self)
            Customer.cleanCustomer()
        except Exception as error:
            print('Error cargar clientes: %s ' % str(error))

    def updateClient(self):
        try:
            newData = []
            client = [var.ui.TxtDni, var.ui.TxtApellidos, var.ui.TxtNombre, var.ui.TxtFecha, var.ui.TxtDireccion]
            for i in client:
                newData.append(i.text())
            newData.append(var.ui.CmbProvincia.currentText())
            newData.append(var.sex)
            var.pay = Customer.selPago()
            print(var.pay)
            newData.append(var.pay)
            cod = var.ui.TxtCodigo.text()
            Conection.Conection.updateCli(cod, newData)
            Conection.Conection.showCustomers(self)
        except Exception as error:
            print('Error load customer:  %s ' %str(error))

    def searchCustomer(self):

