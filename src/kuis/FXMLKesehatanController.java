/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuis;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Vieanugraa
 */
public class FXMLKesehatanController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private JFXTextField nama;
    @FXML
    private JFXTextField tinggi;
    @FXML
    private JFXTextField bb;
    @FXML
    private RadioButton lakilaki;
    @FXML
    private ToggleGroup jk;
    @FXML
    private RadioButton perempuan;
    @FXML
    private JFXButton proses;
    @FXML
    private JFXButton reset;
    @FXML
    private TextArea ideal;
    @FXML
    private TextArea hasil;
    @FXML
    private TextArea saran;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void proses(ActionEvent event) {
        int beratideal=0;
        String analisis=null;
        String analisas=null;
        if(lakilaki.isSelected()){
            beratideal=parseInt(tinggi.getText().toString())-105;
        }
        if(perempuan.isSelected()){
            beratideal=parseInt(tinggi.getText().toString())-110;
        }
        
        ideal.setText(""+beratideal);
        
        if(beratideal == parseInt(tinggi.getText())){
            analisis = "Ideal";
            analisas = "Berat badan Anda sudah ideal \nJaga pola makan dan kesehatan Anda agar tetap Ideal";
        }
        else if(beratideal < parseInt(tinggi.getText())){
            analisis = "Overweight";
            analisas = "Berat badan Anda mengalami Overweight \nKurangi dan jaga pola makan Anda";
        }
        else if(beratideal > parseInt(tinggi.getText())){
            analisis = "Underweight";
            analisas = "Berat badan Anda mengalami Underweight \nTambah dan jaga pola makan Anda";
        }
        hasil.setText("Nama "+nama.getText()+", Anda "+analisis);
        saran.setText(analisas);
    }

    @FXML
    private void reset(ActionEvent event) {
        nama.setText("");
        tinggi.setText("");
        bb.setText("");
        lakilaki.setSelected(false);
        perempuan.setSelected(false);
        ideal.setText("");
        saran.setText("");
        hasil.setText("");
    }
    
}
