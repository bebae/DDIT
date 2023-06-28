import random

if __name__ == '__main__':
    arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]
    random.shuffle(arr)

    while True:
        number = input("숫자를 입력하세요: ")
        mine = [int(digit) for digit in number]

        strike = 0
        ball = 0
        for i in range(3):
            if arr[i] == mine[i]:
                strike += 1
            elif arr[i] in mine:
                ball += 1
        if strike == 0 and ball == 0:
            print("OUT!")
        elif strike == 0:
            print(f"{ball}B")
        elif ball <= 0:
            print(f"{strike}S")
        else:
            print(f"{strike}S{ball}B")

        if strike >= len(mine):
            break
