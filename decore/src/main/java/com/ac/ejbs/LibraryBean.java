package com.ac.ejbs;

import com.ac.ejbsclient.entities.Libro;
import com.ac.core.book.BookManager;
import com.ac.ejbsclient.ejb.LibraryIFace;
import com.ac.ejbclient.ejb.SingIFace;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.*;

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
        Libro libro = new Libro();
        libro.setName(name);
        libro.setBookId(bookId);
        BookManager.setBook(libro);
    }

    @Override
    public Libro getBook( int bookId ){
        return BookManager.getBook(bookId);
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