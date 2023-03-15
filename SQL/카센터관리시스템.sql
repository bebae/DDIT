
INSERT INTO car() VALUES();

-- 고객
INSERT INTO customer(cst_no, cst_name, cst_address, cst_telno) 
    VALUES('A001', '김민수', '대전시 중구 계룡로 1001-10','010-3125-3721');
INSERT INTO customer(cst_no, cst_name, cst_address, cst_telno) 
    VALUES('A002', '강만덕', '대전시 서구 계룡로 615','010-5785-6268');
INSERT INTO customer(cst_no, cst_name, cst_address, cst_telno) 
    VALUES('A003', '이혜민', '대전시 중구 대종로 480','010-1815-3137');
INSERT INTO customer(cst_no, cst_name, cst_address, cst_telno) 
    VALUES('A004', '박한기', '대전시 동구 동서대로 1503','010-9912-0284');
INSERT INTO customer(cst_no, cst_name, cst_address, cst_telno) 
    VALUES('A005', '최이림', '대전시 동구 가양남로 23','010-1017-3387');
INSERT INTO customer(cst_no, cst_name, cst_address, cst_telno) 
    VALUES('A006', '신성경', '대전시 대덕구 중리로 184', '010-2991-9920');
INSERT INTO customer(cst_no, cst_name, cst_address, cst_telno) 
    VALUES('A007', '공분덕', '대전시 서구 계백로 1192', '010-5877-6831');
INSERT INTO customer(cst_no, cst_name, cst_address, cst_telno) 
    VALUES('A008', '강마용', '대전시 동구 한남로 348', '010-1096-3107');
INSERT INTO customer(cst_no, cst_name, cst_address, cst_telno) 
    VALUES('A009', '최훈문', '대전시 중구 산서로 55', '010-2090-2488');
INSERT INTO customer(cst_no, cst_name, cst_address, cst_telno) 
    VALUES('A010', '조학택', '대전시 서구 가수원로 186', '010-5309-7957');

-- 직원
INSERT INTO employee(emp_no, emp_name, emp_address, emp_telno, emp_salay) 
    VALUES('A001', '천걸태', '대전시 대덕구 오정로 860', '010-6873-6874', 3000000);
INSERT INTO employee(emp_no, emp_name, emp_address, emp_telno, emp_salay) 
    VALUES('A002', '류실경', '대전시 서구 배재로 306', '010-1033-1341', 2800000);
INSERT INTO employee(emp_no, emp_name, emp_address, emp_telno, emp_salay) 
    VALUES('A003', '안호박', '대전시 유성구 신성로 781', '010-7148-9261', 3100000);
INSERT INTO employee(emp_no, emp_name, emp_address, emp_telno, emp_salay) 
    VALUES('A004', '허범원', '대전시 서구 도솔로 1131', '010-1079-7142', 2750000);
INSERT INTO employee(emp_no, emp_name, emp_address, emp_telno, emp_salay) 
    VALUES('A005', '손호광', '대전시 중구 문화로 226', '010-1674-1686', 1980000);
INSERT INTO employee(emp_no, emp_name, emp_address, emp_telno, emp_salay) 
    VALUES('A006', '정실은', '대전시 서구 계백로 29', '010-7346-5798', 3600000);
INSERT INTO employee(emp_no, emp_name, emp_address, emp_telno, emp_salay) 
    VALUES('A007', '엄다회', '대전시 서구 갈마로 804', '010-4168-1192', 4980000);
INSERT INTO employee(emp_no, emp_name, emp_address, emp_telno, emp_salay) 
    VALUES('A008', '진소규', '대전시 동구 고니2길 748', '010-9016-5986', 1580000);
INSERT INTO employee(emp_no, emp_name, emp_address, emp_telno, emp_salay) 
    VALUES('A009', '신중전', '대전시 동구 대전로 1258', '010-3074-2834', 2450000);
INSERT INTO employee(emp_no, emp_name, emp_address, emp_telno, emp_salay) 
    VALUES('A010', '노율애', '대전시 대덕구 계족로 540', '010-7099-1051', 3010000);

-- 자동차
INSERT INTO car(car_no, car_year, car_driving, car_maker, cst_no) 
    VALUES('123가4567', '2010', 150000, '현대', 'A001');
