package org.example.prototype.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
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
        Book book1 = new Book("George R.R. Martin","Game of Thrones","fantasy",1999);
        booksList.add(book1);
        //Book book2 = book1.clone();
        //booksList.add(book2);
        Recommendation recommendation = new Recommendation("Recommendation1","Fantasy fans",booksList);
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
    /*
    public void openCreateScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/prototype/create-recommendation.fxml"));
        Parent layout = fxmlLoader.load();
        CreateRecommendationController controller = fxmlLoader.getController();
        controller.initialize();
        Scene scene = new Scene(layout);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

     */
    public void handleView(){
        Recommendation recommendation = (Recommendation) recommendationList.getSelectionModel().getSelectedItem();
        try{
            openNewScene(recommendation);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /*
    public void handleAdd(){
        try{
            openCreateScene();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
     */

    public void handleAdd(){
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add a New Recommendation");
        dialog.setContentText("Recommendation name");
        dialog.showAndWait();
        String recommendationName = dialog.getEditor().getText();
        Recommendation recommendation = new Recommendation(recommendationName,"",new ArrayList<>());
        addRecommendation(recommendation);
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