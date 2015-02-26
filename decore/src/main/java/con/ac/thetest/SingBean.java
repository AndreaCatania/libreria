package con.ac.thetest;

import javax.ejb.Singleton;

/**
 * Created by andrea on 2/26/15.
 */
@Singleton
public class SingBean{
    public String getName(){
        return "Andrea";
    }
}