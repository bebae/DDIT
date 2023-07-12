from PyQt5.QtWidgets import QApplication, QMainWindow, QLabel, QPushButton
from PyQt5.uic import loadUi


class MainWindow(QMainWindow):
    def __init__(self):
        super(MainWindow, self).__init__()
        loadUi("myqt01.ui", self)  # .ui 파일 로드

        self.btn1.clicked.connect(self.myclick)  # 버튼 클릭 시 이벤트 연결

    def myclick(self):
        if self.text1.text() == "Good Moring":
            self.text1.setText("Good Evening!")  # 레이블 텍스트 변경
        else:
            self.text1.setText("Good Moring")  # 레이블 텍스트 변경
        print(self.text1.text())


if __name__ == "__main__":
    app = QApplication([])
    mywindow = MainWindow()
    mywindow.show()
    app.exec_()
