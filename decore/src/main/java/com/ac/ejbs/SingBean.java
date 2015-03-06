package com.ac.ejbs;

import com.ac.core.Factory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class SingBean implements com.ac.ejbsclient.ejb.SingIFace {
    public SingBean(){
        this( "Andrea" );
    }
    public SingBean( String name ){
        setName( name );

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-----------------------            Hib starting           ---------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
        // Load configuration file for log4j
        /*String log4jConfigPath = contextPath + Config.getLog4jConfigPath();
        if( ( new File( log4jConfigPath ) ).exists() ){
            PropertyConfigurator.configure(log4jConfigPath);
        }else{
            System.out.println( "Log4j configuration file not found: " + log4jConfigPath );
        }*/

        /**
         * Starto hibernate
         */
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry =
                new StandardServiceRegistryBuilder()
                        .applySettings(
                                configuration.getProperties()
                        ).build();
        Factory.setHibernateSessionFactory( configuration.buildSessionFactory( serviceRegistry ) );
        /////////////////////////////// - HIBERNATE FINE - ///////////////////////////////
    }
    public void setName( String name ){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    private String name;
}