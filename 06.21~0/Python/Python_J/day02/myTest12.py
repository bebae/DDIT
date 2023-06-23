import random

# mine = input("가위/바위/보를 입력하세요 : ")
sel = ["가위", "바위", "보"]

mine = random.choice(sel)
com = random.choice(sel)

result = ""

if mine == "가위" and com == "보": result = "승리"
if mine == "가위" and com == "바위": result = "패배"
if mine == "가위" and com == "가위": result = "무승부"

if mine == "바위" and com == "가위": result = "승리"
if mine == "바위" and com == "보": result = "패배"
if mine == "바위" and com == "바위": result = "무승부"

if mine == "보" and com == "바위": result = "승리"
if mine == "보" and com == "가위": result = "패배"
if mine == "보" and com == "보": result = "무승부"

print(f"나 : {mine}")
print(f"컴 : {com}")
print(f"결과 : {result}")
