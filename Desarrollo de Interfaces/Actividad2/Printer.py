from datetime import datetime

from PyQt5 import QtSql
from reportlab.lib.pagesizes import A4
from reportlab.pdfgen import canvas
import os

import var


class Printer:

    def reportCli():
        try:
            var.rep = canvas.Canvas('informes/listadoClientes.pdf', pagesize=A4)
            Printer.cabecera()
            var.rep.setFont('Helvetica-Bold', size=9)
            textListado = 'List Clients'
            var.rep.drawString(255, 735, textListado )
            var.rep.line(45, 730, 525, 730)
            itemCli = ['CODIGO', 'DNI', 'LASTNAME', 'NAME', 'HIGTHDATE']
            var.rep.drawString(45, 710, itemCli[0])
            var.rep.drawString(90, 710, itemCli[1])
            var.rep.drawString(180, 710, itemCli[2])
            var.rep.drawString(325, 710, itemCli[3])
            var.rep.drawString(465, 710, itemCli[4])
            var.rep.line(45, 703, 525, 703)
            query = QtSql.QSqlQuery()
            query.prepare('select codigo, dni, lastname, name, higthdate from customer order by lastname, name')
            var.rep.setFont('Helvetica', size=10)
            if query.exec_():
                i = 50
                j = 690
                while query.next():
                    var.rep.drawString(i, j, str(query.value(0)))
                    var.rep.drawString(i+30, j, str(query.value(1)))
                    var.rep.drawString(i+130, j, str(query.value(2)))
                    var.rep.drawString(i+280, j, str(query.value(3)))
                    var.rep.drawRightString(i+470, j, str(query.value(4)))
                    j=j-30
            Printer.pie(textListado)
            var.rep.save()
            rootPath = ".\\informes"
            cont = 0
            for file in os.listdir(rootPath):
                if file.endswith('.pdf'):
                    os.startfile("%s/%s" % (rootPath, file))
                cont = cont + 1
        except Exception as error:
            print('Error reporcli %s' % str(error))

    def cabecera():
        try:
            logo = 'logote.png'
            var.rep.setTitle('INFORMES')
            var.rep.setAuthor('Luis Huapaya')
            var.rep.setFont('Helvetica', size=10)
            var.rep.line(45, 820, 525, 820)
            var.rep.line(45, 745, 525, 745)
            var.rep.drawString(50, 805, 'A28072018L')
            var.rep.drawString(50, 790, 'Import and Export DAM S.A.C')
            var.rep.drawString(50, 775, 'Calle Roris 79 1 Izq.')
            var.rep.drawString(50, 760, '722496572')
            var.rep.drawImage(logo, 450, 752, mask='auto')
        except Exception as error:
            print('Error en la cabecera del informe %s' % str(error))

    def pie(textListado):
        try:
            var.rep.line(50, 50, 525, 50)
            date = datetime.today()
            date = date.strftime('%d.%m.%Y %H.%M.%S')
            var.rep.setFont('Helvetica-Oblique', size=7)
            var.rep.drawString(460, 40, str(date))
            var.rep.drawString(275, 40, str('Página %s' % var.rep.getPageNumber()))
            var.rep.drawImage(50, 40, str(textListado))
        except Exception as error:
            print('Error en el pie del informe %s' % str(error))