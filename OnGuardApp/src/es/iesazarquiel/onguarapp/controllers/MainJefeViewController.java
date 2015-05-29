package es.iesazarquiel.onguarapp.controllers;


import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import es.iesazarquiel.onguarapp.models.dao.DaoDocente;
import es.iesazarquiel.onguarapp.models.dao.DaoFaltas;
import es.iesazarquiel.onguarapp.models.entidades.Docente;
import es.iesazarquiel.onguarapp.models.entidades.Faltas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

public class MainJefeViewController {
	
	//dice al boton OK lo que tiene que hacer
	private boolean activarVerHorarios = false;
	private boolean activarComunicarFaltas = false;
	private boolean activarVerFaltas = false;
	private boolean activarVerGuardias = false;
	private boolean activarAsignarGuardias = false;
	private boolean activarFirmarGuardia = false;
    private boolean activarGenerarInformeGuardias = false;
    private boolean activarGenerarInformeFaltas = false;
    

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Accordion menu;

    @FXML
    private TitledPane horarios;

    @FXML
    private Button verHorarios;

    @FXML
    private TitledPane faltas;

    @FXML
    private Button comunicarFalta;

    @FXML
    private Button verFaltas;

    @FXML
    private TitledPane guardias;

    @FXML
    private Button firmarGuardia;

    @FXML
    private Button verGuardias;

    @FXML
    private Button asignarGuardias;

    @FXML
    private TitledPane informes;

    @FXML
    private Button informeGuadias;

    @FXML
    private Button informeFaltas;

    @FXML
    private DatePicker fecha1;

    @FXML
    private DatePicker fecha2;

    @FXML
    private Button botonok;

    @FXML
    private ComboBox<?> listaFaltas;

    @FXML
    private ComboBox<?> listaHoras;

    @FXML
    private ComboBox<?> listaProfes;

    @FXML
    private Pane ContenedorSuperior;

    @FXML
    private TableView<String> tablaResultados;

    @FXML
    private TableColumn<String, String> columna1;

    @FXML
    private TableColumn<?, ?> columna2;

    @FXML
    private TableColumn<?, ?> columna3;

    @FXML
    private TableColumn<?, ?> columna4;

    @FXML
    private TableColumn<?, ?> columna5;

    @FXML
    private TableColumn<?, ?> columna6;

