package con.ac.thetest;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateless;

@Stateless
public class Library2Bean implements Library2IFace{

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
            setText( "#Default text#" );
    }

    private String text;
}