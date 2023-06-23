# a = input("과일 입력 : ")
# print(a)

a1 = int(input("1번째 수 입력 : "))
a2 = int(input("2번째 수 입력 : "))
print("두 수의 합 : ", a1 + a2)
print("{}와 {}의 합은 {}입니다.".format(a1,a2,a1+a2))

# ---------------------------------------

b1 = int(input("1~100 사이의 수를 입력하세요 : "))
if b1 % 2 == 0:
    print("입력하신 %d는 짝수입니다." % b1)
else:
    print("입력하신 %d는 홀수입니다." % b1)

# ---------------------------------------
c1 = int(input("첫번째 숫자 : "))
c2 = int(input("두번째 숫자 : "))
c3 = int(input("배수를 입력 : "))
total = 0

# for i in range(c1, c2+1):
#     if i % c3 == 0:
#         total += i

for i in range(c1, c2+1):
    if i % c3 == 0 :
        total += i
print("%d에서 %d까지의 %d의 배수의 합은 %d입니다." % (c1, c2, c3, total))
print(f"{c1}에서 {c2}까지의 {c3}의 배수의 합은 {total}입니다.")
