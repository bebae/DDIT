import requests
from bs4 import BeautifulSoup

if __name__ == '__main__':
    url = 'https://kin.naver.com/search/list.nhn?query=%ED%8C%8C%EC%9D%B4%EC%8D%AC'

    response = requests.get(url)
    # print("response", response.text)

    html = response.text
    soup = BeautifulSoup(html, 'html.parser')
    src = soup.find_all("script")
    for idx, s in enumerate(src):
        if idx == 0:
            continue
        print(idx, "soup", s)