INSERT INTO car(car_no, car_year, car_driving, car_maker, cst_no) 
    VALUES('473사6274', '2018', 100000, '제네시스', 'A002');
INSERT INTO car(car_no, car_year, car_driving, car_maker, cst_no) 
    VALUES('135구7208', '2013', 160000, '쌍용', 'A003');
INSERT INTO car(car_no, car_year, car_driving, car_maker, cst_no) 
    VALUES('498러2023', '2020', 135000, '토요타', 'A004');
INSERT INTO car(car_no, car_year, car_driving, car_maker, cst_no) 
    VALUES('369구5991', '2021', 90000, '아반떼', 'A005');
INSERT INTO car(car_no, car_year, car_driving, car_maker, cst_no) 
    VALUES('202로8582', '2022', 12500, '쉐보레', 'A006');
INSERT INTO car(car_no, car_year, car_driving, car_maker, cst_no) 
    VALUES('358도8525', '2017', 280000, '벤츠', 'A007');
INSERT INTO car(car_no, car_year, car_driving, car_maker, cst_no) 
    VALUES('192마6128', '2018', 56000, 'BMW', 'A008');
INSERT INTO car(car_no, car_year, car_driving, car_maker, cst_no) 
    VALUES('477두7908', '2020', 23000, '기아', 'A009');
INSERT INTO car(car_no, car_year, car_driving, car_maker, cst_no) 
    VALUES('41보6378', '2023', 10000, '폭스바겐', 'A010');

INSERT INTO service(svc_no, svc_time, svc_price, emp_no, car_no, cst_no) 
    VALUES('2019031301', 96, 400000, 'A001', '123가4567','A001');
INSERT INTO service(svc_no, svc_time, svc_price, emp_no, car_no, cst_no) 
    VALUES('2019031302', 150, 2000000, 'A002', '473사6274','A002');
INSERT INTO service(svc_no, svc_time, svc_price, emp_no, car_no, cst_no) 
    VALUES('2019031303', 30, 250000, 'A003', '135구7208','A003');
INSERT INTO service(svc_no, svc_time, svc_price, emp_no, car_no, cst_no) 
    VALUES('2019031304', 72, 900000, 'A004', '498러2023','A004');
INSERT INTO service(svc_no, svc_time, svc_price, emp_no, car_no, cst_no) 
    VALUES('2019031401', 100, 30000, 'A005', '369구5991','A005');
INSERT INTO service(svc_no, svc_time, svc_price, emp_no, car_no, cst_no) 
    VALUES('2019031401', 120, 500000, 'A006', '202로8582','A006');
INSERT INTO service(svc_no, svc_time, svc_price, emp_no, car_no, cst_no) 
    VALUES('2019031402', 148, 59000, 'A007', '358도8525','A007');
INSERT INTO service(svc_no, svc_time, svc_price, emp_no, car_no, cst_no) 
    VALUES('2019031403', 300, 40000000, 'A008', '192마6128','A008');
INSERT INTO service(svc_no, svc_time, svc_price, emp_no, car_no, cst_no) 
    VALUES('2019031404', 16, 65000, 'A009', '477두7908','A009');
INSERT INTO service(svc_no, svc_time, svc_price, emp_no, car_no, cst_no) 
    VALUES('2019031405', 100, 2700000, 'A010', '41보6378','A010');


update service set [바꿀 데이터 열] = [바꿀 값] where [찾을 데이터 열] = [값];

select * from service;

-- 월급이 250만원 이사이고 300만원 이하인 직원번호, 주소, 연락처, 월급을 출력
select emp_name, emp_address, emp_telno, emp_salay FROM employee 
where emp_salay >= 2000000 and emp_salay <= 3000000;

-- 고객 'C007'이 수리를 요청한 목록을 수리비를 기준으로 내림차순으로 출력
select b.cst_no, b.cst_name, a.svc_price
    from service a, customer b
    where b.cst_no = 'A007' and a.cst_no = b.cst_no
    order by a.svc_price desc;

-- 카센터의 직원수와 평균급여를 출력
SELECT count(emp_no) 직원수, avg(emp_salay) 평균급여  FROM employee;













