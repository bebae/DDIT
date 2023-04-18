-- 트리거

-- 다음 파일이름을 입력하여 새로 생긴 SQL 파일에 다음과 같이 입력하시오.(파일이름:TRIG01.SQL)
CREATE OR REPLACE TRIGGER th_lprod_in AFTER
    INSERT ON lprod
BEGIN
    dbms_output.put_line('상품부류가 추가되었습니다.');
END;
/

-- 만들어진 트리거확인
SELECT
    trigger_name
FROM
    user_triggers;

-- 상품분류 테이블에 로우를 추가.
set serveroutput on;

INSERT INTO lprod (
    lprod_id,
    lprod_gu,
    lprod_nm
) VALUES (
    (
        SELECT
            MAX(lprod_id) + 1
        FROM
            lprod
    ),
    (
        SELECT
            'P'
            || ( substr(MAX(lprod_gu), 2) + 1 )
        FROM
            lprod
    ),
    '트리거추가값1'
);

SELECT
    *
FROM
    lprod;

/*
-- 직원을 저장할 테이블 생성
create table emp01(
    empno number(4) primary key,
    empname varchar2(45),
    empjob varchar2(60)
);

--급여를 저장할 테이블 생성
create TABLE SAL01(
	SALNO NUMBER(4) PRIMARY KEY,
	SAL   NUMBER(7,2),
	EMPNO NUMBER(4) REFERENCES EMP01(EMPNO)
);
*/

--  급여번호를 자동 생성하는 시퀀스를 정의하고
-- 이 시퀀스로부터 일련번호를 얻어 급여번호에 부여합시다.
CREATE SEQUENCE sal01_salno_seq;

CREATE OR REPLACE TRIGGER trg_02 AFTER
    INSERT ON emp01
    FOR EACH ROW
BEGIN
    INSERT INTO sal01 VALUES (
        sal01_salno_seq.NEXTVAL,
        100,
        :new.empno
    );

END;
/

INSERT INTO emp01 VALUES (
    2,
    '전수빈',
    '프로그래머'
);

INSERT INTO emp01 VALUES (
    1,
    '정범진',
    '프로그래머'
);

INSERT INTO emp01 VALUES (
    3,
    '이한준',
    '화가'
);

SELECT
    *
FROM
    emp01;

SELECT
    *
FROM
    sal01;

-- 사원이 삭제되면 그 사원의 급여 정보도 자동 삭제되는 트리거를 작성해 보도록 합시다.
DELETE FROM emp01
WHERE
    empno = 2;

-- 사원의 정보가 제거 될 때 그 사원의 급여 정보도 함께 삭제하는 내용을 트리거로 작성
CREATE OR REPLACE TRIGGER trg_03 AFTER
    DELETE ON emp01
    FOR EACH ROW
BEGIN
    DELETE FROM sal01
    WHERE
        empno = :old.empno;

END;
/

-- 사원 테이블에 로우를 삭제해 봅시다.
DELETE FROM emp01
WHERE
    empno = 1;

SELECT
    *
FROM
    emp01;

SELECT
    *
FROM
    sal01;

-- DROP TIGGER 다음에 삭제할 트리거 명을 기술합니다.
DROP TRIGGER trg_02;

DROP TRIGGER trg_03;


-- 상품이 입력되면 입고 수량을 상품 테이블의 재고 수량에 추가되는 트리거
/*
-- 상품 테이블 생성
CREATE TABLE PRODUCT(
	PROD_ID   VARCHAR2(6) PRIMARY KEY,	--상품코드
	PROD_NAME VARCHAR2(12) NOT NULL,     --상품명
	PROD_JEJO VARCHAR(12),               --제조사
	PROD_SALE NUMBER(8),				--소비자가격
	PROD_JAEGO NUMBER DEFAULT 0		--재고수량
);

-- 입고 테이블 생성
CREATE TABLE IPGO(
	IPGO_ID NUMBER(6) PRIMARY KEY,				  --입고번호
	PROD_ID VARCHAR2(6) REFERENCES PRODUCT(PROD_ID), --상품코드
	IPGO_DAY DATE DEFAULT SYSDATE,				  --입고일자
	IPGO_QTY NUMBER(6),						  --입고수량
	IPGO_COST NUMBER(8),						  --입고단가
	IPGO_AMOUNT NUMBER(8)					  --입고금액
);
*/

