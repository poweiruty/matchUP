use matchup;

drop table if exists scrap_tb;
create table scrap_tb(
	scrap_id int auto_increment primary key,
    pid varchar(20),
    post_id int(10),
    foreign key (pid) references pusers_tb (pid) on delete cascade,
    foreign key (post_id) references job_posting_tb (post_id) on delete cascade
);

insert into scrap_tb(pid, post_id) values('green','1');

select * from scrap_tb;