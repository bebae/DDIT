select ENAME 이름, JOB 직업, MGR 사수, HIREDATE 입사일, SAL 급여, DEPTNO 부서번호
        from EMPP
        order by SAL;
-- 24.
select JOB 담당업무, max(SAL) 최고액, min(SAL) 최저액, sum(SAL) 총액, round(avg(SAL)) 평균
    from EMPP group by JOB order by sum(SAL) desc;

-- 25. COUNT(*) 함수를 이용하여 담당업무가 동일한 사원 수를 출력하시오.
select JOB 담당업무, count(*) 사원수
        from EMPP group by JOB order by 사원수 desc;
select JOB 담당업무, count(JOB) 사원수
        from EMPP where JOB != '대표이사'
        group by JOB order by 사원수 desc;

-- 26. 관리자 수를 나열하시오.
select count(distinct MGR) 관리자수 from EMPP;
select distinct MGR 관리자코드 from EMPP where MGR != 'NULL';

-- 27. 급여 최고액, 급여 최저액의 차액을 출력하시오.
select JOB 직책, max(SAL) 최고급여, min(SAL) 최저급여, max(SAL)-min(SAL) 차액
        from EMPP group by JOB order by 차액 desc;
        
-- 28. 직급별 사원의 최저 급여를 출력하시오. 
-- 관리자를 알 수 없는 사원의 최저 급여가 300 미만인 그룹은 제외시키고 
-- 결과를 급여에 대한 내림차순으로 정렬하여 출력하시오.
select JOB 직급, min(SAL) 최저급여
        from EMPP
        group by JOB having min(SAL) >= 300
        order by 최저급여 desc;

-- 29. 각 부서에 대해 부서번호, 사원 수, 부서 내의 모든 사원의 평균 급여를 출력하시오. 
-- 평균 급여는 소수점 둘째 자리로 반올림 하시오.
select deptno 부서번호, count(JOB) 사원수, round(avg(SAL)) 평균급여
        from EMPP
        where DEPTNO != '40'
        group by deptno
        order by 평균급여 desc;
        
-- 30. 각 부서에 대해 부서번호 이름, 지역 명, 사원 수, 부서내의 모든 사원의 평균 급여 출력
-- 평균 급여는 정수로 반올림 하시오. DECODE 사용.
select   deptno 부서코드,
        decode(DEPTNO, 10, '회계부', 20, '조사부', 30, '영업부', 40, '관리부', 50, '개발부') 부서이름,
        decode(DEPTNO, 10, '서울', 20, '세종', 30, '서울', 40, '대전', 50, '대전') 지역,
        count(*) 사원수, round(avg(SAL)) 평균급여
        from EMPP
        group by DEPTNO
        order by DEPTNO;
        
-- 31. 업무를 표시한 다음 해당 업무에 대해 
-- 부서 번호별 급여 및 부서 10, 20, 30의 급여 총액을 각각 출력하시오. 
-- 별칭은 각 job, dno, 부서 10, 부서 20, 부서 30, 총액으로 지정하시오. 
-- ( hint. Decode, group by )
select e.deptno 부서번호, sum(E.SAL) 급여총액, d.dname 부서명
        from EMPP E, DEPT D
        where E.DEPTNO = d.deptno
        group by e.deptno, d.dname
        order by e.deptno;

-- 32. EQUI 조인을 사용하여 SCOTT 사원의 부서번호와 부서 이름을 출력하시오.
select E.ENAME 사원명, E.DEPTNO 부서번호, d.dname 부서이름
        from EMPP E, DEPT D
        where e.deptno = d.deptno and e.ename = '구기현'
        order by E.DEPTNO;

-- 33. INNER JOIN과 ON 연산자를 사용하여 사원 이름과 함께 
-- 그 사원이 소속된 부서이름과 지역 명을 출력하시오.
select E.ENAME 사원명, d.dname 부서이름, d.loc 지역명
        from EMPP E inner join DEPT D on e.deptno = d.deptno
        order by E.DEPTNO;

-- 34. INNER JOIN과 USING 연산자를 사용하여 10번 부서에 속하는 모든 담당 업무의 
-- 고유 목록(한 번씩만 표시)을 부서의 지역명을 포함하여 출력 하시오.
select EMPP.EMPNO 사원번호, DEPT.loc 지역명, EMPP.JOB 담당업무
        from EMPP inner join DEPT using(deptno)
        where DEPTNO=10;

-- 35. NATURAL JOIN을 사용하여 커미션을 받는 모든 사원의 
-- 이름, 부서이름, 지역 명을 출력하시오.
select EMPP.ENAME 사원명, dept.dname 부서이름, DEPT.loc 지역명, empp.comm 커미션
        from EMPP natural join DEPT
        where empp.comm is not null;

