# Paquetes Importados
from PyQt5 import QtWidgets, QtSql

# Función que comprueba que el usuario y contraseña ingresado sean correctos.
# Si son correctos acceden a toda la información si no se mostrará una caja
# de mensaje, solicitando que introduzca datos válidos.
from login import Ui_MainWindowLogin
from main_form import Ui_MainWindow
import win32api
import var


def login():
    cont = 0
    query = QtSql.QSqlQuery()
    query.prepare('SELECT nombre FROM empleados WHERE usuario =:usuario and password =:password')
    query.bindValue(':usuario', var.ventana_login.TxtUser.text())
    query.bindValue(':password', var.ventana_login.TxtPassword.text())
    if query.exec_():
        if query.next():
            name = str(query.value(0))
            ventana_main = Ui_MainWindow()
            ventana_main.LbWelcome.setText('Bienvenido ' + name)
            cont += 1
        else:
            win32api.MessageBox(0, "El usuario o contraseña ingresada es incorrecto", "Error")
    else:
        print("Error de logeo: ", query.lastError().text())
