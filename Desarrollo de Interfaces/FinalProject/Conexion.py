# Paquetes Importados
from PyQt5 import QtWidgets, QtSql


class Conexion:

    def dbConnect(filename):
        db = QtSql.QSqlDatabase.addDatabase('QSQLITE')
        db.setDatabaseName(filename)
        if not db.open():
            QtWidgets.QMessageBox.critical(None, "No se puede abrir la base de datos",
                                           'No se puede establecer conexion.\n'
                                           'Haz click para cancelar.',
                                           QtWidgets.QMessageBox.Cancel)
            return False
        else:
            print('Conexion establecida')
        return True