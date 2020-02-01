
insert into genres( id, name_genres , information ) values
( 1,'horor', '18+'),
(2, 'cartoon','for children'),
(3, 'history', '16+'),
(4, 'drama', '12+'),
(5,'non-fiction', '16+ with adults') ,
(6, 'action', '12+ with adults');
insert into films( id, film_name, genre_id , runningtime ) values
( 1,'Марафон желаний',1, '95'),
(2, 'Холодное сердце',2,'103'),
(3, 'Союз спасения', 3,'134'),
(4, 'Холоп', 4, '109'),
(5,'Вторжение', 5, '133') ,
(6, 'Звезные войны', 6, '142');
insert into repertoire( id,
                        date,
                        beginning,
                        endtime ,
                        price) values
(1, date(12.01), 22.30, 00.05, 300.50),
(2, date(12.01), 12.30,  14.20, 500.00),
(3, date(12.01), 12.30, 15.00, 700.00),
(4, date(12.01),17.30, 19.40, 500.00),
(5,date(12.01), 18.30, 20.50, 400.00),
(6, date(12.01), 17.40, 19.10, 300.50);
insert into places( id ,
                    number_place ,
                    density  ) values
( 1,12,  20),
(2, 17, 13),
(3, 14, 56),
(4, 17, 68),
(5, 77, 77) ,
(6, 10, 18);