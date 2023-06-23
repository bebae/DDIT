class LeeJY:
    def __init__(self):
        self.cnt_company = 10

    def hit(self, punch):
        self.cnt_company += punch


class Biden:
    def __init__(self):
        self.hir_color = "white"

    def dye(self):
        self.hir_color = "red"


class Musk:
    def __init__(self):
        self.cnt_sat = 1000

    def launch(self):
        self.cnt_sat += 10


class Eunbi(LeeJY, Biden, Musk):
    def __init__(self):
        LeeJY.__init__(self)
        Biden.__init__(self)
        Musk.__init__(self)


if __name__ == '__main__':
    eb = Eunbi()
    print(eb.cnt_company)
    print(eb.hir_color)
    print(eb.cnt_sat)
    eb.hit(50)
    eb.dye()
    eb.launch()
    print(eb.cnt_company)
    print(eb.hir_color)
    print(eb.cnt_sat)
