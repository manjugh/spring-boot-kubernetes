create sequence bm_id_Seq start with 1 increment by 50;

create table bookmarks (id bigint default nextval('bm_id_Seq') not null, created_at timestamp, title varchar(255), url varchar(255), primary key (id));
