package gui;

import domain.Route;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import service.Service;

import java.util.ArrayList;

public class Controller {
    private Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @FXML
    private ComboBox<String> destinationCityCBox;

    @FXML
    private ListView<Route> listAllRoutes;

    @FXML
    private ListView<Route> listFilteredRoutes;

    @FXML
    private ComboBox<String> sourceCityCBox;

    public void populateComboBoxes() {
        ArrayList<String> cities = service.getCities();
        ObservableList<String> obsCities = FXCollections.observableArrayList(cities);
        destinationCityCBox.setItems(obsCities);
        sourceCityCBox.setItems(obsCities);
    }

    @FXML
    void onComboBoxAction(ActionEvent event) {
        ArrayList<Route> filteredRoutes = service.getFilteredRoutesBySourceCity(sourceCityCBox.getValue());
        ObservableList<Route> obsFilteredRoutes = FXCollections.observableArrayList(filteredRoutes);
        listFilteredRoutes.setItems(obsFilteredRoutes);
    }

    public void initialize() {
        ArrayList<Route> routes = service.getRoutes();
        ObservableList<Route> obsRoutes = FXCollections.observableArrayList(routes);
        listAllRoutes.setItems(obsRoutes);

        ArrayList<Route> filteredRoutes = service.getRoutes();
        ObservableList<Route> obsFilteredRoutes = FXCollections.observableArrayList(routes);
        listFilteredRoutes.setItems(obsFilteredRoutes);

        populateComboBoxes();
    }
}
