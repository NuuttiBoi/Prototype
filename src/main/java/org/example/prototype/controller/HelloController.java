package org.example.prototype.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import org.example.prototype.model.Book;
import org.example.prototype.model.Recommendation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloController {
    @FXML
    public ListView<Recommendation> recommendationList;
    private List<Recommendation> recommendations = new ArrayList<>();
    private Recommendation recommendation;

    public void initialize(Recommendation recommendation){
        this.recommendation = recommendation;
        System.out.println(recommendation);
        recommendations.add(recommendation);
        System.out.println(recommendations);
        recommendationList.getItems().addAll(recommendations);
    }
    public void openNewScene(Recommendation recommendation) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/prototype/recommendation-view.fxml"));
        Parent layout = fxmlLoader.load();
        RecommendationViewController controller = fxmlLoader.getController();
        controller.initialize(recommendation);
        Scene scene = new Scene(layout);
        scene.getStylesheets().add(getClass().getResource("/org/example/prototype/style.css").toExternalForm());
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
        Recommendation recommendation = recommendationList.getSelectionModel().getSelectedItem();
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
        Recommendation recommendation = recommendationList.getSelectionModel().getSelectedItem();
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