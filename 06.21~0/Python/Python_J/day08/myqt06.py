import random

from PyQt5.QtWidgets import QApplication, QMainWindow, QMessageBox, QPushButton
from PyQt5.uic import loadUi


class MainWindow(QMainWindow):
    def __init__(self):
        super(MainWindow, self).__init__()
        loadUi("myqt06.ui", self)  # .ui 파일 로드

        self.pbtn1.clicked.connect(self.myclick)  # 버튼 클릭 시 이벤트 연결

    def myclick(self):
        arr = ["가위", "바위", "보"]

        mine = arr[random.randint(0, 2)]
        self.le1.setText(mine)
        # mine = str(self.le1.text())
        com = arr[random.randint(0, 2)]
        self.le2.setText(com)

        result = ""
        if mine == com:
            result = "무승부"
        elif mine == "가위" and com == "보" or mine == "바위" and com == "가위" or mine == "보" and com == "바위":
            result = "승리!"
        else:
            result = "패배"
        self.le3.setText(result)


if __name__ == "__main__":
    app = QApplication([])
    mywindow = MainWindow()
    mywindow.show()
    app.exec_()
