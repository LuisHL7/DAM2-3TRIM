import sys
import var


class Eventos:
    def Salir(self):
        try:
            var.dlgClose.show()
            if var.dlgClose.exec():
                 sys.exit()
            else:
                var.dlgClose.hide()
        except Exception as error:
            print('Error en módulo salir', error)


