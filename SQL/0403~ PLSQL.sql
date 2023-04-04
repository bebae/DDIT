 -- PL/SQL
 -- 오라클에서만 사용되는 SQL을 확장한 절차적 언어

-- OUTPUT.PUT 출력을 위해서 한 번 실행할 필요가 있음
SET SERVEROUTPUT ON;

-- 변수 선언 및 출력
 declare
    v_i     number(9,2) := 0 ;
    v_name  varchar2(20);
    c_pi    constant number(8,6) := 3.141592;
    v_flag  boolean not null := true;
    v_date  varchar2(10) := to_char(sysdate, 'YYYY-MM-DD');
 begin
    v_name := '홍길동';
    DBMS_OUTPUT.ENABLE;
    DBMS_OUTPUT.PUT_LINE( 'v_i : ' || v_i );
    DBMS_OUTPUT.PUT_LINE( 'v_name : ' || v_name);
    DBMS_OUTPUT.PUT_LINE( 'c_pi : ' || c_pi );
    DBMS_OUTPUT.PUT_LINE( 'v_date : ' || v_date);
 end;/

-- IF문
declare
    v_num number := 36;
begin
    dbms_output.ENABLE;

    if mod(v_num, 2) = 0 then
        dbms_output.PUT_LINE(v_num || '는 짝수');
    else
        dbms_output.PUT_LINE(v_num || '는 홀수');
    end if;
end;/

-- 조건에 따른 다중 IF문
declare
    v_num number := 77;
begin
    dbms_output."ENABLE"();
    if v_num > 90 then
        dbms_output.PUT_LINE('수');
    elsif v_num > 80 then
        dbms_output.PUT_LINE('우');
    elsif v_num > 70 then
        dbms_output.PUT_LINE('미');
    else
        dbms_output.put_line('분발합니다');
    end if;
end;/

-- SELECT INTO로 변수에 할당
declare
    v_avg_sale PROD.PROD_SALE%type;      -- NUMBER(10,0)
    v_sale number := 500000;
begin
    DBMS_OUTPUT."ENABLE"();

    select avg(prod_sale) into v_avg_sale from  PROD;

    if v_sale < v_avg_sale then
        DBMS_OUTPUT.PUT_LINE('평균 단가가 500000 초과입니다.');
    else
        DBMS_OUTPUT.PUT_LINE('평균 단가가 500000 이하 입니다.');
    end if;
end;/

/* 회원테이블에서 아이디가 'e001' 인 회원의
  마일리지가 5000을 넘으면 'VIP 회원' 그렇지 않다면 '일반회원'으로
  출력하시오. (회원이름, 마일리지 포함) */
declare
    v_mem_id varchar2(10) := 'e001';
    v_mem_mileage "MEMBER".MEM_MILEAGE%type;
    v_mem_name "MEMBER".MEM_NAME%type;
    v_mile number := 5000;
begin
    DBMS_OUTPUT."ENABLE"();

    select MEM_MILEAGE, MEM_NAME
    into v_mem_mileage, v_mem_name
    from "MEMBER"
    where MEM_ID = v_mem_id;

    if v_mile < v_mem_mileage then
        DBMS_OUTPUT.PUT_LINE('VIP 회원('||v_mem_name||', '||v_mem_mileage||')');
    else
        DBMS_OUTPUT.PUT_LINE('일반 회원('||v_mem_name||', '||v_mem_mileage||')');
    end if;
end;/

/*  SQL 에서 사용하는 CASE 문과 동일하다.   단, 차이점은 END CASE 로 마지막을 지정해야 한다. */
declare
    v_num bumber := 77;
begin
    v_num := trunc(v_num/10);

     case V_NUM
        when 10 then
            DBMS_OUTPUT.PUT_LINE('수' || '(' || V_NUM || ')');
        when 9 then
            DBMS_OUTPUT.PUT_LINE('수' || '(' || V_NUM || ')');
        when 8 then
            DBMS_OUTPUT.PUT_LINE('우' || '(' || V_NUM || ')');
        when 7 then
            DBMS_OUTPUT.PUT_LINE('미' || '(' || V_NUM || ')');
        else
            DBMS_OUTPUT.PUT_LINE('분발합시다');
    end case;
end;/

-- while 문
declare
    v_sum number := 0;
    v_var number := 1;
begin
    while v_var <= 10 loop
        v_sum := v_sum + v_var;
        v_var := v_var+1;
    end loop;
    dbms_output.put_line('1부터 10까지의 합='|| v_sum);
