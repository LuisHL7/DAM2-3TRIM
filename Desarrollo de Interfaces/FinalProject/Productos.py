# Paquetes Importados
import win32api
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
        self.cargarCampos()
        Eventos.horaActual(self)  # Muestra la hora actual en la barra de estado
        self.mostrarProductos()  # Muestra los datos de la BD en el QTableWidget
        self.ventana_principal.CbSearch.currentTextChanged.connect(self.campoDeBusqueda)
        self.ventana_principal.BtnSearch.clicked.connect(self.campoDeConsulta)
        # self.llenarEspacioTabla()

    def llenarEspacioTabla(self):
        for i in range(self.ventana_principal.cliTable.horizontalHeader().count()):
            self.ventana_principal.cliTable.horizontalHeader().setSectionResizeMode(i, QtWidgets.QHeaderView.Stretch)
            self.ventana_principal.cliTable.show()

    def campoDeBusqueda(self):
        self.ventana_principal.TxtCode.setText('')
        if self.ventana_principal.CbSearch.currentText() == "CODIGO":
            self.ventana_principal.TxtCode.setPlaceholderText("Ingrese el código")
        elif self.ventana_principal.CbSearch.currentText() == "NOMBRE":
            self.ventana_principal.TxtCode.setPlaceholderText("Ingrese el nombre")
        elif self.ventana_principal.CbSearch.currentText() == "CATEGORIA":
            self.ventana_principal.TxtCode.setPlaceholderText("Ingrese la categoría")
        elif self.ventana_principal.CbSearch.currentText() == "ESTADO":
            self.ventana_principal.TxtCode.setPlaceholderText("Ingrese el estado")
        elif self.ventana_principal.CbSearch.currentText() == "PROVEEDOR":
            self.ventana_principal.TxtCode.setPlaceholderText("Ingrese el proveedor")

    def campoDeConsulta(self):
        if self.ventana_principal.CbSearch.currentText() == "CODIGO":
            self.buscarProductosPorCodigo()
        elif self.ventana_principal.CbSearch.currentText() == "NOMBRE":
            self.buscarProductosPorNombre()
        elif self.ventana_principal.CbSearch.currentText() == "CATEGORIA":
            self.buscarProductosPorCategoria()
        elif self.ventana_principal.CbSearch.currentText() == "ESTADO":
            self.buscarProductosPorEstado()
        elif self.ventana_principal.CbSearch.currentText() == "PROVEEDOR":
            self.buscarProductosPorProveedor()

    def cargarCampos(self):
        try:
            campos = ['CODIGO', 'NOMBRE', 'CATEGORIA', 'ESTADO', 'PROVEEDOR']
            for i in campos:
                self.ventana_principal.CbSearch.addItem(i)
            self.ventana_principal.CbSearch.setCurrentIndex(-1)
        except Exception as error:
            print('Error al cargar el combo box de los campos de búsqueda: %s ' % str(error))

    def mostrarProductos(self):
        query = QtSql.QSqlQuery()
        query.prepare(
            'SELECT codigo, nombre, categoria, fecha_ingreso, cantidad, precio_costo, precio_venta, estado, proveedor '
            'FROM productos')
        if query.exec_():
            self.mostrarEnTabla(query)
        else:
            print("Error al mostrar los productos: ", query.lastError().text())

    def buscarProductosPorCodigo(self):
        query = QtSql.QSqlQuery()
        query.prepare(
            'SELECT codigo, nombre, categoria, fecha_ingreso, cantidad, precio_costo, precio_venta, estado, proveedor '
            'FROM productos WHERE codigo=:codigo')
        query.bindValue(':codigo', self.ventana_principal.TxtCode.text())
        if query.exec_():
            self.ventana_principal.cliTable.clearContents()
            self.mostrarEnTabla(query)
        else:
            print("Error al mostrar los productos por código: ", query.lastError().text())

    def buscarProductosPorNombre(self):
        query = QtSql.QSqlQuery()
        query.prepare(
            'SELECT codigo, nombre, categoria, fecha_ingreso, cantidad, precio_costo, precio_venta, estado, proveedor '
            'FROM productos WHERE nombre LIKE :nombre')
        query.bindValue(':nombre', self.ventana_principal.TxtCode.text()+"%")
        if query.exec_():
            self.ventana_principal.cliTable.clearContents()
            self.mostrarEnTabla(query)
        else:
            print("Error al mostrar los productos por nombre: ", query.lastError().text())

    def buscarProductosPorCategoria(self):
        query = QtSql.QSqlQuery()
        query.prepare(
            'SELECT codigo, nombre, categoria, fecha_ingreso, cantidad, precio_costo, precio_venta, estado, proveedor '
            'FROM productos WHERE categoria LIKE :categoria')
        query.bindValue(':categoria', self.ventana_principal.TxtCode.text()+"%")
        if query.exec_():
            self.ventana_principal.cliTable.clearContents()
            self.mostrarEnTabla(query)
        else:
            print("Error al mostrar los productos por categoría: ", query.lastError().text())

    def buscarProductosPorEstado(self):
        query = QtSql.QSqlQuery()
        query.prepare(
            'SELECT codigo, nombre, categoria, fecha_ingreso, cantidad, precio_costo, precio_venta, estado, proveedor '
            'FROM productos WHERE estado LIKE :estado')
        query.bindValue(':estado', self.ventana_principal.TxtCode.text()+"%")
        if query.exec_():
            self.ventana_principal.cliTable.clearContents()
            self.mostrarEnTabla(query)
        else:
            print("Error al mostrar los productos por categoría: ", query.lastError().text())

    def buscarProductosPorProveedor(self):
        query = QtSql.QSqlQuery()
        query.prepare(
            'SELECT codigo, nombre, categoria, fecha_ingreso, cantidad, precio_costo, precio_venta, estado, proveedor '
            'FROM productos WHERE proveedor LIKE :proveedor')
        query.bindValue(':proveedor', self.ventana_principal.TxtCode.text()+"%")
        if query.exec_():
            self.ventana_principal.cliTable.clearContents()
            self.mostrarEnTabla(query)
        else:
            print("Error al mostrar los productos por categoría: ", query.lastError().text())

    def mostrarEnTabla(self, query):
        index = 0
        cont = 0
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
            cont += 1
        if cont == 0:
            win32api.MessageBox(0, "El valor ingresado no existe. Por favor, ingrese un valor existente.", "Error")
