/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iss.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import iss.model.Kolegij;
import iss.model.Smjer;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import service.KolegijService;
import service.SmjerService;

/**
 * FXML Controller class
 *
 * @author Armin
 */
public class Dodaj_studijController implements Initializable {
    
    @FXML
    private AnchorPane glavni_prostor;

    @FXML
    private JFXTextField naziv_txt;

    @FXML
    private JFXComboBox godina_combo;

    @FXML
    private JFXComboBox godina_upisa_combo;

    @FXML
    private HBox kolegij1_box;

    @FXML
    private JFXComboBox kolegij1_oombo;

    @FXML
    private HBox kolegij2_box;

    @FXML
    private JFXComboBox kolegij2_combo;

    @FXML
    private HBox kolegij3_box;

    @FXML
    private JFXComboBox kolegij3_combo;

    @FXML
    private HBox kolegij4_box;

    @FXML
    private JFXComboBox kolegij4_combo;

    @FXML
    private HBox kolegij5_box;

    @FXML
    private JFXComboBox kolegij5_combo;

    @FXML
    private HBox kolegij6_box;

    @FXML
    private JFXComboBox kolegij6_combo;
    
    @FXML
    private JFXComboBox smjer_combo;
    
    @FXML
    private VBox kolegiji_pane;

    @FXML
    private HBox kolegij7_box;

    @FXML
    private JFXComboBox kolegij7_combo;

    ObservableList<String> godine = FXCollections.observableArrayList("1", "2", "3");
    ObservableList<String> godine_upisa = FXCollections.observableArrayList("2013", "2014", "2015","2016", "2017", "2018","2019", "2020", "2021");
    ObservableList<Smjer> smjerovi = SmjerService.smjerService.sveIzBaze();
    ObservableList<Kolegij> kolegiji;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        godina_combo.setItems(godine);
        godina_upisa_combo.setItems(godine_upisa);
        smjer_combo.setItems(smjerovi);
        
        kolegij2_box.setVisible(false);
        kolegij3_box.setVisible(false);
        kolegij4_box.setVisible(false);
        kolegij5_box.setVisible(false);
        kolegij6_box.setVisible(false);
        kolegij7_box.setVisible(false);
        kolegiji_pane.setVisible(false);
    }    
    
    @FXML
    void dodaj1(MouseEvent event) {
        kolegij2_box.setVisible(true);
    }

    @FXML
    void dodaj2(MouseEvent event) {
        kolegij3_box.setVisible(true);
    }

    @FXML
    void dodaj3(MouseEvent event) {
        kolegij4_box.setVisible(true);
    }

    @FXML
    void dodaj4(MouseEvent event) {
        kolegij5_box.setVisible(true);

    }

    @FXML
    void dodaj5(MouseEvent event) {
        kolegij6_box.setVisible(true);

    }

    @FXML
    void dodaj6(MouseEvent event) {
        kolegij7_box.setVisible(true);

    }

    

    @FXML
    void obrisi1(MouseEvent event) {
        kolegij2_box.setVisible(false);

    }

    @FXML
    void obrisi2(MouseEvent event) {
        kolegij3_box.setVisible(false);

    }

    @FXML
    void obrisi3(MouseEvent event) {
        kolegij4_box.setVisible(false);

    }

    @FXML
    void obrisi4(MouseEvent event) {
        kolegij5_box.setVisible(false);

    }

    @FXML
    void obrisi5(MouseEvent event) {
        kolegij6_box.setVisible(false);

    }

    @FXML
    void obrisi6(MouseEvent event) {
        kolegij7_box.setVisible(false);

    }
    
    @FXML
    private void kolegij1_odabir(ActionEvent event){
        
        kolegiji.remove(smjer_combo.getSelectionModel().getSelectedItem());
        
    }
    @FXML
    void pretrazi_kolegije(ActionEvent event) {
        Smjer odabrani_smjer  = (Smjer) this.smjer_combo.getSelectionModel().getSelectedItem();
        int smjer_id = odabrani_smjer.getId();
        kolegiji = KolegijService.kolegijService.kolegijiPoSmjeru(smjer_id);
        kolegij1_oombo.setItems(kolegiji);
        kolegij2_combo.setItems(kolegiji);
        kolegij3_combo.setItems(kolegiji);
        kolegij4_combo.setItems(kolegiji);
        kolegij5_combo.setItems(kolegiji);
        kolegij6_combo.setItems(kolegiji);
        kolegij7_combo.setItems(kolegiji);
        
        kolegiji_pane.setVisible(true);
    }
    
}
