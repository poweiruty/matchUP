use matchup;

-- 직종, 경력, 학력, 활동, 자격증 
drop table if exists resume_tb;
create table resume_tb(
	resume_id int auto_increment primary key,
    pid varchar(20),
    job_id int(10),
    career varchar(1000),
    degree varchar(1000),
    activity varchar(1000),
    certificate varchar(1000),
    resume_created Timestamp default current_Timestamp,  
    resume_modified Timestamp default current_Timestamp on update current_Timestamp,
    foreign key(pid) references pusers_tb(pid) on delete set null,
    foreign key(job_id) references job_tb(job_id) on delete set null
);

insert into resume_tb(pid,job_id,degree,activity,certificate) values ('green',6,'가천대학교 글로벌캠퍼스 학사 졸업','서울대학교 주최 서버개설 대회 은상','정보처리기사자격증');
insert into resume_tb(pid,job_id,career,degree,activity,certificate) values('1green',16,'천일초등학교 교사재직 2년','춘천교육대학교','2023 초등생 교육 공모전 대상','교원 자격증');

-- UPDATE resume_tb SET certificate='교원자격증' WHERE resume_id=2;

select * from resume_tb;

