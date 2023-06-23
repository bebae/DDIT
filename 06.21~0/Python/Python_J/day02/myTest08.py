# 출력할 구구단 입력

num = input("출력할 구구단을 입력하세요 : ")

for i in range(1, 9+1):
    print(f"{num} X {i} = {int(num) * i}")

num = input("출력할 구구단을 입력하세요: ")

result = [f"{num} X {i} = {int(num) * i}" for i in range(1, 9+1)]
print("\n".join(result))
