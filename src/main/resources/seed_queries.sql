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

-- select * from Single_Value_Model;


