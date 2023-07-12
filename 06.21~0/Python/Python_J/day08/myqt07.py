import random

from PyQt5.QtWidgets import QApplication, QMainWindow, QMessageBox, QPushButton
from PyQt5.uic import loadUi


class MainWindow(QMainWindow):
    def __init__(self):
        super(MainWindow, self).__init__()
        loadUi("myqt07.ui", self)  # .ui 파일 로드

        self.pbtn1.clicked.connect(self.myclick)  # 버튼 클릭 시 이벤트 연결

    def myclick(self):
        start = int(self.le1.text())
        end = int(self.le2.text())
        result = ""
        # for i in range(start, end+1):
        #     for j in range(i):
        #         result += "*"
        #     result += "\n"
        for i in range(start, end + 1):
            for j in range(i, end):
                result += ' '
            for j in range(start - 1, 2 * i - 1):
                result += "*"
            result += "\n"

        self.te1.setText(result)


if __name__ == "__main__":
    app = QApplication([])
    mywindow = MainWindow()
    mywindow.show()
    app.exec_()
