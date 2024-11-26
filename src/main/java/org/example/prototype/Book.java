package org.example.prototype;

public class Book {
    private String author, title, genre;
    private int publicationYear;

    public Book(String author, String title, String genre, int publicationYear){
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }
    public Book(Book target){
        if(target!=null){
            this.author=target.author;
            this.title=target.title;
            this.genre= target.genre;
            this.publicationYear= target.publicationYear;
        }
    }
    public Book clone(){
        return new Book(this);
    }
    public String toString(){
        return this.author + " , " + this.title + " , " + this.publicationYear;
    }
}
