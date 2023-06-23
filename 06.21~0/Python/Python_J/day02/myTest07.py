#홀/짝 선택 :
import random

com = ["홀", "짝"]

me = input("홀/짝 선택하세요 : ")
# selcom = com[random.randint(0, len(com)-1)]
selcom = random.choice(com)

result = ""

if me == selcom:
    result = "승리"
else:
    result = "패배"

print(f"나 : {me}\n컴 : {selcom}\n결과 : {result}")