package com.mycompany.exameninterfaces;


import java.net.URL;

import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Cliente;


public class SecondaryController implements Initializable {

       
   ArrayList salida = new ArrayList<Cliente>();
        
    @FXML
    private TableView<Cliente> tabla;
    @FXML
    private TextField Nombree;
    @FXML
    private Spinner<Integer> SpinnerPeso;
    @FXML
    private Spinner<Integer> SpinnerEdad;
    @FXML
    private ComboBox<String> ComboBoxSexo;
    @FXML
    private ComboBox<String> ComboboxActividad;
    @FXML
    private Spinner<Integer> SpinnerAltura;
    @FXML
    private TableColumn<Cliente, String> ColumnaNombre;
    @FXML
    private TableColumn<Cliente, String> ColumnaSexo;
    @FXML
    private TableColumn<Cliente, Integer> ColumnaEdad;
    @FXML
    private TableColumn<Cliente, Integer> ColumnaAltura;
    @FXML
    private TableColumn<Cliente, String> ColumnaActividad;
    @FXML
    private TableColumn<Cliente, Long> ColumnaGER;
    @FXML
    private TableColumn<Cliente, Long> ColumnaGet;
    @FXML
    private Button btnAñadir1;
    @FXML
    private TableColumn<Cliente, Long> PesoColumna;
    @FXML
    private Label LabelInformacion;

   
      @Override
    public void initialize(URL url, ResourceBundle rb) {
          PoblarTabla();
          PoblarOpciones();       
    }

    @FXML
    private void AñadirTabla(ActionEvent event) {
            Cliente Anadir = new Cliente();
        Boolean LoAñadimos=true;
        Anadir.setNombre(Nombree.getText());
        Anadir.setSexo(ComboBoxSexo.getValue());
        Anadir.setActividad(ComboboxActividad.getValue());
        Anadir.setAltura(SpinnerAltura.getValue());
        Anadir.setEdad(SpinnerEdad.getValue());
        Anadir.setPeso(SpinnerPeso.getValue());
        Anadir.setGer(CalculoDeGer());
        Anadir.setGet(CalculoDeGet());
        
        if (Anadir.getNombre()==""){ LoAñadimos=false; 
        LabelInformacion.setText("Falta el nombre");
        }
        if (Anadir.getActividad()==""){ LoAñadimos=false; 
        LabelInformacion.setText("Falta la actividad");
        }
        if (Anadir.getSexo()==""){ LoAñadimos=false; 
        LabelInformacion.setText("Falta el sexo");
        }
        if (Anadir.getAltura()<=0){ LoAñadimos=false; 
        LabelInformacion.setText("Falta la altura");
        }
        if (SpinnerEdad.getValue()<=0){ LoAñadimos=false; 
        LabelInformacion.setText("Falta la edad");
        }
        if (Anadir.getPeso()<=0){ LoAñadimos=false; 
        LabelInformacion.setText("Falta el peso");
        }
       
       
      if (LoAñadimos==true){
          LabelInformacion.setText("Añadido con éxito");
          salida.add(Anadir);
          PoblarTabla();
          PoblarOpciones();
      }
    }

    private void PoblarTabla() {
             
           this.ColumnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
	   this.ColumnaSexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
           this.ColumnaEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
           this.ColumnaAltura.setCellValueFactory(new PropertyValueFactory<>("altura"));
           this.ColumnaActividad.setCellValueFactory(new PropertyValueFactory<>("actividad"));
           this.ColumnaGER.setCellValueFactory(new PropertyValueFactory<>("ger"));
           this.ColumnaGet.setCellValueFactory(new PropertyValueFactory<>("get"));
           this.PesoColumna.setCellValueFactory(new PropertyValueFactory<>("peso"));
               
         ArrayList<Cliente> items= salida;
         var   itemss = FXCollections.observableList(items);
         this.tabla.setItems(itemss);    
    }

    private void PoblarOpciones() {
         Nombree.setText("");
ObservableList<String> genero = FXCollections.observableArrayList();
        
            genero.add("Masculino");
            genero.add("Femenino");


        ComboBoxSexo.setValue("");
        ComboBoxSexo.setItems(genero);
           
          ObservableList<String> activity = FXCollections.observableArrayList();
       
            activity.add("Muy ligera");
            activity.add("Ligera");
            activity.add("Moderada");
            activity.add("Intensa"); 
         ComboboxActividad.setValue("");
         ComboboxActividad.setItems(activity);
         
       SpinnerValueFactory<Integer> valueFactory = 
             new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 300, 140);

        SpinnerAltura.setValueFactory(valueFactory);
        SpinnerAltura.setEditable(true);
        
        
            SpinnerValueFactory<Integer> valueFactory2 = 
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 300, 50);

        SpinnerPeso.setValueFactory(valueFactory2);
        SpinnerPeso.setEditable(true);
        
        
                SpinnerValueFactory<Integer> valueFactory3 = 
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 120, 10);

        SpinnerEdad.setValueFactory(valueFactory3);
        SpinnerEdad.setEditable(true);    
    }

    public  double CalculoDeGer () {
        double valor=0;
         var P= SpinnerPeso.getValue();
         var T= SpinnerAltura.getValue();
         var E= SpinnerEdad.getValue();
         var sexo = ComboBoxSexo.getValue();
         
         if(sexo=="Masculino"){
         valor=(66.473+13.751*P+5.0033*T-6.755*E);
         }else{
             valor=(655.0955+9.463*P+1.8496*T-4.6756*E);
         }
        return valor;
    }
    
      public  double CalculoDeGet () {
         double valor=0;
         String Actividad = ComboboxActividad.getValue();
         var sexo = ComboBoxSexo.getValue();
         
         if(sexo=="Masculino"){
        switch (Actividad){
            case "Muy ligera":  valor = 1.3;
                     break;
            case "Ligera":  valor = 1.6;
                     break;
            case "Moderada": valor = 1.7;
                     break;
            case "Intensa":  valor = 2.1;
                     break;
      
            default: valor = 0.0;
                     break;
        }
         }
         if(sexo=="Femenino"){
        switch (Actividad){
            case "Muy ligera":  valor = 1.3;
                     break;
            case "Ligera":  valor = 1.5;
                     break;
            case "Moderada": valor = 1.6;
                     break;
            case "Intensa":  valor = 1.9;
                     break;
      
            default: valor = 0.0;
                     break;
        }
         }
        return valor*CalculoDeGer();
      }
    
}




  