end;
/

-- while문을 이용해서 피라미드 만들기
declare
    v_id number := 1;
begin
    while v_id < 20 loop
        DBMS_OUTPUT.PUT_LINE(rpad('*',v_id,'*'));
        v_id := v_id+2;
    end loop;
end;
/
declare
    V_I number := 1;
    V_J number := 1;
begin
    while V_I < 20 loop
        V_J := 1;
        while V_J <= V_I loop
            DBMS_OUTPUT.PUT('*');
            V_J := V_J + 1;
        end loop;
        V_I := V_I + 2;
        DBMS_OUTPUT.PUT_LINE('');
    end loop;
end;

-- while문 이용해서 다른 형태 피라미드 만들기
declare
    v_id number := 1;
    v_id2 number := 10;
begin
    while v_id < 20 loop
        DBMS_OUTPUT.PUT(rpad(' ', v_id2, ' '));
        DBMS_OUTPUT.PUT_LINE(rpad('*',v_id,'*'));
        v_id := v_id + 2;
        v_id2 := v_id2 - 1;
    end loop;
end;
/

-- 다중 while문 사용하여 구구단
declare
    v_i number := 2;
    v_j number := 1;
begin
    while v_i < 10 loop
        DBMS_OUTPUT.PUT_LINE(v_i||' 단 ');
        v_j := 1;
        while v_j < 10 loop
            DBMS_OUTPUT.PUT_LINE(v_i||' X '||v_j||'='||v_i*v_j);
            v_j := v_j+1;
        end loop;
        v_i := v_i+1;
        DBMS_OUTPUT.PUT_LINE('');
    end loop;
end;
/

/* Oracle Server는 SQL문장을 실행할 때 PL/SQL은 SQL식별자를
   가지는 암시적 커서를 생성합니다.
   또한 PL/SQL은 자동적으로
    이 커서를 관리합니다. */
declare
    v_nm varchar2(20);
begin
    select LPROD_NM into v_nm from LPROD where LPROD_GU = 'P201';
    if sql%found then
        DBMS_OUTPUT.put_line('받은 값 = '||v_nm);
        DBMS_OUTPUT.put_line('행 수 = '||sql%rowcount);
    end if;
end;
/

-- 상분분류 테이블에 6개의 코드 증가
declare
    v_add number(5) := 1000;
    v_code char(4)  := '';
    v_id number(5);
begin
    select max(LPROD_ID) into v_id from LPROD;
    while v_add <= 1005 loop
        v_add := v_add+1;
        v_id := v_id+1;
        v_code := 'TT'|| substr(to_char(v_add), -2);
        insert into LPROD(LPROD_ID, LPROD_GU, LPROD_NM) values(v_id, v_code, 'LOOP TEST');
        if sql%found then
            DBMS_OUTPUT.PUT_LINE('신규코드'||v_code||'가 추가되었음');
        end if;
    end loop ;
end;
/
-- 신규 코드 TT로 시작하는 코드 삭제하는 코드
declare
    v_count number(5) := 0;
begin
    delete from LPROD where LPROD_GU like 'TT%';
    v_count := sql%rowcount;
    DBMS_OUTPUT.PUT_LINE(v_count||'개의 레코드가 삭제되었습니다.');
end;
/

-- GOTO : 실행처리를 임의의 지점으로 이동 (이거 쓸 거면 프로그램 하지 마라)
declare
    v_sum int := 0;
    v_var int := 1;
begin
    -- 유사 while문
    <<mysql>>
    v_sum := v_sum + v_var;
    v_var := v_var+1;
    if v_var <= 10 then
        goto mysql;
    end if;
    DBMS_OUTPUT.PUT_LINE(v_sum);
    DBMS_OUTPUT.PUT_LINE(v_var);
end;
/

-- 무한 반복문 EXIT문을 사용해 빠져나가기
declare
    v_sum number := 0;
    v_var number := 1;
begin
    loop
        v_sum := v_sum + v_var;
        v_var := v_var + 1;
        if v_var > 10 then
            exit;
        end if;
    end loop;
    DBMS_OUTPUT.PUT_LINE('1 부터 10까지의 합 = '||v_sum);
end;/

-- 무한 반복문 EXIT WHEN 조건 사용해 빠져나가기
declare
    v_sum number := 0;
    v_var number := 1;