-- 샘플 데이터 입력
INSERT INTO product (
    prod_id,
    prod_name,
    prod_jejo,
    prod_sale
) VALUES (
    'A00001',
    '세탁기',
    'LG',
    500
);

INSERT INTO product (
    prod_id,
    prod_name,
    prod_jejo,
    prod_sale
) VALUES (
    'A00002',
    '컴퓨터',
    'LG',
    700
);

INSERT INTO product (
    prod_id,
    prod_name,
    prod_jejo,
    prod_sale
) VALUES (
    'A00003',
    '냉장고',
    '삼성',
    600
);

-- 입고 테이블에 상품이 입력되면 입고 수량을 상품 테이블의 재고 수량에 추가하는 트리거
CREATE OR REPLACE TRIGGER trg_04 AFTER
    INSERT ON ipgo
    FOR EACH ROW
BEGIN
    UPDATE product
    SET
        prod_jaego = prod_jaego + :new.ipgo_qty
    WHERE
        prod_id = :new.prod_id;

END;
/

-- 트리거를 실행시킨 후 입고 테이블에 행 추가
-- 수량 변경을 확인
INSERT INTO ipgo (
    ipgo_id,
    prod_id,
    ipgo_qty,
    ipgo_cost,
    ipgo_amount
) VALUES (
    1,
    'A00001',
    5,
    320,
    1600
);

INSERT INTO ipgo (
    ipgo_id,
    prod_id,
    ipgo_qty,
    ipgo_cost,
    ipgo_amount
) VALUES (
    3,
    'A00001',
    15,
    320,
    4800
);

SELECT
    *
FROM
    ipgo;

SELECT
    *
FROM
    product;

-- 입고 테이블에 또 다른 상품
INSERT INTO ipgo (
    ipgo_id,
    prod_id,
    ipgo_qty,
    ipgo_cost,
    ipgo_amount
) VALUES (
    2,
    'A00002',
    10,
    680,
    6800
);

INSERT INTO ipgo (
    ipgo_id,
    prod_id,
    ipgo_qty,
    ipgo_cost,
    ipgo_amount
) VALUES (
    4,
    'A00003',
    20,
    560,
    13000
);

INSERT INTO ipgo (
    ipgo_id,
    prod_id,
    ipgo_qty,
    ipgo_cost,
    ipgo_amount
) VALUES (
    5,
    'A00002',
    20,
    680,
    13600
);

SELECT
    *
FROM
    ipgo;

SELECT
    *
FROM
    product;

-- 갱신 트리거
CREATE OR REPLACE TRIGGER trg_05 AFTER
    UPDATE ON ipgo
    FOR EACH ROW
BEGIN
    UPDATE product
    SET
        prod_jaego = prod_jaego + ( - :old.ipgo_qty + :new.ipgo_qty )
    WHERE
        prod_id = :new.prod_id;

END;
/

UPDATE ipgo
SET
    ipgo_qty = 10,
    ipgo_amount = 2200
WHERE
    ipgo_id = 3;

SELECT
    *
FROM
    ipgo
ORDER BY
    ipgo_id;

SELECT
    *
FROM
    product;

-- 삭제 트리거
CREATE OR REPLACE TRIGGER trg_06 AFTER
    DELETE ON ipgo
    FOR EACH ROW
BEGIN
    UPDATE product
    SET
        prod_jaego = prod_jaego - :old.ipgo_qty
    WHERE
        prod_id = :old.prod_id;

END;
/

DELETE ipgo
WHERE
    ipgo_id = 3;

SELECT
    *
FROM
    ipgo
ORDER BY
    ipgo_id;

SELECT
    *
FROM
    product;