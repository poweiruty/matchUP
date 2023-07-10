drop database if exists matchup;
create database matchup;

use matchup;

drop table if exists `pusers_tb`;
create table `pusers_tb`(
	pusers_id int auto_increment primary key,	-- 개인유저 인덱스
	pid varchar(20) NOT NULL,			-- 개인유저 아이디
    ppassword varchar(20) NOT NULL,			-- 개인유저 패스워드
    pname varchar(10) NOT NULL,				-- 개인유저 이름
    birth date NOT NULL,					-- 개인유저 생일
    tel varchar(11) NOT NULL unique key,	    -- 개인유저 전화번호		
    `email` varchar(50) unique key,         -- 개인유저 이메일
    user_address varchar(100)			    -- 개인유저 주소
);

insert into `pusers_tb`(pid,ppassword,pname,birth,tel,`email`,user_address) values('green','a1234','김그린','19941001','01011112220','green@naver.com','경기도 수원시 장안구 천천동');
insert into `pusers_tb`(pid,ppassword,pname,birth,tel,`email`,user_address) values('green6','a1234','김그리','19941007','01011112226','green6@naver.com','경기도 성남시 수정구 양지동');
insert into `pusers_tb`(pid,ppassword,pname,birth,tel,`email`,user_address) values('green11','a1234','김사바','19941012','01011112211','green11@naver.com','서울특별시 강남구 역삼동');
insert into `pusers_tb`(pid,ppassword,pname,birth,tel,`email`,user_address) values('green66','b1234','이노랑','19941017','01011112216','green66@naver.com','서울특별시 서초구 양재동');
insert into `pusers_tb`(pid,ppassword,pname,birth,tel,`email`,user_address) values('gree1n','b1234','이나가','19941022','01011712211','gree1n@naver.com','강원도 춘천시 우두동');
insert into `pusers_tb`(pid,ppassword,pname,birth,tel,`email`,user_address) values('gree6n','a2345','박그림','19941027','01011212216','gree6n@naver.com','강원도 강릉시 장현동');
insert into `pusers_tb`(pid,ppassword,pname,birth,tel,`email`,user_address) values('gree11n','a2345','박그리','19931001','01011292211','gree11n@naver.com','충청북도 청주시 상당구 금천동');
insert into `pusers_tb`(pid,ppassword,pname,birth,tel,`email`,user_address) values('gree00n','javaking12','황빨강','19931010','01011199999','gree00n@naver.com','충청북도 제천시 강제동');
insert into `pusers_tb`(pid,ppassword,pname,birth,tel,`email`,user_address) values('gre1en','javaking12','황그리','19931011','01021112211','gre1en@naver.com','충청남도 천안시 동남구 봉명동');
insert into `pusers_tb`(pid,ppassword,pname,birth,tel,`email`,user_address) values('gre11en','a1234','오그리','19931021','01012112211','gre11en@naver.com','경상북도 포항시 남구 해도동');
insert into `pusers_tb`(pid,ppassword,pname,birth,tel,`email`,user_address) values('gr0een','a1234','구빨강','19921009','01031119999','gr0een@naver.com','경상남도 통영시 도천동');
insert into `pusers_tb`(pid,ppassword,pname,birth,tel,`email`,user_address) values('gr11een','a1234','구그리','19921010','01013112211','gr11een@naver.com','전라북도 전주시 완산구 노송동');
insert into `pusers_tb`(pid,ppassword,pname,birth,tel,`email`,user_address) values('gr00een','a1234','양빨강','19921019','01013119999','gr00een@naver.com','전라북도 군산시 금광동');
insert into `pusers_tb`(pid,ppassword,pname,birth,tel,`email`,user_address) values('g1reen','a1234','양그리','19921020','01041112211','g1reen@naver.com','전라남도 목포시 용당동');
insert into `pusers_tb`(pid,ppassword,pname,birth,tel,`email`,user_address) values('g0reen','a1234','신빨강','19921029','01041119999','g0reen@naver.com','전라남도 여수시 수정동');
insert into `pusers_tb`(pid,ppassword,pname,birth,tel,`email`,user_address) values('g11reen','a1234','신그리','19921030','01014112211','g11reen@naver.com','제주도 제주시 월평동');
insert into `pusers_tb`(pid,ppassword,pname,birth,tel,`email`,user_address) values('g00reen','a1234','곽빨강','19911008','01014119999','g00reen@naver.com','제주도 서귀포시 대포동');
insert into `pusers_tb`(pid,ppassword,pname,birth,tel,`email`,user_address) values('1green','a1234','곽그리','19911009','01051112211','1green@naver.com','부산광역시 서구 충무동');
insert into `pusers_tb`(pid,ppassword,pname,birth,tel,`email`,user_address) values('5green','a1234','곽라다','19911013','01051112215','5green@naver.com','부산광역시 해운대구 반송동');
insert into `pusers_tb`(pid,ppassword,pname,birth,tel,`email`,user_address) values('7green','a1234','김벤츠','19911015','01051112217','7green@naver.com','대전광역시 동구 원동');
   
select * from `pusers_tb`;