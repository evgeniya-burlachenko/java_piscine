package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class Program {
    private static void closeConnections(HikariDataSource ds, Scanner scanner) throws SQLException {
        ds.close();
        scanner.close();
    }
    public static void main(String[] args) throws SQLException {
		try{
            HikariDataSource ds = new HikariDataSource();
            ds.setJdbcUrl("jdbc:postgresql://localhost:5432/chat");
            ds.setUsername("postgres");
            ds.setPassword("");
            MessagesRepository repository = new MessagesRepositoryJdbcImpl(ds);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a message ID");
            System.out.print("-> ");
            System.out.println(repository.findById(scanner.nextLong()).get());
            closeConnections(ds, scanner);
        } catch (SQLException e) {
		    e.getMessage();
	    }
    }
}
