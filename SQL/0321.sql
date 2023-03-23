SELECT '<' || LTRIM('       AAA      ') || '>' LTRIM1, '<' 
    || LTRIM('HELOOW WORLD', 'HE') || '>' LTRIM2 FROM DUAL;
SELECT '<' || RTRIM('       AAA      ') || '>' RTRIM1, '<' 
    || RTRIM('HELOOW WORLD', 'LD') || '>' RTRIM2 FROM DUAL;

SELECT '<' || TRIM('     A A A     ') || '>' TRIM1,
    '<' || TRIM(LEADING 'a' FROM 'aaAaBaAaa') || '>' TRIM2,
    '<' || TRIM(TRAILING 'a' FROM 'aaAaBaAaa') || '>' TRIM3,
    '<' || TRIM(BOTH 'a'  FROM 'aaAaBaAaa') || '>' TRIM4,
    '<' || TRIM( 'a' FROM 'aaAaBaAaa') || '>' TRIM5
    FROM DUAL;
    
-- DUAL ���� ���̺�
SELECT * FROM DUAL;

-- SUBSTR [���ڿ�] [������ġ] [����]
SELECT SUBSTR('SQL PROJECT', 1, 3) RESULT1,
        SUBSTR('SQL PROJECT', 5) RESULT2,
        SUBSTR('SQL PROJECT', -7, 3) RESULT3,
        SUBSTR('SQL PROJECT', 3, 5) RESULT4,
        SUBSTR('SQL PROJECT', -4, 2) RESULT5
        FROM DUAL;
        
SELECT MEM_ID, SUBSTR(MEM_NAME, 1, 1) ���� FROM MEMBER;

SELECT PROD_ID ��ǰ�ڵ�, PROD_NAME Į���ǰ�� 
        FROM PROD WHERE SUBSTR(PROD_NAME, 4, 2) = 'Į��';

SELECT REPLACE('SQL Project', 'SQL', 'SSQQLL') ����ġȯ1, REPLACE('Java Flex Via', 'a')
        FROM DUAL;
SELECT MEM_NAME ȸ����, 
        REPLACE(SUBSTR(MEM_NAME, 1, 1), '��', '��') || SUBSTR(MEM_NAME, 2, 2) ġȯȸ����
        FROM MEMBER WHERE SUBSTR(MEM_NAME, 1, 1) = '��';

-- TRANSLATE [��� ���ڿ�] [ġȯ�� ����] [ġȯ�� ����](�����ϸ� ����]
SELECT TRANSLATE('2009-02-28', '0123456789-', '�����̻�����ĥ�ȱ�/') RESULT
        FROM DUAL;
SELECT MEM_ID ȸ�����̵�, TRANSLATE(MEM_ID, '0123456789', ' ') ��ȯ���̵�
        FROM MEMBER;

-- INSTR [�˻��� ���ڿ�] [ã�� ���ڿ�] [���� ��ġ] [N��° ��ġ(�⺻�� 1)]
SELECT INSTR('HELLO HEIDI', 'HE') RESULT1, INSTR('HELLO HEIDI', 'HE', 3) RESULT2
        FROM DUAL;

SELECT LENGTH('SQL ������Ʈ') LENGTH, LENGTHB('SQL ������Ʈ') LENGTHB 
        FROM DUAL;

SELECT  ABS(-365) FROM DUAL;
SELECT SIGN(12),  SIGN(0),  SIGN(-55)
        FROM DUAL;
SELECT  POWER(3, 2) ,    POWER(2, 10)  
        FROM DUAL;
SELECT  SQRT(2) , SQRT(9) FROM DUAL;

SELECT ROUND(345.123, 0) ��� FROM DUAL;
SELECT ROUND(345.123, -1) ���1, TRUNC(345.123, -1) ���2 FROM DUAL;

SELECT * FROM MEMBER;

SELECT ROUND(MEM_MILEAGE/12, 3) ���ϸ��� FROM MEMBER;

SELECT MOD(10,3) FROM DUAL;

SELECT FLOOR(1332.69), CEIL(1332.68) FROM DUAL;
SELECT  FLOOR(-1332.69), CEIL(-1332.69) FROM DUAL;

-- WIDTH_BUCKET([��],[MIN��],[MAX��],[���� ��])
SELECT WIDTH_BUCKET(55, 0, 100, 10) ����������ϴ°� FROM DUAL;
SELECT MEM_ID, MEM_NAME, MEM_MILEAGE,
        WIDTH_BUCKET(MEM_MILEAGE, 9000, 500, 5) MILEAGE_GROUP
        FROM MEMBER ORDER BY MILEAGE_GROUP;
        
SELECT  ROUND(345.123 - 0.05, 1) AS "RESULT1" , 
        ROUND(345.123 - 0.5, 0)  AS "RESULT2", 
        ROUND(345.123 - 5, -1)   AS "RESULT3"  
        FROM DUAL; 

SELECT 10000 / 7 FROM DUAL;
SELECT FLOOR(10000 / 7 * 1000) / 1000 FROM DUAL;
SELECT FLOOR(10000 / 7 * 100) / 100 FROM DUAL;
SELECT FLOOR(10000 / 7 * 10) / 10 FROM DUAL;
SELECT FLOOR(10000 / 7 ) FROM DUAL;
SELECT FLOOR(10000 / 7 / 10) * 10 FROM DUAL;
SELECT FLOOR(10000 / 7 / 100) * 100 FROM DUAL;
SELECT FLOOR(10000 / 7 / 1000) * 10000 FROM DUAL;

SELECT SYSDATE ����ð�, SYSDATE - 1 "���� �̽ð�", SYSDATE+1 "���� �̽ð�"
        FROM DUAL;
        
SELECT SYSDATE ���ó�¥, LAST_DAY(SYSDATE) "�̴� ������ ��¥",
        LAST_DAY(SYSDATE) - SYSDATE "�̹��޿� ���� ��¥"
        FROM DUAL;











