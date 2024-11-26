package org.example.prototype.controller;

import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.example.prototype.Book;
import org.example.prototype.Recommendation;

import java.util.ArrayList;
import java.util.List;

public class RecommendationViewController {
    public ListView bookListView;
    public TextField authorText, titleText, genreText, yearText;
    public Text targetAudienceText, nameText;
    private HelloController helloController;
    private List<Book> bookList = new ArrayList<>();
    private Recommendation recommendation;

    public void initialize(Recommendation recommendation){
        helloController = new HelloController();
        this.recommendation = recommendation;
        bookList = recommendation.getBookList();
        System.out.println(bookList);
        bookListView.getItems().addAll(bookList);
        nameText.setText(recommendation.getName());
        targetAudienceText.setText("Target Audience: " +recommendation.getTargetAudience());
    }
    public void handleAdd(){
        Book newBook = new Book(authorText.getText(), titleText.getText(), genreText.getText(), Integer.parseInt(yearText.getText()));
        recommendation.addBook(newBook);
        bookList.add(newBook);
        bookListView.getItems().add(newBook);
    }
    public void handleRemove(){
        Book selectedBook = (Book) bookListView.getSelectionModel().getSelectedItem();
        bookList.remove(selectedBook);
        bookListView.getItems().remove(selectedBook);
    }
    public void handleClone(){
        Book selectedBook = (Book) bookListView.getSelectionModel().getSelectedItem();
        Book clonedBook = selectedBook.clone();
        bookList.add(clonedBook);
        bookListView.getItems().add(clonedBook);
    }

}
