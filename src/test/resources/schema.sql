create table if not exists student
(
    id          INTEGER(64) PRIMARY KEY AUTO_INCREMENT,
    name        varchar(20)  null,
    address     varchar(200) null,
    create_time datetime     null,
    update_time datetime     null
);