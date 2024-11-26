package org.example.prototype.model;

public class Book implements Cloneable{
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
    @Override
    public Book clone() {
        try {
            return (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported", e);
        }
    }
    public String toString(){
        return this.author + " , " + this.title + " , " + this.publicationYear;
    }
}