    @FXML
    void initialize() throws SQLException {
        assert menu != null : "fx:id=\"menu\" was not injected: check your FXML file 'MainJefeView.fxml'.";
        assert horarios != null : "fx:id=\"horarios\" was not injected: check your FXML file 'MainJefeView.fxml'.";
        assert verHorarios != null : "fx:id=\"verHorarios\" was not injected: check your FXML file 'MainJefeView.fxml'.";
        assert faltas != null : "fx:id=\"faltas\" was not injected: check your FXML file 'MainJefeView.fxml'.";
        assert comunicarFalta != null : "fx:id=\"comunicarFalta\" was not injected: check your FXML file 'MainJefeView.fxml'.";
        assert verFaltas != null : "fx:id=\"verFaltas\" was not injected: check your FXML file 'MainJefeView.fxml'.";
        assert guardias != null : "fx:id=\"guardias\" was not injected: check your FXML file 'MainJefeView.fxml'.";
        assert firmarGuardia != null : "fx:id=\"firmarGuardia\" was not injected: check your FXML file 'MainJefeView.fxml'.";
        assert verGuardias != null : "fx:id=\"verGuardias\" was not injected: check your FXML file 'MainJefeView.fxml'.";
        assert asignarGuardias != null : "fx:id=\"asignarGuardias\" was not injected: check your FXML file 'MainJefeView.fxml'.";
        assert informes != null : "fx:id=\"informes\" was not injected: check your FXML file 'MainJefeView.fxml'.";
        assert informeGuadias != null : "fx:id=\"informeGuadias\" was not injected: check your FXML file 'MainJefeView.fxml'.";
        assert informeFaltas != null : "fx:id=\"informeFaltas\" was not injected: check your FXML file 'MainJefeView.fxml'.";
        assert fecha1 != null : "fx:id=\"fecha1\" was not injected: check your FXML file 'MainJefeView.fxml'.";
        assert fecha2 != null : "fx:id=\"fecha2\" was not injected: check your FXML file 'MainJefeView.fxml'.";
        assert botonok != null : "fx:id=\"botonok\" was not injected: check your FXML file 'MainJefeView.fxml'.";
        assert listaFaltas != null : "fx:id=\"listaFaltas\" was not injected: check your FXML file 'MainJefeView.fxml'.";
        assert listaHoras != null : "fx:id=\"listaHoras\" was not injected: check your FXML file 'MainJefeView.fxml'.";
        assert listaProfes != null : "fx:id=\"listaProfes\" was not injected: check your FXML file 'MainJefeView.fxml'.";
        assert ContenedorSuperior != null : "fx:id=\"ContenedorSuperior\" was not injected: check your FXML file 'MainJefeView.fxml'.";
        assert tablaResultados != null : "fx:id=\"tablaResultados\" was not injected: check your FXML file 'MainJefeView.fxml'.";
        assert columna1 != null : "fx:id=\"columna1\" was not injected: check your FXML file 'MainJefeView.fxml'.";
        assert columna2 != null : "fx:id=\"columna2\" was not injected: check your FXML file 'MainJefeView.fxml'.";
        assert columna3 != null : "fx:id=\"columna3\" was not injected: check your FXML file 'MainJefeView.fxml'.";
        assert columna4 != null : "fx:id=\"columna4\" was not injected: check your FXML file 'MainJefeView.fxml'.";
        assert columna5 != null : "fx:id=\"columna5\" was not injected: check your FXML file 'MainJefeView.fxml'.";
        assert columna6 != null : "fx:id=\"columna6\" was not injected: check your FXML file 'MainJefeView.fxml'.";

 /***********************MOSTRAR LOS NOMBRES DE LOS PROFESORES EN COMBOBOX**********************************/
        DaoDocente daodocente = new DaoDocente();
        List<String> losProfesores = new ArrayList<String>();
        losProfesores = daodocente.getNombresProfesores();
        ObservableList losProfesoresOL = FXCollections.observableList(losProfesores);
        listaProfes.getItems().clear();
        listaProfes.setItems(losProfesoresOL);
 
/***********************MOSTRAR LAS HORAS EN EL COMBOBOX**********************************/
        List<String> lasHoras = new ArrayList<String>();
        lasHoras.add("hora1");
        lasHoras.add("hora2");
        lasHoras.add("hora3");
        lasHoras.add("hora4");
        lasHoras.add("hora5");
        lasHoras.add("hora6");
        ObservableList lasHorasOL = FXCollections.observableList(lasHoras);
        listaHoras.getItems().clear();
        listaHoras.setItems(lasHorasOL);
        
/***********************MOSTRAR LAS FALTAS EN EL COMBOBOX**********************************/      

    }
    
 
    @FXML
    void enviarTodoAlFondo() {
    	botonok.toBack();
    	listaProfes.toBack();
    	listaHoras.toBack();
    	listaFaltas.toBack();
    	fecha1.toBack();
    	fecha2.toBack();
    }
    
    @FXML 
    void botonVerHorarios() {
    	
    	enviarTodoAlFondo();
    	
    	botonok.toFront();
    	listaProfes.toFront();
    	activarVerHorarios = true;
    }
    
    @FXML 
    void botonComunicarFalta() {
    	
    	enviarTodoAlFondo();
    	
    	botonok.toFront();
    	listaProfes.toFront();
    	listaHoras.toFront();
    	fecha1.toFront();
    	activarComunicarFaltas = true;
    }
    
    @FXML
    void botonVerFaltas() {
    	enviarTodoAlFondo();
    	
    	botonok.toFront();
    	listaProfes.toFront();
    	fecha1.toFront();
    	fecha2.toFront();
    	
    	activarVerFaltas = true;
    }
    
