use matchup;

drop table if exists `cusers_tb`;
create table `cusers_tb`(
	cusers_id int auto_increment primary key,	-- 기업회언 인덱스
	cid varchar(20),	-- 기업회원 아이디
    cpassword varchar(20) NOT NULL,	-- 기업회원 비밀번호
    cname varchar(20) NOT NULL,     -- 기업 이름
    cnum int(20) NOT NULL unique key, -- 사업자 번호
    mgr_name varchar(10) NOT NULL,    -- 담당자 이름
    mgr_tel varchar(11) NOT NULL unique key,   -- 담당자 전화번호
    mgr_email varchar(50) unique key,      -- 담당자 이메일
    caddress varchar(100)                  -- 기업 주소
);

insert into `cusers_tb`(cid,cpassword,cname,cnum,mgr_name,mgr_tel,mgr_email,caddress) values('doit1588','d1588','(주)마인상사',1373024111,'황인규',01068940631,'hik7115@yahoo.jp','서울특별시 서초구 양재동');
insert into `cusers_tb`(cid,cpassword,cname,cnum,mgr_name,mgr_tel,mgr_email,caddress) values('doit3082','d3082','그린피자',201133431,'황민규',01068940613,'pizza1588@naver.com','경기도 수원시 권선구 호매실동');
insert into `cusers_tb`(cid,cpassword,cname,cnum,mgr_name,mgr_tel,mgr_email,caddress) values('javaking11','java456!','(주)Trescendence',1373024123,'박규태',01097785303,'trescendence271@naver.com','서울특별시 강남구 역삼동');
insert into `cusers_tb`(cid,cpassword,cname,cnum,mgr_name,mgr_tel,mgr_email,caddress) values('javaking22','java567!','스베누',201133532,'이태우',01024860035,'subenu666@naver.com','강원도 춘천시 우두동');
insert into `cusers_tb`(cid,cpassword,cname,cnum,mgr_name,mgr_tel,mgr_email,caddress) values('javaking33','java789!','(주)EDM소프트',1373024222,'박태규',01071156825,'taetae7152@naver.com','충청북도 청주시 상당구 금천동');
insert into `cusers_tb`(cid,cpassword,cname,cnum,mgr_name,mgr_tel,mgr_email,caddress) values('javaking44','java890@','KAMON HOTEL',201133654,'조동현',01034345635,'dongtak175@naver.com','경기도 성남시 수정구 양지동');
insert into `cusers_tb`(cid,cpassword,cname,cnum,mgr_name,mgr_tel,mgr_email,caddress) values('dongtak58','d3082','(주)세민정밀',1373024321,'이우태',01058548825,'semin0258@naver.com','경상북도 포항시 남구');
insert into `cusers_tb`(cid,cpassword,cname,cnum,mgr_name,mgr_tel,mgr_email,caddress) values('yubi3158','d3082','천리마마트',202233431,'조재현',01025618156,'horse1278@naver.com','전라남도 여수시 수정동');
insert into `cusers_tb`(cid,cpassword,cname,cnum,mgr_name,mgr_tel,mgr_email,caddress) values('white0815','d3082','히드라소프트',1373024789,'안익현',01023691002,'hydra8462@naver.com','부산광역시 서구 충무동');
insert into `cusers_tb`(cid,cpassword,cname,cnum,mgr_name,mgr_tel,mgr_email,caddress) values('black1225','d3082','(주)리바이트',202333431,'정솔',01075692354,'rebite775@naver.com','대전광역시 동구 원동');

select * from cusers_tb;
