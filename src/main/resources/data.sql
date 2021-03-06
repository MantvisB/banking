DROP TABLE IF EXISTS STATEMENT;
DROP TABLE IF EXISTS ACCOUNT;
DROP TABLE IF EXISTS USER;



CREATE TABLE USER (
  ID INT AUTO_INCREMENT  PRIMARY KEY,
  EMAIL VARCHAR(255) NOT NULL UNIQUE,
  PASSWORD VARCHAR(255) NOT NULL,
  FIRST_NAME VARCHAR(255) NOT NULL,
  LAST_NAME VARCHAR(255) NOT NULL
);

CREATE TABLE ACCOUNT (
  ID INT AUTO_INCREMENT  PRIMARY KEY,
  USER_ID INT NOT NULL unique,
  BALANCE REAL NOT NULL,
  FOREIGN KEY (USER_ID) REFERENCES USER(ID)
);

CREATE TABLE STATEMENT (
  ID INT AUTO_INCREMENT  PRIMARY KEY,
  ACCOUNT_ID INT NOT NULL,
  ACTION VARCHAR(255) NOT NULL,
  VALUE REAL NOT NULL,
  DATE TIMESTAMP NOT NULL,
  FOREIGN KEY (ACCOUNT_ID) REFERENCES USER(ID)
);


INSERT INTO USER (EMAIL, PASSWORD, FIRST_NAME, LAST_NAME) VALUES
  ('allByMyself@email.com', 'Titanic', 'Céline', 'Dion'),
  ('LadyG@email.com', 'shallow', 'Lady', 'Gaga'),
  ('mrFahrenheit@email.com', 'queen', 'Freddie', 'Mercury');