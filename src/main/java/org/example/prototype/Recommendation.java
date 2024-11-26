package org.example.prototype;

import java.util.List;

public class Recommendation {
    private String targetAudience;
    private List<Book> bookList;

    public Recommendation(String targetAudience, List<Book> bookList){
        this.targetAudience = targetAudience;
        this.bookList = bookList;
    }
    public Recommendation(Recommendation target){
        if(target!=null){
            this.targetAudience=target.targetAudience;
            this.bookList=target.bookList;
        }
    }
    public Recommendation clone(){
        return new Recommendation(this);
    }
    public void addBook(Book book){
        bookList.add(book);
    }
    public List<Book> getBookList(){
        return bookList;
    }
    public String toString(){
        return targetAudience;
    }
}
