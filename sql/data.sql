-- Work
INSERT INTO work (work_id, code, name) VALUES (1, 'W-00001', '인사기획/노무');
INSERT INTO work (work_id, code, name) VALUES (2, 'W-00002', '노사/인사운영');
INSERT INTO work (work_id, code, name) VALUES (3, 'W-00003', '급여/복리후생');
INSERT INTO work (work_id, code, name) VALUES (4, 'W-00004', '총무');
INSERT INTO work (work_id, code, name) VALUES (5, 'W-00005', '인사');
INSERT INTO work (work_id, code, name) VALUES (6, 'W-00006', '교육');

-- Employee
INSERT INTO employee (employee_id, name, position, task, telephone, work_id) VALUES (1, '손흥민', '선임', '소모품/자산', '08-0111-0002', 1);
INSERT INTO employee (employee_id, name, position, task, telephone, work_id) VALUES (2, '해리케인', '수석', '인사제도/평가관리/승격관리', '08-0111-0003', 2);
INSERT INTO employee (employee_id, name, position, task, telephone, work_id) VALUES (3, '쿨루셉스키', '선임', '채용', '08-0111-0004', 3);
INSERT INTO employee (employee_id, name, position, task, telephone, work_id) VALUES (4, '벤탕쿠르', '선임', '시설관리,문서관리,행사관리,자산관리,기타', '08-0111-0005', 4);
INSERT INTO employee (employee_id, name, position, task, telephone, work_id) VALUES (5, '로메로', '수석', '시설관리,차량관리,인쇄물관리', '08-0111-0006', 4);
INSERT INTO employee (employee_id, name, position, task, telephone, work_id) VALUES (6, '이메르송', '책임', '', '08-0111-0007', 5);
INSERT INTO employee (employee_id, name, position, task, telephone, work_id) VALUES (7, '베르베인', '수석', '인재육성/MBA/그룹 교육', '08-0111-0008', 6);
INSERT INTO employee (employee_id, name, position, task, telephone, work_id) VALUES (8, '요리스', '선임', '교육제도 기획/자기역량개발/채용', '08-0111-0009', 6);

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
