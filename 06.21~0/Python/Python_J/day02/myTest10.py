# 1~45까지 수중에서 로또 만들기
import random

lotto = list(range(1, 45+1))

for i in range(200):
    r = int(random.random()*45)
    x = lotto[0]
    lotto[0] = lotto[r]
    lotto[r] = x

# random.shuffle(lotto)

print(lotto[:6])
