drop table users, accounts, transactions;

CREATE TABLE Users (
id BIGINT,
username VARCHAR(30) NOT NULL,
password VARCHAR(30) NOT NULL,
`name` VARCHAR(30) NOT NULL,
last_name VARCHAR(30) NOT NULL,
phone BIGINT,
email VARCHAR(50),
PRIMARY KEY (id)
);

CREATE TABLE Accounts (
id BIGINT AUTO_INCREMENT,
balance DOUBLE NOT NULL,
user_id BIGINT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (user_id) REFERENCES Users(id)
);

CREATE TABLE Transactions (
id BIGINT AUTO_INCREMENT,
`value` DOUBLE NOT NULL,
cost DOUBLE NOT NULL,
`date` DATE NOT NULL,
description VARCHAR(255),
type ENUM("DEPOSIT","PURCHASE","WITHDRAWAL") NOT NULL,
mean ENUM("ATM","BRANCH","ACCOUNT","CARDINSTORE","CARDONLINE") NOT NULL,
account_id BIGINT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (account_id) REFERENCES Accounts(id)
);

select * from users;
select * from transactions;
select * from accounts;

select Max(a.user_id) from accounts a;

insert
into users (id, username, password, name, last_name, phone, email)
values (1, 'andrecat', 'ahhbjs', 'andrea', 'arias', 3002656789, 'holis@hakjsa.com');

select * from users u where u.id = 1;