-- 36. EQUI 조인과 WildCARD를 사용하여 이름에 ‘A’가 포함된 모든 
-- 사원의 이름과 부서명을 출력하시오.
select E.ENAME 사원명, d.dname 부서명
        from EMPP E, DEPT D
        where  e.deptno = d.deptno and E.ENAME like '%민%';

-- 37. NATUAL JOIN을 이용하여 NEW YORK에 근무하는 모든 사원의 
-- 이름, 업무, 부서번호 및 부서명을 출력하시오.
select DEPT.LOC 지역, EMPP.ENAME 사원명, DEPTNO 부서번호, DEPT.dname 부서이름
        from EMPP natural join DEPT
        where  DEPT.LOC = '대전'
        order by DEPTNO;

-- 38. SELF JOIN을 사용하여 사원의 이름 및 사원번호를 관리자 번호와 함께 출력하시오.
select E1.EMPNO 사원번호, E1.ENAME 사원명, e2.empno 관리사원번호, e2.mgr 관리자번호, E2.ENAME 관리자명
        from EMPP E1, EMPP E2
        where  e1.empno = e2.MGR
        order by E1.ENAME;

-- 39. OUTER JOIN, SELF JOIN을 사용하여 관리자가 없는 사원을 포함하여
-- 사원번호를 기준으로 내림차순 정렬하여 출력하시오.
select E.ENAME 사원명, E.EMPNO 사원번호
        from EMPP E, EMPP E1
        where E.MGR = E1.EMPNO(+)
        order by E.EMPNO desc;

-- 40. SELF JOIN을 사용하여 지정한 사원의 이름, 부서번호, 
-- 지정한 사원과 동일한 부서에서 근무하는 사원을 출력하시오. ( SCOTT )
select E1.ENAME 사원명, e1.deptno 부서번호, e2.ename 동일부서사원
        from EMPP E1, EMPP E2
        where e1.deptno=e2.deptno and E2.ENAME = '김동혁' and E1.ENAME != '김동혁'
        order by e1.deptno ;

-- 41. SELF JOIN을 사용하여 WARD 사원보다 늦게 입사한 사원의 이름과 입사일을 출력하시오.
select  E2.ENAME 이름, E2.HIREDATE 입사일
        from EMPP E1, EMPP E2
        where E1.HIREDATE <= E2.HIREDATE and e1.ename = '배문기'
        order by E2.HIREDATE;

-- 42. SELF JOIN 을 사용하여 관리자보다 먼저 입사한 모든 사원의 이름 및
-- 입사일을 관리자의 이름 및 입사일과 함께 출력하시오.
select E2.ENAME 관리자, e2.hiredate 관지자입사, E1.ENAME 이름, E1.HIREDATE 입사일
        from EMPP E1, EMPP E2
        where e1.hiredate > e2.hiredate and E2.MGR = e1.empno
        order by e1.ename;

-- 43. 사원 번호가 7788인 사원과 담당 업무가 같은 사원을 표시(사원 이름과 담당업무)하시오.
select E1.EMPNO 사원번호, E1.ENAME 사원명, E1.JOB 담당업무, E2.ENAME 이름, E2.JOB 직업
        from EMPP E1, EMPP E2
        where E1.empno = 7788 and E1.JOB = E2.JOB and E2.EMPNO != 7788
        order by E2.JOB;

-- 44. 사원번호가 7499인 사원보다 급여가 많은 사원을 표시하시오. 사원이름과 감당 업무
select E2.EMPNO 사원번호, E2.ENAME 이름, E2.JOB 담당업무, E2.SAL 급여
        from EMPP E1, EMPP E2
        where e1.empno = 7499 and E2.SAL >= E1.SAL
        order by E2.SAL;

-- 45. 최소급여를 받는 사원의 이름, 담당업무 및 급여를 표시하시오. (그룹함수 사용)
select EMPNO 사원번호, ENAME 이름, JOB 담당업무, SAL 급여
        from EMPP
        where SAL = (select min(SAL) from EMPP)
        order by SAL;
-- 45-1. 최소급여를 받는 사원과 같은 부서 전체 표시
select ENAME 이름, JOB 담당업무, SAL 급여
        from EMPP
        where JOB = (select JOB from EMPP where SAL = (select min(SAL) from EMPP))
        order by SAL;
        
-- 46. 평균급여가 가장 적은 직급의 직급 이름과 직급의 평균을 구하시오. (추가 이해 필요)
select e1.JOB 직급, avg(e1.SAL) 평균급여
        from EMPP e1
        where e1.SAL <= (select avg(SAL) from EMPP)
        group by e1.JOB
        having avg(E1.SAL) = (select min(AVG_SAL)
            from (select avg(SAL) AVG_SAL from EMPP group by JOB));
select JOB 담당업무, ASD 급여평균
        from (select JOB, avg(SAL) as ASD
        from EMPP
        group by JOB
        order by avg(SAL) asc)
        where rownum<=1;

