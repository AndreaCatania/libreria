package con.ac.thetest;

import javax.ejb.Local;

@Local
public interface SingIFace{
    public void setName( String name );
    public String getName();
}