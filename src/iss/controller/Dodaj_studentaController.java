/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iss.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Armin
 */
public class Dodaj_studentaController implements Initializable {
    
    
    @FXML
    private AnchorPane glavni_prostor;

    @FXML
    private JFXTextField ime_txt;

    @FXML
    private JFXTextField prezime_txt;

    @FXML
    private JFXTextField jmbg_txt;

    @FXML
    private JFXTextField broj_indeksa_txt;

    @FXML
    private JFXTextField email_txt;

    @FXML
    private JFXDatePicker datum_rodjenja_combo;

    @FXML
    private JFXButton spremi_btn;

    @FXML
    private JFXButton ponisti_btn;

    @FXML
    private Label greska_lbl;

    @FXML
    private JFXComboBox<?> studij_txt;

    @FXML
    private TableView<?> tabela_predmeta;


    @FXML
    private TableColumn<?, ?> naziv_predmeta_column;

    @FXML
    private TableColumn<?, ?> ects_column;

    @FXML
    private TableColumn<?, ?> profesor_column;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tabela_predmeta.setVisible(false);
    }    
    @FXML
    void ponisti(MouseEvent event) {
        ime_txt.setText("");
        prezime_txt.setText("");
        jmbg_txt.setText("");
        datum_rodjenja_combo.setValue(null);
        studij_txt.setValue(null);
        broj_indeksa_txt.setText("");
        email_txt.setText("");
        tabela_predmeta.setVisible(false);
    }

    @FXML
    void spremi(MouseEvent event) {
        String ime = ime_txt.getText();
        String prezime = prezime_txt.getText();
        String email = email_txt.getText();
        String broj_indeksa = broj_indeksa_txt.getText();
        String studij = (String) studij_txt.getValue();
        LocalDate datum_rodjenja = datum_rodjenja_combo.getValue();
        
        if(ime.equals("") || prezime.equals("") || email.equals("") || broj_indeksa.equals("") || studij.equals("") || datum_rodjenja == null){
            greska_lbl.setText("Molimo upišite sve tražene podatke");
        }
        else{}
    }
    
    @FXML
    void odaberi_studij(ActionEvent event) {
        
        tabela_predmeta.setVisible(true);
    }
}
