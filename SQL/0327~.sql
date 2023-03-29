SELECT ENAME �̸�, JOB ����, MGR ���, HIREDATE �Ի���, SAL �޿�, DEPTNO �μ���ȣ
        FROM EMPP
        ORDER BY SAL;
-- 24.
SELECT JOB ������, MAX(SAL) �ְ��, MIN(SAL) ������, SUM(SAL) �Ѿ�, ROUND(AVG(SAL)) ���
    FROM EMPP GROUP BY JOB ORDER BY SUM(SAL) DESC;

-- 25. COUNT(*) �Լ��� �̿��Ͽ� �������� ������ ��� ���� ����Ͻÿ�.
SELECT JOB ������, COUNT(*) ����� 
        FROM EMPP GROUP BY JOB ORDER BY ����� DESC;
SELECT JOB ������, COUNT(JOB) ����� 
        FROM EMPP WHERE JOB != '��ǥ�̻�'
        GROUP BY JOB ORDER BY ����� DESC;

-- 26. ������ ���� �����Ͻÿ�.
SELECT COUNT(DISTINCT MGR) �����ڼ� FROM EMPP;
SELECT DISTINCT MGR �������ڵ� FROM EMPP WHERE MGR != 'NULL';

-- 27. �޿� �ְ��, �޿� �������� ������ ����Ͻÿ�.
SELECT JOB ��å, MAX(SAL) �ְ�޿�, MIN(SAL) �����޿�, MAX(SAL)-MIN(SAL) ���� 
        FROM EMPP GROUP BY JOB ORDER BY ���� DESC;
        
-- 28. ���޺� ����� ���� �޿��� ����Ͻÿ�. 
-- �����ڸ� �� �� ���� ����� ���� �޿��� 300 �̸��� �׷��� ���ܽ�Ű�� 
-- ����� �޿��� ���� ������������ �����Ͽ� ����Ͻÿ�.
SELECT JOB ����, MIN(SAL) �����޿�
        FROM EMPP
        GROUP BY JOB HAVING MIN(SAL) >= 300 
        ORDER BY �����޿� DESC;

-- 29. �� �μ��� ���� �μ���ȣ, ��� ��, �μ� ���� ��� ����� ��� �޿��� ����Ͻÿ�. 
-- ��� �޿��� �Ҽ��� ��° �ڸ��� �ݿø� �Ͻÿ�.
SELECT deptno �μ���ȣ, COUNT(JOB) �����, ROUND(AVG(SAL)) ��ձ޿�
        FROM EMPP 
        WHERE DEPTNO != '40'
        GROUP BY deptno
        ORDER BY ��ձ޿� DESC;
        
-- 30. �� �μ��� ���� �μ���ȣ �̸�, ���� ��, ��� ��, �μ����� ��� ����� ��� �޿� ���
-- ��� �޿��� ������ �ݿø� �Ͻÿ�. DECODE ���.
SELECT   deptno �μ��ڵ�,
        DECODE(DEPTNO, 10, 'ȸ���', 20, '�����', 30, '������', 40, '������', 50, '���ߺ�') �μ��̸�,
        DECODE(DEPTNO, 10, '����', 20, '����', 30, '����', 40, '����', 50, '����') ����, 
        COUNT(*) �����, ROUND(AVG(SAL)) ��ձ޿�
        FROM EMPP 
        group by DEPTNO
        ORDER BY DEPTNO;
        
-- 31. ������ ǥ���� ���� �ش� ������ ���� 
-- �μ� ��ȣ�� �޿� �� �μ� 10, 20, 30�� �޿� �Ѿ��� ���� ����Ͻÿ�. 
-- ��Ī�� �� job, dno, �μ� 10, �μ� 20, �μ� 30, �Ѿ����� �����Ͻÿ�. 
-- ( hint. Decode, group by )
SELECT e.deptno �μ���ȣ, SUM(E.SAL) �޿��Ѿ�, d.dname �μ���
        FROM EMPP E, DEPT D
        WHERE E.DEPTNO = d.deptno
        GROUP BY e.deptno, d.dname 
        ORDER BY e.deptno;

-- 32. EQUI ������ ����Ͽ� SCOTT ����� �μ���ȣ�� �μ� �̸��� ����Ͻÿ�.
SELECT E.ENAME �����, E.DEPTNO �μ���ȣ, d.dname �μ��̸�
        FROM EMPP E, DEPT D
        WHERE e.deptno = d.deptno AND e.ename = '������'
        ORDER BY E.DEPTNO;

-- 33. INNER JOIN�� ON �����ڸ� ����Ͽ� ��� �̸��� �Բ� 
-- �� ����� �Ҽӵ� �μ��̸��� ���� ���� ����Ͻÿ�.
SELECT E.ENAME �����, d.dname �μ��̸�, d.loc ������
        FROM EMPP E INNER JOIN DEPT D ON e.deptno = d.deptno
        ORDER BY E.DEPTNO;

