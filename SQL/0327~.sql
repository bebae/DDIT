SELECT ENAME 이름, JOB 직업, MGR 사수, HIREDATE 입사일, SAL 급여, DEPTNO 부서번호
        FROM EMPP
        ORDER BY SAL;
-- 24.
SELECT JOB 담당업무, MAX(SAL) 최고액, MIN(SAL) 최저액, SUM(SAL) 총액, ROUND(AVG(SAL)) 평균
    FROM EMPP GROUP BY JOB ORDER BY SUM(SAL) DESC;

-- 25. COUNT(*) 함수를 이용하여 담당업무가 동일한 사원 수를 출력하시오.
SELECT JOB 담당업무, COUNT(*) 사원수 
        FROM EMPP GROUP BY JOB ORDER BY 사원수 DESC;
SELECT JOB 담당업무, COUNT(JOB) 사원수 
        FROM EMPP WHERE JOB != '대표이사'
        GROUP BY JOB ORDER BY 사원수 DESC;

-- 26. 관리자 수를 나열하시오.
SELECT COUNT(DISTINCT MGR) 관리자수 FROM EMPP;
SELECT DISTINCT MGR 관리자코드 FROM EMPP WHERE MGR != 'NULL';

-- 27. 급여 최고액, 급여 최저액의 차액을 출력하시오.
SELECT JOB 직책, MAX(SAL) 최고급여, MIN(SAL) 최저급여, MAX(SAL)-MIN(SAL) 차액 
        FROM EMPP GROUP BY JOB ORDER BY 차액 DESC;
        
-- 28. 직급별 사원의 최저 급여를 출력하시오. 
-- 관리자를 알 수 없는 사원의 최저 급여가 300 미만인 그룹은 제외시키고 
-- 결과를 급여에 대한 내림차순으로 정렬하여 출력하시오.
SELECT JOB 직급, MIN(SAL) 최저급여
        FROM EMPP
        GROUP BY JOB HAVING MIN(SAL) >= 300 
        ORDER BY 최저급여 DESC;

-- 29. 각 부서에 대해 부서번호, 사원 수, 부서 내의 모든 사원의 평균 급여를 출력하시오. 
-- 평균 급여는 소수점 둘째 자리로 반올림 하시오.
SELECT deptno 부서번호, COUNT(JOB) 사원수, ROUND(AVG(SAL)) 평균급여
        FROM EMPP 
        WHERE DEPTNO != '40'
        GROUP BY deptno
        ORDER BY 평균급여 DESC;
        
-- 30. 각 부서에 대해 부서번호 이름, 지역 명, 사원 수, 부서내의 모든 사원의 평균 급여 출력
-- 평균 급여는 정수로 반올림 하시오. DECODE 사용.
SELECT   deptno 부서코드,
        DECODE(DEPTNO, 10, '회계부', 20, '조사부', 30, '영업부', 40, '관리부', 50, '개발부') 부서이름,
        DECODE(DEPTNO, 10, '서울', 20, '세종', 30, '서울', 40, '대전', 50, '대전') 지역, 
        COUNT(*) 사원수, ROUND(AVG(SAL)) 평균급여
        FROM EMPP 
        group by DEPTNO
        ORDER BY DEPTNO;
        
-- 31. 업무를 표시한 다음 해당 업무에 대해 
-- 부서 번호별 급여 및 부서 10, 20, 30의 급여 총액을 각각 출력하시오. 
-- 별칭은 각 job, dno, 부서 10, 부서 20, 부서 30, 총액으로 지정하시오. 
-- ( hint. Decode, group by )
SELECT e.deptno 부서번호, SUM(E.SAL) 급여총액, d.dname 부서명
        FROM EMPP E, DEPT D
        WHERE E.DEPTNO = d.deptno
        GROUP BY e.deptno, d.dname 
        ORDER BY e.deptno;

-- 32. EQUI 조인을 사용하여 SCOTT 사원의 부서번호와 부서 이름을 출력하시오.
SELECT E.ENAME 사원명, E.DEPTNO 부서번호, d.dname 부서이름
        FROM EMPP E, DEPT D
        WHERE e.deptno = d.deptno AND e.ename = '구기현'
        ORDER BY E.DEPTNO;

-- 33. INNER JOIN과 ON 연산자를 사용하여 사원 이름과 함께 
-- 그 사원이 소속된 부서이름과 지역 명을 출력하시오.
SELECT E.ENAME 사원명, d.dname 부서이름, d.loc 지역명
        FROM EMPP E INNER JOIN DEPT D ON e.deptno = d.deptno
        ORDER BY E.DEPTNO;

