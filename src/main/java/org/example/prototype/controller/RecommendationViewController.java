package org.example.prototype.controller;

import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.example.prototype.Book;
import org.example.prototype.Recommendation;

import java.util.ArrayList;
import java.util.List;

public class RecommendationViewController {
    public ListView bookList;
    public TextField authorText;
    public TextField titleText;
    public TextField genreText;
    public TextField yearText;
    private HelloController helloController;
    private List<Book> booksList= new ArrayList<>();
    private Recommendation recommendation;

    public void initialize(Recommendation recommendation){
        helloController = new HelloController();
        this.recommendation = recommendation;
        booksList = recommendation.getBookList();
        bookList.getItems().addAll(booksList);
    }
    public void handleAdd(){
        Book newBook = new Book(authorText.getText(), titleText.getText(), genreText.getText(), Integer.parseInt(yearText.getText()));
        recommendation.addBook(newBook);
        booksList.add(newBook);
        bookList.getItems().add(newBook);
    }
    public void handleRemove(){
        Book selectedBook = (Book) bookList.getSelectionModel().getSelectedItem();
        booksList.remove(selectedBook);
    }

}