-- 34. INNER JOIN�� USING �����ڸ� ����Ͽ� 10�� �μ��� ���ϴ� ��� ��� ������ 
-- ���� ���(�� ������ ǥ��)�� �μ��� �������� �����Ͽ� ��� �Ͻÿ�.
SELECT EMPP.EMPNO �����ȣ, DEPT.loc ������, EMPP.JOB ������
        FROM EMPP INNER JOIN DEPT USING(deptno)
        WHERE DEPTNO=10;

-- 35. NATURAL JOIN�� ����Ͽ� Ŀ�̼��� �޴� ��� ����� 
-- �̸�, �μ��̸�, ���� ���� ����Ͻÿ�.
SELECT EMPP.ENAME �����, dept.dname �μ��̸�, DEPT.loc ������, empp.comm Ŀ�̼�
        FROM EMPP NATURAL JOIN DEPT
        WHERE empp.comm IS NOT NULL;

-- 36. EQUI ���ΰ� WildCARD�� ����Ͽ� �̸��� ��A���� ���Ե� ��� 
-- ����� �̸��� �μ����� ����Ͻÿ�.
SELECT E.ENAME �����, d.dname �μ���
        FROM EMPP E, DEPT D
        WHERE  e.deptno = d.deptno AND E.ENAME LIKE '%��%';

-- 37. NATUAL JOIN�� �̿��Ͽ� NEW YORK�� �ٹ��ϴ� ��� ����� 
-- �̸�, ����, �μ���ȣ �� �μ����� ����Ͻÿ�.
SELECT DEPT.LOC ����, EMPP.ENAME �����, DEPTNO �μ���ȣ, DEPT.dname �μ��̸�
        FROM EMPP NATURAL JOIN DEPT
        WHERE  DEPT.LOC = '����'
        ORDER BY DEPTNO;

-- 38. SELF JOIN�� ����Ͽ� ����� �̸� �� �����ȣ�� ������ ��ȣ�� �Բ� ����Ͻÿ�.
SELECT E1.EMPNO �����ȣ, E1.ENAME �����, e2.empno ���������ȣ, e2.mgr �����ڹ�ȣ, E2.ENAME �����ڸ�
        FROM EMPP E1, EMPP E2
        WHERE  e1.empno = e2.MGR
        ORDER BY E1.ENAME;

-- 39. OUTER JOIN, SELF JOIN�� ����Ͽ� �����ڰ� ���� ����� �����Ͽ�
-- �����ȣ�� �������� �������� �����Ͽ� ����Ͻÿ�.
SELECT E.ENAME �����, E.EMPNO �����ȣ 
        FROM EMPP E, EMPP E1
        WHERE E.MGR = E1.EMPNO(+)
        ORDER BY E.EMPNO DESC;

-- 40. SELF JOIN�� ����Ͽ� ������ ����� �̸�, �μ���ȣ, 
-- ������ ����� ������ �μ����� �ٹ��ϴ� ����� ����Ͻÿ�. ( SCOTT )
SELECT E1.ENAME �����, e1.deptno �μ���ȣ, e2.ename ���Ϻμ���� 
        FROM EMPP E1, EMPP E2
        WHERE e1.deptno=e2.deptno AND E2.ENAME = '�赿��' AND E1.ENAME != '�赿��'
        ORDER BY e1.deptno ;

-- 41. SELF JOIN�� ����Ͽ� WARD ������� �ʰ� �Ի��� ����� �̸��� �Ի����� ����Ͻÿ�.
SELECT  E2.ENAME �̸�, E2.HIREDATE �Ի���
        FROM EMPP E1, EMPP E2
        WHERE E1.HIREDATE <= E2.HIREDATE AND e1.ename = '�蹮��'
        ORDER BY E2.HIREDATE;

-- 42. SELF JOIN �� ����Ͽ� �����ں��� ���� �Ի��� ��� ����� �̸� ��
-- �Ի����� �������� �̸� �� �Ի��ϰ� �Բ� ����Ͻÿ�.
SELECT E2.ENAME ������, e2.hiredate �������Ի�, E1.ENAME �̸�, E1.HIREDATE �Ի���
        FROM EMPP E1, EMPP E2
        WHERE e1.hiredate > e2.hiredate AND E2.MGR = e1.empno
        ORDER BY e1.ename;

-- 43. ��� ��ȣ�� 7788�� ����� ��� ������ ���� ����� ǥ��(��� �̸��� ������)�Ͻÿ�.
SELECT E1.EMPNO �����ȣ, E1.ENAME �����, E1.JOB ������, E2.ENAME �̸�, E2.JOB ����
        FROM EMPP E1, EMPP E2
        WHERE E1.empno = 7788 AND E1.JOB = E2.JOB AND E2.EMPNO != 7788
        ORDER BY E2.JOB;

-- 44. �����ȣ�� 7499�� ������� �޿��� ���� ����� ǥ���Ͻÿ�. ����̸��� ���� ����
SELECT E2.EMPNO �����ȣ, E2.ENAME �̸�, E2.JOB ������, E2.SAL �޿�
        FROM EMPP E1, EMPP E2
        WHERE e1.empno = 7499 AND E2.SAL >= E1.SAL
        ORDER BY E2.SAL;

