from datetime import datetime

import Conection
from windowsSinDatos import *
from ManagmentCustomer import *
from windowsAviso import *
import sys
import var
import events
import Customer
from windowsCalendar import Ui_Dialog

#Clase Principal

class Main(QtWidgets.QMainWindow):

    def __init__(self):
        super(Main, self).__init__()
        var.ui = Ui_MainWindow()
        var.ui.setupUi(self)
        var.dlgCalendar = DialogCalendar()
        var.avisoSalir = DialogClose()
        var.ui.actionSalir.triggered.connect(events.Eventos.Salir)
        var.ui.BtnClose.clicked.connect(events.Eventos.Salir)
        var.ui.TxtDni.editingFinished.connect(Customer.Customer.verifyDni)
        var.ui.BtnCalendar.clicked.connect(Customer.Customer.abrirCalendar)
        var.ui.RbtGroupSex.buttonClicked.connect(Customer.Customer.selSexo)
        #var.rbtsex = (var.ui.RbtMasculino, var.ui.RbtFemenino)
        #for i in var.rbtsex:
            #i.toggled.connect(Customer.Customer.selSexo)
        var.chkpago = (var.ui.ChkEfectivo, var.ui.ChkTarjeta, var.ui.ChkTransferencia)
        for i in var.chkpago:
            i.stateChanged.connect(Customer.Customer.selPago)
        Customer.Customer.cargarProv()
        Conection.Conection.dbConnect(var.filebd)
        Conection.Conection.showCustomers()
        var.ui.CmbProvincia.activated[str].connect(Customer.Customer.selProv)
        var.ui.BtnSave.clicked.connect(Customer.Customer.highClients)
        var.ui.BtnSearch.clicked.connect(Customer.Customer.searchCustomer)
        var.ui.BtnUpdate.clicked.connect(Customer.Customer.updateClient)
        var.ui.BtnDelete.clicked.connect(Customer.Customer.deleteClient)
        var.ui.BtnClean.clicked.connect(Customer.Customer.cleanCustomer)
        var.ui.BtnRefresh.clicked.connect(Customer.Customer.cleanCustomer)

class DialogClose(QtWidgets.QDialog):
    def __init__(self):
        #   Clase que instancia la ventana de aviso salir
        super(DialogClose, self).__init__()
        var.dlgClose = Ui_Aviso()
        var.dlgClose.setupUi(self)
        var.dlgClose.BtnBoxAvisoYes.clicked.connect(self.accept)
        var.dlgClose.BtnBoxAvisoNo.clicked.connect(self.reject)


class DialogCalendar(QtWidgets.QDialog):
    def __init__(self):
        super(DialogCalendar, self).__init__()
        var.dlgCalendar = Ui_Dialog()
        var.dlgCalendar.setupUi(self)
        diaActual = datetime.now().day
        mesActual = datetime.now().month
        anoActual = datetime.now().year
        var.dlgCalendar.venCalendar.setSelectedDate((QtCore.QDate(anoActual, mesActual, diaActual)))
        var.dlgCalendar.venCalendar.clicked.connect(Customer.Customer.cargarFecha)

if __name__ == '__main__':
    app = QtWidgets.QApplication([])
    window = Main()
    var.dlgClose = DialogClose()
    window.show()
    sys.exit(app.exec())
