package edu.school21.chat.repositories;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {

    private final DataSource ds;

    private void closeConnections(ResultSet resultSet, Statement statement , Connection connection) throws SQLException {
        resultSet.close();
        statement.close();
        connection.close();
    }
    public MessagesRepositoryJdbcImpl(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public Optional<Message> findById(Long id) throws SQLException {

        try {
            Optional<Message> optionalMessage;
            Connection connection = ds.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM chat.messages WHERE id = " + id);
            resultSet.next();
            User user = new User(1, "UserA", "1", null, null);
            Chatroom chatroom = new Chatroom(1, "chatroom", null, null);
            Message message = new Message(resultSet.getInt(1), user, chatroom, resultSet.getString("message"), LocalDateTime.of(2022, 04, 25, 23, 21));
            closeConnections(resultSet, statement, connection);
            return Optional.of(message);
        } catch (SQLException e) {
            e.getMessage();
        }
        return Optional.empty();
    }
}