begin
    loop
        v_sum := v_sum + v_var;
        v_var := v_var + 1;
        exit when v_var > 10;
    end loop;
    DBMS_OUTPUT.PUT_LINE('when문 1 부터 10까지의 합 = '||v_sum);
end;/

-- FOR 문
begin
    for i in 1..10 loop
        DBMS_OUTPUT.PUT_LINE('i = '||i);
    end loop;
end;/

-- VARRAY 사용
declare
-- type 선언/starcraft 타입명/varray 고정길이 배열 안 데이터 크기(20) [데이터타입] 길이가 (10)
    type starcraft is varray(20) of varchar2(10);
    v_star starcraft;
begin
    v_star := starcraft('Terran','Protos');
    -- 배열 인덱스 범위 1증가
    v_star.extend;
    v_star(3) := 'Zerg';
    DBMS_OUTPUT.PUT_LINE('스타크래프트 종족 :'|| v_star.count);
    for i in v_star.first..v_star.last loop
        DBMS_OUTPUT.PUT_LINE(i||'번째 종족: '||v_star(i));
    end loop;
end;/

-- 이 코드가 안되는 이유는 varray 타입을 선언할 때 (3)이지만 변수에 넣을 때 초기값이 2개만 있으면
-- 배열 크기가 2가 되기 때문에 추가로 값을 넣을 땐 실행부에서 반드시 v_star.extend;를 추가해야 함
-- 아니면 초기값을 넣을 때 다 지정하거나 공백으로 처리하여 자리만 만들어 두기
declare
    type starcraft is varray(3) of varchar2(10);  -- 배열의 크기를 3으로 지정
    v_star starcraft := starcraft('Terran', 'Protos');  -- 인덱스 1, 2 초기값 할당
begin
    v_star(3) := 'Zerg';  -- 인덱스 3에 직접 값을 할당
    DBMS_OUTPUT.PUT_LINE('스타크래프트 종족 :'|| v_star.count);
    for i in v_star.first..v_star.last loop
        DBMS_OUTPUT.PUT_LINE(i||'번째 종족: '||v_star(i));
    end loop;
end;/

-- 예외 처리 : 미리 정의된 예외인 경우
declare
    v_name varchar2(20);
begin
    select LPROD_NM into v_name from LPROD where LPROD_GU = 'P201';
    DBMS_OUTPUT.PUT_LINE('분류명 = '||v_name);
    exception
        when no_data_found then
            DBMS_OUTPUT.PUT_LINE('해당 정보가 없습니다.');
        when too_many_rows then
            DBMS_OUTPUT.PUT_LINE('한개 이상의 값이 나왔습니다.');
        when others then
            DBMS_OUTPUT.PUT_LINE('기타 에러 :'||sqlerrm );
end;/

-- 예외 처리 : 정의되지 않은 예외의 경우
declare
    exp_reference exception;
    pragma exception_init(exp_reference, -2202);
begin
    delete from LPROD where LPROD_GU = 'P101' ;
    DBMS_OUTPUT.PUT_LINE('분류 삭제');
    exception
        when exp_reference then
            DBMS_OUTPUT.PUT_LINE('삭제 불가 :'||sqlerrm);
        when others then
            DBMS_OUTPUT.PUT_LINE(sqlerrm||' '||sqlerrm);
end;/

-- 예외 처리 : 사용자 정의된 예외인 경우
ACCEPT p_lgu PROMPT '등록하려는 분류코드 입력 :'
declare
   exp_lprod_gu exception;
   v_lgu varchar2(10) := upper('&p_lgu');
begin
   if v_lgu in ('P101','P102','P201','P202') then
        raise exp_lprod_gu;
   end if;
   DBMS_OUTPUT.PUT_LINE (v_lgu || '는 등록 가능');
exception
     when exp_lprod_gu then
           DBMS_OUTPUT.PUT_LINE ( v_lgu ||  '는 이미 등록된 코드 입니다.');
end;
/

-- CURSOR 문
declare
    v_prod varchar2(30);
    v_qty number(10,0);

    cursor upremain_cur is
        select buy_prod, sum(buy_qty) from BUYPROD
        where extract(year from buy_date) = 2020
        group by buy_prod order by buy_prod asc;
begin
    open upremain_cur;
    fetch upremain_cur into v_prod, v_qty;
    while (upremain_cur%found) loop
        DBMS_OUTPUT.PUT_LINE(
            upremain_cur%rowcount||'번째 상품='||v_prod||' 입고수량='||v_qty||'입니다.');
        fetch upremain_cur into v_prod, v_qty;
    end loop ;
    close upremain_cur;
