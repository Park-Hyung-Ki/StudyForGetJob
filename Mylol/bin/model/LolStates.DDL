create table s_rank (
	id		char(10),
result		char(5)		    not null,
champions	varchar2(500)   not null,
   kda		integer			not null,
)

/* test */  --result 부분을 int형으로 주었음, 나중에 각각 승률 구하는 수식때문에
   
create table s_rank_1 (
	id		char(10),
result		integer		    not null,
champions	varchar2(500)   not null,
   kda		integer			not null
);