
INSERT INTO car() VALUES();

-- ��
INSERT INTO customer(cst_no, cst_name, cst_address, cst_telno) 
    VALUES('A001', '��μ�', '������ �߱� ���� 1001-10','010-3125-3721');
INSERT INTO customer(cst_no, cst_name, cst_address, cst_telno) 
    VALUES('A002', '������', '������ ���� ���� 615','010-5785-6268');
INSERT INTO customer(cst_no, cst_name, cst_address, cst_telno) 
    VALUES('A003', '������', '������ �߱� ������ 480','010-1815-3137');
INSERT INTO customer(cst_no, cst_name, cst_address, cst_telno) 
    VALUES('A004', '���ѱ�', '������ ���� ������� 1503','010-9912-0284');
INSERT INTO customer(cst_no, cst_name, cst_address, cst_telno) 
    VALUES('A005', '���̸�', '������ ���� ���糲�� 23','010-1017-3387');

-- ����
INSERT INTO employee(emp_no, emp_name, emp_address, emp_telno, emp_salay) 
    VALUES('A001', 'õ����', '������ ����� ������ 860', '010-6873-6874', 3000000);
INSERT INTO employee(emp_no, emp_name, emp_address, emp_telno, emp_salay) 
    VALUES('A002', '���ǰ�', '������ ���� ����� 306', '010-1033-1341', 2800000);
INSERT INTO employee(emp_no, emp_name, emp_address, emp_telno, emp_salay) 
    VALUES('A003', '��ȣ��', '������ ������ �ż��� 781', '010-7148-9261', 3100000);
INSERT INTO employee(emp_no, emp_name, emp_address, emp_telno, emp_salay) 
    VALUES('A004', '�����', '������ ���� ���ַ� 1131', '010-1079-7142', 2750000);
INSERT INTO employee(emp_no, emp_name, emp_address, emp_telno, emp_salay) 
    VALUES('A005', '��ȣ��', '������ �߱� ��ȭ�� 226', '010-1674-1686', 1980000);

-- �ڵ���
INSERT INTO car(car_no, car_year, car_driving, car_maker, cst_no) 
    VALUES('123��4567', '2010', 150000, '����', 'A001');
INSERT INTO car(car_no, car_year, car_driving, car_maker, cst_no) 
    VALUES('473��6274', '2018', 100000, '���׽ý�', 'A002');
INSERT INTO car(car_no, car_year, car_driving, car_maker, cst_no) 
    VALUES('135��7208', '2013', 160000, '�ֿ�', 'A003');
INSERT INTO car(car_no, car_year, car_driving, car_maker, cst_no) 
    VALUES('498��2023', '2020', 135000, '���Ÿ', 'A004');
INSERT INTO car(car_no, car_year, car_driving, car_maker, cst_no) 
    VALUES('369��5991', '2021', 90000, '�ƹݶ�', 'A005');


INSERT INTO service(svc_no, svc_time, svc_price, emp_no, car_no, cst_no) 
    VALUES('2019031301', 96, 400000, 'A001', '123��4567','A001');
INSERT INTO service(svc_no, svc_time, svc_price, emp_no, car_no, cst_no) 
    VALUES('2019031302', 150, 2000000, 'A002', '473��6274','A002');
INSERT INTO service(svc_no, svc_time, svc_price, emp_no, car_no, cst_no) 
    VALUES('2019031303', 30, 250000, 'A003', '135��7208','A003');
INSERT INTO service(svc_no, svc_time, svc_price, emp_no, car_no, cst_no) 
    VALUES('2019031304', 72, 900000, 'A004', '498��2023','A004');
INSERT INTO service(svc_no, svc_time, svc_price, emp_no, car_no, cst_no) 
    VALUES('2019031305', 10, 30000, 'A005', '369��5991','A005');