-- 47. 각 부서의 최소 급여를 받는 사원의 이름, 급여, 부서번호를 표시하시오.
select distinct E1.ENAME 사원명, E1.SAL 급여, E1.DEPTNO 부서번호
        from EMPP E1, (select min(SAL) SAL from EMPP group by DEPTNO) E2
        where E1.SAL = E2.SAL
        order by e1.SAL;

-- 48. 담당업무가 ANALYST 인 사원보다 급여가 적으면서 
-- 업무가 ANALYST가 아닌 사원들을 표시(사원번호, 이름, 담당 업무, 급여)하시오.
select distinct e1.empno 사원번호, E1.ENAME 사원이름, E1.JOB 담당업무, E1.SAL
        from EMPP E1, (select max(SAL) SAL from EMPP where JOB='회계업무') E2
        where E1.SAL < E2.SAL and E1.JOB != '회계업무'
        order by JOB;

-- 49. 부하직원이 없는 사원의 이름을 표시하시오. 
-- (사원 번호가 매니저로 저장되어 있진 않은 사람을 조회해야 함)
select distinct ENAME 사원명
        from EMPP
        where ENAME not in
        (select E1.ENAME 사원이름 from EMPP E1, EMPP E2 where E1.EMPNO = E2.MGR);
        
-- 50. 부하직원이 있는 사원의 이름을 표시하시오. 
-- (사원 번호가 매니저로 저장되어 있는 사람을 조회해야 함)
select distinct E1.ENAME 사원명
        from EMPP E1, EMPP E2
        where E1.EMPNO = E2.MGR;

-- 51. BLAKE와 동일한 부서에 속한 사원의 이름과 입사일을 표시하는 질의를 작성( 단 BLAKE는 제외 )
select E2.ENAME 사원명, E2.HIREDATE 입사일
        from EMPP E1, EMPP E2
        where E1.DEPTNO = E2.DEPTNO and
        E1.ENAME = '김민수' and not E2.ENAME = '김민수';

-- 52. 급여가 평균 급여보다 많은 사원들의 사원 번호와 이름을 표시하되
-- 결과를 급여에 대해서 오름차순으로 정렬하시오.
select EMPNO 사원번호, ENAME 사원명, SAL 급여
        from EMPP
        where SAL > (select avg(SAL) from EMPP)
        order by SAL asc;
        
-- 53. 이름에 K가 포함된 사원과 같은 부서에서 일하는 사원의 사원 번호와 이름을 표시하시오.
select distinct E2.EMPNO 사원번호, E2.ENAME 사원명
        from EMPP E1, EMPP E2
        where E1.DEPTNO = E2.DEPTNO and E1.ENAME like '%김%';

-- 54. 부서위치가 DALLAS인 사원의 이름과 부서번호 및 담당업무를 표시하시오.
select EMPP.ENAME 사원명, EMPP.DEPTNO 부서번호, EMPP.JOB 담당업무
        from EMPP, DEPT
        where EMPP.DEPTNO = DEPT.DEPTNO and DEPT.LOC = '대전'
        order by DEPT.DEPTNO;

-- 55. KING에게 보고하는 사원의 이름과 급여를 표시하시오.
select E2.ENAME 사원이름, E2.SAL 급여
        from EMPP E1, EMPP E2
        where E1.EMPNO = E2.MGR and E1.ENAME like '%지완';

-- 56. RESEARCH 부서의 사원에 대한 부서번호, 사원이름 및 담당 업무를 표시하시오.
select D.DEPTNO 부서번호, E.ENAME 사원이름, E.JOB 담당업무
        from EMPP E, DEPT D
        where D.DEPTNO = E.deptno and D.DNAME = '개발부'
        order by JOB;

-- 57. 평균 월급보다 많은 급여를 받고 이름에 M이 포함된 사원과 
-- 같은 부서에서 근무하는 사원의 사원 번호, 이름, 급여를 표시하시오.
select EMPNO 사원번호, ENAME 이름, SAL 급여
        from EMPP
        where SAL > (select avg(SAL) from EMPP) and ENAME like '%민%';

-- 58. 평균급여가 가장 적은 업무를 찾으시오.
select ASD 업무
        from (select JOB ASD
            from EMPP
            group by JOB
            order by avg(SAL) asc)
        where rownum<=2;

-- 59. 담당업무가 프로그래머 인 사원이 소속된 부서와 동일한 부서의 사원을 표시하시오.
select distinct E1.ENAME 사원명, e1.deptno 소속부서
        from EMPP E1, (select DEPTNO from EMPP where JOB='프로그래머') E2
        where E1.DEPTNO = E2.DEPTNO;


select PROD_LGU
     , PROD_BUYER
     , count(*)
     , sum(PROD_COST)
