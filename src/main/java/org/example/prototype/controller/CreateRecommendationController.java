package org.example.prototype.controller;

import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.example.prototype.model.Book;
import org.example.prototype.model.Recommendation;

import java.util.ArrayList;
import java.util.List;

public class CreateRecommendationController {
    public ListView bookList;
    public TextField authorText;
    public TextField titleText;
    public TextField genreText;
    public TextField yearText;
    private HelloController helloController;
    private List<Book> booksList= new ArrayList<>();
    private Recommendation recommendation;

    public void initialize(){
        helloController = new HelloController();
        bookList.getItems().addAll(booksList);
    }
    public void handleAdd(){
        Book newBook = new Book(authorText.getText(), titleText.getText(), genreText.getText(), Integer.parseInt(yearText.getText()));
        booksList.add(newBook);
        bookList.getItems().add(newBook);
    }
    public void handleRemove(){
        Book selectedBook = (Book) bookList.getSelectionModel().getSelectedItem();
        booksList.remove(selectedBook);
    }
}
