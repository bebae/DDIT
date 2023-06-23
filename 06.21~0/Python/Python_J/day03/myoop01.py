class Animal:
    def __init__(self):
        print("생성자")
        self.flag_sound = True

    def soundfalse(self):
        self.flag_sound = False

    def __del__(self):
        print("소멸자")

    def __str__(self):
        return "소리능력 : " + str(self.flag_sound)


class Human(Animal):
    def __init__(self):
        super().__init__()
        self.coummunity_skill = 0

    def momstouch(self, punch):
        self.coummunity_skill += punch

    def __str__(self):
        return "사람 : " + str(self.coummunity_skill)


if __name__ == '__main__':
    a = Animal()
    print("a oop1", a)
    a.soundfalse()
    print("a oop1", a)
    print("a oop1", not a.flag_sound)

    h = Human()
    print("oop1 h", h.coummunity_skill)
    print("h", h.flag_sound)
    h.soundfalse()
    h.momstouch(10)
    print("h", h)
    print("h", h.flag_sound)
