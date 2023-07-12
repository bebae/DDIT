import requests
from bs4 import BeautifulSoup

if __name__ == '__main__':
    url = "https://www.daangn.com/hot_articles"

    response = requests.get(url)

    html = response.text
    soup = BeautifulSoup(html, 'html.parser')

    tab = soup.select(".card-price")

    for idx, i in enumerate(tab):
        print(i.text)