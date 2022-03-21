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
                      "VALUES ( :dni, :lastname, :name, :higthdate, :address, :province, :sex, :waytopay)")
        Conection.loadData(query, client)
        if query.exec_():
            print("Insercion correcta")
            Conection.showCustomers(self)
        else:
            print("Error al insertar: ", query.lastError().text())

    def showCustomers(self):
        index = 0
        query = QtSql.QSqlQuery()
        query.prepare('SELECT codigo, dni, lastname, name, higthdate, address, province, sex, waytopay FROM customer')
        if query.exec_():
            while query.next():
                codigo = query.value(0)
                dni = query.value(1)
                lastname = query.value(2)
                name = query.value(3)
                higthdate = query.value(4)
                address = query.value(5)
                province = query.value(6)
                sex = query.value(7)
                waytopay = query.value(8)
                var.ui.cliTable.setRowCount(index + 1)
                var.ui.cliTable.setItem(index, 0, QtWidgets.QTableWidgetItem(str(codigo)))
                var.ui.cliTable.setItem(index, 1, QtWidgets.QTableWidgetItem(dni))
                var.ui.cliTable.setItem(index, 2, QtWidgets.QTableWidgetItem(lastname))
                var.ui.cliTable.setItem(index, 3, QtWidgets.QTableWidgetItem(name))
                var.ui.cliTable.setItem(index, 4, QtWidgets.QTableWidgetItem(higthdate))
                var.ui.cliTable.setItem(index, 5, QtWidgets.QTableWidgetItem(address))
                var.ui.cliTable.setItem(index, 6, QtWidgets.QTableWidgetItem(province))
                var.ui.cliTable.setItem(index, 7, QtWidgets.QTableWidgetItem(sex))
                var.ui.cliTable.setItem(index, 8, QtWidgets.QTableWidgetItem(waytopay))
                index += 1
        else:
            print("Error show customer: ", query.lastError().text())

    def deleteCli(dni):
        query = QtSql.QSqlQuery()
        query.prepare('delete from customer where dni =:dni')
        query.bindValue(':dni', dni)
        if query.exec_():
            print('Customer delete')
            var.ui.lblStatus.setText('Customer with dni' + dni + 'has been deleted')
        else:
            print("Error displaying customers: ", query.lastError().text())

    def updateCli(code, newData):
        query = QtSql.QSqlQuery()
        code =int(code)
        query.prepare('UPDATE CUSTOMER SET  dni=:dni, lastname=:lastname, name=:name, higthdate=:highdate,'
                      'address=:address, province=:province, sex=:sex, waytopay=:waytopay WHERE codigo=:codigo')
        query.bindValue(':codigo', int(code))
        Conection.loadData(query, newData)
        if query.exec_():
            print('Customer modify')
            var.ui.lblStatus.setText('Customer with dni ' + str(newData[0]) + 'updated')
        else:
            print('Error updating customers: ', query.lastError().text())

    def loadData(query, newData):
        query.bindValue(':dni', str(newData[0]))
        query.bindValue(':lastname', str(newData[1]))
        query.bindValue(':name', str(newData[2]))
        query.bindValue(':higthdate', str(newData[3]))
        query.bindValue(':address', str(newData[4]))
        query.bindValue(':province', str(newData[5]))
        query.bindValue(':sex', str(newData[6]))
        query.bindValue(':waytopay', str(newData[7]))


