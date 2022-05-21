-- Delete All Data
delete from affiliated;
delete from employee;
delete from work;
delete from company;

-- Set Auto Increment
alter table affiliated auto_increment = 1;
alter table employee auto_increment = 1;
alter table work auto_increment = 1;
alter table company auto_increment = 1;

-- Work
INSERT INTO work (work_id, code, name) VALUES (1, 'W-00001', '인사기획/노무');
INSERT INTO work (work_id, code, name) VALUES (2, 'W-00002', '노사/인사운영');
INSERT INTO work (work_id, code, name) VALUES (3, 'W-00003', '급여/복리후생');
INSERT INTO work (work_id, code, name) VALUES (4, 'W-00004', '총무');
INSERT INTO work (work_id, code, name) VALUES (5, 'W-00005', '인사');
INSERT INTO work (work_id, code, name) VALUES (6, 'W-00006', '교육');
INSERT INTO work (work_id, code, name) VALUES (7, 'W-00007', '내자구매(용역/투산/자산)');
INSERT INTO work (work_id, code, name) VALUES (8, 'W-00008', '내자구매(구매지원)');
INSERT INTO work (work_id, code, name) VALUES (9, 'W-00009', '내자구매(상품)');
INSERT INTO work (work_id, code, name) VALUES (10, 'W-00010', '외자구매');
INSERT INTO work (work_id, code, name) VALUES (11, 'W-00011', '내자,외자 구매(투자 자산)');
INSERT INTO work (work_id, code, name) VALUES (12, 'W-00012', '자금');
INSERT INTO work (work_id, code, name) VALUES (13, 'W-00013', '공시/IR');
INSERT INTO work (work_id, code, name) VALUES (14, 'W-00014', '재무/관리');
INSERT INTO work (work_id, code, name) VALUES (15, 'W-00015', 'RiskManagement');

-- Employee
INSERT INTO employee (employee_id, name, position, task, telephone, work_id) VALUES (1, '손흥민', '선임', '소모품/자산', '08-0111-0002', 1);
INSERT INTO employee (employee_id, name, position, task, telephone, work_id) VALUES (2, '해리케인', '수석', '인사제도/평가관리/승격관리', '08-0111-0003', 2);
INSERT INTO employee (employee_id, name, position, task, telephone, work_id) VALUES (3, '쿨루셉스키', '선임', '채용', '08-0111-0004', 3);
INSERT INTO employee (employee_id, name, position, task, telephone, work_id) VALUES (4, '벤탕쿠르', '선임', '시설관리,문서관리,행사관리,자산관리,기타', '08-0111-0005', 4);
INSERT INTO employee (employee_id, name, position, task, telephone, work_id) VALUES (5, '로메로', '수석', '시설관리,차량관리,인쇄물관리', '08-0111-0006', 4);
INSERT INTO employee (employee_id, name, position, task, telephone, work_id) VALUES (6, '이메르송', '책임', '', '08-0111-0007', 5);
INSERT INTO employee (employee_id, name, position, task, telephone, work_id) VALUES (7, '베르베인', '수석', '인재육성/MBA/그룹 교육', '08-0111-0008', 6);
INSERT INTO employee (employee_id, name, position, task, telephone, work_id) VALUES (8, '요리스', '선임', '교육제도 기획/자기역량개발/채용', '08-0111-0009', 6);
INSERT INTO employee (employee_id, name, position, task, telephone, work_id) VALUES (9, '모우라', '수석', '내자용역,협력업체,하도급', '08-0111-0010', 7);
INSERT INTO employee (employee_id, name, position, task, telephone, work_id) VALUES (10, '레길론', '책임', '내자용역,협력업체', '08-0111-0011', 8);
INSERT INTO employee (employee_id, name, position, task, telephone, work_id) VALUES (11, '도허티', '선임', '내자상품,요역(모바일, 운영관리)', '08-0111-0012', 9);
INSERT INTO employee (employee_id, name, position, task, telephone, work_id) VALUES (12, '세세뇽', '수석', '창고재고, 원가, 안전재고,대관', '08-0111-0013', 10);
INSERT INTO employee (employee_id, name, position, task, telephone, work_id) VALUES (13, '호이비에르', '책임', '프로젝트 내자,외자 용역,하도급,구매발주 입고)', '08-0111-0014', 11);
INSERT INTO employee (employee_id, name, position, task, telephone, work_id) VALUES (14, '다이어', '선임', '', '08-0111-0015', 12);
INSERT INTO employee (employee_id, name, position, task, telephone, work_id) VALUES (15, '윙크스', '수석', '', '08-0111-0016', 12);
INSERT INTO employee (employee_id, name, position, task, telephone, work_id) VALUES (16, '골리니', '책임', '', '08-0111-0017', 13);
INSERT INTO employee (employee_id, name, position, task, telephone, work_id) VALUES (17, '스킵', '선임', '전표결재,세무,결산 감사,계획', '08-0111-0018', 14);
INSERT INTO employee (employee_id, name, position, task, telephone, work_id) VALUES (18, '산체스', '수석', '전표결재,세무,결산 감사,계획', '08-0111-0019', 14);
INSERT INTO employee (employee_id, name, position, task, telephone, work_id) VALUES (19, '탕당가', '책임', '전표결재,세무,결산 감사,계획', '08-0111-0020', 14);
INSERT INTO employee (employee_id, name, position, task, telephone, work_id) VALUES (20, '로든', '선임', '전표결재,세무,결산 감사,계획', '08-0111-0021', 14);
INSERT INTO employee (employee_id, name, position, task, telephone, work_id) VALUES (21, '스칼렛', '수석', '리스크관리/감사/법무', '08-0111-0022',15);
INSERT INTO employee (employee_id, name, position, task, telephone, work_id) VALUES (22, '화이트', '책임', '리스크관리/감사/법무', '08-0111-0023', 15);


