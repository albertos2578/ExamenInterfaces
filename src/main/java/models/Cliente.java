/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author AlbertoMoralesGálvez
 */

import java.io.Serializable;

import javafx.collections.ObservableList;
/**
 *
 * @author AlbertoMoralesGálvez
 */

public class Cliente implements Serializable {
         private int edad;
	     private String actividad;
     private String nombre;
     private double get;
  private double ger;
    private String sexo;
     private int  altura;
   private double  peso;

    public Cliente() {
    }

 

    public double getGet() {
        return get;
    }

    public Cliente(int edad, String actividad, String nombre, double get, double ger, String sexo, int altura, double peso) {
        this.edad = edad;
        this.actividad = actividad;
        this.nombre = nombre;
        this.get = get;
        this.ger = ger;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
    }

    public void setGet(double get) {
        this.get = get;
    }

    public double getGer() {
        return ger;
    }

    public void setGer(double ger) {
        this.ger = ger;
    }

    @Override
    public String toString() {
        return "Cliente{" + "edad=" + edad + ", actividad=" + actividad + ", nombre=" + nombre + ", get=" + get + ", ger=" + ger + ", sexo=" + sexo + ", altura=" + altura + ", peso=" + peso + '}';
    }
  
 

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
   
      
        }
            
