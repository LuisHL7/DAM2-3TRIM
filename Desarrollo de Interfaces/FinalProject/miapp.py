# Paquetes Importados
import sys
from PyQt5 import QtWidgets, QtSql
from PyQt5.QtCore import Qt

import Empleados
import Eventos
import var
import Conexion
from windowsAviso import Ui_Aviso
from login import Ui_MainWindowLogin
from main_form import Ui_MainWindowMain
import time


# Clase Principal
class MiApp(QtWidgets.QMainWindow):
        def __init__(self):
            super().__init__()
            self.ventana_login = Ui_MainWindowLogin()
            self.ventana_login.setupUi(self)
            var.dialogo_salir = Salir() # Asignando la clase Salir a la variable global dialogo_salir
            # var.ventana_principal = Iniciar() # Asignando la clase Iniciar a la variable global ventana_principal
            self.setWindowFlag(Qt.FramelessWindowHint) # elimina barra
            self.setAttribute(Qt.WA_TranslucentBackground) # transparente
            Conexion.Conexion.dbConnect('BDProductos.db') # Conexión
            # Asignando la clase operaciones a la variable global ventana_principal
            # var.ventana_principal = Iniciar_sesion()
            self.ventana_login.ButLogin.clicked.connect(self.iniciar_sesion)
            self.ventana_login.ButClose.clicked.connect(Eventos.salir)

        def iniciar_sesion(self):
            query = QtSql.QSqlQuery()
            query.prepare('SELECT nombre, apellidoS FROM empleados WHERE usuario =:usuario and password =:password')
            query.bindValue(':usuario', self.ventana_login.TxtUser.text())
            query.bindValue(':password', self.ventana_login.TxtPassword.text())
            if query.exec_():
                if query.next():
                    nombre = str(query.value(0))
                    nombre+= " " +  str(query.value(1))

                    for i in range(0, 99):
                        time.sleep(0.02)
                        self.ventana_login.LineProgress.setValue(i)
                        self.ventana_login.LbLoad.setText('Cargando...')
                    self.hide()
                    var.ventana_principal = Iniciar(nombre)
                    var.ventana_principal.show()
                else:
                    win32api.MessageBox(0, "El usuario o contraseña ingresada es incorrecto", "Error")

            else:
                print("Error de inicio de sesión: ", query.lastError().text())

class Salir(QtWidgets.QDialog):
    def __init__(self):
        #   Clase que instancia la ventana de aviso salir
        super(Salir, self).__init__()
        var.dialogo_salir = Ui_Aviso()
        var.dialogo_salir.setupUi(self)
        var.dialogo_salir.BtnBoxAvisoYes.clicked.connect(self.accept)
        var.dialogo_salir.BtnBoxAvisoNo.clicked.connect(self.reject)
        # elimina la barra
        self.setWindowFlag(Qt.FramelessWindowHint)
        # transparente
        self.setAttribute(Qt.WA_TranslucentBackground)


class Iniciar(QtWidgets.QMainWindow):
    def __init__(self, nombre):
        #   Clase que instancia la ventana de aviso salir
        super().__init__()
        self.ventana_principal = Ui_MainWindowMain()
        self.ventana_principal.setupUi(self)
        self.ventana_principal.LbWelcome.setText('Bienvenido, ' + nombre)
        self.ventana_principal.LbWelcome2.setText('Bienvenido, ' + nombre)
        self.ventana_principal.LbWelcome3.setText('Bienvenido, ' + nombre)
        Eventos.hora_actual(self)


# Función que ejecuta la clase Main
if __name__ == '__main__':
    app = QtWidgets.QApplication(sys.argv)
    window = MiApp()
    window.show()
    sys.exit(app.exec())
