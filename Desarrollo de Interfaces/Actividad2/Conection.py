import self as self
from PyQt5 import QtWidgets, QtSql

import var


class Conection:

    def dbConnect(filename):

        db = QtSql.QSqlDatabase.addDatabase('QSQLITE')
        db.setDatabaseName(filename)
        if not db.open():
            QtWidgets.QMessageBox.critical(None, "No se puede abrir la base de datos",
                                           'No se puede establecer conexion.\n'
                                           'Haz click para cancelar.',
                                           QtWidgets.QMessageBox.Cancel)
            return False
        else:
            print('Conexion establecida')
        return True

    def loadCustomer(client):
        query = QtSql.QSqlQuery()
        query.prepare("INSERT INTO customer (dni, lastname, name, higthdate, address, province, sex, waytopay) "
                      "VALUES ( :dni, :lastname, :nombre, :higthdate, :address, :province, :sex, :waytopay)")
        query.bindValue(':dni', str(client[0]))
        query.bindValue(':lastname', str(client[1]))
        query.bindValue(':nombre', str(client[2]))
        query.bindValue(':higthdate', str(client[3]))
        query.bindValue(':address', str(client[4]))
        query.bindValue(':province', str(client[5]))
        query.bindValue(':sex', str(client[6]))
        query.bindValue(':waytopay', str(client[7]))
        if query.exec_():
            print("Insercion correcta")
            Conection.showCustomers(self)
        else:
            print("Error al insertar: ", query.lastError().text())

    def showCustomers(self):
        index = 0
        query = QtSql.QSqlQuery()
        query.prepare('SELECT dni, lastname, name, higthdate, address, province, sex, waytopay FROM customer')
        if query.exec_():
            while query.next():
                dni = query.value(0)
                lastname = query.value(1)
                name = query.value(2)
                higthdate = query.value(3)
                address = query.value(4)
                province = query.value(5)
                sex = query.value(6)
                waytopay = query.value(7)
                var.ui.cliTable.setRowCount(index + 1)
                var.ui.cliTable.setItem(index, 0, QtWidgets.QTableWidgetItem(dni))
                var.ui.cliTable.setItem(index, 1, QtWidgets.QTableWidgetItem(lastname))
                var.ui.cliTable.setItem(index, 2, QtWidgets.QTableWidgetItem(name))
                var.ui.cliTable.setItem(index, 3, QtWidgets.QTableWidgetItem(higthdate))
                var.ui.cliTable.setItem(index, 4, QtWidgets.QTableWidgetItem(address))
                var.ui.cliTable.setItem(index, 5, QtWidgets.QTableWidgetItem(province))
                var.ui.cliTable.setItem(index, 6, QtWidgets.QTableWidgetItem(sex))
                var.ui.cliTable.setItem(index, 7, QtWidgets.QTableWidgetItem(waytopay))
                index += 1
        else:
            print("Error show customer: ", query.lastError().text())