end;/

-- Stored Procedure 상품코드를 매개변수(parameter)로 하여 재고수량  ADD
create or replace procedure usp_pord_totalstock_update
    (v_prod_id in PROD.PROD_ID%type, v_qty in PROD.PROD_TOTALSTOCK%type)
is
begin
    update PROD set prod_totalstock = prod_totalstock + v_qty
    where prod_id = v_prod_id;
    DBMS_OUTPUT.PUT_LINE('정상적으로 업데이트 되었습니다.');
    commit;
exception
    when others then
        DBMS_OUTPUT.PUT_LINE('예외 발생: '||sqlerrm);
        rollback;
end;/

--  Procedure 실행
execute usp_pord_totalstock_update('P102000006',500);
select PROD_ID, PROD_TOTALSTOCK
    from PROD
    where prod_id = 'P102000006';

--  OUT 매개변수 예제 1    - 회원아이디를 입력받아 이름과 취미를  OUT 매개변수로 처리
create or replace procedure usp_memberID(
    p_mem_id in member.mem_id%type,
    p_mem_name out member.mem_name%type,
    p_mem_like out member.mem_like%type)
is
begin
    select mem_name, mem_like into p_mem_name, p_mem_like
    from "MEMBER" where MEM_ID = p_mem_id;
end;/

select MEM_ID, MEM_NAME, MEM_LIKE  from "MEMBER";

--  OUT 매개변수의 간단 출력
VAR mem_name VARCHAR2(20)
VAR mem_like VARCHAR2(20)
EXECUTE usp_MemberID ('m001', :mem_name, :mem_like);
PRINT mem_name
PRINT mem_like;
/

-- OUT 매개변수 예제2
CREATE OR REPLACE PROCEDURE usp_MemberCartTop
    ( p_year                  IN  VARCHAR2,
      p_amt                OUT  NUMBER ,
      p_mem_name   OUT member.mem_name%TYPE )
IS
    v_year VARCHAR2(5);
BEGIN
     v_year := (p_year || '%');
    SELECT  mem_name, mem_amt  INTO  p_mem_name, p_amt
      FROM (
    SELECT mem_name, SUM(prod_price * cart_qty) mem_amt
       FROM member, cart, prod
      WHERE cart_no LIKE v_year
           AND cart_member = mem_id
           AND cart_prod = prod_id
      GROUP BY mem_name
      ORDER BY SUM(prod_price * cart_qty)  DESC
      )
      WHERE  ROWNUM <= 1 ;
END;
/

VAR send_member VARCHAR2
VAR send_amt NUMBER
EXEC usp_MemberCartTop('2020', :send_amt, :send_member);
PRINT send_member
PRINT send_amt;

-- Function = 함수
-- 회원 아이디를 받으면 해당 이름을 리턴하는 함수 만들기
create or replace function fn_memName (p_mem_id in varchar2)
    return varchar2
is r_name varchar2(30);
begin
    select MEM_NAME into r_name from "MEMBER"
    where MEM_ID = p_mem_id;
    return r_name;
exception
    when others then
    DBMS_OUTPUT.PUT_LINE('예외 발생: '||sqlerrm );
    return null;
end;

-- 년도 및 상품코드를 입력 받으면 해당년도의 평균 판매 횟수를      반환하는 함수
create or replace function fn_prodAvgQty
    (p_year in number default (extract(year from sysdate)), p_prod_id in varchar2)
    return number
is
    r_qty number(10);
    v_year varchar2(5) := to_char(p_year)||'%';
begin
    select nvl(avg(cart_qty),0) into r_qty from CART
    where CART_PROD = p_prod_id and cart_no like v_year;
    return r_qty;
exception
    when others then
        DBMS_OUTPUT.PUT_LINE('예외 발생:'||sqlerrm);
        return 0;
end;/
--  fn_prodAvgQty 실행 테스트
VAR qty NUMBER EXEC :qty := fn_prodAvgQty( 2004, 'P101000002');
PRINT qty EXEC :qty := fn_prodAvgQty(2020, 'P101000002');
PRINT qty;
SELECT prod_id,  prod_name,
    fn_prodAvgQty(2004,prod_id) "2004년 평균 판매횟수",
    fn_prodAvgQty(2020,prod_id) "2020년 평균 판매횟수"
    FROM prod












