drop table if exists corporation_tb;
create table corporation_tb(
	corp_id int auto_increment primary key,		-- 기업정보 인덱스
    cusers_id int(10),							-- 기업회원 인덱스(외래키)
    cid varchar(20),							-- 기업 아이디
    corp_name varchar(20) NOT NULL,             -- 기업 이름
    staffs int(10) NOT NULL,                    -- 사원 수
    ceo varchar(10) NOT NULL,					-- 대표자
    foreign key (cusers_id) references cusers_tb(cusers_id) on delete cascade	-- id는 변경되는 정보가 아니므로 update는 반영 안 함  
																	-- 기업회원정보가 삭제될 경우, 서로 연관된 정보들은 모두 삭제
);

select * from cusers_tb;

insert into `corporation_tb` (cusers_id,cid,corp_name,staffs,ceo) 
values(1,'doit1588','(주)마인상사',50,'황인규'); -- (주)마인상사 
insert into `corporation_tb` (cusers_id,cid,corp_name,staffs,ceo) 
values(2,'doit3082','그린피자',20,'황민규'); -- 그린피자
insert into `corporation_tb` (cusers_id,cid,corp_name,staffs,ceo) 
values(3,'javaking11','(주)Trescendence',200,'이상진'); -- (주)Trescendence
insert into `corporation_tb` (cusers_id,cid,corp_name,staffs,ceo) 
values(4,'javaking22','스베누',1500,'김주연'); -- 스베누
insert into `corporation_tb` (cusers_id,cid,corp_name,staffs,ceo) 
values(5,'javaking33','(주)EDM소프트',10,'박태규'); -- (주)EDM소프트
insert into `corporation_tb` (cusers_id,cid,corp_name,staffs,ceo) 
values(6,'javaking44','KAMON HOTEL',50,'信国 亮'); -- KAMON HOTEL
insert into `corporation_tb` (cusers_id,cid,corp_name,staffs,ceo) 
values(7,'dongtak58','(주)세민정밀',120,'최혜정'); -- (주)세민정밀
insert into `corporation_tb` (cusers_id,cid,corp_name,staffs,ceo) 
values(8,'yubi3158','천리마마트',300,'조미란'); -- 천리마마트
insert into `corporation_tb` (cusers_id,cid,corp_name,staffs,ceo) 
values(9,'white0815','히드라소프트',300,'안익현'); -- 히드라소프트
insert into `corporation_tb` (cusers_id,cid,corp_name,staffs,ceo) 
values(10,'black1225','(주)리바이트',5,'정솔'); -- (주)리바이트

select * from corporation_tb;