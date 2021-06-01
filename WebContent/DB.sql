create table a(
	name varchar2(10) primary key,
	h number(30),
	k number(30)
)

insert into a values('미국',33833181,602616);
insert into a values('인도',26031991,291365);
insert into a values('브라질',15898558,444391);
insert into a values('프랑스',5568551,108314);
insert into a values('터키',5160423,45626);

select name, h, k from a order by h desc

select * from a where name = '미국'

update a set name='미국', h='30', k='30' where name = '미국'
