package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;
	
	public void setModel(Model model) {
		
		this.model = model;
		
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextArea txtGiusti;

    @FXML
    private TextArea txtErrati;

    @FXML
    private Button btnReset;

    @FXML
    void doAnagrammi(ActionEvent event) {

    	txtGiusti.clear();
    	txtErrati.clear();
    	
    	String parola = txtParola.getText();
    	
    	for(int i=0;i<parola.length();i++) {
    		if(Character.isDigit(parola.charAt(i))){
    			txtGiusti.setText("Devi solo inserire solo caratteri alfabetici!!");
    			return;
    		}
    	}
    	
    	Set<String> anagrammi = this.model.getAnagrammi(parola);
    	for(String s : anagrammi) {
    		if(this.model.isCorretto(s)) {
    			txtGiusti.appendText(s+"\n");
    		}else {
    			txtErrati.appendText(s+"\n");
    		}
    	}
    	
    	
    }

    @FXML
    void doReset(ActionEvent event) {

    	txtParola.clear();
    	txtGiusti.clear();
    	txtErrati.clear();
    	
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtGiusti != null : "fx:id=\"txtGiusti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
