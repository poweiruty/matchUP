use matchup;

drop table if exists job_posting_tb;
create table `job_posting_tb`(
	post_id int auto_increment primary key,		-- 채용공고 인덱스
    corp_id int(10),							-- 기업 인덱스(외래키)
    job_id int(10),								-- 직무/직종 인덱스
    main_region_id int(10),						-- 지역자치 메인 인덱스
    semi_region_id int(10),						-- 지역자치 세부 인덱스
    recruit_people int(5) NOT NULL,				-- 채용인원
    recruit_period date NOT NULL,				-- 채용기간
    salary varchar(10),							-- 임금
    welfare varchar(500),						-- 복지
    `description` varchar(1000),				-- 채용 상세내용
    created_post Timestamp default current_Timestamp NOT NULL,	-- 공고게시 날짜
    foreign key (corp_id) references corporation_tb(corp_id) on delete cascade,		-- 기업정보가 삭제될 경우, 채용공고는 자동삭제
    foreign key (job_id) references job_tb(job_id) on delete set null,	-- 직무/직업 정보가 삭제될 경우, null값으로 남겨둠
    foreign key (semi_region_id) references semi_region_tb(semi_region_id) on delete set null		-- 지역정보가 삭제될 경우, null값으로 남겨둠
);

insert into job_posting_tb (corp_id, job_id, semi_region_id, recruit_people, recruit_period, salary, welfare, `description`)
values(9,6,5,3,'20230830','3000만원','연 2회 상여금','프론트엔드/백엔드 개발부문 성실하게 일하실 분');
insert into job_posting_tb (corp_id, job_id, semi_region_id, recruit_people, recruit_period, salary, welfare, `description`)
values(9,6,1,1,'20230830','2800만원','연 2회 상여금','웹퍼블리셔 모집합니다.');
insert into job_posting_tb (corp_id, job_id, semi_region_id, recruit_people, recruit_period, salary, welfare, `description`)
values(2,11,2,1,20230715,'3500만원','그린피자 전 지점 직원할인 20% 할인','메뉴개발 기획자 1명 모집합니다(유사직종 경력자 우대)');
insert into job_posting_tb (corp_id, job_id, semi_region_id, recruit_people, recruit_period, salary, `description`)
values(4,10,8,1,20230730,'4000만원','허브관리자 1명 급하게 채용');

select * from job_posting_tb;