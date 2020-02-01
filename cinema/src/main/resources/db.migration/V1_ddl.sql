CREATE DATABASE cinema;
create  table genres(
id bigserial primary key,
name_genres varchar(50) not null,
information varchar(50) not null
);
create  table places(
id bigserial primary key,
number_place int not null,
density int  not null
);

create  table repertoire(
 id bigserial primary key,
 date timestamptz not null ,
 beginning timestamptz not null,
 endtime timestamptz not null ,
 price float not null
);
create  table films(
                            id bigserial primary key,
                            film_name varchar(50) not null ,
                            genre_id varchar(50) not null,
                            runningtime int not null
  );