package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Timestamp;

public class Program {
    public static void main(String[] args) throws SQLException {

        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:postgresql://localhost:5432/chat");
        ds.setUsername("postgres");
        ds.setPassword("");

        MessagesRepository repository = new MessagesRepositoryJdbcImpl(ds);
        User author = new User(3, "user", "user", new ArrayList(), new ArrayList());
        Chatroom room = new Chatroom(4, "chat1", author, new ArrayList());
        Message message = new Message(null, author, room, "Hello!", new Timestamp(System.currentTimeMillis()));
        repository.save(message);
        System.out.println(message.getId());
    }
}
