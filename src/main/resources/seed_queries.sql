CREATE DATABASE tasks;
use tasks;

create user 'tasksUser'@'%' identified by 'ThePassword'; -- Creates the user
grant all on tasks.* to 'tasksUser'@'%'; -- Gives all privileges to the new user on the newly created database

CREATE TABLE `single_value_model` (
  `id` varchar(255) NOT NULL,
  `int_value` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


insert into single_value_model values("1", 0);
update single_value_model set int_value = 0;
commit;

select * from Single_Value_Model;


-- other user queries


DROP TABLE IF EXISTS `numberincrement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `numberincrement` (
  `id` int NOT NULL AUTO_INCREMENT,
  `count` int NOT NULL DEFAULT '0',
  `version` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

insert into numberincrement values(1, 0, 0);
update numberincrement set count = 0, version = 0;
commit;

select * from numberincrement;





