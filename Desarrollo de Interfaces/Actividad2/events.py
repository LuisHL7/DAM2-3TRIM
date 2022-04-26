import sys
import Conection
import var
import easygui
# import Customer
import pandas as pd
# import xlrd
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
        file_name = easygui.fileopenbox()
        Conection.Conection.importDataFromExcel(file_name, pd)

    def export_bd():
        file_name = easygui.fileopenbox()
        Conection.Conection.exportBDtoZip(file_name, pd)

