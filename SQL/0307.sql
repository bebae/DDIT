
DROP TABLE EMPOLYER;                     -- ���̺� ����

CREATE TABLE EMPOLYER(                  -- ���̺� ����
    EMPNO CHAR(6) NOT NULL,            -- �μ� ��ȣ
    ENAME  VARCHAR2(20) NOT NULL,  -- �̸�
    DEPT     VARCHAR2(16) NOT NULL,  -- �μ���
    TEL       VARCHAR2(14),                  -- ��ȭ��ȣ
    SALARY NUMBER(10),                      -- �޿�
    CONSTRAINT PK_EMPNO PRIMARY KEY (EMPNO)      -- �����̸Ӹ� Ű ����
);
ALTER TABLE EMPOLYER ADD (ADDRESS VARCHAR2 (50) NOT NULL);  -- �ʵ� ����
ALTER TABLE EMPOLYER MODIFY(DEPT VARCHAR2(30));                     -- �ʵ� �Ӽ� ����

CREATE TABLE EMPOLYER(                  -- ���̺� ����
    EMPNO CHAR(6) NOT NULL,            -- �μ� ��ȣ
    ENAME  VARCHAR2(20) NOT NULL,  -- �̸�
    ADDRESS VARCHAR2 (50) NOT NULL, -- �ּ�
    DEPT     VARCHAR2(16) NOT NULL,  -- �μ���
    TEL       VARCHAR2(14),                  -- ��ȭ��ȣ
    SALARY NUMBER(10),                      -- �޿�
    CONSTRAINT PK_EMPNO PRIMARY KEY (EMPNO)      -- �����̸Ӹ� Ű ����
);


INSERT INTO EMPOLYER(EMPNO, ENAME, DEPT, TEL, SALARY, ADDRESS)
    VALUES('100','�����','������','010-8422-8117',300,'���������� ���� �л��31���� 31');
INSERT INTO EMPOLYER(EMPNO,ENAME,DEPT,TEL,SALARY,ADDRESS)
        VALUES('101','ȫ����','��ȹ��','010-7562-3217',350,'���������� ���� ����29���� 50');
 INSERT INTO EMPOLYER(EMPNO,ENAME,DEPT,TEL,SALARY,ADDRESS)
        VALUES('102','�̸���','��ȹ��','010-5562-6677',500,'���������� �߱� ����30���� 10');
 INSERT INTO EMPOLYER(EMPNO,ENAME,DEPT,TEL,SALARY,ADDRESS)
        VALUES('103','������','������','010-4442-5614',350,'���������� �߱� ��ȭ��10���� 30');
 INSERT INTO EMPOLYER(EMPNO,ENAME,DEPT,TEL,SALARY,ADDRESS)
        VALUES('109','�κ�ö','�ѹ���','010-2542-8211',250,'���������� ���� �곻��1205���� 24');

INSERT INTO EMPOLYER(EMPNO,ENAME,DEPT,TEL,SALARY,ADDRESS)
        VALUES('110','������','���ߺ�','010-9303-1907',250,'���������� ���� �������1014���� 25');

SELECT * FROM EMPOLYER;             -- ������ ��ȸ

-- ������ SQL ���� �׽�Ʈ �ϱ�
-- �����ȣ�� 110�� ��� ��ȸ
SELECT * FROM EMPOLYER WHERE EMPNO='110';
-- �޿��� 250������ ��� ��ȸ
SELECT * FROM EMPOLYER WHERE SALARY=250;
-- ���� ����� ��ȸ
SELECT COUNT(*) �ѻ���� FROM EMPOLYER;
-- �޿��� 300���� �̻��� ��� ��ȸ
SELECT * FROM EMPOLYER WHERE SALARY>=300;



-- ���̺� �� ������ ���� SQL Developer
DROP TABLE EMP;

CREATE TABLE EMP(
    EMPID   CHAR(6) NOT NULL,
    SUNG    VARCHAR2(20) NOT NULL,
    DEPT    VARCHAR2(20) NOT NULL,
    HIRE_DATE   DATE,
    BIRTHDAY    VARCHAR2(20),
    ADDRESS VARCHAR2(50),
    JOB     VARCHAR2(20),
    SALARY     NUMBER(10),
    CONSTRAINT PK_EMP PRIMARY KEY(EMPID)
);

 INSERT INTO EMP(EMPID,SUNG,DEPT,HIRE_DATE,BIRTHDAY, ADDRESS, JOB, SALARY)
        VALUES('1006','��¼�','���ߺ�',SYSDATE,'1985.10.12','���� ���� ���� 345', 'ERP���α׷�', 350);
   INSERT INTO EMP(EMPID,SUNG,DEPT,HIRE_DATE,BIRTHDAY, ADDRESS, JOB, SALARY)
        VALUES('1002','������','������',SYSDATE,'1985.10.12','�Ⱦ� �����', 'Ư������', 400);
   INSERT INTO EMP(EMPID,SUNG,DEPT,HIRE_DATE,BIRTHDAY, ADDRESS, JOB, SALARY)
        VALUES('1003','�赿��','�����',SYSDATE,'1985.10.12','�λ� ���ϵ�', 'ǰ������', 300);
   INSERT INTO EMP(EMPID,SUNG,DEPT,HIRE_DATE,BIRTHDAY, ADDRESS, JOB, SALARY)
        VALUES('1004','�����','�λ��',SYSDATE,'1985.10.12','�뱸 �޼���', '�޿�����', 450);
   INSERT INTO EMP(EMPID,SUNG,DEPT,HIRE_DATE,BIRTHDAY, ADDRESS, JOB, SALARY)
        VALUES('1005','�ڼ���','���ź�',SYSDATE,'1985.10.12','���� �����', '��������', 320);

SELECT * FROM EMP;

CREATE VIEW VIEW_EMP1 AS SELECT EMPID, SUNG, DEPT, HIRE_DATE, SALARY FROM EMP;
-- WHERE SALARY >= 150;
CREATE VIEW VIEW_EMP2 AS SELECT EMPID, SUNG, DEPT, JOB FROM EMP;
CREATE VIEW VIEW_EMP3 AS SELECT EMPID, SUNG, BIRTHDAY, ADDRESS FROM EMP;

SELECT * FROM view_emp1;
SELECT * FROM view_emp2;
SELECT * FROM view_emp3;

-- VIEW���� ������ SQL ���� �׽�Ʈ �ϱ�
-- VIEW_EMP1���� ������� 2000�� �����̰� �޿��� 350���� �̻��� ��� ��ȸ
SELECT * FROM VIEW_EMP1 WHERE SUBSTR(HIRE_DATE, 1, 4) > '2000' AND SALARY>=350;
-- VIEW_EMP2���� ����(JOB)�� Ư�������� ��� ��ȸ
SELECT * FROM VIEW_EMP2 WHERE JOB = 'Ư������';
-- VIEW_EMP3���� ������ 1986�⵵�� ��� ��ȸ
SELECT * FROM VIEW_EMP3 WHERE SUBSTR(BIRTHDAY, 1, 4) = '1985';










