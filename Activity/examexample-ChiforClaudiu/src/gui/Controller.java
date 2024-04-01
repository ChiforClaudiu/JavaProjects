package gui;

import domain.Activity;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import service.Service;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller {
    private Service service;

    public Controller(Service service) {
        this.service = service;
    }
    @FXML
    private ListView<Activity> listView;


    @FXML
    void filter(ActionEvent event) {/*
        Integer lowerBound=Integer.parseInt(textLowerMinutes.getText());
        Integer upperBound=Integer.parseInt(textUpperMinutes.getText());
        String inputText= textActivity.getText();
        listView.setItems(FXCollections.observableArrayList(this.service.getActivitesBetweenAGivenIntervalAndACertainActivity(inputText)));
 */   }

    public void initialize() {
        this.listView.setItems(FXCollections.observableArrayList(this.service.getActivitiesSortedByDate()));

    }
}
