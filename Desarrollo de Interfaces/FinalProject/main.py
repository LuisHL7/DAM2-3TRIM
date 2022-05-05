# Paquetes Importados
import sys
from PyQt5 import QtWidgets

import Empleados
import var
from login import Ui_MainWindowLogin


# Clase Principal
class Main(QtWidgets.QMainWindow):
    def __init__(self):
        super(Main, self).__init__()
        var.ventana_login = Ui_MainWindowLogin()
        var.ventana_login.setupUi(self)
        var.ventana_login.ButLogin.clicked.connect(Empleados.login)


# Función que ejecuta la clase Main
if __name__ == '__main__':
    app = QtWidgets.QApplication([])
    window = Main()
    window.show()
    sys.exit(app.exec())
