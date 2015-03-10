package com.ac.ejbsclient.ejb;

import com.ac.core.entities.Book;

import javax.ejb.Local;

@Local
public interface LibraryIFace{
    public String getName();
    public void setName(String name);
    public String getText();
    public void setText(String text);
    public void createBook(int bookId, String name);
    public Book getBook(int bookId);
}