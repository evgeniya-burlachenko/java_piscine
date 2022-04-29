CREATE SCHEMA IF NOT EXISTS chat;
DROP TABLE IF  EXISTS chat.messages, chat.room, chat.users ;

CREATE TABLE IF NOT EXISTS  chat.users (
    id              serial primary key ,
    login           text not null ,
    pass            text
);

CREATE TABLE IF NOT EXISTS  chat.room (
    id              serial primary key ,
    chat_owner      int not null references chat.users(id) ,
    chat_name       text not null
);

CREATE TABLE IF NOT EXISTS chat.messages(
    id              serial primary key,
    room_id         int  not null references chat.room(id),
    sender          int  not null references chat.users(id),
    message         text not null,
    time   TIMESTAMP default current_timestamp
    );
