from PyQt5.QtGui import QPixmap, QIcon
from PyQt5.QtWidgets import QApplication, QMainWindow, QPushButton, QMessageBox
from PyQt5.uic import loadUi


class MainWindow(QMainWindow):
    def __init__(self):
        super(MainWindow, self).__init__()
        loadUi("omok03.ui", self)  # .ui 파일 로드
        self.setWindowTitle("오목판")

        # 오목판 크기
        row_count = 20
        column_count = 20

        self.buttons = []  # 버튼 리스트 초기화
        self.board = [[0] * column_count for _ in range(row_count)]  # 2D 배열 초기화

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
        self.game_ended = False

    def change_image(self):
        if self.game_ended:
            return

        button = self.sender()
        current_icon = button.icon().pixmap(button.iconSize())
        if current_icon and current_icon.isNull():
            return
        if current_icon and current_icon.toImage() != QPixmap("40pix/0.png").toImage():
            return
        if self.image_index % 2 == 0:
            button.setIcon(QIcon(QPixmap("40pix/2.png")))
            self.update_board(button, 2)  # 배열 업데이트
            if self.check_win(2):
                self.show_win_message(2)
                self.game_ended = True
        else:
            button.setIcon(QIcon(QPixmap("40pix/1.png")))
            self.update_board(button, 1)  # 배열 업데이트
            if self.check_win(1):
                self.show_win_message(1)
                self.game_ended = True
        self.image_index += 1

    def update_board(self, button, value):
        index = self.buttons.index(button)
        row = index // len(self.board[0])
        column = index % len(self.board[0])
        self.board[row][column] = value

    def check_win(self, value):
        directions = [(1, 0), (0, 1), (1, 1), (-1, 1)]  # 가로, 세로, 대각선 방향
        for button in self.buttons:
            if button.icon().pixmap(button.iconSize()).toImage() == QPixmap(f"40pix/{value}.png").toImage():
                index = self.buttons.index(button)
                row = index // len(self.board[0])
                column = index % len(self.board[0])
                for direction in directions:
                    if self.check_sequence(row, column, direction, value, 5):
                        return True
        return False

    def check_sequence(self, row, column, direction, value, length):
        dx, dy = direction
        count = 1  # 시작 돌을 포함하기 때문에 1로 초기화
        current_row, current_column = row + dx, column + dy

        while count < length:
            # 보드 범위를 벗어나거나 돌의 값이 다른 경우
            if (
                    current_row < 0
                    or current_row >= len(self.board)
                    or current_column < 0
                    or current_column >= len(self.board[0])
                    or self.board[current_row][current_column] != value
            ):
                break
            count += 1
            current_row += dx
            current_column += dy

        if count == length:
            return True
        return False

    def show_win_message(self, value):
        message = f"Player {value}가 이겼습니다!"
        QMessageBox.information(self, "게임 종료", message)

    def reset(self):
        for button in self.buttons:
            button.setIcon(QIcon(QPixmap("40pix/0.png")))
        self.board = [[0] * len(self.board[0]) for _ in range(len(self.board))]
        self.game_ended = False


if __name__ == "__main__":
    app = QApplication([])
    mywindow = MainWindow()
    mywindow.show()
    app.exec_()
