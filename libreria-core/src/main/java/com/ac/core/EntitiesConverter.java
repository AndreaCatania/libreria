package com.ac.core;

import com.ac.core.book.BookEntity;
import com.ac.core.entities.BookEJB;

/**
 * Created by andrea on 3/10/15.
 */
public class EntitiesConverter{
    public static BookEJB toEJB(BookEntity bookTBC){
        if( null!=bookTBC ){
            BookEJB book = new BookEJB();
            book.setBookId(bookTBC.getBookId());
            book.setName(bookTBC.getName());
            return book;
        }else{
            return null;
        }
    }
    public static BookEntity toEntity(BookEJB bookTBC){
        if( null!=bookTBC ){
            BookEntity book = new BookEntity();
            book.setBookId(bookTBC.getBookId());
            book.setName(bookTBC.getName());
            return book;
        }else{
            return null;
        }
    }
}
