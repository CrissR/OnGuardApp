package es.iesazarquiel.onguarapp.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.sun.java.swing.plaf.windows.resources.windows;

import es.iesazarquiel.onguarapp.models.dao.DaoDocente;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label usuario;

    @FXML
    private TextField loginUsuario;

    @FXML
    private PasswordField loginPassword;

    @FXML
    private Label contrasenia;

    @FXML
    private Button entrar;

    @FXML
    void initialize() {
        assert usuario != null : "fx:id=\"usuario\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert loginUsuario != null : "fx:id=\"loginUsuario\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert loginPassword != null : "fx:id=\"loginPassword\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert contrasenia != null : "fx:id=\"contrasenia\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert entrar != null : "fx:id=\"entrar\" was not injected: check your FXML file 'LoginView.fxml'.";

    }
    
    @FXML
    void mostrarPrincipal() {
    		try {
    			
    		DaoDocente daodocente = new DaoDocente();
    		
    		ArrayList listaUsusContrs = daodocente.getUsuariosyContrasenias();
    		
    		boolean usuarioExiste = false;
    		boolean contraseniaCoincide = false;
    		int posicionUsuario = 0;
    		
    		for (int i=0; i<listaUsusContrs.size(); i=i+2) {
    			if (loginUsuario.getText().equals(listaUsusContrs.get(i))) {
    				usuarioExiste = true;
    				posicionUsuario = i;
    			}
    		}
    		
    		if (!usuarioExiste) {
    			Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Mensaje");
    			alert.setHeaderText("Atencion!");
    			alert.setContentText("Ese nombre de usuario no existe");

    			alert.showAndWait();
    		}
    		
    		else {
    		if (loginPassword.getText().equals(listaUsusContrs.get(posicionUsuario+1))) {
    			contraseniaCoincide = true;
    		}
    		
    		if (!contraseniaCoincide) {
    			Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Mensaje");
    			alert.setHeaderText("Atencion!");
    			alert.setContentText("La contrasenia no es correcta");

    			alert.showAndWait();
    		}
    		
    		else {
    		
    		if (daodocente.getTipoDocente(loginUsuario.getText()).equals("jefe estudios")) {
    		Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/es/iesazarquiel/onguarapp/views/MainJefeView.fxml")); //--> quitar el comentario para ejecutar el main
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			Stage escena = (Stage) entrar.getScene().getWindow();
			escena.close();
    		}
    		
    		else {
    			Stage primaryStage = new Stage();
    			Parent root = FXMLLoader.load(getClass().getResource("/es/iesazarquiel/onguarapp/views/MainProfeView.fxml")); //--> quitar el comentario para ejecutar el main
    			Scene scene = new Scene(root);
    			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    			primaryStage.setScene(scene);
    			primaryStage.show();
    			
    			Stage escena = (Stage) entrar.getScene().getWindow();
    			escena.close();
    			
    		}
    		
    		}
    		}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
    }

