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
    name_width = 20
    price_width = 15
    rate_width = 10

    # 항목 출력
    print("번호", end="\t")
    print("고유키".ljust(code_width), end="\t")
    print("기업명".ljust(15), end="")
    print("1주가격".ljust(15), end="\t")
    print("변동율".ljust(rate_width), end="\t")
    print("거래량(주)".ljust(10), end="\t")
    print("자본금(억)".ljust(10), end="\t")
    print("상장주식수(천주)".ljust(14), end="\t")
    print("시가총액(백만)".ljust(14), end="\t")
    print("외국인보유비중".ljust(12), end="\t")
    print("PER/EPS")
    print("=" * 200)

    for idx, row in enumerate(tab):
        # 데이터 추출
        href = row.select_one(".st_name a")['href']
        code = href.split("/")[-1]
        name = row.select_one(".st_name a").text
        price = row.select_one(".st_price .price").text
        rate = row.select_one(".st_rate .icon").text

        # 상세 페이지 접근
        detail_url = f"https://stock.mk.co.kr/price/home/{code}"
        detail_response = requests.get(detail_url)
        detail_html = detail_response.text
        detail_soup = BeautifulSoup(detail_html, 'html.parser')

        # 상세 데이터 추출
        trading_volume = detail_soup.select_one("#trading_valume").text.strip()
        detail_table = detail_soup.select_one(".noline_bottom")
        rows = detail_table.select(".volume")[2:]  # 3번째 데이터부터 추출

        # 추가 데이터 추출
        data_values = [row.text.strip().replace(' ', '').replace('\n', '') for row in rows]

        # 데이터 출력
        print(f"{idx + 1}", end="\t")
        print(f"{code:{code_width}}", end="\t\t")
        print(f"{name:{name_width}}", end="\t")
        print(f"{price:{price_width}}", end="\t")
        print(f"{rate:{rate_width}}", end="\t")
        print(f"{trading_volume}", end="\t")
        # 추가 데이터 출력 (공백과 줄바꿈 제거)
        for value in data_values:
            print(value, end="\t\t\t\t")
        print()  # 개행
