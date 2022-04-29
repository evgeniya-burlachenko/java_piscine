package edu.school21.chat.repositories;

import edu.school21.chat.exceptions.NotSavedSubEntityException;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.*;

import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {

    private final DataSource ds;

    private void closeConnections(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
        rs.close();
        ps.close();
        conn.close();
    }
    private static final String INSERT_MESSAGE = "insert into chat.messages(room_id, sender, message, time)\n" +
            "VALUES (?, ?, ?, ?) returning id";

    private static final String UPDATE_MESSAGE = "update chat.messages\n" +
            "SET room_id = ?,\n" +
            "sender   = ?,\n" +
            "message  = ?,\n" +
            "time     = ?\n" +
            "WHERE id = ?";
    public MessagesRepositoryJdbcImpl(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public Optional<Message> findById(Long id) throws SQLException {
        Optional<Message> optionalMessage;

        try(Connection connection = ds.getConnection();
            Statement statement = connection.createStatement()) {

            String query = "SELECT * FROM chat.messages WHERE id = " + id;
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();

            User user = new User(1, "UserA", "1", null, null);
            Chatroom chatroom = new Chatroom(1, "chatroom", null, null);
            Message message = new Message(resultSet.getInt(1), user, chatroom, resultSet.getString("message"), resultSet.getTimestamp("time"));
            optionalMessage = Optional.of(message);
        }
        return optionalMessage;
    }

    @Override
    public boolean save(Message message) throws NotSavedSubEntityException{
        try(Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_MESSAGE, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, message.getRoom().getId());
            statement.setInt(2, message.getAuthor().getUserId());
            statement.setString(3, message.getText());
            if (message.getTime() == null) {
                statement.setNull(4, Types.TIMESTAMP);
            } else {
                statement.setTimestamp(4, message.getTime());
            }
            statement.execute();
            ResultSet key = statement.getGeneratedKeys();
            key.next();
            message.setId(key.getInt(1));
            closeConnections(key, statement, connection);
        } catch (SQLException e) {
            throw new NotSavedSubEntityException();
        }
        return true;
    }

	public void update(Message message) throws SQLException {
        Connection connection = ds.getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE_MESSAGE);
        statement.setInt(1, message.getRoom().getId());
        statement.setInt(2, message.getAuthor().getUserId());
        statement.setString(3, message.getText());
        if (message.getTime() == null) {
            statement.setNull(4, Types.TIMESTAMP);
        } else {
            statement.setTimestamp(4, message.getTime());
        }
            statement.setInt(5, message.getId());
        statement.execute();
        statement.close();
        connection.close();
    }
}

