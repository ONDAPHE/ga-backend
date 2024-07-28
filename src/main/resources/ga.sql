create database GA;

    create table client (
        id integer primary key not null AUTO_INCREMENT,
        email varchar(50)
    );

    create table sentiment (
        id integer primary key not null AUTO_INCREMENT,
        texte varchar(50),
        type varchar(10),
        client_id integer,
        constraint client_fk foreign key (client_id) references client(id)
    );