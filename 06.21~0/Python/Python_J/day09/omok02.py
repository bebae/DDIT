from PyQt5.QtGui import QPixmap, QIcon
from PyQt5.QtWidgets import QApplication, QMainWindow, QPushButton
from PyQt5.uic import loadUi


class MainWindow(QMainWindow):
    def __init__(self):
        super(MainWindow, self).__init__()
        loadUi("omok02.ui", self)  # .ui 파일 로드
        self.setWindowTitle("오목판")

        # 오목판 크기
        row_count = 10
        column_count = 10

        self.buttons = []  # 버튼 리스트 초기화

        # 오목판 버튼 생성 및 이미지 설정
        button_width = 40
        button_height = 40
        button_spacing = 0
        for i in range(row_count):
            for j in range(column_count):
                button = QPushButton(self)
                button.setFixedSize(button_width, button_height)
                button.setIcon(QIcon(QPixmap("40pix/0.png")))
                button.setIconSize(button.size())
                button.clicked.connect(self.change_image)
                self.buttons.append(button)

                x = j * (button_width + button_spacing)
                y = i * (button_height + button_spacing)
                button.setGeometry(x, y, button_width, button_height)  # 버튼의 위치와 크기 설정

        self.btn_reset.clicked.connect(self.reset)
        self.image_index = 0

    def change_image(self):
        button = self.sender()
        if self.image_index % 2 == 0:
            button.setIcon(QIcon(QPixmap("40pix/2.png")))
        else:
            button.setIcon(QIcon(QPixmap("40pix/1.png")))
        self.image_index += 1

    def reset(self):
        for button in self.buttons:
            button.setIcon(QIcon(QPixmap("40pix/0.png")))


if __name__ == "__main__":
    app = QApplication([])
    mywindow = MainWindow()
    mywindow.show()
    app.exec_()
