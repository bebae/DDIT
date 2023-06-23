

snum = input("첫 수를 입력하세요 : ")
enum = input("끝 수를 입력하세요 : ")


char = int(snum) - int(enum)
if char < 0:
    char *= -1

if snum > enum:
    print(f"{snum}은 {enum}보다 {char}만큼 작다")
elif enum > snum:
    print(f"{snum}은 {enum}보다 {char}만큼 크다")
else:
    print("같은 숫자입니다.")
