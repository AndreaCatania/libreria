package con.ac.thetest;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Remove;
import javax.ejb.Stateless;

@Stateless
public class LibraryBean implements LibraryIFace
{
    //public String text = "asd";

    @Override
    public void setText(String text)
    {
        //this.text = text;
    }

    @Override
    public String getText()
    {
        return "EJB text!";
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
    public void postConstruct()
    {
        System.out.println("EJB LIBRARY CONSTRUCTED");
    }

}