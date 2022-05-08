# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'main_form.ui'
#
# Created by: PyQt5 UI code generator 5.15.6
#
# WARNING: Any manual changes made to this file will be lost when pyuic5 is
# run again.  Do not edit this file unless you know what you are doing.


from PyQt5 import QtCore, QtGui, QtWidgets


class Ui_MainWindowMain(object):
    def setupUi(self, MainWindowMain):
        MainWindowMain.setObjectName("MainWindowMain")
        MainWindowMain.resize(1108, 697)
        self.centralwidget = QtWidgets.QWidget(MainWindowMain)
        self.centralwidget.setObjectName("centralwidget")
        self.verticalLayout = QtWidgets.QVBoxLayout(self.centralwidget)
        self.verticalLayout.setObjectName("verticalLayout")
        self.frame = QtWidgets.QFrame(self.centralwidget)
        self.frame.setStyleSheet("background-color: qlineargradient(spread:reflect, x1:0.543, y1:0, x2:0.541, y2:1, stop:0.300766 rgba(11, 255, 240, 255), stop:1 rgba(68, 0, 127, 255));\n"
"\n"
"border-radius:20px;\n"
"border:1px solid #00007f;")
        self.frame.setFrameShape(QtWidgets.QFrame.StyledPanel)
        self.frame.setFrameShadow(QtWidgets.QFrame.Raised)
        self.frame.setObjectName("frame")
        self.verticalLayout_2 = QtWidgets.QVBoxLayout(self.frame)
        self.verticalLayout_2.setObjectName("verticalLayout_2")
        self.tabWidget = QtWidgets.QTabWidget(self.frame)
        self.tabWidget.setObjectName("tabWidget")
        self.tab_2 = QtWidgets.QWidget()
        self.tab_2.setObjectName("tab_2")
        self.label_2 = QtWidgets.QLabel(self.tab_2)
        self.label_2.setGeometry(QtCore.QRect(70, 120, 81, 21))
        self.label_2.setStyleSheet("background-color: rgba(0, 0, 0,0%);\n"
"font: 75 16pt \"Arial\";\n"
"border:none")
        self.label_2.setAlignment(QtCore.Qt.AlignCenter)
        self.label_2.setObjectName("label_2")
        self.TxtName = QtWidgets.QLineEdit(self.tab_2)
        self.TxtName.setGeometry(QtCore.QRect(170, 110, 291, 31))
        font = QtGui.QFont()
        font.setPointSize(12)
        font.setBold(True)
        font.setWeight(75)
        self.TxtName.setFont(font)
        self.TxtName.setStyleSheet("background-color: rgb(255, 255, 255,255);\n"
"border-radius:10px;\n"
"border:none")
        self.TxtName.setAlignment(QtCore.Qt.AlignCenter)
        self.TxtName.setObjectName("TxtName")
        self.label_3 = QtWidgets.QLabel(self.tab_2)
        self.label_3.setGeometry(QtCore.QRect(580, 120, 101, 21))
        self.label_3.setStyleSheet("background-color: rgba(0, 0, 0,0%);\n"
"font: 75 16pt \"Arial\";\n"
"border:none")
        self.label_3.setAlignment(QtCore.Qt.AlignCenter)
        self.label_3.setObjectName("label_3")
        self.BtnClose = QtWidgets.QPushButton(self.tab_2)
        self.BtnClose.setGeometry(QtCore.QRect(760, 420, 120, 40))
        font = QtGui.QFont()
        font.setFamily("MS Shell Dlg 2")
        font.setPointSize(10)
        font.setBold(False)
        font.setItalic(False)
        font.setWeight(9)
        self.BtnClose.setFont(font)
        self.BtnClose.setStyleSheet("QPushButton{\n"
"font: 75 10pt \"MS Shell Dlg 2\";\n"
"background-color: rgb(0, 255, 0);\n"
"font: 75 10pt \"MS Shell Dlg 2\";\n"
"border:5px solid #ffffff;\n"
"}\n"
"\n"
"QPushButton:hover{\n"
"background-color: rgb(255, 255, 0);\n"
"font: 75 10pt \"MS Shell Dlg 2\";\n"
"border:5px solid #0000f;\n"
"}")
        icon = QtGui.QIcon()
        icon.addPixmap(QtGui.QPixmap("../Actividad2/close.png"), QtGui.QIcon.Normal, QtGui.QIcon.Off)
        self.BtnClose.setIcon(icon)
        self.BtnClose.setIconSize(QtCore.QSize(30, 30))
        self.BtnClose.setObjectName("BtnClose")
        self.BtnDelete = QtWidgets.QPushButton(self.tab_2)
        self.BtnDelete.setGeometry(QtCore.QRect(480, 420, 120, 40))
        font = QtGui.QFont()
        font.setFamily("MS Shell Dlg 2")
        font.setPointSize(10)
        font.setBold(False)
        font.setItalic(False)
        font.setWeight(9)
        self.BtnDelete.setFont(font)
        self.BtnDelete.setStyleSheet("QPushButton{\n"
"font: 75 10pt \"MS Shell Dlg 2\";\n"
"background-color: rgb(0, 255, 0);\n"
"font: 75 10pt \"MS Shell Dlg 2\";\n"
"border:5px solid #ffffff;\n"
"}\n"
"\n"
"QPushButton:hover{\n"
"background-color: rgb(255, 255, 0);\n"
"font: 75 10pt \"MS Shell Dlg 2\";\n"
"border:5px solid #0000f;\n"
"}")
        icon1 = QtGui.QIcon()
        icon1.addPixmap(QtGui.QPixmap("../Actividad2/delete.png"), QtGui.QIcon.Normal, QtGui.QIcon.Off)
        self.BtnDelete.setIcon(icon1)
        self.BtnDelete.setIconSize(QtCore.QSize(30, 30))
        self.BtnDelete.setObjectName("BtnDelete")
        self.BtnClean = QtWidgets.QPushButton(self.tab_2)
        self.BtnClean.setGeometry(QtCore.QRect(620, 420, 120, 40))
        font = QtGui.QFont()
        font.setFamily("MS Shell Dlg 2")
        font.setPointSize(10)
        font.setBold(False)
        font.setItalic(False)
        font.setWeight(9)
        self.BtnClean.setFont(font)
        self.BtnClean.setStyleSheet("QPushButton{\n"
"font: 75 10pt \"MS Shell Dlg 2\";\n"
"background-color: rgb(0, 255, 0);\n"
"font: 75 10pt \"MS Shell Dlg 2\";\n"
"border:5px solid #ffffff;\n"
"}\n"
"\n"
"QPushButton:hover{\n"
"background-color: rgb(255, 255, 0);\n"
"font: 75 10pt \"MS Shell Dlg 2\";\n"
"border:5px solid #0000f;\n"
"}")
        icon2 = QtGui.QIcon()
        icon2.addPixmap(QtGui.QPixmap("../Actividad2/papelera.png"), QtGui.QIcon.Normal, QtGui.QIcon.Off)
        self.BtnClean.setIcon(icon2)
        self.BtnClean.setIconSize(QtCore.QSize(30, 30))
        self.BtnClean.setObjectName("BtnClean")
        self.BtnUpdate = QtWidgets.QPushButton(self.tab_2)
        self.BtnUpdate.setGeometry(QtCore.QRect(340, 420, 120, 40))
        font = QtGui.QFont()
        font.setFamily("MS Shell Dlg 2")
        font.setPointSize(10)
        font.setBold(False)
        font.setItalic(False)
        font.setWeight(9)
        self.BtnUpdate.setFont(font)
        self.BtnUpdate.setStyleSheet("QPushButton{\n"
"font: 75 10pt \"MS Shell Dlg 2\";\n"
"background-color: rgb(0, 255, 0);\n"
"font: 75 10pt \"MS Shell Dlg 2\";\n"
"border:5px solid #ffffff;\n"
"}\n"
"\n"
"QPushButton:hover{\n"
"background-color: rgb(255, 255, 0);\n"
"font: 75 10pt \"MS Shell Dlg 2\";\n"
"border:5px solid #0000f;\n"
"}")
        icon3 = QtGui.QIcon()
        icon3.addPixmap(QtGui.QPixmap("../Actividad2/modify.png"), QtGui.QIcon.Normal, QtGui.QIcon.Off)
        self.BtnUpdate.setIcon(icon3)
        self.BtnUpdate.setIconSize(QtCore.QSize(30, 30))
        self.BtnUpdate.setObjectName("BtnUpdate")
        self.BtnSave = QtWidgets.QPushButton(self.tab_2)
        self.BtnSave.setGeometry(QtCore.QRect(200, 420, 120, 40))
        font = QtGui.QFont()
        font.setFamily("MS Shell Dlg 2")
        font.setPointSize(10)
        font.setBold(False)
        font.setItalic(False)
        font.setWeight(9)
        self.BtnSave.setFont(font)
        self.BtnSave.setStyleSheet("QPushButton{\n"
"font: 75 10pt \"MS Shell Dlg 2\";\n"
"background-color: rgb(0, 255, 0);\n"
"font: 75 10pt \"MS Shell Dlg 2\";\n"
"border:5px solid #ffffff;\n"
"}\n"
"\n"
"QPushButton:hover{\n"
"background-color: rgb(255, 255, 0);\n"
"font: 75 10pt \"MS Shell Dlg 2\";\n"
"border:5px solid #0000f;\n"
"}")
        icon4 = QtGui.QIcon()
        icon4.addPixmap(QtGui.QPixmap("../Actividad2/save.png"), QtGui.QIcon.Normal, QtGui.QIcon.Off)
        self.BtnSave.setIcon(icon4)
        self.BtnSave.setIconSize(QtCore.QSize(30, 30))
        self.BtnSave.setObjectName("BtnSave")
        self.TxtPriceC = QtWidgets.QLineEdit(self.tab_2)
        self.TxtPriceC.setGeometry(QtCore.QRect(170, 250, 291, 31))
        font = QtGui.QFont()
        font.setPointSize(12)
        font.setBold(True)
        font.setWeight(75)
        self.TxtPriceC.setFont(font)
        self.TxtPriceC.setStyleSheet("background-color: rgb(255, 255, 255,255);\n"
"border-radius:10px;\n"
"border:none")
        self.TxtPriceC.setAlignment(QtCore.Qt.AlignCenter)
        self.TxtPriceC.setObjectName("TxtPriceC")
        self.label_4 = QtWidgets.QLabel(self.tab_2)
        self.label_4.setGeometry(QtCore.QRect(60, 260, 91, 21))
        self.label_4.setStyleSheet("background-color: rgba(0, 0, 0,0%);\n"
"font: 75 16pt \"Arial\";\n"
"border:none")
        self.label_4.setAlignment(QtCore.Qt.AlignCenter)
        self.label_4.setObjectName("label_4")
        self.TxtPriceV = QtWidgets.QLineEdit(self.tab_2)
        self.TxtPriceV.setGeometry(QtCore.QRect(700, 250, 291, 31))
        font = QtGui.QFont()
        font.setPointSize(12)
        font.setBold(True)
        font.setWeight(75)
        self.TxtPriceV.setFont(font)
        self.TxtPriceV.setStyleSheet("background-color: rgb(255, 255, 255,255);\n"
"border-radius:10px;\n"
"border:none")
        self.TxtPriceV.setAlignment(QtCore.Qt.AlignCenter)
        self.TxtPriceV.setObjectName("TxtPriceV")
        self.label_5 = QtWidgets.QLabel(self.tab_2)
        self.label_5.setGeometry(QtCore.QRect(580, 260, 71, 21))
        self.label_5.setStyleSheet("background-color: rgba(0, 0, 0,0%);\n"
"font: 75 16pt \"Arial\";\n"
"border:none")
        self.label_5.setAlignment(QtCore.Qt.AlignCenter)
        self.label_5.setObjectName("label_5")
        self.label_6 = QtWidgets.QLabel(self.tab_2)
        self.label_6.setGeometry(QtCore.QRect(70, 330, 81, 21))
        self.label_6.setStyleSheet("background-color: rgba(0, 0, 0,0%);\n"
"font: 75 16pt \"Arial\";\n"
"border:none")
        self.label_6.setAlignment(QtCore.Qt.AlignCenter)
        self.label_6.setObjectName("label_6")
        self.TxtStock = QtWidgets.QLineEdit(self.tab_2)
        self.TxtStock.setGeometry(QtCore.QRect(700, 180, 291, 31))
        font = QtGui.QFont()
        font.setPointSize(12)
        font.setBold(True)
        font.setWeight(75)
        self.TxtStock.setFont(font)
        self.TxtStock.setStyleSheet("background-color: rgb(255, 255, 255,255);\n"
"border-radius:10px;\n"
"border:none")
        self.TxtStock.setAlignment(QtCore.Qt.AlignCenter)
        self.TxtStock.setObjectName("TxtStock")
        self.label_7 = QtWidgets.QLabel(self.tab_2)
        self.label_7.setGeometry(QtCore.QRect(580, 190, 91, 21))
        self.label_7.setStyleSheet("background-color: rgba(0, 0, 0,0%);\n"
"font: 75 16pt \"Arial\";\n"
"border:none")
        self.label_7.setAlignment(QtCore.Qt.AlignCenter)
        self.label_7.setObjectName("label_7")
        self.label_9 = QtWidgets.QLabel(self.tab_2)
        self.label_9.setGeometry(QtCore.QRect(580, 320, 101, 21))
        self.label_9.setStyleSheet("background-color: rgba(0, 0, 0,0%);\n"
"font: 75 16pt \"Arial\";\n"
"border:none")
        self.label_9.setAlignment(QtCore.Qt.AlignCenter)
        self.label_9.setObjectName("label_9")
        self.label_10 = QtWidgets.QLabel(self.tab_2)
        self.label_10.setGeometry(QtCore.QRect(70, 190, 141, 21))
        self.label_10.setStyleSheet("background-color: rgba(0, 0, 0,0%);\n"
"font: 75 16pt \"Arial\";\n"
"border:none")
        self.label_10.setAlignment(QtCore.Qt.AlignCenter)
        self.label_10.setObjectName("label_10")
        self.CbCategory = QtWidgets.QComboBox(self.tab_2)
        self.CbCategory.setGeometry(QtCore.QRect(700, 110, 291, 31))
        self.CbCategory.setStyleSheet("background-color: rgb(255, 255, 255,255);\n"
"border-radius:10px;\n"
"border:none")
        self.CbCategory.setObjectName("CbCategory")
        self.CbSupplier = QtWidgets.QComboBox(self.tab_2)
        self.CbSupplier.setGeometry(QtCore.QRect(710, 310, 281, 31))
        self.CbSupplier.setStyleSheet("background-color: rgb(255, 255, 255,255);\n"
"border-radius:10px;\n"
"border:none")
        self.CbSupplier.setObjectName("CbSupplier")
        self.radioButton = QtWidgets.QRadioButton(self.tab_2)
        self.radioButton.setGeometry(QtCore.QRect(190, 330, 101, 17))
        font = QtGui.QFont()
        font.setPointSize(12)
        font.setBold(False)
        font.setWeight(50)
        self.radioButton.setFont(font)
        self.radioButton.setStyleSheet("background-color: rgba(0, 0, 0,0%);\n"
"border:none")
        self.radioButton.setObjectName("radioButton")
        self.buttonGroup = QtWidgets.QButtonGroup(MainWindowMain)
        self.buttonGroup.setObjectName("buttonGroup")
        self.buttonGroup.addButton(self.radioButton)
        self.RbGroupStatus = QtWidgets.QRadioButton(self.tab_2)
        self.RbGroupStatus.setGeometry(QtCore.QRect(320, 330, 131, 17))
        font = QtGui.QFont()
        font.setPointSize(12)
        self.RbGroupStatus.setFont(font)
        self.RbGroupStatus.setStyleSheet("background-color: rgba(0, 0, 0,0%);\n"
"border:none")
        self.RbGroupStatus.setObjectName("RbGroupStatus")
        self.buttonGroup.addButton(self.RbGroupStatus)
        self.BtnSearch_2 = QtWidgets.QPushButton(self.tab_2)
        self.BtnSearch_2.setGeometry(QtCore.QRect(310, 30, 29, 25))
        self.BtnSearch_2.setAutoFillBackground(False)
        self.BtnSearch_2.setStyleSheet("background-color: rgba(0, 0, 0,0%);\n"
"border:none")
        self.BtnSearch_2.setText("")
        icon5 = QtGui.QIcon()
        icon5.addPixmap(QtGui.QPixmap("../Actividad2/lupa.png"), QtGui.QIcon.Normal, QtGui.QIcon.Off)
        self.BtnSearch_2.setIcon(icon5)
        self.BtnSearch_2.setIconSize(QtCore.QSize(25, 25))
        self.BtnSearch_2.setObjectName("BtnSearch_2")
        self.TxtId = QtWidgets.QLineEdit(self.tab_2)
        self.TxtId.setGeometry(QtCore.QRect(70, 30, 221, 31))
        font = QtGui.QFont()
        font.setPointSize(12)
        font.setBold(True)
        font.setWeight(75)
        self.TxtId.setFont(font)
        self.TxtId.setStyleSheet("background-color: rgb(255, 255, 255,255);\n"
"border-radius:10px;\n"
"border:none")
        self.TxtId.setAlignment(QtCore.Qt.AlignCenter)
        self.TxtId.setObjectName("TxtId")
        self.TxtName_2 = QtWidgets.QLineEdit(self.tab_2)
        self.TxtName_2.setGeometry(QtCore.QRect(220, 180, 241, 31))
        font = QtGui.QFont()
        font.setPointSize(12)
        font.setBold(True)
        font.setWeight(75)
        self.TxtName_2.setFont(font)
        self.TxtName_2.setStyleSheet("background-color: rgb(255, 255, 255,255);\n"
"border-radius:10px;\n"
"border:none")
        self.TxtName_2.setAlignment(QtCore.Qt.AlignCenter)
        self.TxtName_2.setObjectName("TxtName_2")
        self.pushButton = QtWidgets.QPushButton(self.tab_2)
        self.pushButton.setGeometry(QtCore.QRect(470, 175, 40, 40))
        self.pushButton.setStyleSheet("background-color: rgba(0, 0, 0,0%);\n"
"border:none")
        self.pushButton.setText("")
        icon6 = QtGui.QIcon()
        icon6.addPixmap(QtGui.QPixmap("images/dateta.png"), QtGui.QIcon.Normal, QtGui.QIcon.Off)
        self.pushButton.setIcon(icon6)
        self.pushButton.setIconSize(QtCore.QSize(50, 50))
        self.pushButton.setObjectName("pushButton")
        self.LbStatus = QtWidgets.QLabel(self.tab_2)
        self.LbStatus.setGeometry(QtCore.QRect(20, 490, 991, 20))
        self.LbStatus.setStyleSheet("background-color: rgba(0, 0, 0,0%);\n"
"color: rgb(0, 255, 127);\n"
"font: 75 10pt \"Arial\";\n"
"border:none")
        self.LbStatus.setText("")
        self.LbStatus.setObjectName("LbStatus")
        self.LbWelcome = QtWidgets.QLabel(self.tab_2)
        self.LbWelcome.setGeometry(QtCore.QRect(810, 530, 241, 20))
        font = QtGui.QFont()
        font.setFamily("Arial")
        font.setPointSize(12)
        font.setBold(False)
        font.setItalic(False)
        font.setWeight(9)
        self.LbWelcome.setFont(font)
        self.LbWelcome.setStyleSheet("background-color: rgba(0, 0, 0,0%);\n"
"color: rgb(0, 255, 127);\n"
"font: 75 12pt \"Arial\";\n"
"border:none")
        self.LbWelcome.setText("")
        self.LbWelcome.setAlignment(QtCore.Qt.AlignRight|QtCore.Qt.AlignTrailing|QtCore.Qt.AlignVCenter)
        self.LbWelcome.setObjectName("LbWelcome")
        self.tabWidget.addTab(self.tab_2, "")
        self.tab = QtWidgets.QWidget()
        self.tab.setObjectName("tab")
        self.BtnSearch = QtWidgets.QPushButton(self.tab)
        self.BtnSearch.setGeometry(QtCore.QRect(270, 30, 29, 25))
        self.BtnSearch.setAutoFillBackground(False)
        self.BtnSearch.setStyleSheet("background-color: rgba(0, 0, 0,0%);\n"
"border:none")
        self.BtnSearch.setText("")
        self.BtnSearch.setIcon(icon5)
        self.BtnSearch.setIconSize(QtCore.QSize(25, 25))
        self.BtnSearch.setObjectName("BtnSearch")
        self.cliTable = QtWidgets.QTableWidget(self.tab)
        self.cliTable.setGeometry(QtCore.QRect(30, 90, 981, 301))
        self.cliTable.setAutoFillBackground(False)
        self.cliTable.setStyleSheet("background-color: rgba(0, 0, 0,0%);\n"
"border:none")
        self.cliTable.setDragEnabled(False)
        self.cliTable.setAlternatingRowColors(False)
        self.cliTable.setGridStyle(QtCore.Qt.SolidLine)
        self.cliTable.setObjectName("cliTable")
        self.cliTable.setColumnCount(9)
        self.cliTable.setRowCount(0)
        item = QtWidgets.QTableWidgetItem()
        item.setTextAlignment(QtCore.Qt.AlignCenter)
        font = QtGui.QFont()
        font.setPointSize(12)
        font.setBold(True)
        font.setWeight(75)
        item.setFont(font)
        self.cliTable.setHorizontalHeaderItem(0, item)
        item = QtWidgets.QTableWidgetItem()
        item.setTextAlignment(QtCore.Qt.AlignCenter)
        font = QtGui.QFont()
        font.setPointSize(12)
        font.setBold(True)
        font.setWeight(75)
        item.setFont(font)
        self.cliTable.setHorizontalHeaderItem(1, item)
        item = QtWidgets.QTableWidgetItem()
        item.setTextAlignment(QtCore.Qt.AlignCenter)
        font = QtGui.QFont()
        font.setPointSize(12)
        font.setBold(True)
        font.setWeight(75)
        item.setFont(font)
        self.cliTable.setHorizontalHeaderItem(2, item)
        item = QtWidgets.QTableWidgetItem()
        item.setTextAlignment(QtCore.Qt.AlignCenter)
        font = QtGui.QFont()
        font.setPointSize(12)
        font.setBold(True)
        font.setWeight(75)
        item.setFont(font)
        self.cliTable.setHorizontalHeaderItem(3, item)
        item = QtWidgets.QTableWidgetItem()
        item.setTextAlignment(QtCore.Qt.AlignCenter)
        font = QtGui.QFont()
        font.setPointSize(12)
        font.setBold(True)
        font.setWeight(75)
        item.setFont(font)
        self.cliTable.setHorizontalHeaderItem(4, item)
        item = QtWidgets.QTableWidgetItem()
        item.setTextAlignment(QtCore.Qt.AlignCenter)
        font = QtGui.QFont()
        font.setPointSize(12)
        font.setBold(True)
        font.setWeight(75)
        item.setFont(font)
        self.cliTable.setHorizontalHeaderItem(5, item)
        item = QtWidgets.QTableWidgetItem()
        item.setTextAlignment(QtCore.Qt.AlignCenter)
        font = QtGui.QFont()
        font.setPointSize(12)
        font.setBold(True)
        font.setWeight(75)
        item.setFont(font)
        self.cliTable.setHorizontalHeaderItem(6, item)
        item = QtWidgets.QTableWidgetItem()
        item.setTextAlignment(QtCore.Qt.AlignCenter)
        font = QtGui.QFont()
        font.setPointSize(12)
        font.setBold(True)
        font.setWeight(75)
        item.setFont(font)
        self.cliTable.setHorizontalHeaderItem(7, item)
        item = QtWidgets.QTableWidgetItem()
        item.setTextAlignment(QtCore.Qt.AlignCenter)
        font = QtGui.QFont()
        font.setPointSize(12)
        font.setBold(True)
        font.setWeight(75)
        item.setFont(font)
        self.cliTable.setHorizontalHeaderItem(8, item)
        self.cliTable.horizontalHeader().setCascadingSectionResizes(False)
        self.cliTable.horizontalHeader().setHighlightSections(True)
        self.cliTable.horizontalHeader().setMinimumSectionSize(50)
        self.cliTable.verticalHeader().setDefaultSectionSize(50)
        self.cliTable.verticalHeader().setMinimumSectionSize(50)
        self.cliTable.verticalHeader().setSortIndicatorShown(False)
        self.cliTable.verticalHeader().setStretchLastSection(True)
        self.TxtCode = QtWidgets.QLineEdit(self.tab)
        self.TxtCode.setGeometry(QtCore.QRect(30, 30, 221, 31))
        font = QtGui.QFont()
        font.setPointSize(12)
        font.setBold(True)
        font.setWeight(75)
        self.TxtCode.setFont(font)
        self.TxtCode.setStyleSheet("background-color: rgb(255, 255, 255,255);\n"
"border-radius:10px;\n"
"border:none")
        self.TxtCode.setAlignment(QtCore.Qt.AlignCenter)
        self.TxtCode.setObjectName("TxtCode")
        self.BtnRefresh = QtWidgets.QPushButton(self.tab)
        self.BtnRefresh.setGeometry(QtCore.QRect(310, 20, 40, 40))
        self.BtnRefresh.setStyleSheet("background-color: rgba(0, 0, 0,0%);\n"
"border:none")
        self.BtnRefresh.setText("")
        icon7 = QtGui.QIcon()
        icon7.addPixmap(QtGui.QPixmap("../Actividad2/recarga1.png"), QtGui.QIcon.Normal, QtGui.QIcon.Off)
        self.BtnRefresh.setIcon(icon7)
        self.BtnRefresh.setIconSize(QtCore.QSize(30, 30))
        self.BtnRefresh.setObjectName("BtnRefresh")
        self.LbWelcome2 = QtWidgets.QLabel(self.tab)
        self.LbWelcome2.setGeometry(QtCore.QRect(810, 530, 241, 20))
        font = QtGui.QFont()
        font.setFamily("Arial")
        font.setPointSize(12)
        font.setBold(False)
        font.setItalic(False)
        font.setWeight(9)
        self.LbWelcome2.setFont(font)
        self.LbWelcome2.setStyleSheet("background-color: rgba(0, 0, 0,0%);\n"
"color: rgb(0, 255, 127);\n"
"font: 75 12pt \"Arial\";\n"
"border:none")
        self.LbWelcome2.setText("")
        self.LbWelcome2.setAlignment(QtCore.Qt.AlignRight|QtCore.Qt.AlignTrailing|QtCore.Qt.AlignVCenter)
        self.LbWelcome2.setObjectName("LbWelcome2")
        self.tabWidget.addTab(self.tab, "")
        self.tab_3 = QtWidgets.QWidget()
        self.tab_3.setObjectName("tab_3")
        self.LbWelcome3 = QtWidgets.QLabel(self.tab_3)
        self.LbWelcome3.setGeometry(QtCore.QRect(810, 530, 241, 20))
        font = QtGui.QFont()
        font.setFamily("Arial")
        font.setPointSize(12)
        font.setBold(False)
        font.setItalic(False)
        font.setWeight(9)
        self.LbWelcome3.setFont(font)
        self.LbWelcome3.setStyleSheet("background-color: rgba(0, 0, 0,0%);\n"
"color: rgb(0, 255, 127);\n"
"font: 75 12pt \"Arial\";\n"
"border:none")
        self.LbWelcome3.setText("")
        self.LbWelcome3.setAlignment(QtCore.Qt.AlignRight|QtCore.Qt.AlignTrailing|QtCore.Qt.AlignVCenter)
        self.LbWelcome3.setObjectName("LbWelcome3")
        self.tabWidget.addTab(self.tab_3, "")
        self.verticalLayout_2.addWidget(self.tabWidget)
        self.verticalLayout.addWidget(self.frame)
        MainWindowMain.setCentralWidget(self.centralwidget)
        self.menubar = QtWidgets.QMenuBar(MainWindowMain)
        self.menubar.setGeometry(QtCore.QRect(0, 0, 1108, 21))
        self.menubar.setObjectName("menubar")
        self.menuAbrir = QtWidgets.QMenu(self.menubar)
        self.menuAbrir.setObjectName("menuAbrir")
        MainWindowMain.setMenuBar(self.menubar)
        self.toolBar = QtWidgets.QToolBar(MainWindowMain)
        self.toolBar.setObjectName("toolBar")
        MainWindowMain.addToolBar(QtCore.Qt.TopToolBarArea, self.toolBar)
        self.statusBar = QtWidgets.QStatusBar(MainWindowMain)
        self.statusBar.setObjectName("statusBar")
        MainWindowMain.setStatusBar(self.statusBar)
        self.actionOpen = QtWidgets.QAction(MainWindowMain)
        icon8 = QtGui.QIcon()
        icon8.addPixmap(QtGui.QPixmap("images/folder.png"), QtGui.QIcon.Normal, QtGui.QIcon.Off)
        self.actionOpen.setIcon(icon8)
        self.actionOpen.setObjectName("actionOpen")
        self.actionExport = QtWidgets.QAction(MainWindowMain)
        icon9 = QtGui.QIcon()
        icon9.addPixmap(QtGui.QPixmap("images/exportar.png"), QtGui.QIcon.Normal, QtGui.QIcon.Off)
        self.actionExport.setIcon(icon9)
        self.actionExport.setObjectName("actionExport")
        self.actionImport = QtWidgets.QAction(MainWindowMain)
        icon10 = QtGui.QIcon()
        icon10.addPixmap(QtGui.QPixmap("images/importar.png"), QtGui.QIcon.Normal, QtGui.QIcon.Off)
        self.actionImport.setIcon(icon10)
        self.actionImport.setObjectName("actionImport")
        self.actionCloseTB = QtWidgets.QAction(MainWindowMain)
        icon11 = QtGui.QIcon()
        icon11.addPixmap(QtGui.QPixmap("images/close.png"), QtGui.QIcon.Normal, QtGui.QIcon.Off)
        self.actionCloseTB.setIcon(icon11)
        self.actionCloseTB.setObjectName("actionCloseTB")
        self.actionAbrir = QtWidgets.QAction(MainWindowMain)
        self.actionAbrir.setObjectName("actionAbrir")
        self.actionSalir = QtWidgets.QAction(MainWindowMain)
        self.actionSalir.setObjectName("actionSalir")
        self.menuAbrir.addAction(self.actionAbrir)
        self.menuAbrir.addAction(self.actionSalir)
        self.menubar.addAction(self.menuAbrir.menuAction())
        self.toolBar.addAction(self.actionOpen)
        self.toolBar.addAction(self.actionImport)
        self.toolBar.addAction(self.actionExport)
        self.toolBar.addAction(self.actionCloseTB)

        self.retranslateUi(MainWindowMain)
        self.tabWidget.setCurrentIndex(1)
        QtCore.QMetaObject.connectSlotsByName(MainWindowMain)

    def retranslateUi(self, MainWindowMain):
        _translate = QtCore.QCoreApplication.translate
        MainWindowMain.setWindowTitle(_translate("MainWindowMain", "MainWindow"))
        self.label_2.setText(_translate("MainWindowMain", "Nombre:"))
        self.TxtName.setPlaceholderText(_translate("MainWindowMain", "Ingrese el nombre"))
        self.label_3.setText(_translate("MainWindowMain", "Categoría:"))
        self.BtnClose.setText(_translate("MainWindowMain", "Close"))
        self.BtnDelete.setText(_translate("MainWindowMain", "Eliminar"))
        self.BtnClean.setText(_translate("MainWindowMain", "Limpiar"))
        self.BtnUpdate.setText(_translate("MainWindowMain", "Actualizar"))
        self.BtnSave.setText(_translate("MainWindowMain", "Guardar"))
        self.TxtPriceC.setPlaceholderText(_translate("MainWindowMain", "Ingrese el precio de costo"))
        self.label_4.setText(_translate("MainWindowMain", "Precio:"))
        self.TxtPriceV.setPlaceholderText(_translate("MainWindowMain", "Ingrese el precio de venta"))
        self.label_5.setText(_translate("MainWindowMain", "Precio:"))
        self.label_6.setText(_translate("MainWindowMain", "Estado:"))
        self.TxtStock.setPlaceholderText(_translate("MainWindowMain", "Ingrese la cantidad"))
        self.label_7.setText(_translate("MainWindowMain", "Cantidad:"))
        self.label_9.setText(_translate("MainWindowMain", "Proveedor:"))
        self.label_10.setText(_translate("MainWindowMain", "Fecha Ingreso:"))
        self.radioButton.setText(_translate("MainWindowMain", "Disponible"))
        self.RbGroupStatus.setText(_translate("MainWindowMain", "No Disponible"))
        self.TxtId.setPlaceholderText(_translate("MainWindowMain", "Ingrese el código"))
        self.TxtName_2.setPlaceholderText(_translate("MainWindowMain", "Seleccione la fecha -->"))
        self.tabWidget.setTabText(self.tabWidget.indexOf(self.tab_2), _translate("MainWindowMain", "Registro de Productos"))
        item = self.cliTable.horizontalHeaderItem(0)
        item.setText(_translate("MainWindowMain", "Código"))
        item = self.cliTable.horizontalHeaderItem(1)
        item.setText(_translate("MainWindowMain", "Nombre"))
        item = self.cliTable.horizontalHeaderItem(2)
        item.setText(_translate("MainWindowMain", "Categoría"))
        item = self.cliTable.horizontalHeaderItem(3)
        item.setText(_translate("MainWindowMain", "Fecha Ingreso"))
        item = self.cliTable.horizontalHeaderItem(4)
        item.setText(_translate("MainWindowMain", "Cantidad"))
        item = self.cliTable.horizontalHeaderItem(5)
        item.setText(_translate("MainWindowMain", "Precio Costo"))
        item = self.cliTable.horizontalHeaderItem(6)
        item.setText(_translate("MainWindowMain", "Precio Venta"))
        item = self.cliTable.horizontalHeaderItem(7)
        item.setText(_translate("MainWindowMain", "Estado"))
        item = self.cliTable.horizontalHeaderItem(8)
        item.setText(_translate("MainWindowMain", "Proveedor"))
        self.TxtCode.setPlaceholderText(_translate("MainWindowMain", "Ingrese el código"))
        self.tabWidget.setTabText(self.tabWidget.indexOf(self.tab), _translate("MainWindowMain", "Consulta de Productos"))
        self.tabWidget.setTabText(self.tabWidget.indexOf(self.tab_3), _translate("MainWindowMain", "Reportes"))
        self.menuAbrir.setTitle(_translate("MainWindowMain", "Archivo"))
        self.toolBar.setWindowTitle(_translate("MainWindowMain", "toolBar"))
        self.actionOpen.setText(_translate("MainWindowMain", "Open"))
        self.actionExport.setText(_translate("MainWindowMain", "Export"))
        self.actionImport.setText(_translate("MainWindowMain", "Import"))
        self.actionCloseTB.setText(_translate("MainWindowMain", "Close"))
        self.actionAbrir.setText(_translate("MainWindowMain", "Abrir"))
        self.actionSalir.setText(_translate("MainWindowMain", "Salir"))
