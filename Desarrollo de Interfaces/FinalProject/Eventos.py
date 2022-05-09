# Paquetes Importados
import var
import sys
from datetime import datetime


# Función salir que muestra una ventana de diálogo al usuario con dos botones, preguntando si está seguro de salir de la aplicación o no.
def salir():
    try:
        var.dialogo_salir.show()
        if var.dialogo_salir.exec():
            sys.exit()
        else:
            var.dialogo_salir.hide()
    except Exception as error:
        print('Error al intentar salir de la ventana', error)


# Función que muestra la fecha y la hora actual en la barra de estado.
def horaActual(self):
    now = datetime.now()
    self.ventana_principal.statusBar.showMessage(str(now.strftime("%d/%m/%Y, %H:%M:%S")))


def abrirCalendario():
    try:
        var.dialogo_fecha.show()
    except Exception as error:
        print('Error al abrir el calendario: %s ' % str(error))



