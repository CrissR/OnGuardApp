package es.iesazarquiel.onguarapp.views;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
/*************************EJECUCION DE VENTA IDNTIFICACION  [  ANA  ]*******************************/
	public void start(Stage primaryStage) {
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("LoginView.fxml"));//--> comentar para ejecutar el main
			//Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml")); //--> quitar el comentario para ejecutar el main
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/es/iesazarquiel/onguarapp/views/style/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/*falta un método que encadene el login con la ventana principal*/
	/*hay que desarrollar el main AÑADIDO JOSE: era un problema de desmarcar una opción
	 * en scene builder, está solucionado.*/
	public static void main(String[] args) {
		launch(args);
	}
}