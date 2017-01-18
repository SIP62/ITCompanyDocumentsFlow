-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.0.45-community-nt - MySQL Community Edition (GPL)
-- Операционная система:         Win32
-- HeidiSQL Версия:              9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Дамп структуры базы данных itcompany
CREATE DATABASE IF NOT EXISTS `itcompany` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `itcompany`;

-- Дамп структуры для таблица itcompany.client
CREATE TABLE IF NOT EXISTS `client` (
  `id` int(11) NOT NULL auto_increment,
  `id_users` int(11) default NULL,
  `payment_credentials` varchar(50) collate utf8_unicode_ci default NULL,
  `phone` varchar(50) collate utf8_unicode_ci default NULL,
  `email` varchar(50) collate utf8_unicode_ci default NULL,
  `discount` float NOT NULL default '0',
  `address` varchar(50) collate utf8_unicode_ci default NULL,
  PRIMARY KEY  (`id`),
  KEY `id_users` (`id_users`),
  CONSTRAINT `FK_client_users` FOREIGN KEY (`id_users`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Дамп данных таблицы itcompany.client: ~10 rows (приблизительно)
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` (`id`, `id_users`, `payment_credentials`, `phone`, `email`, `discount`, `address`) VALUES
	(1, 9, 'VISA0111', '2936855', 'siphome@mail.ru', 0, 'Minsk'),
	(2, 10, 'VISA02', '3993834', 'sytauhome@yandex.ru', 7, 'Minsk'),
	(3, 11, 'VISA03', '4545451', 'ivan@mail.ru', 0, 'Minsk'),
	(4, 12, 'VISA04', '1212121', 'peter@mail.ru', 0, 'Minsk'),
	(5, 13, 'VISA05', '1111113', 'vasya@mail.ru', 0, 'Minsk'),
	(6, 14, 'VISA06', '6575757', 'semen@mail.ru', 0, 'Minsk'),
	(7, 15, 'VISA07', '7657657', 'marat@mail.ru', 5, 'Minsk'),
	(9, 22, 'VISA77', '6161616', 'mir@mail.ru', 0, 'Brest'),
	(10, 25, 'visa111', '222', 'vic@a', 0, 'Minsk'),
	(11, 28, 'VISA444', '45645645', 'anna@mail.ru', 2, 'Minsk');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;

-- Дамп структуры для таблица itcompany.clientemployees
CREATE TABLE IF NOT EXISTS `clientemployees` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) collate utf8_unicode_ci default NULL,
  `phone` varchar(50) collate utf8_unicode_ci default NULL,
  `email` varchar(50) collate utf8_unicode_ci default NULL,
  `skype` varchar(50) collate utf8_unicode_ci default NULL,
  `status` varchar(50) collate utf8_unicode_ci default NULL,
  `id_client` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `id_client` (`id_client`),
  CONSTRAINT `FK_clientemployees_client` FOREIGN KEY (`id_client`) REFERENCES `client` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Дамп данных таблицы itcompany.clientemployees: ~4 rows (приблизительно)
/*!40000 ALTER TABLE `clientemployees` DISABLE KEYS */;
INSERT INTO `clientemployees` (`id`, `name`, `phone`, `email`, `skype`, `status`, `id_client`) VALUES
	(1, 'Petrov', '6565656', 'petrov@mail.ru', 'petr', 'tester', 1),
	(2, 'Sidorov', '7878787', 'sidorov@mail.ru', 'sidor', 'user', 1),
	(3, 'Ivanov', '1231234', 'ivanov@mail.ru', 'ivan', 'tester', 2),
	(4, 'Platonov', '9999999', 'platonov@mail.ru', 'platon', 'user', 1);
/*!40000 ALTER TABLE `clientemployees` ENABLE KEYS */;

-- Дамп структуры для таблица itcompany.employee
CREATE TABLE IF NOT EXISTS `employee` (
  `id` int(11) NOT NULL auto_increment,
  `id_users` int(11) default NULL,
  `address` varchar(50) collate utf8_unicode_ci default NULL,
  `phone` varchar(50) collate utf8_unicode_ci default NULL,
  `passport` varchar(50) collate utf8_unicode_ci default NULL,
  `credit_card` varchar(50) collate utf8_unicode_ci default NULL,
  `resume` text collate utf8_unicode_ci,
  `specialization` varchar(50) collate utf8_unicode_ci default NULL,
  `salary` float default NULL,
  `recruitment_date` date default NULL,
  `contract_expiration_date` date default NULL,
  PRIMARY KEY  (`id`),
  KEY `id_users` (`id_users`),
  CONSTRAINT `FK_employee_users` FOREIGN KEY (`id_users`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Дамп данных таблицы itcompany.employee: ~10 rows (приблизительно)
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`id`, `id_users`, `address`, `phone`, `passport`, `credit_card`, `resume`, `specialization`, `salary`, `recruitment_date`, `contract_expiration_date`) VALUES
	(1, 1, 'Minsk', '6123123', 'MP12345678', 'VISA13', 'very good', 'java', 600, '2014-05-31', '2018-03-01'),
	(2, 2, 'Minsk', '6457890', 'MP87654321', 'VISA14', 'good', 'javascript', 400, '2014-03-07', '2018-03-07'),
	(3, 3, 'Minsk', '6787878', 'MP12341234', 'VISA15', 'good', 'java', 1000, '2012-03-07', '2019-03-07'),
	(4, 4, 'Minsk', '6232323', 'MP23232323', 'VISA23', 'good', 'management', 2050, '2010-03-07', '2020-04-06'),
	(5, 5, 'Minsk', '6575757', 'MP57575757', 'VISA17', 'very good', 'administration', 1500, '2009-05-11', '2021-05-11'),
	(6, 6, 'Minsk', '6989898', 'MP98989898', 'VISA18', 'good', 'human resources', 1400, '2013-03-09', '2019-03-09'),
	(7, 7, 'Minsk', '6234234', 'MP23423423', 'VISA19', 'very good', 'management', 1600, '2012-03-10', '2020-03-10'),
	(8, 8, 'Minsk', '7777777', 'MP78787878', 'VISA20', 'good', 'php', 400, '2011-05-05', '2017-05-05'),
	(9, 21, 'Minsk', '9877890', 'MP67896789', 'VISA88', 'good', 'java', 500, '2015-11-11', '2020-11-11'),
	(13, 27, 'Brest', '12341234', 'MP12341234', 'VISA1234', 'good', 'java', 700, '2016-05-20', '2020-05-20');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;

-- Дамп структуры для таблица itcompany.info
CREATE TABLE IF NOT EXISTS `info` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) collate utf8_unicode_ci default NULL,
  `date` date default NULL,
  `description` text collate utf8_unicode_ci,
  `author_id` int(11) default NULL,
  `id_project` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `id_project` (`id_project`),
  KEY `author_id` (`author_id`),
  CONSTRAINT `FK_info_employee` FOREIGN KEY (`author_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `FK_info_project` FOREIGN KEY (`id_project`) REFERENCES `project` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Дамп данных таблицы itcompany.info: ~3 rows (приблизительно)
/*!40000 ALTER TABLE `info` DISABLE KEYS */;
INSERT INTO `info` (`id`, `name`, `date`, `description`, `author_id`, `id_project`) VALUES
	(1, 'change', '2016-03-17', 'change of term', 4, 1),
	(2, 'change', '2016-03-17', 'change of condition', 1, 1),
	(3, 'change of parameter', '2016-03-16', 'change of parameter of website', 4, 2);
/*!40000 ALTER TABLE `info` ENABLE KEYS */;

-- Дамп структуры для таблица itcompany.project
CREATE TABLE IF NOT EXISTS `project` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) collate utf8_unicode_ci default NULL,
  `description` text collate utf8_unicode_ci,
  `requirements_specification` text collate utf8_unicode_ci,
  `cost` float default NULL,
  `start_date` date default NULL,
  `finish_date` date default NULL,
  `progress` float default NULL,
  `id_client` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `id_client` (`id_client`),
  CONSTRAINT `FK_project_client` FOREIGN KEY (`id_client`) REFERENCES `client` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Дамп данных таблицы itcompany.project: ~3 rows (приблизительно)
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` (`id`, `name`, `description`, `requirements_specification`, `cost`, `start_date`, `finish_date`, `progress`, `id_client`) VALUES
	(1, 'Library', 'Accounting books in Library', 'specification for library', 5000, '2016-02-20', '2016-08-07', 20, 1),
	(2, 'Website', 'Website of Furniture Company', 'specification for website', 3000, '2016-02-08', '2016-05-08', 15, 2),
	(3, 'University', 'University documentation', 'specification for university', 4000, '2016-01-08', '2016-07-08', 10, 1);
/*!40000 ALTER TABLE `project` ENABLE KEYS */;

-- Дамп структуры для таблица itcompany.project_employee
CREATE TABLE IF NOT EXISTS `project_employee` (
  `id` int(11) NOT NULL auto_increment,
  `id_employee` int(11) NOT NULL default '0',
  `id_project` int(11) NOT NULL default '0',
  PRIMARY KEY  (`id`),
  KEY `id_employee` (`id_employee`),
  KEY `id_project` (`id_project`),
  CONSTRAINT `FK_project_employee_employee` FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id`),
  CONSTRAINT `FK_project_employee_project` FOREIGN KEY (`id_project`) REFERENCES `project` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Дамп данных таблицы itcompany.project_employee: ~8 rows (приблизительно)
