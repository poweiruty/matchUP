use matchup;

drop table if exists review_tb;
create table review_tb(
	review_id int auto_increment primary key,
    pusers_id int(10),
    corp_id int(10),
    star int(1) NOT NULL,
    review varchar(1000),
    created Timestamp default current_timestamp,
    updated Timestamp default current_timestamp on update current_timestamp,
    foreign key (pusers_id) references pusers_tb(pusers_id) on delete set null,
    foreign key (corp_id) references corporation_tb(corp_id) on delete set null
);

insert into review_tb(pusers_id,corp_id,star,review) values('1','1','2','답이 없는 꼰대경영진들이 회사의 진보를 막고 있음.');

select * from review_tb;