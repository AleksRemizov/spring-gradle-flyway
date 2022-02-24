CREATE TABLE person (
    id int NOT NULL AUTO_INCREMENT,
    password varchar(20) not null,
    username varchar(50) not null unique,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE task (
    id int NOT NULL AUTO_INCREMENT,
    title varchar(64) not null,
    completed BOOLEAN NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;