DROP table if exists person;

DROP table if exists task;

CREATE TABLE person (
  id SERIAL NOT NULL,
   name VARCHAR(255) NULL UNIQUE,
   password VARCHAR(255) NULL,
   CONSTRAINT pk_person PRIMARY KEY (id)
);

CREATE TABLE task (
  id INT NOT NULL,
   title VARCHAR(255) NULL,
   completed BIT(1) NULL,
   description VARCHAR(255) NULL,
   person_id INT NULL,
   CONSTRAINT pk_task PRIMARY KEY (id)
);

ALTER TABLE task ADD CONSTRAINT FK_TASK_ON_PERSON FOREIGN KEY (person_id) REFERENCES person (id);

