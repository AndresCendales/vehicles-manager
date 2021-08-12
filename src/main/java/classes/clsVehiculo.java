/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import Interfaces.ITipoDeTransporte;
import Interfaces.IVehiculosGasolina;

/**
 *
 * @author andres
 */
public class clsVehiculo implements ITipoDeTransporte, IVehiculosGasolina {
       private int pasajeros;
    private int combustible;
    private String impronta_chasis;
    private String estado_vehiculo;
    private clsTallerMecanico taller;

    public clsVehiculo(int pasajeros, int combustible, String impronta_chasis, String estado_vehiculo) {
        this.pasajeros = pasajeros;
        this.combustible = combustible;
        this.impronta_chasis = impronta_chasis;
        this.estado_vehiculo = estado_vehiculo;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    public int getCombustible() {
        return combustible;
    }

    public void setCombustible(int combustible) {
        this.combustible = combustible;
    }

    public String getImpronta_chasis() {
        return impronta_chasis;
    }

    public void setImpronta_chasis(String impronta_chasis) {
        this.impronta_chasis = impronta_chasis;
    }

    public String getEstado_vehiculo() {
        return estado_vehiculo;
    }

    public void setEstado_vehiculo(String estado_vehiculo) {
        this.estado_vehiculo = estado_vehiculo;
    }

    public void encender() {
        System.out.println("el vehiculo esta encendido");
    }

    public void acelerar() {
        System.out.println("el vehiculo esta acelerando");
    }

    public int Frenar() {
        System.out.println("el vehiculo se detuvo");
        return 0;
    }

    public void Dirigirse(int calle, int carrera) {
        System.out.println(" el vehiculo se dirigue a" + calle + "con " + carrera);
    }

    public float Velocidad_final(float taza_aceleracion, float tiempo) {
        System.out.println("La velocidad final al cabo de: " + tiempo + " segundos será: " + taza_aceleracion * tiempo);
        /*float Velocidad_final=taza_aceleracion*tiempo;
        return Velocidad_final; */
        return taza_aceleracion * tiempo;
    }


    public clsTallerMecanico getTaller() {
        return this.taller;
    }

    public void setTaller(clsTallerMecanico taller) {
        this.taller = taller;
    }

    @Override
    public String tipoDeTransporte() {
        return "pasajeros";
    }

    @Override
    public int revisarOctanaje() {
        return 0;
    }
}
