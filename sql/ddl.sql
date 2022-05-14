CREATE TABLE work
(
    `id`    INT            NOT NULL    AUTO_INCREMENT,
    `code`  CHAR(7)        NOT NULL,
    `name`  VARCHAR(45)    NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE employee
(
    `id`         INT            NOT NULL    AUTO_INCREMENT,
    `name`       VARCHAR(45)    NOT NULL,
    `company1`   VARCHAR(45)    NOT NULL,
    `company2`   VARCHAR(45)    NULL,
    `position`   VARCHAR(45)    NOT NULL,
    `task`       VARCHAR(45)    NULL,
    `telephone`  CHAR(12)       NULL,
    `work_id`    INT            NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (work_id) REFERENCES work(id)
);