import random

from PyQt5.QtWidgets import QApplication, QMainWindow, QMessageBox, QPushButton
from PyQt5.uic import loadUi


class MainWindow(QMainWindow):
    arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]

    def __init__(self):
        super(MainWindow, self).__init__()
        loadUi("omok01.ui", self)  # .ui 파일 로드

        random.shuffle(self.arr)
        self.pbtn1.clicked.connect(self.myclick)  # 버튼 클릭 시 이벤트 연결
        self.le1.returnPressed.connect(self.enter_pressed)  # 엔터 키 이벤트 연결

    def enter_pressed(self):
        self.myclick()

    def myclick(self):
        mine = [int(digit) for digit in self.le1.text()]

        # strike = 0
        # ball = 0
        # for i in range(3):
        #     if self.arr[i] == mine[i]:
        #         strike += 1
        #     elif self.arr[i] in mine:
        #         ball += 1
        strike = sum(1 for i in range(3) if self.arr[i] == mine[i])
        ball = sum(1 for i in range(3) if self.arr[i] in mine and self.arr[i] != mine[i])

        if strike == 0 and ball == 0:
            result = "OUT!\n"
        elif strike == 0:
            result = f"{ball}B\n"
        elif ball <= 0:
            result = f"{strike}S\n"
        else:
            result = f"{strike}S{ball}B\n"

        if strike >= len(mine):
            QMessageBox.information(self, "결과창", "홈런!")

        result = self.le1.text() + " : " + result
        self.le1.setText("")
        self.le2.setText(result)
        oldtext = self.te1.toPlainText()
        self.te1.setPlainText(result+oldtext)


if __name__ == "__main__":
    app = QApplication([])
    mywindow = MainWindow()
    mywindow.show()
    app.exec_()
