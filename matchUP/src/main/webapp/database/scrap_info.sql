use matchup;

drop table if exists scrap_tb;
create table scrap_tb(
	scrap_id int auto_increment primary key,
    pusers_id int(0),
    post_id int(10),
    foreign key (pusers_id) references pusers_tb (pusers_id) on delete cascade,
    foreign key (post_id) references job_posting_tb (post_id) on delete cascade
);

insert into scrap_tb(pusers_id, post_id) values('1','1');

select * from scrap_tb;