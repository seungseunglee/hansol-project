CREATE TABLE work
(
    `work_id`    INT            NOT NULL    AUTO_INCREMENT,
    `code`  CHAR(7)        NOT NULL,
    `name`  VARCHAR(45)    NOT NULL,
    PRIMARY KEY (work_id)
);

CREATE TABLE employee
(
    `employee_id`         INT            NOT NULL    AUTO_INCREMENT,
    `name`       VARCHAR(45)    NOT NULL,
    `position`   VARCHAR(45)    NOT NULL,
    `task`       VARCHAR(45)    NULL,
    `telephone`  CHAR(12)       NULL,
    `work_id`    INT            NULL,
    PRIMARY KEY (employee_id),
    CONSTRAINT FK_work_id_employee_work_id FOREIGN KEY (work_id) REFERENCES work(work_id) ON DELETE CASCADE
);

CREATE TABLE company
(
    `company_id`    INT            NOT NULL    AUTO_INCREMENT,
    `name`  VARCHAR(45)    NOT NULL,
    PRIMARY KEY (company_id)
);

CREATE TABLE affiliated
(
    `affiliated_id`           INT    NOT NULL    AUTO_INCREMENT,
    `employee_id`  INT    NOT NULL,
    `company_id`   INT    NOT NULL,
    PRIMARY KEY (affiliated_id),
    CONSTRAINT FK_employee_id_affiliated_employee_id FOREIGN KEY (employee_id) REFERENCES employee(employee_id) ON DELETE CASCADE,
    CONSTRAINT FK_company_id_affiliated_company_id FOREIGN KEY (company_id) REFERENCES company(company_id) ON DELETE CASCADE
);