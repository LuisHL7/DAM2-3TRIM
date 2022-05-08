# Paquetes Importados
import sys

from PyQt5 import QtWidgets, QtSql

# Función que comprueba que el usuario y contraseña ingresado sean correctos.
# Si son correctos acceden a toda la información si no se mostrará una caja
# de mensaje, solicitando que introduzca datos válidos.
from login import Ui_MainWindowLogin
from main_form import Ui_MainWindowMain
import win32api
import var
from miapp import Iniciar


