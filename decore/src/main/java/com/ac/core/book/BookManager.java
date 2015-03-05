package com.ac.core.book;

import com.ac.ejbsclient.entities.Libro;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by andrea on 3/5/15.
 */
public class BookManager {
    public static Libro getBook(int bookId){
        return BOOKS.get(bookId);
    }
    public static void setBook(Libro book){
        BOOKS.put(book.getBookId(), book);
    }
    private static Map<Integer,Libro> BOOKS = new HashMap<>();
}