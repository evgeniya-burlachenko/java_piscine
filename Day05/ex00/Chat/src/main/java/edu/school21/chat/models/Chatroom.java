package edu.school21.chat.models;

import java.util.List;

public class Chatroom {
    private int 			id;
    private String 			name;
    private User 			owner;
    private List<Message> 	message;

    public Chatroom(int id, String name, User owner, List<Message> message) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.message = message;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Chatroom{" +
                "id=" + id +
                ", chatName='" + name + '\'' +
                ", owner=" + owner +
                ", messageList=" + message +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChatName() {
        return name;
    }

    public void setChatName(String chatName) {
        this.name = chatName;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Message> getMessageList() {
        return message;
    }

    public void setMessageList(List<Message> messageList) {
        this.message = messageList;
    }
}

