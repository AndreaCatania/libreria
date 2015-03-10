package com.ac.ejbs;

import com.ac.core.Factory;
import com.ac.core.book.BookManager;
import com.ac.ejbsclient.ejb.LibraryIFace;
import com.ac.ejbsclient.ejb.SingIFace;
import com.ac.ejbsclient.entities.Book;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateless;

@Stateless
public class LibraryBean implements LibraryIFace {

    public LibraryBean(){
        setText( "#Default text#" );
    }

    @Override
    public void setName(String text){
        sb.setName( text );
    }

    @Override
    public String getName(){
        return sb.getName();
    }

    @Override
    public String getText(){
        return text;
    }

    @Override
    public void createBook(int bookId, String name){

    }

    @Override
    public Book getBook( int bookId ){
        Factory factory = new Factory();
        BookManager bookManager = factory.getBookManager();
        Book hBook = bookManager.getBook( bookId );
        return hBook;
    }

    @Override
    public void setText(String text){
        this.text=text;
    }

    @Remove
    public void remove()
    {
        System.out.println("EJB RIMOSSO");
    }

    @PreDestroy
    public void preDestroy()
    {
        System.out.println("EJB LIBRARY DESTROYED");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("EJB LIBRARY CONSTRUCTED");
    }

    private String text;

    @EJB
    private SingIFace sb;
}