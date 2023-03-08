-- 자동차 기본테이블 만들기

DROP TABLE motor;

CREATE TABLE motor (
    memberno CHAR(9) NOT NULL,
    name VARCHAR2(10) NOT NULL,
    model VARCHAR2(20) NOT NULL,
    yymm NUMBER(4) NOT NULL,
    add1 VARCHAR2(30) NOT NULL,
    CONSTRAINT pk_motor PRIMARY KEY (memberno)
);

INSERT INTO motor(memberno, name, model, yymm, add1) 
VALUES('A00010001', '김경자', '소나타', 1990, '서울시');
INSERT INTO motor(memberno, name, model, yymm, add1) 
VALUES('A00010002', '이종삼', '아반테', 1995, '제주시');
INSERT INTO motor(memberno, name, model, yymm, add1) 
VALUES('A00010003', '김장미', 'EF소나타', 1999, '인천시');
INSERT INTO motor(memberno, name, model, yymm, add1) 
VALUES('A00010004', '최창호', '에쿠스', 2000, '강릉시');
INSERT INTO motor(memberno, name, model, yymm, add1) 
VALUES('A00010005', '이춘화', '소나타Ⅱ', 1998, '제주시');
INSERT INTO motor(memberno, name, model, yymm, add1) 
VALUES('A00010006', '전청화', '다이너스티', 1997, '서울시');
INSERT INTO motor(memberno, name, model, yymm, add1) 
VALUES('A00010007', '길기태', '엑셀', 1992, '서울시');
INSERT INTO motor(memberno, name, model, yymm, add1) 
VALUES('A00010008', '장준화', '엑센트', 1997, '수원시');
INSERT INTO motor(memberno, name, model, yymm, add1) 
VALUES('A00010009', '김미희', '그랜져X', 1994, '인천시');
INSERT INTO motor(memberno, name, model, yymm, add1) 
VALUES('A00010010', '이재창', '아토스', 1998, '대구시');

SELECT * FROM motor WHERE yymm <1999;

UPDATE motor SET add1 = '서울시' WHERE add1 = '인천광역시';



