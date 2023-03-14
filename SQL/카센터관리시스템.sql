
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


INSERT INTO service(svc_no, svc_time, svc_price, emp_no, car_no, cst_no) 
    VALUES('2019031301', 96, 400000, 'A001', '123가4567','A001');
INSERT INTO service(svc_no, svc_time, svc_price, emp_no, car_no, cst_no) 
    VALUES('2019031302', 150, 2000000, 'A002', '473사6274','A002');
INSERT INTO service(svc_no, svc_time, svc_price, emp_no, car_no, cst_no) 
    VALUES('2019031303', 30, 250000, 'A003', '135구7208','A003');
INSERT INTO service(svc_no, svc_time, svc_price, emp_no, car_no, cst_no) 
    VALUES('2019031304', 72, 900000, 'A004', '498러2023','A004');
INSERT INTO service(svc_no, svc_time, svc_price, emp_no, car_no, cst_no) 
    VALUES('2019031305', 10, 30000, 'A005', '369구5991','A005');






