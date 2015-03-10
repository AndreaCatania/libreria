package com.ac.core;

import com.ac.core.book.BookManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Factory{

    public BookManager getBookManager(){
        if( null==cache_bookManager ){
            cache_bookManager = new BookManager( getCurrentHibernateSession() );
        }
        return cache_bookManager;
    }

    /**
     * This method return an hibernate session.
     * If the session was already created will be returned,
     * either if it isn't alive will be created before the return.
     *
     * @return
     */
    public synchronized Session getCurrentHibernateSession(){

        if( null==cache_hSession){
            cache_hSession = hibernateSessionFactory.openSession();
            cache_hSession.beginTransaction();
        }
        return cache_hSession;
    }

    /**
     * The hibernate session will be committed and closed if is open.
     *
     * This method must be called at the end of all method that call an hibernate session.
     */
    public synchronized boolean hibernateSession_commitAndClose(){
        if( null!=cache_hSession ){
            boolean status = false;
            try{
                cache_hSession.getTransaction().commit();
                status = true;
            }catch( Exception ex ){

                try{
                    cache_hSession.getTransaction().rollback();
                }catch( Exception ex2 ){}
                log.error( ex  );
                status = false;
            }finally{

                if( cache_hSession.isOpen() ){
                    cache_hSession.close();
                }
                cache_hSession = null;
            }
            return status;
        }else{
            return true;
        }
    }

    /**
     * Rollback the transaction
     *
     * @return true if all is ok
     */
    public synchronized boolean hibernateSession_rollbackAndClose(){
        boolean status = false;
        try{
            cache_hSession.getTransaction().rollback();
            status = true;
        }catch( Exception ex ){
            log.error( ex );
            status = false;
        }finally{
            if( cache_hSession.isOpen() ){
                cache_hSession.close();
            }
            cache_hSession = null;
        }
        return status;
    }

    /**
     * cache
     */
    private Session cache_hSession = null;
    private BookManager cache_bookManager = null;

    private Logger log;

    public static void setHibernateSessionFactory(SessionFactory hibernateSessionFactory){
        Factory.hibernateSessionFactory=hibernateSessionFactory;
    }
    private static SessionFactory hibernateSessionFactory;
}