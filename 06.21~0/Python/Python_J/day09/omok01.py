from PyQt5.QtGui import QPixmap, QIcon
from PyQt5.QtWidgets import QApplication, QMainWindow
from PyQt5.uic import loadUi


class MainWindow(QMainWindow):
    def __init__(self):
        super(MainWindow, self).__init__()
        loadUi("omok01.ui", self)  # .ui 파일 로드

        self.lb1.mousePressEvent = self.change_image
        self.pbtn1.clicked.connect(self.change_image2)

    def change_image(self, event):
        pixmap = QPixmap("./40pix/1.png")
        self.lb1.setPixmap(pixmap)

    def change_image2(self, event):
        self.pbtn1.setIcon(QIcon("./40pix/2.png"))

    def myclick(self):
        pass


if __name__ == "__main__":
    app = QApplication([])
    mywindow = MainWindow()
    mywindow.show()
    app.exec_()
