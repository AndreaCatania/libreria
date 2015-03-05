package com.ac.ejbs;

import com.ac.ejbsclient.ejb.Library2IFace;
import com.ac.ejbclient.ejb.SingIFace;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateless;

@Stateless
public class Library2Bean implements Library2IFace {

    @EJB
    SingIFace sb;

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
    public void setText(String text){
        this.text=text;
    }

    @Remove
    public void remove()
    {
        System.out.println("EJB2 RIMOSSO");
    }

    @PreDestroy
    public void preDestroy()
    {
        System.out.println("EJB LIBRARY2 DESTROYED");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("EJB LIBRARY2 CONSTRUCTED");
        setText( "#Default text#" );
    }

    private String text;
}