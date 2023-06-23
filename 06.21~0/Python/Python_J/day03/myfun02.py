def showdan(dan):
    result = [f"{dan} X {i} = {int(dan) * i}" for i in range(1, 9 + 1)]
    print("\n".join(result))


showdan(7)
