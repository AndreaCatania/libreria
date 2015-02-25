package con.ac.thetest;

import javax.ejb.Remote;

@Remote
public interface LibraryIFace{
    public void setText(String text);
    public String getText();
}