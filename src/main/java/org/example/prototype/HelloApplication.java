package org.example.prototype;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.prototype.controller.HelloController;
import org.example.prototype.model.Book;
import org.example.prototype.model.Recommendation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        Book book = new Book("George R.R. Martin","A Dance of Dragons","Fantasy",2001);
        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        Recommendation recommendation = new Recommendation("Rec1","Fantasy fans",bookList);
        HelloController controller = fxmlLoader.getController();
        controller.initialize(recommendation);

        scene.getStylesheets().add(getClass().getResource("/org/example/prototype/style.css").toExternalForm());
        stage.setTitle("Book Recommendations");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}