package es.iesazarquiel.onguarapp.controllers;


import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import es.iesazarquiel.onguarapp.models.dao.DaoDocente;
import es.iesazarquiel.onguarapp.models.dao.DaoFaltas;
import es.iesazarquiel.onguarapp.models.entidades.Docente;
import es.iesazarquiel.onguarapp.models.entidades.Faltas;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

//esta clase es necesaria para meter cosas en el Tableview
class LineaTabla {
	
	public SimpleStringProperty c1;
	public SimpleStringProperty c2;
	public SimpleStringProperty c3;
	public SimpleStringProperty c4;
	public SimpleStringProperty c5;
	public SimpleStringProperty c6;
	
	public LineaTabla(String tc1, String tc2, String tc3, String tc4, String tc5, String tc6) {
		this.c1 = new SimpleStringProperty(tc1);
		this.c2 = new SimpleStringProperty(tc2);
		this.c3 = new SimpleStringProperty(tc3);
		this.c4 = new SimpleStringProperty(tc4);
		this.c5 = new SimpleStringProperty(tc5);
		this.c6 = new SimpleStringProperty(tc6);
	}
	
	}

public class MainJefeViewController {
	
	//estos booleanos dicen al boton OK lo que tiene que hacer
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

    @FXML  //la TableView es de tipo LineaTabla, la clase creada arriba
    private TableView<LineaTabla> tablaResultados;

    @FXML
    private TableColumn<LineaTabla, String> columna1;

    @FXML
    private TableColumn<LineaTabla, String> columna2;

    @FXML
    private TableColumn<LineaTabla, String> columna3;

    @FXML
    private TableColumn<LineaTabla, String> columna4;

    @FXML
    private TableColumn<LineaTabla, String> columna5;

    @FXML
    private TableColumn<LineaTabla, String> columna6;

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
    
 
    @FXML //método que envía los elementos de la pantalla al fondo, para que no se muestren
    void enviarTodoAlFondo() {
    	botonok.toBack();
    	listaProfes.toBack();
    	listaHoras.toBack();
    	listaFaltas.toBack();
    	fecha1.toBack();
    	fecha2.toBack();
    }
    
    void ponerTodosLosBooleanosAFalso() {
    	activarVerHorarios = false;
    	activarComunicarFaltas = false;
    	activarVerFaltas = false;
    	activarVerGuardias = false;
    	activarAsignarGuardias = false;
    	activarFirmarGuardia = false;
        activarGenerarInformeGuardias = false;
        activarGenerarInformeFaltas = false;
    }
    
    @FXML //los siguientes métodos controlan los botones de la izquierda. 
    //Dicen qué elementos tienen que aparecer en la pantalla central.
  
    void botonVerHorarios() {
    	
    	enviarTodoAlFondo();
    	ponerTodosLosBooleanosAFalso();
    	
    	botonok.toFront();
    	listaProfes.toFront();
    	activarVerHorarios = true;
    }
    
    @FXML 
    void botonComunicarFalta() {
    	
    	enviarTodoAlFondo();
    	ponerTodosLosBooleanosAFalso();
    	
    	botonok.toFront();
    	listaProfes.toFront();
    	listaHoras.toFront();
    	fecha1.toFront();
    	activarComunicarFaltas = true;
    }
    
    @FXML
    void botonVerFaltas() {
    	enviarTodoAlFondo();
    	ponerTodosLosBooleanosAFalso();
    	
    	botonok.toFront();
    	listaProfes.toFront();
    	fecha1.toFront();
    	fecha2.toFront();
    	
    	activarVerFaltas = true;
    }
    
    @FXML
    void botonVerGuardias() {
    	enviarTodoAlFondo();
    	ponerTodosLosBooleanosAFalso();
    	
    	botonok.toFront();
    	listaProfes.toFront();
    	fecha1.toFront();
    	fecha2.toFront();
    	
    	activarVerGuardias = true;
    }
    
    @FXML
    void botonAsignarGuardia() {
    	enviarTodoAlFondo();
    	ponerTodosLosBooleanosAFalso();
    	
        botonok.toFront();
        listaFaltas.toFront();
        listaProfes.toFront();
    	
    	activarAsignarGuardias = true;
    }
    
