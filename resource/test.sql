TRUNCATE TABLE theaters;
insert into theaters (address, name) values ('ул. Дмитрия Ульянова, 16', 'Муви1');
insert into theaters (address, name) values ('Яузская ул., 11/6 строение 11', 'Муви2');
insert into theaters (address, name) values ('Подкопаевский пер., 2/6', 'Муви3');
insert into theaters (address, name) values ('ул. Пречистенка, 22/2', 'Муви4');
insert into theaters (address, name) values ('Рогожский Вал ул., 7', 'Муви5');
delete from theaters where idtheater = 13;
INSERT INTO theaters (address, name) VALUES ('ул. Маленковская, 9', 'Муви6');
select * from theaters
