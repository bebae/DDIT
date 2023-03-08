-- �ڵ��� �⺻���̺� �����

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
VALUES('A00010001', '�����', '�ҳ�Ÿ', 1990, '�����');
INSERT INTO motor(memberno, name, model, yymm, add1) 
VALUES('A00010002', '������', '�ƹ���', 1995, '���ֽ�');
INSERT INTO motor(memberno, name, model, yymm, add1) 
VALUES('A00010003', '�����', 'EF�ҳ�Ÿ', 1999, '��õ��');
INSERT INTO motor(memberno, name, model, yymm, add1) 
VALUES('A00010004', '��âȣ', '����', 2000, '������');
INSERT INTO motor(memberno, name, model, yymm, add1) 
VALUES('A00010005', '����ȭ', '�ҳ�Ÿ��', 1998, '���ֽ�');
INSERT INTO motor(memberno, name, model, yymm, add1) 
VALUES('A00010006', '��ûȭ', '���̳ʽ�Ƽ', 1997, '�����');
INSERT INTO motor(memberno, name, model, yymm, add1) 
VALUES('A00010007', '�����', '����', 1992, '�����');
INSERT INTO motor(memberno, name, model, yymm, add1) 
VALUES('A00010008', '����ȭ', '����Ʈ', 1997, '������');
INSERT INTO motor(memberno, name, model, yymm, add1) 
VALUES('A00010009', '�����', '�׷���X', 1994, '��õ��');
INSERT INTO motor(memberno, name, model, yymm, add1) 
VALUES('A00010010', '����â', '���佺', 1998, '�뱸��');

SELECT * FROM motor WHERE yymm <1999;

UPDATE motor SET add1 = '�����' WHERE add1 = '��õ������';



