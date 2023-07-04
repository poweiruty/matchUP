drop database if exists pusers_db;
create database pusers_db;

use pusers_db;

drop table if exists `pusers_db`;
create table `pusers_db`(
   pid varchar(20) primary key,
    ppassword varchar(20) NOT NULL,
    pname varchar(10) NOT NULL,
    birth date NOT NULL,
    tel int(11) NOT NULL unique key,
    `email` varchar(50) unique key,
    user_address varchar(100)
);

insert into `pusers_db` values('higheg','a1234','황예지','19941003','01042110630','heg1234@naver.com','경기도 수원시 장안구 천천동');

select * from `pusers_db`;