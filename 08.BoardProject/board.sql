create table board (
	num number primary key,
	id varchar2(10) not null,
	title varchar2(100),
	content varchar2(4000),
	write_date date default sysdate,
	file_name varchar2(100),
	read_count number default(0),
	down_count number default(0)
)

select * from board

CREATE SEQUENCE board_seq
   START WITH 1
   INCREMENT BY 1
   
insert into board values(board_seq.nextval, 'test', '안녕하세요', '반갑습니다.', default, null, default, default)

select * from board

select m.id id, name, title, content, write_date from member m inner join board b on m.id = b.id;