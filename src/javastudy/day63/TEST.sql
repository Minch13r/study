CREATE TABLE MEMBER(
                       MID VARCHAR(10) PRIMARY KEY,
                       MPW VARCHAR(10) NOT NULL,
                       NAME VARCHAR(30) NOT NULL,
                       MROLE VARCHAR(10) DEFAULT 'USER'
);

INSERT INTO MEMBER VALUES ('test', '1234', '테스트', 'USER');
INSERT INTO MEMBER VALUES ('admin', '1234', '관리자', 'ADMIN');


CREATE TABLE BOARD(
                      BID INT PRIMARY KEY,
                      TITLE VARCHAR(30) NOT NULL,
                      CONTENT VARCHAR(30) NOT NULL,
                      WRITER VARCHAR(10) NOT NULL,
                      CNT INT DEFAULT 0
);

INSERT INTO BOARD VALUES (NVL((SELECT MAX(BID)+1 FROM BOARD),1001), '제목1', '내용1', 'ADMIN', 0);
INSERT INTO BOARD VALUES (NVL((SELECT MAX(BID)+1 FROM BOARD),1001), '제목2', '내용2', 'ADMIN', 0);

SELECT * FROM BOARD;