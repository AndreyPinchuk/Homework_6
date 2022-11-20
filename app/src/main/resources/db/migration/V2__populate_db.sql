INSERT INTO WORKER (NAME, BIRTHDAY, LEVEL, SALARY) VALUES
	('Mark Jakob', '1995-10-03', 'Junior', 800),
	('Jim Ford','2000-08-15','Middle', 1200),
	('Rosy Bafoun','1994-01-06','Senior', 1900),
	('Bill Trast','1988-03-11','Trainee', 5900),
	('Karl Magic','2005-10-01','Middle', 2300),
	('Naomi Salar','2007-02-14','Junior', 1000),
	('Natan Browen','1999-12-09','Senior', 2800),
	('Ruf Rimes','2003-04-04','Senior', 3000),
	('Richi Foster','1995-03-16','Middle', 1500),
	('Cristin Malta','1997-05-29','Trainee', 5000);

INSERT INTO CLIENT (NAME) VALUES
	('Judi Karum'),
	('Michael Turner'),
	('Toky Mikaoto'),
	('Nike Demios'),
	('Rih Magdaun'),
	('Natali Forg');

INSERT INTO PROJECT (CLIENT_ID, START_DATE, FINISH_DATE) VALUES
	(1,'2014-09-12', '2022-02-10'),
	(1,'2017-12-20', '2021-10-23'),
	(5,'2018-08-12', '2020-12-12'),
	(6,'2018-09-01', '2019-07-19'),
	(2,'2018-10-01', '2022-01-29'),
	(3,'2018-12-11', '2019-02-20'),
	(5,'2019-01-19', '2021-08-22'),
	(1,'2020-06-06', '2021-10-27'),
	(4,'2021-04-15', '2022-10-04'),
	(2,'2021-09-25', '2022-07-19');

INSERT INTO PROJECT_WORKER (PROJECT_ID, WORKER_ID ) VALUES
	(1,10), (1,5), (1,3), (1,7),
	(2,2), (2,4), (2,6),
	(3,5), (3,4), (3,8),
	(4,3), (4,10),
	(5,3), (5,9), (5,5),
	(6,7), (6,8),
	(7,4), (7,6), (7,9),
	(8,4), (8,8),
	(9,4),
	(10,1), (10,8);