-- 45. �ּұ޿��� �޴� ����� �̸�, ������ �� �޿��� ǥ���Ͻÿ�. (�׷��Լ� ���)
SELECT EMPNO �����ȣ, ENAME �̸�, JOB ������, SAL �޿�
        FROM EMPP
        WHERE SAL = (SELECT MIN(SAL) FROM EMPP)
        ORDER BY SAL;
-- 45-1. �ּұ޿��� �޴� ����� ���� �μ� ��ü ǥ��
SELECT ENAME �̸�, JOB ������, SAL �޿�
        FROM EMPP
        WHERE JOB = (SELECT JOB FROM EMPP WHERE SAL = (SELECT MIN(SAL) FROM EMPP))
        ORDER BY SAL;
        
-- 46. ��ձ޿��� ���� ���� ������ ���� �̸��� ������ ����� ���Ͻÿ�. (�߰� ���� �ʿ�)
SELECT e1.JOB ����, AVG(e1.SAL) ��ձ޿�
        FROM EMPP e1
        WHERE e1.SAL <= (SELECT AVG(SAL) FROM EMPP)
        GROUP BY e1.JOB
        HAVING AVG(E1.SAL) = (SELECT MIN(AVG_SAL) 
            FROM (SELECT AVG(SAL) AVG_SAL FROM EMPP GROUP BY JOB));
SELECT JOB ������, ASD �޿����
        FROM (SELECT JOB, AVG(SAL) AS ASD
        FROM EMPP
        GROUP BY JOB
        ORDER BY AVG(SAL) ASC)
        WHERE ROWNUM<=1;

-- 47. �� �μ��� �ּ� �޿��� �޴� ����� �̸�, �޿�, �μ���ȣ�� ǥ���Ͻÿ�.
SELECT DISTINCT E1.ENAME �����, E1.SAL �޿�, E1.DEPTNO �μ���ȣ
        FROM EMPP E1, (SELECT MIN(SAL) SAL FROM EMPP GROUP BY DEPTNO) E2
        WHERE E1.SAL = E2.SAL
        ORDER BY e1.SAL;

-- 48. �������� ANALYST �� ������� �޿��� �����鼭 
-- ������ ANALYST�� �ƴ� ������� ǥ��(�����ȣ, �̸�, ��� ����, �޿�)�Ͻÿ�.
SELECT DISTINCT e1.empno �����ȣ, E1.ENAME ����̸�, E1.JOB ������, E1.SAL
        FROM EMPP E1, (SELECT MAX(SAL) SAL FROM EMPP WHERE JOB='ȸ�����') E2
        WHERE E1.SAL < E2.SAL AND E1.JOB != 'ȸ�����'
        ORDER BY JOB;

-- 49. ���������� ���� ����� �̸��� ǥ���Ͻÿ�. 
-- (��� ��ȣ�� �Ŵ����� ����Ǿ� ���� ���� ����� ��ȸ�ؾ� ��)
SELECT DISTINCT ENAME ����� 
        FROM EMPP
        WHERE ENAME NOT IN 
        (SELECT E1.ENAME ����̸� FROM EMPP E1, EMPP E2 WHERE E1.EMPNO = E2.MGR);
        
-- 50. ���������� �ִ� ����� �̸��� ǥ���Ͻÿ�. 
-- (��� ��ȣ�� �Ŵ����� ����Ǿ� �ִ� ����� ��ȸ�ؾ� ��)
SELECT DISTINCT E1.ENAME �����
        FROM EMPP E1, EMPP E2 
        WHERE E1.EMPNO = E2.MGR;

-- 51. BLAKE�� ������ �μ��� ���� ����� �̸��� �Ի����� ǥ���ϴ� ���Ǹ� �ۼ�( �� BLAKE�� ���� )
SELECT E2.ENAME �����, E2.HIREDATE �Ի��� 
        FROM EMPP E1, EMPP E2
        WHERE E1.DEPTNO = E2.DEPTNO AND 
        E1.ENAME = '��μ�' AND NOT E2.ENAME = '��μ�';

-- 52. �޿��� ��� �޿����� ���� ������� ��� ��ȣ�� �̸��� ǥ���ϵ�
-- ����� �޿��� ���ؼ� ������������ �����Ͻÿ�.
SELECT EMPNO �����ȣ, ENAME �����, SAL �޿�
        FROM EMPP
        WHERE SAL > (SELECT AVG(SAL) FROM EMPP)
        ORDER BY SAL ASC;
        
-- 53. �̸��� K�� ���Ե� ����� ���� �μ����� ���ϴ� ����� ��� ��ȣ�� �̸��� ǥ���Ͻÿ�.
SELECT DISTINCT E2.EMPNO �����ȣ, E2.ENAME �����
        FROM EMPP E1, EMPP E2
        WHERE E1.DEPTNO = E2.DEPTNO AND E1.ENAME LIKE '%��%';



















































