package com.ac.ejbsclient.ejb;



import javax.ejb.Local;

@Local(Library2IFace.class)
public interface Library2IFace{
    public String getName();
    public void setName(String name);
    public String getText();
    public void setText(String text);
}