-- Company
INSERT INTO company (company_id, name) VALUES (1, 'PNS');
INSERT INTO company (company_id, name) VALUES (2, '인티큐브');

-- Affiliated
INSERT INTO affiliated (affiliated_id, employee_id, company_id) VALUES (1, 1, 1);
INSERT INTO affiliated (affiliated_id, employee_id, company_id) VALUES (2, 1, 2);
INSERT INTO affiliated (affiliated_id, employee_id, company_id) VALUES (3, 2, 1);
INSERT INTO affiliated (affiliated_id, employee_id, company_id) VALUES (4, 2, 2);
INSERT INTO affiliated (affiliated_id, employee_id, company_id) VALUES (5, 3, 1);
INSERT INTO affiliated (affiliated_id, employee_id, company_id) VALUES (6, 3, 2);
INSERT INTO affiliated (affiliated_id, employee_id, company_id) VALUES (7, 4, 1);
INSERT INTO affiliated (affiliated_id, employee_id, company_id) VALUES (8, 4, 2);
INSERT INTO affiliated (affiliated_id, employee_id, company_id) VALUES (9, 5, 1);
INSERT INTO affiliated (affiliated_id, employee_id, company_id) VALUES (10, 5, 2);
INSERT INTO affiliated (affiliated_id, employee_id, company_id) VALUES (11, 6, 1);
INSERT INTO affiliated (affiliated_id, employee_id, company_id) VALUES (12, 6, 2);
INSERT INTO affiliated (affiliated_id, employee_id, company_id) VALUES (13, 7, 1);
INSERT INTO affiliated (affiliated_id, employee_id, company_id) VALUES (14, 7, 2);
INSERT INTO affiliated (affiliated_id, employee_id, company_id) VALUES (15, 8, 1);
INSERT INTO affiliated (affiliated_id, employee_id, company_id) VALUES (16, 8, 2);
INSERT INTO affiliated (affiliated_id, employee_id, company_id) VALUES (17, 9, 1);
INSERT INTO affiliated (affiliated_id, employee_id, company_id) VALUES (18, 9, 2);
INSERT INTO affiliated (affiliated_id, employee_id, company_id) VALUES (19, 10, 1);
INSERT INTO affiliated (affiliated_id, employee_id, company_id) VALUES (20, 10, 2);
INSERT INTO affiliated (affiliated_id, employee_id, company_id) VALUES (21, 11, 1);
INSERT INTO affiliated (affiliated_id, employee_id, company_id) VALUES (22, 11, 2);
INSERT INTO affiliated (affiliated_id, employee_id, company_id) VALUES (23, 12, 1);
INSERT INTO affiliated (affiliated_id, employee_id, company_id) VALUES (24, 12, 2);
INSERT INTO affiliated (affiliated_id, employee_id, company_id) VALUES (25, 13, 1);
INSERT INTO affiliated (affiliated_id, employee_id, company_id) VALUES (26, 14, 1);
INSERT INTO affiliated (affiliated_id, employee_id, company_id) VALUES (27, 14, 2);
INSERT INTO affiliated (affiliated_id, employee_id, company_id) VALUES (28, 15, 1);
INSERT INTO affiliated (affiliated_id, employee_id, company_id) VALUES (29, 15, 2);
INSERT INTO affiliated (affiliated_id, employee_id, company_id) VALUES (30, 16, 2);
INSERT INTO affiliated (affiliated_id, employee_id, company_id) VALUES (31, 17, 1);
INSERT INTO affiliated (affiliated_id, employee_id, company_id) VALUES (32, 18, 2);
INSERT INTO affiliated (affiliated_id, employee_id, company_id) VALUES (33, 19, 1);
INSERT INTO affiliated (affiliated_id, employee_id, company_id) VALUES (34, 20, 2);
INSERT INTO affiliated (affiliated_id, employee_id, company_id) VALUES (35, 21, 1);
INSERT INTO affiliated (affiliated_id, employee_id, company_id) VALUES (36, 22, 2);
