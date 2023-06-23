# 1~9까지 수 중에서 중복없이 3개의 수를 출력하세요
import random

arr1 = list(range(1, 9 + 1))
random.shuffle(arr1)

for i in range(3):
    print(arr1[i], end=" ")

print()
arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]

for i in range(len(arr)):
    r = random.randint(0, len(arr)-1)
    temp = arr[0]
    arr[0] = arr[int(r)]
    arr[r] = temp

print(arr)
print(arr[0], arr[1], arr[2])
