import sys
import var
import easygui
import pandas as pd
from datetime import datetime


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

    def datetime_now():
        now = datetime.now()
        var.ui.statusbar.showMessage(str(now.strftime("%d/%m/%Y, %H:%M:%S")))

    def open_exlorer():
        file = easygui.fileopenbox()
        print(file)

    def import_data():
        # file_name = easygui.fileopenbox()
        # route = r+file_name
        # print(route)
        file = pd.read_excel(
            r'C:\Users\a19luisjhl\Desktop\DAM\DAM2\DAM2-3TRIM\Desarrollo de Interfaces\Actividad2\customer.xlsx',
            sheet_name='cliente')
        print(file)
