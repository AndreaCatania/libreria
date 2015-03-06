package com.ac.test.servlet;

import com.ac.ejbsclient.ejb.Library2IFace;
import com.ac.ejbsclient.ejb.LibraryIFace;
import com.ac.ejbsclient.entities.Book;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MyObj{

    public MyObj(){
        try{
            lb1 = (LibraryIFace) new InitialContext().lookup("java:global/"+NAME_VERSION_EAR+"/"+NAME_VERSION_EJBMODULE+"/LibraryBean");
            lb2 = (Library2IFace) new InitialContext().lookup("java:global/"+NAME_VERSION_EAR+"/"+NAME_VERSION_EJBMODULE+"/Library2Bean");
        }catch( NamingException e ){
            e.printStackTrace();
        }
    }

    public void setName(String name){
        lb1.setName(name);
    }

    public String getName(){
        return lb1.getName();
    }

    public void setText(String text){
        lb1.setText(text);
    }

    public String getText(){
        return lb1.getText();
    }

    public void setName2(String name){
        lb2.setName(name);
    }

    public String getName2(){
        return lb2.getName();
    }

    public void setText2(String text){
        lb2.setText(text);
    }

    public String getText2(){
        return lb2.getText();
    }

    public void createBook(int bookId, String name){
        lb1.createBook(bookId,name);
    }

    public Book getBook(int bookId){
        return lb1.getBook(bookId);
    }

    private static LibraryIFace lb1;
    private static Library2IFace lb2;
    private static final String NAME_VERSION_EAR = "libreriaEar-1.0-SNAPSHOT";
    private static final String NAME_VERSION_EJBMODULE = "decore-1.0-SNAPSHOT";
}