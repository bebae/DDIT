
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
INSERT INTO customer(cst_no, cst_name, cst_address, cst_telno) 
    VALUES('A006', '�ż���', '������ ����� �߸��� 184', '010-2991-9920');
INSERT INTO customer(cst_no, cst_name, cst_address, cst_telno) 
    VALUES('A007', '���д�', '������ ���� ���� 1192', '010-5877-6831');
INSERT INTO customer(cst_no, cst_name, cst_address, cst_telno) 
    VALUES('A008', '������', '������ ���� �ѳ��� 348', '010-1096-3107');
INSERT INTO customer(cst_no, cst_name, cst_address, cst_telno) 
    VALUES('A009', '���ƹ�', '������ �߱� �꼭�� 55', '010-2090-2488');
INSERT INTO customer(cst_no, cst_name, cst_address, cst_telno) 
    VALUES('A010', '������', '������ ���� �������� 186', '010-5309-7957');

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
INSERT INTO employee(emp_no, emp_name, emp_address, emp_telno, emp_salay) 
    VALUES('A006', '������', '������ ���� ���� 29', '010-7346-5798', 3600000);
INSERT INTO employee(emp_no, emp_name, emp_address, emp_telno, emp_salay) 
    VALUES('A007', '����ȸ', '������ ���� ������ 804', '010-4168-1192', 4980000);
INSERT INTO employee(emp_no, emp_name, emp_address, emp_telno, emp_salay) 
    VALUES('A008', '���ұ�', '������ ���� ���2�� 748', '010-9016-5986', 1580000);
INSERT INTO employee(emp_no, emp_name, emp_address, emp_telno, emp_salay) 
    VALUES('A009', '������', '������ ���� ������ 1258', '010-3074-2834', 2450000);
INSERT INTO employee(emp_no, emp_name, emp_address, emp_telno, emp_salay) 
    VALUES('A010', '������', '������ ����� ������ 540', '010-7099-1051', 3010000);

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
INSERT INTO car(car_no, car_year, car_driving, car_maker, cst_no) 
    VALUES('202��8582', '2022', 12500, '������', 'A006');
INSERT INTO car(car_no, car_year, car_driving, car_maker, cst_no) 
    VALUES('358��8525', '2017', 280000, '����', 'A007');
INSERT INTO car(car_no, car_year, car_driving, car_maker, cst_no) 
    VALUES('192��6128', '2018', 56000, 'BMW', 'A008');
INSERT INTO car(car_no, car_year, car_driving, car_maker, cst_no) 
    VALUES('477��7908', '2020', 23000, '���', 'A009');
INSERT INTO car(car_no, car_year, car_driving, car_maker, cst_no) 
    VALUES('41��6378', '2023', 10000, '�����ٰ�', 'A010');

INSERT INTO service(svc_no, svc_time, svc_price, emp_no, car_no, cst_no) 
    VALUES('2019031301', 96, 400000, 'A001', '123��4567','A001');
INSERT INTO service(svc_no, svc_time, svc_price, emp_no, car_no, cst_no) 
    VALUES('2019031302', 150, 2000000, 'A002', '473��6274','A002');
INSERT INTO service(svc_no, svc_time, svc_price, emp_no, car_no, cst_no) 
    VALUES('2019031303', 30, 250000, 'A003', '135��7208','A003');
INSERT INTO service(svc_no, svc_time, svc_price, emp_no, car_no, cst_no) 
    VALUES('2019031304', 72, 900000, 'A004', '498��2023','A004');
INSERT INTO service(svc_no, svc_time, svc_price, emp_no, car_no, cst_no) 
    VALUES('2019031401', 100, 30000, 'A005', '369��5991','A005');
INSERT INTO service(svc_no, svc_time, svc_price, emp_no, car_no, cst_no) 
    VALUES('2019031401', 120, 500000, 'A006', '202��8582','A006');
INSERT INTO service(svc_no, svc_time, svc_price, emp_no, car_no, cst_no) 
    VALUES('2019031402', 148, 59000, 'A007', '358��8525','A007');
INSERT INTO service(svc_no, svc_time, svc_price, emp_no, car_no, cst_no) 
    VALUES('2019031403', 300, 40000000, 'A008', '192��6128','A008');
INSERT INTO service(svc_no, svc_time, svc_price, emp_no, car_no, cst_no) 
    VALUES('2019031404', 16, 65000, 'A009', '477��7908','A009');
INSERT INTO service(svc_no, svc_time, svc_price, emp_no, car_no, cst_no) 
    VALUES('2019031405', 100, 2700000, 'A010', '41��6378','A010');


update service set [�ٲ� ������ ��] = [�ٲ� ��] where [ã�� ������ ��] = [��];

select * from service;

-- ������ 250���� �̻��̰� 300���� ������ ������ȣ, �ּ�, ����ó, ������ ���
select emp_name, emp_address, emp_telno, emp_salay FROM employee 
where emp_salay >= 2000000 and emp_salay <= 3000000;

-- �� 'C007'�� ������ ��û�� ����� ������ �������� ������������ ���
select b.cst_no, b.cst_name, a.svc_price
    from service a, customer b
    where b.cst_no = 'A007' and a.cst_no = b.cst_no
    order by a.svc_price desc;

-- ī������ �������� ��ձ޿��� ���
SELECT count(emp_no) ������, avg(emp_salay) ��ձ޿�  FROM employee;













