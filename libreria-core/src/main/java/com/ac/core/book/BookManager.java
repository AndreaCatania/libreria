package com.ac.core.book;

import com.ac.core.entities.Book;
import org.hibernate.Session;



public class BookManager {
    public BookManager(Session hibernateSession){
        this.hibernateSession = hibernateSession;
    }

    public Book getBook(int bookId){
        return (Book) hibernateSession.get(Book.class, bookId);
    }
    public void setBook(Book book){
        hibernateSession.save(book);
    }

    private Session hibernateSession;
}