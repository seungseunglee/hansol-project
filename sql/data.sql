-- Works
insert into work (id, code, name) values (1, 'W-00001', '인사기획/노무');
insert into work (id, code, name) values (2, 'W-00002', '노사/인사운영');
insert into work (id, code, name) values (3, 'W-00003', '급여/복리후생');
insert into work (id, code, name) values (4, 'W-00004', '총무');
insert into work (id, code, name) values (5, 'W-00005', '인사');

-- Employees
insert into employee (id, name, company1, company2, position, task, telephone, work_id) values (1, '손흥민', 'PNS', '인티큐브', '선임', '소모품/자산', '08-0111-0002', 1);
insert into employee (id, name, company1, company2, position, task, telephone, work_id) values (2, '해리케인', 'PNS', '인티큐브', '수석', '인사제도/평가관리/승격관리', '08-0111-0003', 2);
insert into employee (id, name, company1, company2, position, task, telephone, work_id) values (3, '쿨루셉스키', 'PNS', '인티큐브', '선임', '채용', '08-0111-0004', 3);
insert into employee (id, name, company1, company2, position, task, telephone, work_id) values (4, '벤탕쿠르', 'PNS', '인티큐브', '선임', '시설관리,문서관리,행사관리,자산관리,기타', '08-0111-0005', 4);
insert into employee (id, name, company1, company2, position, task, telephone, work_id) values (5, '로메로', 'PNS', '인티큐브', '수석', '시설관리,차량관리,인쇄물관리', '08-0111-0006', 4);