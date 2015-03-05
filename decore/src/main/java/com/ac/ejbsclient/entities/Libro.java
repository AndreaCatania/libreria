package com.ac.ejbsclient.entities;


import java.io.Serializable;


public class Libro implements Serializable{

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getBookId() {
        return bookId;
    }


    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    private String name;
    private int bookId;
}