-- 34. INNER JOIN과 USING 연산자를 사용하여 10번 부서에 속하는 모든 담당 업무의 
-- 고유 목록(한 번씩만 표시)을 부서의 지역명을 포함하여 출력 하시오.
SELECT EMPP.EMPNO 사원번호, DEPT.loc 지역명, EMPP.JOB 담당업무
        FROM EMPP INNER JOIN DEPT USING(deptno)
        WHERE DEPTNO=10;

-- 35. NATURAL JOIN을 사용하여 커미션을 받는 모든 사원의 
-- 이름, 부서이름, 지역 명을 출력하시오.
SELECT EMPP.ENAME 사원명, dept.dname 부서이름, DEPT.loc 지역명, empp.comm 커미션
        FROM EMPP NATURAL JOIN DEPT
        WHERE empp.comm IS NOT NULL;

-- 36. EQUI 조인과 WildCARD를 사용하여 이름에 ‘A’가 포함된 모든 
-- 사원의 이름과 부서명을 출력하시오.
SELECT E.ENAME 사원명, d.dname 부서명
        FROM EMPP E, DEPT D
        WHERE  e.deptno = d.deptno AND E.ENAME LIKE '%민%';

-- 37. NATUAL JOIN을 이용하여 NEW YORK에 근무하는 모든 사원의 
-- 이름, 업무, 부서번호 및 부서명을 출력하시오.
SELECT DEPT.LOC 지역, EMPP.ENAME 사원명, DEPTNO 부서번호, DEPT.dname 부서이름
        FROM EMPP NATURAL JOIN DEPT
        WHERE  DEPT.LOC = '대전'
        ORDER BY DEPTNO;

-- 38. SELF JOIN을 사용하여 사원의 이름 및 사원번호를 관리자 번호와 함께 출력하시오.
SELECT E1.EMPNO 사원번호, E1.ENAME 사원명, e2.empno 관리사원번호, e2.mgr 관리자번호, E2.ENAME 관리자명
        FROM EMPP E1, EMPP E2
        WHERE  e1.empno = e2.MGR
        ORDER BY E1.ENAME;

-- 39. OUTER JOIN, SELF JOIN을 사용하여 관리자가 없는 사원을 포함하여
-- 사원번호를 기준으로 내림차순 정렬하여 출력하시오.
SELECT E.ENAME 사원명, E.EMPNO 사원번호 
        FROM EMPP E, EMPP E1
        WHERE E.MGR = E1.EMPNO(+)
        ORDER BY E.EMPNO DESC;

-- 40. SELF JOIN을 사용하여 지정한 사원의 이름, 부서번호, 
-- 지정한 사원과 동일한 부서에서 근무하는 사원을 출력하시오. ( SCOTT )
SELECT E1.ENAME 사원명, e1.deptno 부서번호, e2.ename 동일부서사원 
        FROM EMPP E1, EMPP E2
        WHERE e1.deptno=e2.deptno AND E2.ENAME = '김동혁' AND E1.ENAME != '김동혁'
        ORDER BY e1.deptno ;

-- 41. SELF JOIN을 사용하여 WARD 사원보다 늦게 입사한 사원의 이름과 입사일을 출력하시오.
SELECT  E2.ENAME 이름, E2.HIREDATE 입사일
        FROM EMPP E1, EMPP E2
        WHERE E1.HIREDATE <= E2.HIREDATE AND e1.ename = '배문기'
        ORDER BY E2.HIREDATE;

-- 42. SELF JOIN 을 사용하여 관리자보다 먼저 입사한 모든 사원의 이름 및
-- 입사일을 관리자의 이름 및 입사일과 함께 출력하시오.
SELECT E2.ENAME 관리자, e2.hiredate 관지자입사, E1.ENAME 이름, E1.HIREDATE 입사일
        FROM EMPP E1, EMPP E2
        WHERE e1.hiredate > e2.hiredate AND E2.MGR = e1.empno
        ORDER BY e1.ename;

-- 43. 사원 번호가 7788인 사원과 담당 업무가 같은 사원을 표시(사원 이름과 담당업무)하시오.
SELECT E1.EMPNO 사원번호, E1.ENAME 사원명, E1.JOB 담당업무, E2.ENAME 이름, E2.JOB 직업
        FROM EMPP E1, EMPP E2
        WHERE E1.empno = 7788 AND E1.JOB = E2.JOB AND E2.EMPNO != 7788
        ORDER BY E2.JOB;

-- 44. 사원번호가 7499인 사원보다 급여가 많은 사원을 표시하시오. 사원이름과 감당 업무
SELECT E2.EMPNO 사원번호, E2.ENAME 이름, E2.JOB 담당업무, E2.SAL 급여
        FROM EMPP E1, EMPP E2
        WHERE e1.empno = 7499 AND E2.SAL >= E1.SAL
        ORDER BY E2.SAL;

