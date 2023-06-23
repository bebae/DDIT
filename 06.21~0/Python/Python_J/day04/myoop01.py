class Vechicle:
    def __init__(self):
        self.wheel_cnt = 2

    def flex(self):
        self.wheel_cnt = 4

    def __str__(self):
        return str(self.wheel_cnt)


class Car(Vechicle):
    def __init__(self):
        super().__init__()
        self.autoPilot_level = 1

    def hit(self):
        self.autoPilot_level += 1


if __name__ == '__main__':
    v = Vechicle()
    print(v)
    v.flex()
    print(v)
    c = Car()
    print("c cnt : ", c.wheel_cnt)
    print("c level : ", c.autoPilot_level)
    c.flex()
    c.hit()
    c.hit()
    print("c cnt : ", c.wheel_cnt)
    print("c level : ", c.autoPilot_level)