    @FXML
    void botonVerGuardias() {
    	enviarTodoAlFondo();
    	
    	botonok.toFront();
    	listaProfes.toFront();
    	fecha1.toFront();
    	fecha2.toFront();
    	
    	activarVerGuardias = true;
    }
    
    @FXML
    void botonAsignarGuardia() {
    	enviarTodoAlFondo();
    	
        botonok.toFront();
        listaFaltas.toFront();
        listaProfes.toFront();
    	
    	activarAsignarGuardias = true;
    }
    
    @FXML
    void botonFirmarGuardia() {
    	enviarTodoAlFondo();
    	
        botonok.toFront();
        fecha1.toFront();
        listaHoras.toFront();
        listaProfes.toFront();
    	
    	activarFirmarGuardia = true;
    }
    
    @FXML
    void botonGenerarInformeGuardias() {
    	enviarTodoAlFondo();
    	
    	botonok.toFront();
    	fecha1.toFront();
    	
    	activarGenerarInformeGuardias = true;
    }
    
    @FXML
    void botonGenerarInformeFaltas() {
    	enviarTodoAlFondo();
    	
    	botonok.toFront();
    	fecha1.toFront();
    	
    	activarGenerarInformeFaltas = true;
    }
    
    
    @FXML
    void mostrarResultados() throws SQLException {
    	
    	if (activarVerHorarios) {
    		
    		/* M�todo de Alejandro*/
    		
    		activarVerHorarios = false;
    	}
    	
    	else if (activarComunicarFaltas) {
    		
    		/*M�todo de Cristina*/
    		
    		activarComunicarFaltas = false;
    	}
    	
    	else if (activarVerFaltas) {
    		
    		/*M�todo de Carlos*/
    		DaoDocente daodocente = new DaoDocente();
    		
    		String nombreProfe = (String) listaProfes.getSelectionModel().getSelectedItem().toString();//captura el profesor
    		String codProfe = daodocente.encontrarCodigo(nombreProfe);
    		
    		LocalDate fechaInicio= fecha1.getValue();
    		Date fechaInicio2 = (Date) Date.from(fechaInicio.atStartOfDay(ZoneId.systemDefault()).toInstant());//coge la fecha
    		LocalDate fechaFin= fecha2.getValue();
    		Date fechaFin2 = (Date) Date.from(fechaFin.atStartOfDay(ZoneId.systemDefault()).toInstant());//coge la fecha
    	    // System.out.println(fechaInicio2 + " " + fechaFin2 + " " + codProfe);
    		
    		//insertamos los datos de arriba//	
    		DaoFaltas daofaltas = new DaoFaltas();//necesario para usar el método verFaltasProf
    		ArrayList<String> lasFaltas = daofaltas.verFaltasProf(codProfe, fechaInicio2, fechaFin2);
    	
    		ObservableList<String> listaFaltas = FXCollections.observableArrayList(lasFaltas);
    		//columna1.setCellFactory(new Callback<TableColumn.CellDataFeatures<ObservableList<String>,String>,ObservableValue<String>>);
    		columna1.setCellValueFactory(new PropertyValueFactory<String, String>("cosas"));
    		tablaResultados.getItems().setAll(listaFaltas);
    		
    		activarVerFaltas = false;
    		
    	}
    	
    	else if (activarVerGuardias) {
    		
    		/*M�todo de Carlos*/
    		
    		activarVerGuardias = false;
    	}
    	
    	else if (activarAsignarGuardias) {
    		
    		/*M�todo de Cristina*/
    		
    		activarAsignarGuardias = false;
    		
    	}
    	
    	else if (activarFirmarGuardia) {
    		
    		/*M�todo de Ana*/
    		
    		activarFirmarGuardia = false;
    	}
    	
    	else if (activarGenerarInformeGuardias) {
    		
    		/*M�todo de Jose*/
    		
    		activarGenerarInformeGuardias = false;
    	}
    	
    	else if (activarGenerarInformeFaltas) {
    		
    		/*M�todo de Jose*/
    		
    		activarGenerarInformeFaltas = false;
    		
    	}
    

    	
    }
    
    
}