-- 45. 최소급여를 받는 사원의 이름, 담당업무 및 급여를 표시하시오. (그룹함수 사용)
SELECT EMPNO 사원번호, ENAME 이름, JOB 담당업무, SAL 급여
        FROM EMPP
        WHERE SAL = (SELECT MIN(SAL) FROM EMPP)
        ORDER BY SAL;
-- 45-1. 최소급여를 받는 사원과 같은 부서 전체 표시
SELECT ENAME 이름, JOB 담당업무, SAL 급여
        FROM EMPP
        WHERE JOB = (SELECT JOB FROM EMPP WHERE SAL = (SELECT MIN(SAL) FROM EMPP))
        ORDER BY SAL;
        
-- 46. 평균급여가 가장 적은 직급의 직급 이름과 직급의 평균을 구하시오. (추가 이해 필요)
SELECT e1.JOB 직급, AVG(e1.SAL) 평균급여
        FROM EMPP e1
        WHERE e1.SAL <= (SELECT AVG(SAL) FROM EMPP)
        GROUP BY e1.JOB
        HAVING AVG(E1.SAL) = (SELECT MIN(AVG_SAL) 
            FROM (SELECT AVG(SAL) AVG_SAL FROM EMPP GROUP BY JOB));
SELECT JOB 담당업무, ASD 급여평균
        FROM (SELECT JOB, AVG(SAL) AS ASD
        FROM EMPP
        GROUP BY JOB
        ORDER BY AVG(SAL) ASC)
        WHERE ROWNUM<=1;

-- 47. 각 부서의 최소 급여를 받는 사원의 이름, 급여, 부서번호를 표시하시오.
SELECT DISTINCT E1.ENAME 사원명, E1.SAL 급여, E1.DEPTNO 부서번호
        FROM EMPP E1, (SELECT MIN(SAL) SAL FROM EMPP GROUP BY DEPTNO) E2
        WHERE E1.SAL = E2.SAL
        ORDER BY e1.SAL;

-- 48. 담당업무가 ANALYST 인 사원보다 급여가 적으면서 
-- 업무가 ANALYST가 아닌 사원들을 표시(사원번호, 이름, 담당 업무, 급여)하시오.
SELECT DISTINCT e1.empno 사원번호, E1.ENAME 사원이름, E1.JOB 담당업무, E1.SAL
        FROM EMPP E1, (SELECT MAX(SAL) SAL FROM EMPP WHERE JOB='회계업무') E2
        WHERE E1.SAL < E2.SAL AND E1.JOB != '회계업무'
        ORDER BY JOB;

-- 49. 부하직원이 없는 사원의 이름을 표시하시오. 
-- (사원 번호가 매니저로 저장되어 있진 않은 사람을 조회해야 함)
SELECT DISTINCT ENAME 사원명 
        FROM EMPP
        WHERE ENAME NOT IN 
        (SELECT E1.ENAME 사원이름 FROM EMPP E1, EMPP E2 WHERE E1.EMPNO = E2.MGR);
        
-- 50. 부하직원이 있는 사원의 이름을 표시하시오. 
-- (사원 번호가 매니저로 저장되어 있는 사람을 조회해야 함)
SELECT DISTINCT E1.ENAME 사원명
        FROM EMPP E1, EMPP E2 
        WHERE E1.EMPNO = E2.MGR;

-- 51. BLAKE와 동일한 부서에 속한 사원의 이름과 입사일을 표시하는 질의를 작성( 단 BLAKE는 제외 )
SELECT E2.ENAME 사원명, E2.HIREDATE 입사일 
        FROM EMPP E1, EMPP E2
        WHERE E1.DEPTNO = E2.DEPTNO AND 
        E1.ENAME = '김민수' AND NOT E2.ENAME = '김민수';

-- 52. 급여가 평균 급여보다 많은 사원들의 사원 번호와 이름을 표시하되
-- 결과를 급여에 대해서 오름차순으로 정렬하시오.
SELECT EMPNO 사원번호, ENAME 사원명, SAL 급여
        FROM EMPP
        WHERE SAL > (SELECT AVG(SAL) FROM EMPP)
        ORDER BY SAL ASC;
        
-- 53. 이름에 K가 포함된 사원과 같은 부서에서 일하는 사원의 사원 번호와 이름을 표시하시오.
SELECT DISTINCT E2.EMPNO 사원번호, E2.ENAME 사원명
        FROM EMPP E1, EMPP E2
        WHERE E1.DEPTNO = E2.DEPTNO AND E1.ENAME LIKE '%김%';



















































