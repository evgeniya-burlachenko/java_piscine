package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class User {
    private int           	id;
    private String          login;
    private String          password;
    private List<Chatroom>  createdRooms;
    private List<Chatroom>  activeChatroom;

    public User(int id, String login, String password, List<Chatroom> createdRooms, List<Chatroom> activeChatroom) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.createdRooms = createdRooms;
        this.activeChatroom = activeChatroom;
    }
        @Override
    public int hashCode() {
        return Objects.hash(id, login, password, createdRooms, activeChatroom);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    @Override
    public String toString() {
        return "User{" +
                "userId=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", createdRooms=" + createdRooms +
                ", activeChatroom=" + activeChatroom +
                '}';
    }
    public int getUserId() {
        return id;
    }

    public void setUserId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Chatroom> getCreatedRooms() {
        return createdRooms;
    }

    public void setCreatedRooms(List<Chatroom> createdRooms) {
        this.createdRooms = createdRooms;
    }

    public List<Chatroom> getActiveChatroom() {
        return activeChatroom;
    }

    public void setActiveChatroom(List<Chatroom> activeChatroom) {
        this.activeChatroom = activeChatroom;
    }
}

