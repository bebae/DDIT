from PyQt5.QtWidgets import QApplication, QMainWindow, QLabel, QPushButton
from PyQt5.uic import loadUi


class MainWindow(QMainWindow):
    def __init__(self):
        super(MainWindow, self).__init__()
        loadUi("myqt02.ui", self)  # .ui 파일 로드

        self.pbtn1.clicked.connect(self.myclick)  # 버튼 클릭 시 이벤트 연결

    def myclick(self):
        num = int(self.le1.text())
        num -= 1
        self.le1.setText(str(num))


if __name__ == "__main__":
    app = QApplication([])
    mywindow = MainWindow()
    mywindow.show()
    app.exec_()
