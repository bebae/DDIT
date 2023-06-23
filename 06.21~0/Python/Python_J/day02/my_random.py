import random

# 랜덤 함수 호출 0.5 보다 크면 홀 아니면 짝 출력
ran_num = random.random()
if ran_num > 0.5:
    print("짝입니다")
else :
    print("홀입니다")