from datetime import datetime
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
            Conection.showCustomers()
            var.ui.LblStatus.setText('Customer with dni ' + str(client[0]) + ' inserted')
        else:
            print("Error al insertar: ", query.lastError().text())

    def importDataFromExcel(file_name, pd):
        df = pd.read_excel(file_name)
        if df.size == 0:
            return print("El archivo está vació.")
        for row in df.itertuples():
            newClient = [row.DNI, row.LASTNAME, row.NAME,  str(datetime.date(row.HIGTHDATE))[:18], row.ADDRESS, row.PROVINCE, row.SEX, row.WAYTOPAY]
            print("first", newClient)
            Conection.loadCustomer(newClient)

    def exportBDtoZip(file_name, pd):
        import zipfile
        jungle_zip = zipfile.ZipFile(str(file_name)+'.zip', 'w')
        jungle_zip.write(str(file_name), compress_type=zipfile.ZIP_DEFLATED)
        var.ui.LblStatus.setText('Information: The file was exported in a zip correctly')
        jungle_zip.close()

    def showCustomers():
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

    def updateCli(code, newData):
        query = QtSql.QSqlQuery()
        code = int(code)
        query.prepare('UPDATE CUSTOMER SET  dni=:dni, lastname=:lastname, name=:name, higthdate=:higthdate,'
                      'address=:address, province=:province, sex=:sex, waytopay=:waytopay WHERE codigo=:codigo')
        query.bindValue(':codigo', int(code))
        Conection.loadData(query, newData)
        if query.exec_():
            print('Customer modify')
            var.ui.LblStatus.setText('Customer with dni ' + str(newData[0]) + ' updated')
        else:
            print('Error updating customers: ', query.lastError().text())

    def deleteCus(dni):
        query = QtSql.QSqlQuery()
        query.prepare('delete from customer where dni =:dni')
        query.bindValue(':dni', dni)
        if query.exec_():
            print('Customer delete')
            var.ui.LblStatus.setText('Customer with dni ' + dni + ' has been deleted')
        else:
            print("Error displaying customers: ", query.lastError().text())

    def loadData(query, newData):
        query.bindValue(':dni', str(newData[0]))
        query.bindValue(':lastname', str(newData[1]))
        query.bindValue(':name', str(newData[2]))
        query.bindValue(':higthdate', str(newData[3]))
        query.bindValue(':address', str(newData[4]))
        query.bindValue(':province', str(newData[5]))
        query.bindValue(':sex', str(newData[6]))
        query.bindValue(':waytopay', str(newData[7]))
