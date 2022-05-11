# Paquetes Importados
import self as self
import win32api
from PyQt5 import QtWidgets, QtSql, QtCore
from PyQt5.QtCore import Qt

import Eventos
import var
from datetime import datetime
from main_form import Ui_MainWindowMain

# Clase que inicializa la ventana principal a la cual se accede después de introducir el usuario y contraseña correctos.
from windowsCalendarL import Ui_Dialog


class Iniciar(QtWidgets.QMainWindow):
    def __init__(self, nombre):
        super().__init__()
        self.ventana_principal = Ui_MainWindowMain()
        self.ventana_principal.setupUi(self)
        # Mensaje de Bienvenida con el nombre del usuario que ingresó.
        self.ventana_principal.LbWelcome.setText('Bienvenido, ' + nombre)
        self.ventana_principal.LbWelcome2.setText('Bienvenido, ' + nombre)
        self.ventana_principal.LbWelcome3.setText('Bienvenido, ' + nombre)
        # Cargar Datos
        self.cargarCampos()  # Cargando el QcomboBox
        self.cargarCategoria()
        self.cargarProveedor()
        Eventos.horaActual(self)  # Muestra la hora actual en la barra de estado
        self.mostrarProductos()  # Muestra los datos de la BD en el QTableWidget
        var.dialogo_fecha = Fecha()  # Asignando la clase Fecha a la variable global dialogo_fecha
        # Botones
        self.ventana_principal.CbSearch.currentTextChanged.connect(self.campoDeBusqueda)
        self.ventana_principal.BtnSearch.clicked.connect(self.campoDeConsulta)
        self.ventana_principal.BtnSearch_2.clicked.connect(self.buscarProducto)
        self.ventana_principal.BtnClean.clicked.connect(self.limpiarValores)
        self.ventana_principal.BtnClose.clicked.connect(Eventos.salir)
        self.ventana_principal.BtnCalendar.clicked.connect(Eventos.abrirCalendario)

    # Función que de acuerdo a la opción que elijas en el QComboBox te mostrará un texto dentro del LineEdit.
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

    # Función que de acuerdo a la opción que elijas en el QComboBox te mostrará los datos obtenidos en el QTableWidget.
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

    def eligeEstado(self):
        estado = ""
        try:
            if self.ventana_principal.RbAvailable.isChecked():
                estado = 'DISPONIBLE'
            if self.ventana_principal.RbNotAvailable.isChecked():
                estado = 'NO DISPONIBLE'
            return estado
        except Exception as error:
            print('Error al seleccionar el estado:', error)

    # Cargar Datos
    # Función que carga valores dentro del QComboBox
    def cargarCampos(self):
        try:
            campos = ['CODIGO', 'NOMBRE', 'CATEGORIA', 'ESTADO', 'PROVEEDOR']
            for i in campos:
                self.ventana_principal.CbSearch.addItem(i)
            self.ventana_principal.CbSearch.setCurrentIndex(-1)  # No muestra ningún valor inicial.
        except Exception as error:
            print('Error al cargar el QComboBox de los campos de búsqueda: %s ' % str(error))

    def cargarCategoria(self):
        try:
            campos = ['CEREALES', 'LEGUMBRES', 'VERDURAS', 'LECHE', 'PATATAS', 'DULCES', 'GALLETAS', 'LECHE']
            for i in campos:
                self.ventana_principal.CbCategory.addItem(i)
            self.ventana_principal.CbCategory.setCurrentIndex(-1)  # No muestra ningún valor inicial.
        except Exception as error:
            print('Error al cargar el QComboBox de las categorías: %s ' % str(error))

    def cargarProveedor(self):
        try:
            campos = ['ALTEZA', 'GLORIA', 'LA HACIENDA', 'GALLO', 'NUTRIBÉN', 'COLA-CAO', 'NESTLE', 'GULLÓN',
                      'HACENDADO']
            for i in campos:
                self.ventana_principal.CbSupplier.addItem(i)
            self.ventana_principal.CbSupplier.setCurrentIndex(-1)  # No muestra ningún valor inicial.
        except Exception as error:
            print('Error al cargar el QComboBox de los proveedores: %s ' % str(error))

    # Operaciones CRUD PRODUCTOS
    # Consultas
    # Función que muestra en el QTableWidget todos los productos que hay en la BD.
    def mostrarProductos(self):
        query = QtSql.QSqlQuery()
        query.prepare(
            'SELECT codigo, nombre, categoria, fecha_ingreso, cantidad, precio_costo, precio_venta, estado, proveedor '
            'FROM productos')
        if query.exec_():
            self.mostrarEnTabla(query)
        else:
            print("Error al mostrar los productos: ", query.lastError().text())

    # Función que busca por un código un determinado registro.
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

    # Función que consulta por como comienza el nombre o la totalidad del mismo y que devuelve el registro o los
    # registro que coincidan.
    def buscarProductosPorNombre(self):
        query = QtSql.QSqlQuery()
        query.prepare(
            'SELECT codigo, nombre, categoria, fecha_ingreso, cantidad, precio_costo, precio_venta, estado, proveedor '
            'FROM productos WHERE nombre LIKE :nombre')
        query.bindValue(':nombre', self.ventana_principal.TxtCode.text() + "%")
        if query.exec_():
            self.ventana_principal.cliTable.clearContents()
            self.mostrarEnTabla(query)
        else:
            print("Error al mostrar los productos por nombre: ", query.lastError().text())

    # Función que consulta por como comienza la categoría o la totalidad del mismo y que devuelve el registro o los
    # registro que coincidan.
    def buscarProductosPorCategoria(self):
        query = QtSql.QSqlQuery()
        query.prepare(
            'SELECT codigo, nombre, categoria, fecha_ingreso, cantidad, precio_costo, precio_venta, estado, proveedor '
            'FROM productos WHERE categoria LIKE :categoria')
        query.bindValue(':categoria', self.ventana_principal.TxtCode.text() + "%")
        if query.exec_():
            self.ventana_principal.cliTable.clearContents()
            self.mostrarEnTabla(query)
        else:
            print("Error al mostrar los productos por categoría: ", query.lastError().text())

    # Función que consulta por como comienza el estado o la totalidad del mismo y que devuelve el registro o los
    # registro que coincidan.
    def buscarProductosPorEstado(self):
        query = QtSql.QSqlQuery()
        query.prepare(
            'SELECT codigo, nombre, categoria, fecha_ingreso, cantidad, precio_costo, precio_venta, estado, proveedor '
            'FROM productos WHERE estado LIKE :estado')
        query.bindValue(':estado', self.ventana_principal.TxtCode.text() + "%")
        if query.exec_():
            self.ventana_principal.cliTable.clearContents()
            self.mostrarEnTabla(query)
        else:
            print("Error al mostrar los productos por categoría: ", query.lastError().text())

    # Función que consulta por como comienza el nombre del proveedor o la totalidad del mismo y que devuelve el
    # registro o los registro que coincidan.
    def buscarProductosPorProveedor(self):
        query = QtSql.QSqlQuery()
        query.prepare(
            'SELECT codigo, nombre, categoria, fecha_ingreso, cantidad, precio_costo, precio_venta, estado, proveedor '
            'FROM productos WHERE proveedor LIKE :proveedor')
        query.bindValue(':proveedor', self.ventana_principal.TxtCode.text() + "%")
        if query.exec_():
            self.ventana_principal.cliTable.clearContents()
            self.mostrarEnTabla(query)
        else:
            print("Error al mostrar los productos por categoría: ", query.lastError().text())

    # Función que se encarga de llenar el QTableWidget con los valores que se obtienen de la BD.
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

    # Función que busca un producto por su id y carga las cajas de texto con sus datos.
    def buscarProducto(self):
        cont = 0
        query = QtSql.QSqlQuery()
        query.prepare(
            'SELECT codigo, nombre, categoria, fecha_ingreso, cantidad, precio_costo, precio_venta, estado, proveedor '
            'FROM productos WHERE codigo=:codigo')
        query.bindValue(':codigo', self.ventana_principal.TxtId.text())
        if query.exec_():
            while query.next():
                self.ventana_principal.TxtId.setText(str(query.value(0)))
                self.ventana_principal.TxtName.setText(query.value(1))
                self.ventana_principal.CbCategory.setCurrentText(str(query.value(2)).upper())
                self.ventana_principal.TxtDate.setText(str(query.value(3)))
                self.ventana_principal.TxtStock.setText(str(query.value(4)))
                self.ventana_principal.TxtPriceC.setText(str(query.value(5)))
                self.ventana_principal.TxtPriceV.setText(str(query.value(6)))
                if str(query.value(7)).upper() == 'DISPONIBLE':
                    self.ventana_principal.RbAvailable.setChecked(True)
                    self.ventana_principal.RbNotAvailable.setChecked(False)
                else:
                    self.ventana_principal.RbNotAvailable.setChecked(True)
                    self.ventana_principal.RbAvailable.setChecked(False)
                self.ventana_principal.CbSupplier.setCurrentText(str(query.value(8)).upper())
                cont += 1
            if cont == 0:
                win32api.MessageBox(0, "El código ingresado es incorrecto", "Error")
        else:
            print("Error al buscar un producto: ", query.lastError().text())

    # INSERTAR

    def altaProductos(self):
        try:
            # Preparamos el registro
            var.estado = self.eligeEstado()
            nuevoProducto = [self.ventana_principal.TxtName.text(), self.ventana_principal.CbCategory.currentText(),
                             self.ventana_principal.TxtDate.text(), self.ventana_principal.TxtStock.text(),
                             self.ventana_principal.TxtPriceC.text(), self.ventana_principal.TxtPriceV.text(),
                             var.estado, self.ventana_principal.CbSupplier.currentText()]
            self.insertarProducto(nuevoProducto)
            self.limpiarValores()
        except Exception as error:
            print('Error alta cliente: %s ' % str(error))

    def insertarProducto(self, nuevoProducto):
        query = QtSql.QSqlQuery()
        query.prepare(
            "INSERT INTO productos (nombre, categoria, fecha_ingreso, cantidad, precio_costo, precio_venta, estado, proveedor) "
            "VALUES ( :nombre, :categoria, :fecha_ingreso, :cantidad, :precio_costo, :precio_venta, :estado, :proveedor)")
        self.loadData(nuevoProducto, query)
        if query.exec_():
            print("Registro insertado correctamente")
            self.mostrarProductos()
            self.ventana_principal.LbStatus.setText('Producto con nombre ' + str(nuevoProducto[0]) + ' ha sido insertado.')
        else:
            print("Error al insertar: ", query.lastError().text())

    def loadData(self, nuevoProducto, query):
        query.bindValue(':nombre', str(nuevoProducto[0]))
        query.bindValue(':categoria', str(nuevoProducto[1]))
        query.bindValue(':fecha_ingreso', str(nuevoProducto[2]))
        query.bindValue(':cantidad', str(nuevoProducto[3]))
        query.bindValue(':precio_costo', str(nuevoProducto[4]))
        query.bindValue(':precio_venta', str(nuevoProducto[5]))
        query.bindValue(':estado', str(nuevoProducto[6]))
        query.bindValue(':proveedor', str(nuevoProducto[7]))

    def limpiarValores(self):
        self.ventana_principal.TxtId.setText('')
        self.ventana_principal.TxtName.setText('')
        self.ventana_principal.TxtDate.setText('')
        self.ventana_principal.TxtStock.setText('')
        self.ventana_principal.TxtPriceC.setText('')
        self.ventana_principal.TxtPriceV.setText('')
        self.ventana_principal.CbCategory.setCurrentIndex(-1)
        self.ventana_principal.CbSupplier.setCurrentIndex(-1)
        self.ventana_principal.ButGroupStatus.setExclusive(False)
        self.ventana_principal.RbAvailable.setChecked(False)
        self.ventana_principal.RbNotAvailable.setChecked(False)


class Fecha(QtWidgets.QDialog):
    def __init__(self):
        super(Fecha, self).__init__()
        var.dialogo_fecha = Ui_Dialog()
        var.dialogo_fecha.setupUi(self)
        self.setWindowFlag(Qt.FramelessWindowHint)  # elimina la barra
        self.setAttribute(Qt.WA_TranslucentBackground)  # transparente
        var.dialogo_fecha.venCalendar.setSelectedDate(
            QtCore.QDate(datetime.now().year, datetime.now().month, datetime.now().day))
        var.dialogo_fecha.venCalendar.clicked.connect(Eventos.cargarFecha)
