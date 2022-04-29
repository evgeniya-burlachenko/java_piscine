package edu.school21.chat.models;

import java.sql.Timestamp;

public class Message {
    private Integer id;
    private User author;
    private Chatroom room;
    private String text;
    private Timestamp time;

    public Message(Integer id, User author, Chatroom room, String text, Timestamp time) {
        this.id = id;
        this.author = author;
        this.room = room;
        this.text = text;
        this.time = time;
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object e) {
        return super.equals(e);
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", author=" + author +
                ", room=" + room +
                ", text='" + text + '\'' +
                ", time=" + time +
                '}';
    }
    public User getAuthor() {
        return author;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public void setAuthor(User author) {
        this.author = author;
    }

    public Chatroom getRoom() {
        return room;
    }

    public void setRoom(Chatroom room) {
        this.room = room;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setDate(Timestamp time) {
        this.time = time;
    }
}
