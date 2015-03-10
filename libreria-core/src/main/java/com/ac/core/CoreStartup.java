package com.ac.core;

import com.ac.core.Factory;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;


@WebListener
public class CoreStartup implements ServletContextListener{

    @Override
    public void contextInitialized( ServletContextEvent arg0 ){

        // Take context and path of context
        ServletContext servletContext = arg0.getServletContext();
        String contextPath = servletContext.getRealPath("/");

        // Load configuration file for log4j
        String log4jConfigPath = "/WEB-INF/classes/config/ac/log4j.properties";
        if( ( new File( contextPath+log4jConfigPath ) ).exists() ){
            PropertyConfigurator.configure(contextPath+log4jConfigPath);
        }else{
            System.out.println( "Log4j configuration file not found: " +contextPath+log4jConfigPath );
        }

        // Hibernate start
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        Factory.setHibernateSessionFactory(configuration.buildSessionFactory(serviceRegistry));
    }

    @Override
    public void contextDestroyed(ServletContextEvent var1){
        System.out.println("Destroy");
    }
}