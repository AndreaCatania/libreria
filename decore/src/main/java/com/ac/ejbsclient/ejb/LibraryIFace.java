package com.ac.ejbsclient.ejb;


import com.ac.ejbsclient.entities.Libro;

import javax.ejb.Remote;

@Remote
public interface LibraryIFace{
    public String getName();
    public void setName(String name);
    public String getText();
    public void setText(String text);
    public void createBook(int bookId, String name);
    public Libro getBook(int bookId);
}