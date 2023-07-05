use matchup;

drop table if exists main_region_tb;
create table main_region_tb(
	main_region_id int auto_increment primary key,	-- 광역자치 인덱스
    main_region varchar(10) unique key				-- 광역자치 분류
);

insert into main_region_tb(main_region) values ('서울특별시');
insert into main_region_tb(main_region) values ('경기도');
insert into main_region_tb(main_region) values ('인천광역시');
insert into main_region_tb(main_region) values ('부산광역시');
insert into main_region_tb(main_region) values ('대구광역시');
insert into main_region_tb(main_region) values ('광주광역시');
insert into main_region_tb(main_region) values ('대전광역시');
insert into main_region_tb(main_region) values ('울산광역시');
insert into main_region_tb(main_region) values ('세종특별시');
insert into main_region_tb(main_region) values ('강원도');
insert into main_region_tb(main_region) values ('충청남도');
insert into main_region_tb(main_region) values ('충청북도');
insert into main_region_tb(main_region) values ('경상남도');
insert into main_region_tb(main_region) values ('경상북도');
insert into main_region_tb(main_region) values ('전라남도');
insert into main_region_tb(main_region) values ('전라북도');
insert into main_region_tb(main_region) values ('제주도'); 

select * from main_region_tb order by main_region_id ASC;

drop table if exists semi_region_tb;
create table semi_region_tb(
	semi_region_id int auto_increment primary key,			-- 지역자치 인덱스
    main_region_id int(10),									-- 광역자치 인덱스(외래키)
    semi_region varchar(50) unique key NOT NULL,			-- 지역자치 분류
    foreign key (main_region_id) references main_region_tb(main_region_id) on delete cascade
		-- 광역자치 항목 삭제 시, 지역자치도 같이 삭제
        -- 광역자치 업데이트 시, 지역자치도 같이 업데이트
);

insert into semi_region_tb(main_region_id, semi_region) values (1,'서초구');
insert into semi_region_tb(main_region_id, semi_region) values (1,'강남구');
insert into semi_region_tb(main_region_id, semi_region) values (2,'성남시');
insert into semi_region_tb(main_region_id, semi_region) values (2,'수원시');
insert into semi_region_tb(main_region_id, semi_region) values (4,'서구');
insert into semi_region_tb(main_region_id, semi_region) values (4,'해운대구');
insert into semi_region_tb(main_region_id, semi_region) values (7,'동구');
insert into semi_region_tb(main_region_id, semi_region) values (10,'춘천시');
insert into semi_region_tb(main_region_id, semi_region) values (10,'강릉시');
insert into semi_region_tb(main_region_id, semi_region) values (11,'천안시');
insert into semi_region_tb(main_region_id, semi_region) values (12,'청주시');
insert into semi_region_tb(main_region_id, semi_region) values (12,'제천시');
insert into semi_region_tb(main_region_id, semi_region) values (13,'통영시');
insert into semi_region_tb(main_region_id, semi_region) values (14,'포항시');
insert into semi_region_tb(main_region_id, semi_region) values (15,'목포시');
insert into semi_region_tb(main_region_id, semi_region) values (15,'여수시');
insert into semi_region_tb(main_region_id, semi_region) values (16,'전주시');
insert into semi_region_tb(main_region_id, semi_region) values (16,'군산시');
insert into semi_region_tb(main_region_id, semi_region) values (17,'제주시');
insert into semi_region_tb(main_region_id, semi_region) values (17,'서귀포시');

select * from semi_region_tb order by semi_region_id ASC;

-- delete 구문
-- delete from main_region_tb where main_region_id=1;

-- update 구문