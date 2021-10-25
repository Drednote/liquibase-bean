--liquibase formatted sql

--changeset GalushkoID:data-1
insert into test (text)
values ('hi');

do '
DECLARE
    r int8;
BEGIN
FOR r IN 0..100
    loop
    insert into test (text)
    values (''hi'' || r);
    end loop;
END;
'
LANGUAGE plpgsql;

