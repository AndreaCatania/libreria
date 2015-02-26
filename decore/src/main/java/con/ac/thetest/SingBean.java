package con.ac.thetest;

import javax.ejb.Local;
import javax.ejb.Singleton;

@Singleton
public class SingBean implements SingIFace{
    public SingBean(){
        this( "Andrea" );
    }
    public SingBean( String name ){
        setName( name );
    }
    public void setName( String name ){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    private String name;
}