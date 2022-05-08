# Paquetes Importados
import sys
from PyQt5 import QtWidgets, QtSql
from login import Ui_MainWindowLogin
from main_form import Ui_MainWindowMain
import win32api
from miapp import Iniciar


def mostrarProductos(self):
    index = 0
    query = QtSql.QSqlQuery()
    query.prepare('SELECT codigo, nombre, categoria, fecha_ingreso, cantidad, precio_costo, precio_venta, estado, proveedor FROM productos')
    if query.exec_():
        while query.next():
            codigo = query.value(0)
            nombre = query.value(1)
            categoria = query.value(2)
            fecha_ingreso = query.value(3)
            cantidad = query.value(4)
            precio_costo = query.value(5)
            precio_venta = query.value(6)
            estado = query.value(7)
            proveedor = query.value(8)
            self.ventana_principal.cliTable.setRowCount(index + 1)
            self.ventana_principal.cliTable.setItem(index, 0, QtWidgets.QTableWidgetItem(str(codigo)))
            self.ventana_principal.cliTable.setItem(index, 1, QtWidgets.QTableWidgetItem(nombre))
            self.ventana_principal.cliTable.setItem(index, 2, QtWidgets.QTableWidgetItem(categoria))
            self.ventana_principal.cliTable.setItem(index, 3, QtWidgets.QTableWidgetItem(fecha_ingreso))
            self.ventana_principal.cliTable.setItem(index, 4, QtWidgets.QTableWidgetItem(str(cantidad)))
            self.ventana_principal.cliTable.setItem(index, 5, QtWidgets.QTableWidgetItem(str(precio_costo)))
            self.ventana_principal.cliTable.setItem(index, 6, QtWidgets.QTableWidgetItem(str(precio_venta)))
            self.ventana_principal.cliTable.setItem(index, 7, QtWidgets.QTableWidgetItem(estado))
            self.ventana_principal.cliTable.setItem(index, 8, QtWidgets.QTableWidgetItem(proveedor))
            index += 1
    else:
        print("Error al mostrar los productos customer: ", query.lastError().text())