/*!40000 ALTER TABLE `project_employee` DISABLE KEYS */;
INSERT INTO `project_employee` (`id`, `id_employee`, `id_project`) VALUES
	(2, 2, 1),
	(3, 1, 2),
	(4, 3, 1),
	(5, 3, 2),
	(6, 1, 3),
	(7, 2, 3),
	(8, 3, 3),
	(12, 1, 1);
/*!40000 ALTER TABLE `project_employee` ENABLE KEYS */;

-- Дамп структуры для таблица itcompany.project_proposal
CREATE TABLE IF NOT EXISTS `project_proposal` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) collate utf8_unicode_ci default NULL,
  `contact_name` varchar(50) collate utf8_unicode_ci default NULL,
  `phone` varchar(50) collate utf8_unicode_ci default NULL,
  `email` varchar(50) collate utf8_unicode_ci default NULL,
  `status` varchar(50) collate utf8_unicode_ci default NULL,
  `description` text collate utf8_unicode_ci,
  `requirement_specification` text collate utf8_unicode_ci,
  `term` varchar(50) collate utf8_unicode_ci default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Дамп данных таблицы itcompany.project_proposal: ~3 rows (приблизительно)
/*!40000 ALTER TABLE `project_proposal` DISABLE KEYS */;
INSERT INTO `project_proposal` (`id`, `name`, `contact_name`, `phone`, `email`, `status`, `description`, `requirement_specification`, `term`) VALUES
	(7, 'Website of school', 'Ivan', '4545450', 'ivan@mail.ru', 'client', 'Website of school', 'specification', '50 days'),
	(8, 'Website', 'Ivan', '4545450', 'ivan@mail.ru', 'client', 'website', 'specification', '50 days'),
	(11, 'Website of theater', 'Serg ', '6333333', 'serg@mail.ru', 'guest', 'Website of theater', 'specification of website', '3 month');
