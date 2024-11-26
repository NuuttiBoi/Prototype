package org.example.prototype.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.example.prototype.Book;
import org.example.prototype.Recommendation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloController {
    public ListView recommendationList;
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
    }
    public void openNewScene(Recommendation recommendation) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/prototype/recommendation-view.fxml"));
        Parent layout = fxmlLoader.load();
        RecommendationViewController controller = fxmlLoader.getController();
        controller.initialize(recommendation);
        Scene scene = new Scene(layout);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    public void openNewCreateScene(Recommendation recommendation) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/prototype/create-recommendation.fxml"));
        Parent layout = fxmlLoader.load();
        RecommendationViewController controller = fxmlLoader.getController();
        controller.initialize(recommendation);
        Scene scene = new Scene(layout);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    public void handleView(){
        Recommendation recommendation = (Recommendation) recommendationList.getSelectionModel().getSelectedItem();
        try{
            openNewScene(recommendation);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void handleAdd(){
        Recommendation recommendation = (Recommendation) recommendationList.getSelectionModel().getSelectedItem();
        try{
            openNewScene(recommendation);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void handleClone(){
        Recommendation recommendation = (Recommendation) recommendationList.getSelectionModel().getSelectedItem();
        Recommendation clonedRecommendation = recommendation.clone();
        addRecommendation(clonedRecommendation);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Recommendation cloned");
        alert.show();
    }
    public void addRecommendation(Recommendation recommendation){
        recommendations.add(recommendation);
        recommendationList.getItems().add(recommendation);
        System.out.println(recommendations);
    }


}