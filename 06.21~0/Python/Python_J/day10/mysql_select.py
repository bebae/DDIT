import mysql.connector

# MySQL 서버에 연결합니다.
cnx = mysql.connector.connect(
    host="localhost",
    user="root",
    password="python",
    database="pythontest01"
)

# 커서를 생성합니다.
cursor = cnx.cursor()

# SELECT 문을 실행합니다.
query = "SELECT * FROM emp"
cursor.execute(query)

# 결과를 가져옵니다.
result = cursor.fetchall()

# 결과를 출력합니다.
for row in result:
    print(row)

# 커서와 연결을 닫습니다.
cursor.close()
cnx.close()