/*!40000 ALTER TABLE `project_proposal` ENABLE KEYS */;

-- Дамп структуры для таблица itcompany.recruit
CREATE TABLE IF NOT EXISTS `recruit` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) collate utf8_unicode_ci default NULL,
  `phone` varchar(50) collate utf8_unicode_ci default NULL,
  `email` varchar(50) collate utf8_unicode_ci default NULL,
  `specialization` varchar(50) collate utf8_unicode_ci default NULL,
  `resume` text collate utf8_unicode_ci,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Дамп данных таблицы itcompany.recruit: ~5 rows (приблизительно)
/*!40000 ALTER TABLE `recruit` DISABLE KEYS */;
INSERT INTO `recruit` (`id`, `name`, `phone`, `email`, `specialization`, `resume`) VALUES
	(1, 'Semenov', '6888888', 'semenov@mail.ru', 'java', 'good'),
	(2, 'Sedov', '6050505', 'sedov@mail.ru', 'php', 'good'),
	(3, 'Panov', '6868687', 'panov@mail.ru', 'javascript', 'good'),
	(4, 'Serg', '7474747', 'serg@mail.ru', 'java', 'good'),
	(5, 'Gorg', '6716716', 'gorg@mail.ru', 'c#', 'good');
/*!40000 ALTER TABLE `recruit` ENABLE KEYS */;

-- Дамп структуры для таблица itcompany.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) NOT NULL auto_increment,
  `role` varchar(50) collate utf8_unicode_ci default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Дамп данных таблицы itcompany.roles: ~8 rows (приблизительно)
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`id`, `role`) VALUES
	(1, 'programmer'),
	(2, 'team_leader'),
	(3, 'project_manager'),
	(4, 'client_manager'),
	(5, 'admin'),
	(6, 'HR'),
	(7, 'client'),
	(8, 'guest');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;

-- Дамп структуры для таблица itcompany.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) character set utf8 default NULL,
  `login` varchar(50) character set utf8 default NULL,
  `password_hash` varchar(50) character set utf8 default NULL,
  `id_roles` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `id_roles` (`id_roles`),
  CONSTRAINT `FK__roles` FOREIGN KEY (`id_roles`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Дамп данных таблицы itcompany.users: ~23 rows (приблизительно)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `name`, `login`, `password_hash`, `id_roles`) VALUES
	(1, 'Alex', 'alex', 'doha', 1),
	(2, 'Fedor', 'fedor', 'ihgru', 1),
	(3, 'Maxim', 'max', 'pda', 2),
	(4, 'Artur', 'artur', 'duwxu', 3),
	(5, 'Andrew', 'andrew', 'dqguhz', 5),
	(6, 'Oleg', 'oleg', 'rohj', 6),
	(7, 'Vadim', 'vadim', 'ydglp', 4),
	(8, 'Egor', 'egor', 'hjru', 1),
	(9, 'Ihar', 'sip', 'tzhuwb', 7),
	(10, 'Pasha', 'pasha', 'iluvw', 7),
	(11, 'Ivan', 'ivan', 'lydq', 7),
	(12, 'Peter', 'peter', 'shwhu', 7),
	(13, 'Vasya', 'vasya', 'ydvbd', 7),
	(14, 'Semen', 'semen', 'vhphq', 7),
	(15, 'Marat', 'marat', 'pdudw', 7),
	(16, 'Serg', 'serg', 'vhuj', 8),
	(21, 'Petr', 'petr', 'shwu', 1),
	(22, 'Miron', 'mir', 'plu', 7),
	(23, 'Gorg', 'gorg', 'jruj', 8),
	(25, 'Vic', 'vic', 'ylf', 7),
	(27, 'Gena', 'gena', 'jhqd', 1),
	(28, 'Anna', 'anna', 'dqqd', 7),
	(29, 'John', 'john', 'mrkq', 8);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
