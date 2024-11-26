package org.example.prototype;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

public class HelloController {
    @FXML
    public ListView bookList;
    public ListView recommendationList;
    @FXML
    private Label welcomeText;
    private List<Book> booksList = new ArrayList<>();
    private List<Recommendation> recommendations = new ArrayList<>();

    @FXML
    public void initialize(){
        Book book1 = new Book("George","Game of thrones","fantasy",1999);
        booksList.add(book1);
        Book book2 = book1.clone();
        booksList.add(book2);

        Recommendation recommendation = new Recommendation("Fantasy fans",booksList);
        recommendations.add(recommendation);

        recommendationList.getItems().addAll(recommendations);

        bookList.getItems().addAll(booksList);
    }
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

}