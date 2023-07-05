use matchup;

drop table if exists job_tb;
create table job_tb(
	job_id int auto_increment primary key,		-- 직무/직종 인덱스
    job varchar(20) NOT NULL unique key			-- 직무/직종 종류
);

insert into job_tb(job) values('기획,전략');
insert into job_tb(job) values('마케팅,홍보');
insert into job_tb(job) values('회계,세무,재무');
insert into job_tb(job) values('인사,노무');
insert into job_tb(job) values('총무,법무,사무');
insert into job_tb(job) values('IT개발,데이터');
insert into job_tb(job) values('디자인');
insert into job_tb(job) values('영업,판매,무역');
insert into job_tb(job) values('고객상담,TM');
insert into job_tb(job) values('구재,자재,물류');
insert into job_tb(job) values('상품기획,MD');
insert into job_tb(job) values('운전,운송,배송');
insert into job_tb(job) values('생산');
insert into job_tb(job) values('의료');
insert into job_tb(job) values('연구R&D');
insert into job_tb(job) values('교육');
insert into job_tb(job) values('미디어,문화,스포츠');
insert into job_tb(job) values('금융,보험');
insert into job_tb(job) values('공공,복지');

select * from job_tb order by job_id ASC;