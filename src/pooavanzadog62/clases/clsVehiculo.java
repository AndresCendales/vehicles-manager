/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooavanzadog62.clases;

import pooavanzadog62.interfaces.ITipo_de_transporte;
import pooavanzadog62.interfaces.IVehiculos_gasolina;

/**
 *
 * @author samur
 */
public class clsVehiculo implements ITipo_de_transporte,IVehiculos_gasolina{
    //Atributos
    private int pasajeros;
    private int combustible;
    private String impronta_chasis;
    private String estado_vehiculo;//En funcionamiento averiado/ boolean true false/ char a, r, c, v
    private clsTaller_mecanico taller;        
    //Constructor

    public clsVehiculo(int pasajeros, int combustible, String impronta_chasis, String estado_vehiculo) {
        this.pasajeros = pasajeros;
        this.combustible = combustible;
        this.impronta_chasis = impronta_chasis;
        this.estado_vehiculo = estado_vehiculo;
    } 
    
    //Métodos
    //Setter y Getter
    
    /**
     * @return the pasajeros
     */
    public int getPasajeros() {
        return pasajeros;
    }

    /**
     * @param pasajeros the pasajeros to set
     */
    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    /**
     * @return the combustible
     */
    public int getCombustible() {
        return combustible;
    }

    /**
     * @param combustible the combustible to set
     */
    public void setCombustible(int combustible) {
        this.combustible = combustible;
    }

    /**
     * @return the impronta_chasis
     */
    public String getImpronta_chasis() {
        return impronta_chasis;
    }

    /**
     * @param impronta_chasis the impronta_chasis to set
     */
    public void setImpronta_chasis(String impronta_chasis) {
        this.impronta_chasis = impronta_chasis;
    }

    /**
     * @return the estado_vehiculo
     */
    public String getEstado_vehiculo() {
        return estado_vehiculo;
    }

    /**
     * @param estado_vehiculo the estado_vehiculo to set
     */
    public void setEstado_vehiculo(String estado_vehiculo) {
        this.estado_vehiculo = estado_vehiculo;
    }
    
    //Otros Métodos
    
    public void Encender(){
        System.out.println("El vehiculo está encendido");
    }
    
    public void Acelerar(int taza_aceleracion){
        System.out.println("El vehiculo está acelerando a: " +taza_aceleracion + " Km/s2");        
    }
    
    public int Frenar(){
        System.out.println("El vehiculo se detuvo");
        return 0;
    }
    
    public String Dirigirse(int calle, int carrera){
        System.out.println("El vehiculo se dirige a la calle: "+calle+" con carrera: "+carrera);
        return "El vehiculo va en camino";
    }
    
    public float Velocidad_final(float taza_aceleracion,float tiempo){
        System.out.println("La velocidad final al cabo de: " + tiempo + " segundos será: " + taza_aceleracion*tiempo);
        /*float Velocidad_final=taza_aceleracion*tiempo;
        return Velocidad_final; */
        return taza_aceleracion*tiempo;
    }

    /**
     * @return the taller
     */
    public clsTaller_mecanico getTaller() {
        return taller;
    }

    /**
     * @param taller the taller to set
     */
    public void setTaller(clsTaller_mecanico taller) {
        this.taller = taller;
    }

    @Override
    public String Tipo_de_Transporte(){
        return "Pasajeros";
    }
    
    @Override
    public int Revisar_octanaje(){
        return 0;
    }
}
