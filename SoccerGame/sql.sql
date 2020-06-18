CREATE DATABASE soccer;
USE soccer;


CREATE TABLE team(
teamName CHAR(20),
address VARCHAR(50),
id CHAR(20),
setUp DATE,
peopleCounting INT(20),
PRIMARY KEY (id)
)ENGINE=INNODB AUTO_INCREMENT=100031 DEFAULT CHARSET=utf8mb4;


INSERT INTO team VALUES('豆腐金刚', '河北省邢台市','12138', '1997-6-7', 20);
INSERT INTO team VALUES('玉面双雄', '河北省唐山市','071000', '2000-3-23', 20);
INSERT INTO team VALUES('少林足球队', '河北省保定市', '071221', '2001-7-12', 20);
INSERT INTO team VALUES('魔鬼队', '河北省张家口市','071429', '2003-12-21', 20);


crea`player`te TABLE player(
NAME CHAR(10),
personId CHAR(13),
birthDate DATE,
height INT(250),
address VARCHAR(50),
teamName CHAR(20),
PRIMARY KEY(personId)
)ENGINE=INNODB AUTO_INCREMENT=100031 DEFAULT CHARSET=utf8mb4;

INSERT INTO player VALUES('大狗','1234567890111','1976-10-22', 185, '河北省唐山市','豆腐金刚');
INSERT INTO player VALUES('二狗','1234567890112','1976-10-23', 175, '河北省唐山市','豆腐金刚');
INSERT INTO player VALUES('星','1234567892117','1975-10-28', 174, '河北省保定市','少林足球');
INSERT INTO player VALUES('三狗','1234567890113','1976-10-24', 187, '河北省唐山市','豆腐金刚');
INSERT INTO player VALUES('二师兄','1234567840117','1973-7-2', 180, '河北省邢台市','少林足球');
INSERT INTO player VALUES('四狗','1234567890114','1976-10-25', 186, '河北省唐山市','豆腐金刚');
INSERT INTO player VALUES('五狗','1234567890115','1976-10-26', 174, '河北省唐山市','豆腐金刚');
INSERT INTO player VALUES('大师兄','1234567893117','1976-10-28', 182, '河北省张家口市','少林足球');
INSERT INTO player VALUES('六狗','1234567890116','1976-10-27', 160, '河北省唐山市','豆腐金刚');
INSERT INTO player VALUES('七狗','1234567890117','1976-10-28', 177, '河北省唐山市','豆腐金刚');

SELECT * FROM player WHERE teamName='豆腐金刚';
SELECT * FROM player WHERE personId = '071000';

CREATE TABLE coach(
NAME CHAR(10),
personId CHAR(13),
birthdate DATE,
certificate VARCHAR(20),
LEVEL CHAR(5),
teamName CHAR(20),
PRIMARY KEY(personId)
)ENGINE=INNODB AUTO_INCREMENT=100031 DEFAULT CHARSET=utf8mb4;