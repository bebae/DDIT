-- �ķ���

DROP TABLE goddess;


-- ī�� �̸� ����Ʈ
CREATE TABLE goddess (
    godno       NUMBER(2) NOT NULL,          -- ��ȣ
    godname     CHAR(9) NOT NULL,            -- �̸�
    o_n_1          VARCHAR2(50) NOT NULL,   -- NO.1
    o_n_2          VARCHAR2(50) NOT NULL,   -- NO.2
    o_n_3          VARCHAR2(50) NOT NULL,   -- NO.3
    o_n_4          VARCHAR2(50) NOT NULL,   -- NO.4
    o_n_5          VARCHAR2(50) NOT NULL,   -- NO.5
    o_n_6          VARCHAR2(50) NOT NULL,   -- NO.6
    o_n_7          VARCHAR2(50) NOT NULL,   -- NO.7
    o_s_1          VARCHAR2(50) NOT NULL,   -- NO. S1
    o_s_2          VARCHAR2(50) NOT NULL,   -- NO. S2
    o_s_3          VARCHAR2(50) NOT NULL,   -- NO. S3
    o_s_4          VARCHAR2(50) NOT NULL,   -- NO. S4
    CONSTRAINT pk_godno PRIMARY KEY(godno)      -- �����̸Ӹ� Ű ����
);

INSERT INTO goddess (godno,godname,o_n_1,o_n_2,o_n_3,o_n_4,o_n_5,o_n_6,o_n_7,
        o_s_1,o_s_2,o_s_3,o_s_4)  VALUES('','','','','','','','','',
        '','','','');

INSERT INTO goddess (godno,godname,o_n_1,o_n_2,o_n_3,o_n_4,o_n_5,o_n_6,o_n_7,
        o_s_1,o_s_2,o_s_3,o_s_4) 
        VALUES('01','������','��','�ϼ�','�ڷ�ġ��','����','���','�е�','�⿰����',
        '�� �׸��� ��������','�ؾȿ� �Ķ��ϸ�','�ʹ迡 �����','�Ƹ��� �������� ����');
INSERT INTO goddess (godno,godname,o_n_1,o_n_2,o_n_3,o_n_4,o_n_5,o_n_6,o_n_7,
        o_s_1,o_s_2,o_s_3,o_s_4) 
        VALUES('02','���̳�','�ȹ� �ֵθ���','�ķ�����','������','����','�ǿ�','������','������',
        '����ȣ��','������','�������','����� ���̳��� ������ ����');        
INSERT INTO goddess (godno,godname,o_n_1,o_n_2,o_n_3,o_n_4,o_n_5,o_n_6,o_n_7,
        o_s_1,o_s_2,o_s_3,o_s_4)  
        VALUES('03','����ī','��','���ǵ� ���̾�','�ű׳� ĳ��','Ǯ ����Ʈ','�齺��','��巡��Ʈ','����ũ',
        '���� �Ҹ�','ũ���� ����','��Į�� �̸���','���и��� �ʵ�');
INSERT INTO goddess (godno,godname,o_n_1,o_n_2,o_n_3,o_n_4,o_n_5,o_n_6,o_n_7,
        o_s_1,o_s_2,o_s_3,o_s_4)  
        VALUES('04','���ڿ�','�������','����� Ÿ��','���ٴ� �䳢','���� ��','��ä ������','�ٶ��� ����','������ ����',
        '������ ��','õ���� ��','������ �ٶ�','���� ��');


-- ī�� ��
CREATE TABLE card (
    GODNO       NUMBER(2) NOT NULL,  -- ���Ź�ȣ
    MAINTAG    CHAR(10) NOT NULL,     -- ī�� ���� �з�
    SUBTAG      CHAR(10),                     -- ī�� ���� �з�   
    SHIELDATTACK CHAR(1),                  -- ���� ī���϶� ���� ���ݷ�
    LIFEATTACK CHAR(1),                       -- ���� ī���϶� ������ ���ݷ�
    BUFFNUM   NUMBER(1),                  -- �ο� ī���϶� ��
    COST         NUMBER(1),                   -- �������϶� ��� ��
    EFFECT       VARCHAR2(50)              -- ī�� ȿ�� �ؽ�Ʈ
);



























