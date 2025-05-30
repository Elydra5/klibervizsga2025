package com.example;

import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Primary {

    @FXML
    private TableColumn<Adattipus, String> chefNameCol;

    @FXML
    private TableColumn<Adattipus, Date> datumCol;

    @FXML
    private DatePicker datumField;

    @FXML
    private TableColumn<Adattipus, Integer> idCol;

    @FXML
    private ComboBox<String> kategoriaCB;

    @FXML
    private TableColumn<Adattipus, String> kategoriaCol;

    @FXML
    private TableColumn<Adattipus, String> megjegyzesCol;

    @FXML
    private TextField megjegyzesField;

    @FXML
    private TableColumn<Adattipus, Integer> osszegCol;

    @FXML
    private TextField osszegField;

    @FXML
    private TextField sefField;

    @FXML
    private TableView<Adattipus> tableView;

    @FXML
    void addBtn(ActionEvent event) {
        String chefName = sefField.getText();
        Date datum = Date.valueOf(datumField.getValue());
        String kategoria = kategoriaCB.getValue().toString();
        int osszeg = Integer.parseInt(osszegField.getText());
        String megjegyzes = megjegyzesField.getText();
        int id = generateNewId();
        Adattipus newAdat = new Adattipus(id, chefName, datum, kategoria, osszeg, megjegyzes);
        tableView.getItems().add(newAdat);
        Beolvaso.saveToCSV(newAdat);
        sefField.clear();
        datumField.setValue(null);
        kategoriaCB.setValue(null);
        osszegField.clear();
        megjegyzesField.clear();
    }

    @FXML
    void initialize() throws FileNotFoundException{
        inittable();
        ArrayList<Adattipus> adatok = Beolvaso.beolvas();
        ObservableList<Adattipus> adatokList = FXCollections.observableArrayList(adatok);
        tableView.setItems(adatokList);
        ObservableList<String> kategoriaList = FXCollections.observableArrayList();
        for (Adattipus adatt : adatok) {
            if (!kategoriaList.contains(adatt.getKategoria())) {
                kategoriaList.add(adatt.getKategoria());
            }
        }
        kategoriaCB.setItems(kategoriaList);
    }

    @FXML
    void inittable(){
        this.idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.chefNameCol.setCellValueFactory(new PropertyValueFactory<>("chefname"));
        this.datumCol.setCellValueFactory(new PropertyValueFactory<>("datum"));
        this.kategoriaCol.setCellValueFactory(new PropertyValueFactory<>("kategoria"));
        this.osszegCol.setCellValueFactory(new PropertyValueFactory<>("osszeg"));
        this.megjegyzesCol.setCellValueFactory(new PropertyValueFactory<>("megjegyzes"));
        ObservableList<Adattipus> adatok = FXCollections.observableArrayList();
        this.tableView.getItems().addAll(adatok);
    }

    private int generateNewId() {
        ObservableList<Adattipus> currentItems = tableView.getItems();
        if (currentItems.isEmpty()) {
            return 1;
        }
        int maxId = currentItems.stream().mapToInt(Adattipus::getId).max().orElse(0);
        return maxId + 1;
    }
}
