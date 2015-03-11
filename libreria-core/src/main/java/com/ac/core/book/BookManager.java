package com.ac.core.book;

import org.hibernate.Session;



public class BookManager {
    public BookManager(Session hibernateSession){
        this.hibernateSession = hibernateSession;
    }

    public BookEntity getBook(int bookId){
        return (BookEntity) hibernateSession.get(BookEntity.class, bookId);
    }
    public void setBook(BookEntity book){
        hibernateSession.save(book);
    }

    private Session hibernateSession;
}