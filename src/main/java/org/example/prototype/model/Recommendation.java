package org.example.prototype.model;

import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable{
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
    @Override
    public Recommendation clone(){
        try {
            Recommendation cloned = (Recommendation) super.clone();
            cloned.bookList = new ArrayList<>();
            for (Book book : this.bookList) {
                cloned.bookList.add(book.clone());
            }
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported", e);
        }
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
