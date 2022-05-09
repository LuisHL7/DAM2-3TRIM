# Paquetes Importados
from PyQt5 import QtWidgets, QtSql
import Eventos
from main_form import Ui_MainWindowMain


class Iniciar(QtWidgets.QMainWindow):
    def __init__(self, nombre):
        super().__init__()
        self.ventana_principal = Ui_MainWindowMain()
        self.ventana_principal.setupUi(self)
        # Mensaje de Bienvenida con el nombre del usuario que ingresó.
        self.ventana_principal.LbWelcome.setText('Bienvenido, ' + nombre)
        self.ventana_principal.LbWelcome2.setText('Bienvenido, ' + nombre)
        self.ventana_principal.LbWelcome3.setText('Bienvenido, ' + nombre)
        Eventos.horaActual(self)  # Muestra la hora actual en la barra de estado
        self.mostrarProductos()  # Muestra los datos de la BD en el QTableWidget
        self.ventana_principal.BtnSearch.clicked.connect(self.buscarProductos)

    def mostrarProductos(self):
        query = QtSql.QSqlQuery()
        query.prepare(
            'SELECT codigo, nombre, categoria, fecha_ingreso, cantidad, precio_costo, precio_venta, estado, proveedor '
            'FROM productos')
        if query.exec_():
            self.mostrarEnTabla(query)
        else:
            print("Error al mostrar los productos: ", query.lastError().text())

    def buscarProductos(self):
        query = QtSql.QSqlQuery()
        query.prepare(
            'SELECT codigo, nombre, categoria, fecha_ingreso, cantidad, precio_costo, precio_venta, estado, proveedor '
            'FROM productos WHERE codigo=:codigo')
        query.bindValue(':codigo', self.ventana_principal.TxtCode.text())
        if query.exec_():
            self.ventana_principal.cliTable.clearContents()
            self.mostrarEnTabla(query)
        else:
            print("Error al mostrar los productos customer: ", query.lastError().text())

    def mostrarEnTabla(self, query):
        index = 0
        while query.next():
            self.ventana_principal.cliTable.setRowCount(index + 1)
            self.ventana_principal.cliTable.setItem(index, 0, QtWidgets.QTableWidgetItem(str(query.value(0))))
            self.ventana_principal.cliTable.setItem(index, 1, QtWidgets.QTableWidgetItem(query.value(1)))
            self.ventana_principal.cliTable.setItem(index, 2, QtWidgets.QTableWidgetItem(query.value(2)))
            self.ventana_principal.cliTable.setItem(index, 3, QtWidgets.QTableWidgetItem(query.value(3)))
            self.ventana_principal.cliTable.setItem(index, 4, QtWidgets.QTableWidgetItem(str(query.value(4))))
            self.ventana_principal.cliTable.setItem(index, 5, QtWidgets.QTableWidgetItem(str(query.value(5))))
            self.ventana_principal.cliTable.setItem(index, 6, QtWidgets.QTableWidgetItem(str(query.value(6))))
            self.ventana_principal.cliTable.setItem(index, 7, QtWidgets.QTableWidgetItem(query.value(7)))
            self.ventana_principal.cliTable.setItem(index, 8, QtWidgets.QTableWidgetItem(query.value(8)))
            index += 1
