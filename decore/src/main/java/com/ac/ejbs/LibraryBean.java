package com.ac.ejbs;

import com.ac.core.Factory;
import com.ac.core.book.BookManager;
import com.ac.ejbsclient.ejb.LibraryIFace;
import com.ac.ejbsclient.ejb.SingIFace;
import com.ac.ejbsclient.entities.Book;

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

    }

    @Override
    public Book getBook( int bookId ){
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-----------------------            HERE                   ---------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
        /*Factory factory = new Factory();
        BookManager bookManager = factory.getBookManager();
        Book hBook = bookManager.getBook( bookId );*/
        Book book = new Book();
        /*book.setName(hBook.getName());
        book.setBookId(hBook.getBookId());*/
        book.setName("Libro AA");
        book.setBookId(1);
        return book;
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