INSERT INTO chat.users(login, pass) VALUES
    ('UserA', '1'),
    ('UserB', '12'),
    ('UserB', '123'),
    ('UserC', '1234'),
    ('UserD', '12345');

INSERT  INTO chat.room (chat_owner, chat_name) VALUES
    (1, 'chat1'),
    (2, 'chat2'),
    (3, 'chat3'),
    (4, 'chat4'),
    (5, 'chat5');

INSERT INTO chat.messages(room_id, sender, message, time) VALUES
    (1, 4, 'hello world', to_timestamp('2022     Apr','YYYY MON')),
    (2, 3, 'hello world', to_timestamp('2022     Apr','YYYY MON')),
    (3, 2, 'hello world', to_timestamp('2022     Apr','YYYY MON')),
    (4, 2, 'hello world', to_timestamp('2022     Apr','YYYY MON')),
    (5, 1, 'hello world', to_timestamp('2022     Apr','YYYY MON'));
