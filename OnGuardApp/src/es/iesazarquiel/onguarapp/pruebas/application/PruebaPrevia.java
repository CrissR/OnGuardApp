package es.iesazarquiel.onguarapp.pruebas.application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class PruebaPrevia extends Application {

	
	/*************************************PRUEBA VISUAL [ JOSE ]********************************/
	
	public static Canvas canvas = new Canvas(550, 350);

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 600, 650);
			scene.getStylesheets().add(
					getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Control de guardias");

			ObservableList<String> profesores = FXCollections
					.observableArrayList();
			profesores.addAll("Luis", "David", "Natalia", "Juana");

			ObservableList<String> horas = FXCollections.observableArrayList();
			horas.addAll("H1", "H2", "H3", "H4", "H5", "H6");

			ObservableList<String> diaHoras = FXCollections
					.observableArrayList();
			diaHoras.addAll("D�a entero", "H1", "H2", "H3", "H4", "H5", "H6");

			ObservableList<String> semanas = FXCollections
					.observableArrayList();
			semanas.addAll("Semana 1", "Semana 2", "Semana 3", "Semana 4");

			ComboBox listaProfs = new ComboBox(profesores);
			ComboBox listaProfs2 = new ComboBox(profesores);
			ComboBox listaSemanas = new ComboBox(semanas);
			ComboBox desplegableHoras = new ComboBox(horas);
			ComboBox desplegableDiaHoras = new ComboBox(diaHoras);
			TextField fecha = new TextField("XX/XX/XX");
			TextField fecha2 = new TextField("XX/XX/XX");
			Label asignarFalta = new Label("Asignar falta de... ");
			Label alProf = new Label("Al prof ");
			Label desde = new Label("Desde ");
			Label hasta = new Label(" hasta ");

			HBox lineaCentral = new HBox();

			GraphicsContext gc = canvas.getGraphicsContext2D();
			gc.setFill(Color.WHITE);
			gc.fillRect(0, 0, 550, 350);
			Image azarquiel = new Image("./application/azarquiel.jpg");
			gc.drawImage(azarquiel, 10, 10);

			VBox caja = new VBox();

			VBox botones = new VBox();
			HBox botones1 = new HBox();
			HBox botones2 = new HBox();
			HBox botones3 = new HBox();

			Button verHorarios = new Button("Ver horarios");
			verHorarios
					.setOnAction(e -> {
						Button b1 = new Button("Ver");
						b1.setOnAction(ev -> {
							gc.setFill(Color.WHITE);
							gc.fillRect(100, 100, 200, 50);
							gc.setFill(Color.BLACK);
							gc.fillText("Aqu� deber�a salir el horario", 110,
									130);
						});
						lineaCentral.getChildren().clear();
						lineaCentral.getChildren().addAll(listaProfs,
								listaSemanas, b1);
						root.setCenter(lineaCentral);
					});

			Button comunicarFalta = new Button("Comunicar falta");
			comunicarFalta.setOnAction(e -> {
				Button b2 = new Button("Anotar");
				lineaCentral.getChildren().clear();
				lineaCentral.getChildren().addAll(listaProfs, fecha,
						desplegableDiaHoras, b2);
				root.setCenter(lineaCentral);
			});

			Button firmarGuardia = new Button("Firmar guardia");
			firmarGuardia.setOnAction(e -> {
				Button b3 = new Button("Firmar");
				lineaCentral.getChildren().clear();
				lineaCentral.getChildren().addAll(listaProfs, fecha,
						desplegableHoras, b3);
				root.setCenter(lineaCentral);
			});

			Button asignarGuardia = new Button("Asignar guardia");
			asignarGuardia.setOnAction(e -> {
				Button b4 = new Button("Asignar");
				lineaCentral.getChildren().clear();
				lineaCentral.getChildren().addAll(asignarFalta, listaProfs,
						alProf, listaProfs2, fecha, desplegableHoras, b4);
				root.setCenter(lineaCentral);
			});

			botones1.getChildren().addAll(verHorarios, comunicarFalta,
					firmarGuardia, asignarGuardia);

			Button verFaltasProf = new Button("Ver faltas de un profesor");
			verFaltasProf.setOnAction(e -> {
				Button b5 = new Button("Ver");
				lineaCentral.getChildren().clear();
				lineaCentral.getChildren().addAll(listaProfs, desde, fecha,
						hasta, fecha2, b5);
				root.setCenter(lineaCentral);
			});

			Button histGuardias = new Button("Ver guardias de un profesor");
			histGuardias.setOnAction(e -> {
				Button b6 = new Button("Ver");
				lineaCentral.getChildren().clear();
				lineaCentral.getChildren().addAll(listaProfs, desde, fecha,
						hasta, fecha2, b6);
				root.setCenter(lineaCentral);
			});

			botones2.getChildren().addAll(verFaltasProf, histGuardias);

			Button informeGuardias = new Button(
					"Generar informe diario de guardias");
			informeGuardias.setOnAction(e -> {
				Button b7 = new Button("Generar");
				lineaCentral.getChildren().clear();
				lineaCentral.getChildren().addAll(fecha, b7);
				root.setCenter(lineaCentral);
			});

			Button informeFaltas = new Button(
					"Generar informe diario de faltas");
			informeFaltas.setOnAction(e -> {
				Button b8 = new Button("Generar");
				lineaCentral.getChildren().clear();
				lineaCentral.getChildren().addAll(fecha, b8);
				root.setCenter(lineaCentral);
			});

			botones3.getChildren().addAll(informeGuardias, informeFaltas);
			botones.getChildren().addAll(botones1, botones2, botones3);

			caja.getChildren().addAll(botones);

			Label inicio = new Label("Gesti�n de guardias del Azarquiel");

			root.setTop(canvas);
			root.setBottom(caja);
			root.setCenter(inicio);

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
