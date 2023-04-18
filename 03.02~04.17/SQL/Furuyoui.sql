<<<<<<< HEAD
-- 후루요니

DROP TABLE goddess;


-- 카드 이름 리스트
CREATE TABLE goddess (
    godno       NUMBER(2) NOT NULL,          -- 번호
    godname     CHAR(9) NOT NULL,            -- 이름
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
    CONSTRAINT pk_godno PRIMARY KEY(godno)      -- 프라이머리 키 생성
);

INSERT INTO goddess (godno,godname,o_n_1,o_n_2,o_n_3,o_n_4,o_n_5,o_n_6,o_n_7,
        o_s_1,o_s_2,o_s_3,o_s_4)  VALUES('','','','','','','','','',
        '','','','');

INSERT INTO goddess (godno,godname,o_n_1,o_n_2,o_n_3,o_n_4,o_n_5,o_n_6,o_n_7,
        o_s_1,o_s_2,o_s_3,o_s_4) 
        VALUES('01','유리나','참','일섬','자루치기','거합','기백','압도','기염만장',
        '달 그림자 떨어지니','해안에 파랑일며','쪽배에 쉬노니','아마네 유리나의 저력');
INSERT INTO goddess (godno,godname,o_n_1,o_n_2,o_n_3,o_n_4,o_n_5,o_n_6,o_n_7,
        o_s_1,o_s_2,o_s_3,o_s_4) 
        VALUES('02','사이네','팔방 휘두르기','후려베기','무게추','간파','권역','충음정','무음벽',
        '율동호극','향명공진','음무쇄빙','히사메 사이네의 최후의 종극');        
INSERT INTO goddess (godno,godname,o_n_1,o_n_2,o_n_3,o_n_4,o_n_5,o_n_6,o_n_7,
        o_s_1,o_s_2,o_s_3,o_s_4)  
        VALUES('03','히미카','슛','래피드 파이어','매그넘 캐논','풀 버스트','백스텝','백드래프트','스모크',
        '레드 불릿','크림슨 제로','스칼렛 이매진','버밀리온 필드');
INSERT INTO goddess (godno,godname,o_n_1,o_n_2,o_n_3,o_n_4,o_n_5,o_n_6,o_n_7,
        o_s_1,o_s_2,o_s_3,o_s_4)  
        VALUES('04','토코요','빗어내리기','우아한 타격','날뛰는 토끼','시의 춤','부채 뒤집기','바람의 무대','맑음의 무대',
        '영원의 꽃','천년의 새','무궁의 바람','상세의 달');


-- 카드 상세
CREATE TABLE card (
    GODNO       NUMBER(2) NOT NULL,  -- 여신번호
    MAINTAG    CHAR(10) NOT NULL,     -- 카드 메인 분류
    SUBTAG      CHAR(10),                     -- 카드 서브 분류   
    SHIELDATTACK CHAR(1),                  -- 공격 카드일때 오라 공격력
    LIFEATTACK CHAR(1),                       -- 공격 카드일때 라이프 공격력
    BUFFNUM   NUMBER(1),                  -- 부여 카드일때 납
    COST         NUMBER(1),                   -- 비장패일때 비용 값
    EFFECT       VARCHAR2(50)              -- 카드 효과 텍스트
);



























=======
-- 후루요니

DROP TABLE goddess;


-- 카드 이름 리스트
CREATE TABLE goddess (
    godno       NUMBER(2) NOT NULL,          -- 번호
    godname     CHAR(9) NOT NULL,            -- 이름
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
    CONSTRAINT pk_godno PRIMARY KEY(godno)      -- 프라이머리 키 생성
);

INSERT INTO goddess (godno,godname,o_n_1,o_n_2,o_n_3,o_n_4,o_n_5,o_n_6,o_n_7,
        o_s_1,o_s_2,o_s_3,o_s_4)  VALUES('','','','','','','','','',
        '','','','');

INSERT INTO goddess (godno,godname,o_n_1,o_n_2,o_n_3,o_n_4,o_n_5,o_n_6,o_n_7,
        o_s_1,o_s_2,o_s_3,o_s_4) 
        VALUES('01','유리나','참','일섬','자루치기','거합','기백','압도','기염만장',
        '달 그림자 떨어지니','해안에 파랑일며','쪽배에 쉬노니','아마네 유리나의 저력');
INSERT INTO goddess (godno,godname,o_n_1,o_n_2,o_n_3,o_n_4,o_n_5,o_n_6,o_n_7,
        o_s_1,o_s_2,o_s_3,o_s_4) 
        VALUES('02','사이네','팔방 휘두르기','후려베기','무게추','간파','권역','충음정','무음벽',
        '율동호극','향명공진','음무쇄빙','히사메 사이네의 최후의 종극');        
INSERT INTO goddess (godno,godname,o_n_1,o_n_2,o_n_3,o_n_4,o_n_5,o_n_6,o_n_7,
        o_s_1,o_s_2,o_s_3,o_s_4)  
        VALUES('03','히미카','슛','래피드 파이어','매그넘 캐논','풀 버스트','백스텝','백드래프트','스모크',
        '레드 불릿','크림슨 제로','스칼렛 이매진','버밀리온 필드');
INSERT INTO goddess (godno,godname,o_n_1,o_n_2,o_n_3,o_n_4,o_n_5,o_n_6,o_n_7,
        o_s_1,o_s_2,o_s_3,o_s_4)  
        VALUES('04','토코요','빗어내리기','우아한 타격','날뛰는 토끼','시의 춤','부채 뒤집기','바람의 무대','맑음의 무대',
        '영원의 꽃','천년의 새','무궁의 바람','상세의 달');


-- 카드 상세
CREATE TABLE card (
    GODNO       NUMBER(2) NOT NULL,  -- 여신번호
    MAINTAG    CHAR(10) NOT NULL,     -- 카드 메인 분류
    SUBTAG      CHAR(10),                     -- 카드 서브 분류   
    SHIELDATTACK CHAR(1),                  -- 공격 카드일때 오라 공격력
    LIFEATTACK CHAR(1),                       -- 공격 카드일때 라이프 공격력
    BUFFNUM   NUMBER(1),                  -- 부여 카드일때 납
    COST         NUMBER(1),                   -- 비장패일때 비용 값
    EFFECT       VARCHAR2(50)              -- 카드 효과 텍스트
);



























>>>>>>> origin/main