    @FXML
    void botonFirmarGuardia() {
    	enviarTodoAlFondo();
    	ponerTodosLosBooleanosAFalso();
    	
        botonok.toFront();
        fecha1.toFront();
        listaHoras.toFront();
        listaProfes.toFront();
    	
    	activarFirmarGuardia = true;
    }
    
    @FXML
    void botonGenerarInformeGuardias() {
    	enviarTodoAlFondo();
    	ponerTodosLosBooleanosAFalso();
    	
    	botonok.toFront();
    	fecha1.toFront();
    	
    	activarGenerarInformeGuardias = true;
    }
    
    @FXML
    void botonGenerarInformeFaltas() {
    	enviarTodoAlFondo();
    	ponerTodosLosBooleanosAFalso();
    	
    	botonok.toFront();
    	fecha1.toFront();
    	
    	activarGenerarInformeFaltas = true;
    }
    
    
    @FXML  //Método para mostrar la información visual en pantalla
    void mostrarResultados() throws SQLException {
    	
    	if (activarVerHorarios) {
    		
    		/* Parte de Alejandro*/
    		
    		
    	}
    	
    	else if (activarComunicarFaltas) {
    		
    		/*Parte de Cristina, requiere crear un objeto de la clase Falta*/
    		
    		
    	}
    	
    	else if (activarVerFaltas) {
    		
    		/*Primer metodo en comun, con ayuda de Angel*/
    		
    		//Ponemos encabezados a las columnas
    		columna1.setText("Fecha falta");
    		columna2.setText("Hora falta");
      		columna3.setText("Profesor de guardia");
      		columna4.setText(" ");
      		columna5.setText(" ");
      		columna6.setText(" ");
    	
      		//cogemos el nombre de profesor, averiguamos su codigo
    		DaoDocente daodocente = new DaoDocente();
    		String nombreProfe = (String) listaProfes.getSelectionModel().getSelectedItem().toString();//captura el profesor
    		String codProfe = daodocente.encontrarCodigo(nombreProfe);
    		
    		//cogemos la fecha de inicio del DatePicker y la convertimos en Date sql
    		LocalDate fechaInicio= fecha1.getValue();
    		Instant instant = Instant.from(fechaInicio.atStartOfDay(ZoneId.systemDefault()));
    		java.util.Date theDate = Date.from(instant);
    		java.sql.Date fechaInicio2 = new java.sql.Date(theDate.getTime());
    		
    		//cogemos la fecha de fin del DatePicker y la convertimos en Date sql
    		LocalDate fechaFin = fecha2.getValue();
    		Instant instant2 = Instant.from(fechaFin.atStartOfDay(ZoneId.systemDefault()));
    		java.util.Date theDate2 = Date.from(instant2);
    		java.sql.Date fechaFin2 = new java.sql.Date(theDate2.getTime());  	
    		 		
    		//insertamos los datos de arriba en un arraylist que llevará los datos de las faltas solicitadas
    		DaoFaltas daofaltas = new DaoFaltas();//necesario para usar el metodo verFaltasProf
    		ArrayList<String> lasFaltas = daofaltas.verFaltasProf(codProfe, fechaInicio2, fechaFin2);
    		
    		//creamos las lineas de la tabla en pantalla (clase creada arriba del todo)
    		ArrayList <LineaTabla> lineasTablaVerFaltas = new ArrayList<LineaTabla>();
    		
    		//ponemos los valores en las tres columnas que me interesan según el arrayList de lasFaltas
    		//las columnas no utilizadas de las seis las rellenamos con vacíos
    		for (int i=0; i<lasFaltas.size(); i=i+4) {
    			LineaTabla linea = new LineaTabla(lasFaltas.get(i+1), lasFaltas.get(i+2), lasFaltas.get(i+3),"","","");
    			lineasTablaVerFaltas.add(linea);
    		}
  
    		//asignamos los valores de las "columnas" de LineaTabla a cada columna del TableView, del siguiente modo
    		columna1.setCellValueFactory(cellData -> cellData.getValue().c1); 
    		columna2.setCellValueFactory(cellData -> cellData.getValue().c2);
    		columna3.setCellValueFactory(cellData -> cellData.getValue().c3);
    		
    		//decimos a la tabla que coja los valores del arraylist de lineas de la tabla   
    		tablaResultados.getItems().setAll(lineasTablaVerFaltas);
    	
    		
    	}
    	
    	else if (activarVerGuardias) {
    		
    		/*Parte de Carlos*/
    		
    		
    	}
    	
    	else if (activarAsignarGuardias) {
    		
    		/*Parte de Cristina*/
    		
    		
    		
    	}
    	
    	else if (activarFirmarGuardia) {
    		
    		/*Parte de Ana*/
    		
    		
    	}
    	
    	else if (activarGenerarInformeGuardias) {
    		
    		/*Parte de Alejandro*/
    		
    		
    	}
    	
    	else if (activarGenerarInformeFaltas) {
    		
    		/*Metodo de Jose*/  /*NO FUNCIONA POR AHORA*/
    		
    		columna1.setText("HORA");
    		columna2.setText("B-301");
      		columna3.setText("B-302");
      		columna4.setText(" ");
      		columna5.setText(" ");
      		columna6.setText(" ");
    	
      		
    		//coger la fecha del DatePicker y la convertimos en Date sql
    		LocalDate fecha = fecha1.getValue();
    		Instant instant = Instant.from(fecha.atStartOfDay(ZoneId.systemDefault()));
    		java.util.Date laFecha = Date.from(instant);
    		java.sql.Date fecha2 = new java.sql.Date(laFecha.getTime());
    		
    		//insertamos los datos de arriba en un arraylist que llevará los datos de las faltas solicitadas
    		DaoFaltas daofaltas = new DaoFaltas();//necesario para usar el metodo verFaltasProf
    		ArrayList<String> lasFaltas = daofaltas.generarInformeFaltasCub(fecha2);
    		
    		//creamos las lineas de la tabla en pantalla (clase creada arriba del todo)
    		ArrayList <LineaTabla> lineasTablaGenerarInformeFaltas = new ArrayList<LineaTabla>();
    		
    		/* Devuelve algo así como:
    		hora5
    		B-302
    		profe004
    		hora6
    		B-302
    		profe004
    		*/
    		
    		//creo seis lineas de tabla, una para cada hora
    		for (int i=0; i<6; i++) {
    			LineaTabla linea = new LineaTabla("hora"+(i+1),"","","","","");
    			lineasTablaGenerarInformeFaltas.add(linea);
    		}
    		
    		//miro las horas que me ha devuelto el arrayList anterior, y meto el profe en la columna del aula correspondiente
    		for (int i=0; i < lasFaltas.size(); i=i+3) {
    			//profesor
    			DaoDocente daodocente = new DaoDocente();
    			String nombreProf = daodocente.encontrarNombre(lasFaltas.get(i+1));
    			
    			int numeroLinea = -1;
    			if (lasFaltas.get(i).equals("hora1")) numeroLinea = 0;
    			if (lasFaltas.get(i).equals("hora2")) numeroLinea = 1;
    			if (lasFaltas.get(i).equals("hora3")) numeroLinea = 2;
    			if (lasFaltas.get(i).equals("hora4")) numeroLinea = 3;
    			if (lasFaltas.get(i).equals("hora5")) numeroLinea = 4;
    			if (lasFaltas.get(i).equals("hora6")) numeroLinea = 5;
    			
    			
    			
    				if (lasFaltas.get(i+2).equals("B-301")) {
    					lineasTablaGenerarInformeFaltas.get(numeroLinea).c1 = new SimpleStringProperty(nombreProf);
    				}
    				else if (lasFaltas.get(i+2).equals("B-302")) {
    					lineasTablaGenerarInformeFaltas.get(numeroLinea).c2 = new SimpleStringProperty(nombreProf);
    				}
    			
    			
    		}
    		    		  		 
    		//asignamos los valores de las "columnas" de LineaTabla a cada columna del TableView
    		columna1.setCellValueFactory(cellData -> cellData.getValue().c1); 
    		columna2.setCellValueFactory(cellData -> cellData.getValue().c2);
    	    		
    		//decimos a la tabla que coja los valores del arraylist de lineas de la tabla   
    		tablaResultados.getItems().setAll(lineasTablaGenerarInformeFaltas);
    		
    		
    		
    	}
    

    	
    }
    
    
}