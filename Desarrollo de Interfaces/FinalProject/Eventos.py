# Paquetes Importados
import var
import sys
from datetime import datetime


def salir():
    try:
        var.dialogo_salir.show()
        if var.dialogo_salir.exec():
            sys.exit()
        else:
            var.dialogo_salir.hide()
    except Exception as error:
        print('Error al intentar salir de la ventana', error)

def hora_actual(self):
    now = datetime.now()
    self.ventana_principal.statusBar.showMessage(str(now.strftime("%d/%m/%Y, %H:%M:%S")))
