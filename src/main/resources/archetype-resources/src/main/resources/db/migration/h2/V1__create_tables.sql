create sequence user_id_seq start with 10 increment by 50;
create sequence role_id_seq start with 10 increment by 50;

create table users (
    id bigint default user_id_seq.nextval,
    username varchar(255) not null,
    password varchar(255) not null,
    name varchar(255) not null,
    email varchar(255) not null,
    enabled boolean not null,
    last_password_reset_date timestamp,
    primary key (id),
    UNIQUE KEY user_username_unique (username),
    UNIQUE KEY user_email_unique (email)
);

create table roles (
    id bigint default role_id_seq.nextval,
    name varchar(255) not null,
    primary key (id),
    UNIQUE KEY role_name_unique (name)
);

create table user_role (
    user_id bigint REFERENCES users(id),
    role_id bigint REFERENCES roles(id)
);