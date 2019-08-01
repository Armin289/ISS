/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iss.controller;

import com.jfoenix.controls.JFXButton;
import iss.Utils;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Armin
 */
public class PocetnaController implements Initializable {

    
    @FXML
    private AnchorPane glavni_pane;

    @FXML
    private ImageView meni_btn;

    @FXML
    private AnchorPane meni_pane;
    
    @FXML
    private Pane glavni_prostor;

    @FXML
    private JFXButton pocetna_btn;

    @FXML
    private JFXButton pretrazi_studenta_btn;

    @FXML
    private JFXButton dodaj_studenta_btn;

    @FXML
    private JFXButton pretrazi_profesora_btn;

    @FXML
    private JFXButton studij_btn;

    @FXML
    private JFXButton ispitni_rokovi_btn;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        prikaz_izbornika(glavni_pane, meni_pane, 0, -200);

    }

    @FXML
    void otvori_meni(MouseEvent event) {
        prikaz_izbornika(glavni_pane, meni_pane, 0, 0);

    }

    @FXML
    void zatvori(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void zatvori_meni(MouseEvent event) {
        prikaz_izbornika(glavni_pane, meni_pane, 0, -200);
    }
    
    @FXML
    void otvori_dodaj_studenta(MouseEvent event) throws IOException {
        Pane pregled = FXMLLoader.load(Utils.class.getResource("view/dodaj_studenta.fxml"));
        glavni_prostor.getChildren().setAll(pregled);
        zatvori_meni(event);
    }

    @FXML
    void otvori_ispitni_rokovi(MouseEvent event) {

    }

    @FXML
    void otvori_pocetnu(MouseEvent event) {

    }

    @FXML
    void otvori_pretrazi_profesora(MouseEvent event) {

    }

    @FXML
    void otvori_pretrazi_studenta(MouseEvent event) {

    }

    @FXML
    void otvori_studij(MouseEvent event) {

    }

    private void prikaz_izbornika(AnchorPane node, AnchorPane slider, int pomak_node, int pomak_slider) {

        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.7));
        slide.setNode(node);

        slide.setToX(pomak_node);
        slide.play();

        slider.setTranslateX(pomak_slider);

        slide.setOnFinished((e -> {

        }));
    }
    

}
