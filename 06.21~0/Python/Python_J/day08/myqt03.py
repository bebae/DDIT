import random
from PyQt5.QtWidgets import QApplication, QMainWindow, QLabel, QPushButton
from PyQt5.uic import loadUi


class MainWindow(QMainWindow):
    def __init__(self):
        super(MainWindow, self).__init__()
        loadUi("myqt03.ui", self)  # .ui 파일 로드

        self.pbtn1.clicked.connect(self.myclick)  # 버튼 클릭 시 이벤트 연결

    def myclick(self):
        arr = list(range(1, 45+1))
        random.shuffle(arr)
        label_widgets = [self.lb1, self.lb2, self.lb3, self.lb4, self.lb5, self.lb6]

        for i in range(6):
            label_widgets[i].setText(str(arr[i]))


if __name__ == "__main__":
    app = QApplication([])
    mywindow = MainWindow()
    mywindow.show()
    app.exec_()
