package main;

import gui.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import repository.Repository;
import service.*;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/gui/ui.fxml"));

        Repository repo = new Repository();
        Service service = new Service(repo);
        Controller controller = new Controller(service);
        fxmlLoader.setController(controller);
        Scene scene = new Scene(fxmlLoader.load(), 700, 700);
        stage.setTitle("Bus Company!");
        stage.setScene(scene);
        stage.show();

        FXMLLoader fxmlLoader2 = new FXMLLoader(Main.class.getResource("/gui/ui.fxml"));

        Controller controller2 = new Controller(service);
        fxmlLoader2.setController(controller2);
        Scene scene2 = new Scene(fxmlLoader2.load(), 700, 700);
        Stage stage2 = new Stage();
        stage2.setTitle("Bus Company2!");
        stage2.setScene(scene2);
        stage2.show();
    }

    public static void main(String[] args) {
        launch();
    }
}