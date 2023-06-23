import random


def getrandomholl():
    cm = ""
    if random.random() > 0.5:
        cm = "홀"
    else:
        cm = "짝"
    return cm


com = getrandomholl()
print("com : ", com)