from   PROD
group  by rollup (PROD_LGU, PROD_BUYER);

select case '나' when '철호' then '아니다'
                      when '너'    then '아니다'
                      when '나'    then '맞다'
                      else '모르겠다'
        end RESULT
        from DUAL;

 select MEM_ID "회원ID", MEM_NAME "회원명"
    from   MEMBER
    where  regexp_like(MEM_NAME, '^김(성|형)');


 select regexp_substr('Java Flex Oracle', '[^ ]+')
      from DUAL;
 select regexp_substr('Java Flex Oracle', '[^ ]+', 1, 3)
      from DUAL;

select * from empp;
select mem_name 회원이름, mem_regno1 || '-' || MEM_REGNO2 주민번호,
        substr(MEM_REGNO1,1,2) || '년' ||
        substr(MEM_REGNO1,3,2) || '월' ||
        substr(MEM_REGNO1,5,2) || '일' 생일
        from "MEMBER";

select regexp_instr('JAVA Flex Oracle','[ae]') result
    from dual;

 SELECT REGEXP_INSTR('JAVA Flex Oracle','[ae]', 1, 1, 0, 'i') RESULT1,
    REGEXP_INSTR('JAVA Flex Oracle','[ae]', 3, 1, 0, 'i') RESULT2
    FROM DUAL;

SELECT PROD_ID      AS "상품코드"
     , PROD_NAME    AS "상품명"
     , PROD_SALE    AS "판매가"
     , REGEXP_INSTR(PROD_NAME, '\d') AS "포함된 숫자위치 아아"
FROM   PROD
WHERE  REGEXP_INSTR(PROD_NAME,'\d') = 0;

select  PROD.prod_id "상품코드",
    PROD.prod_name "상품",
    sum(BUYPROD.buy_qty) "입고수량"
    from PROD prod, buyprod buyprod
    where PROD.prod_id = BUYPROD.buy_prod
    and BUYPROD.buy_date = '20200505'
    group by prod.prod_id, PROD.prod_name
    order by PROD.prod_id;

select PROD.prod_id "상품코드",
    PROD.prod_name "상품",
    sum(cart.cart_qty) "판매수량"
    from prod prod inner join CART cart on (prod.prod_id = CART.cart_prod)
    where CART.cart_no like '20200505%'
    group by PROD.prod_id, PROD.prod_name;

SELECT PROD.PROD_ID "상품코드",
    PROD.PROD_NAME "상품",
    SUM(NVL(BUYPROD.BUY_QTY,0)) "입고수량",
    SUM(NVL(CART.CART_QTY,0)) "판매수량"
    FROM PROD, BUYPROD, CART
    WHERE PROD.PROD_ID = BUYPROD.BUY_PROD
        AND PROD.PROD_ID = CART.CART_PROD
        AND BUYPROD.BUY_DATE = '20200505'
        AND SUBSTR(CART.CART_NO,1,8) = '20200505'
    GROUP BY PROD.PROD_ID, PROD.PROD_NAME;

SELECT PROD.PROD_ID "상품코드",
    PROD.PROD_NAME "상품",
    SUM(NVL(BUYPROD.BUY_QTY,0)) "입고수량",
    SUM(NVL(CART.CART_QTY,0)) "판매수량"
    FROM PROD
    LEFT OUTER JOIN BUYPROD ON(PROD.PROD_ID = BUYPROD.BUY_PROD AND BUYPROD.BUY_DATE = '20200505')
    LEFT OUTER JOIN CART ON(PROD.PROD_ID = CART.CART_PROD   AND SUBSTR(CART.CART_NO,1,8) = '20200505')
    HAVING SUM(NVL(BUYPROD.BUY_QTY,0)) > 0 OR SUM(NVL(CART.CART_QTY,0)) > 0
    GROUP BY PROD.PROD_ID, PROD.PROD_NAME;

INSERT INTO LPROD(LPROD_ID, LPROD_GU, LPROD_NM)
VALUES((SELECT NVL(MAX(LPROD_ID),0)+1 FROM LPROD),'P103','USB제품');
select * from LPROD;

-- 시퀸스 : 일렬번호를 자동으로 생성하기 위한 객체로써 주로 프라이머리 키에 사용됨
CREATE SEQUENCE CART_SEQ
INCREMENT BY    1
MINVALUE        10000
MAXVALUE        99999
CYCLE;

SELECT CART_SEQ.NEXTVAL FROM DUAL;

drop sequence cart_seq;


SELECT TABLE_NAME, COMMENTS
    FROM DICTIONARY
    WHERE TABLE_NAME LIKE 'ALL_%';

SELECT   OBJECT_NAME, OBJECT_TYPE, CREATED
    FROM ALL_OBJECTS
    WHERE OWNER = 'PC03'
    ORDER BY OBJECT_TYPE  ASC;















