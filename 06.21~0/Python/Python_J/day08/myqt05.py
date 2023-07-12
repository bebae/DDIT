from PyQt5.QtWidgets import QApplication, QMainWindow, QMessageBox, QPushButton
from PyQt5.uic import loadUi


class MainWindow(QMainWindow):
    def __init__(self):
        super(MainWindow, self).__init__()
        loadUi("myqt05.ui", self)  # .ui 파일 로드

        self.pbtn_call.clicked.connect(self.myclick)  # 버튼 클릭 시 이벤트 연결
        btn_list = [self.pbtn0, self.pbtn1, self.pbtn2, self.pbtn3, self.pbtn4, self.pbtn5, self.pbtn6, self.pbtn7,
                    self.pbtn8, self.pbtn9]
        for i in range(9):
            btn = btn_list[i]
            btn.clicked.connect(self.btnclick)
            # btn.n = i

    def myclick(self):
        QMessageBox.information(self, "결과창", self.le1.text())

    def btnclick(self):
        # btn = self.sender()  # 클릭된 버튼 객체 가져오기
        # n = btn.n  # 사용자 정의 속성에서 n 값 읽어오기
        string = self.le1.text() + self.sender().text()
        self.le1.setText(string)


if __name__ == "__main__":
    app = QApplication([])
    mywindow = MainWindow()
    mywindow.show()
    app.exec_()
