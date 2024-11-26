package org.example.prototype;

import java.util.List;

public class Recommendation {
    private String targetAudience, name;
    private List<Book> bookList;

    public Recommendation(String name, String targetAudience, List<Book> bookList){
        this.name = name;
        this.targetAudience = targetAudience;
        this.bookList = bookList;
    }
    public Recommendation(Recommendation target){
        if(target!=null){
            this.name=target.name;
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
    public String getTargetAudience(){return targetAudience;}
    public String getName(){return name;}
    public String toString(){
        return name;
    }
}
