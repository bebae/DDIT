import requests
from bs4 import BeautifulSoup

if __name__ == '__main__':
    url = "https://stock.mk.co.kr/domestic/all_stocks?type=kospi&status=industry"

    response = requests.get(url)

    html = response.text
    soup = BeautifulSoup(html, 'html.parser')

    tab = soup.select(".row_sty")

    # 각 열의 폭 지정
    code_width = 12
    name_width = 25
    price_width = 15
    rate_width = 10

    for idx, row in enumerate(tab):
        # 데이터 추출
        href = row.select_one(".st_name a")['href']
        code = href.split("/")[-1]
        name = row.select_one(".st_name a").text
        price = row.select_one(".st_price .price").text
        rate = row.select_one(".st_rate .icon").text

        # 데이터 출력
        print(f"{code:{code_width}}", end=" ")
        print(f"{name:{name_width}}", end="")
        print(f"{price:{price_width}}", end="")
        print(f"{rate:{rate_width}}")

