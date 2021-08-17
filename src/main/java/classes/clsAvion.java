/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author andres
 */
public class clsAvion extends clsVehiculo {
    private String tipo_combustible;
    private int numero_motores;

    public clsAvion(String tipo_combustible, int pasajeros, int combustible, String impronta_chasis, String estado_vehiculo, int numero_motores) {
        super(pasajeros, combustible, impronta_chasis, estado_vehiculo);
        this.tipo_combustible = tipo_combustible;
        this.numero_motores = numero_motores;
    }

    public String getTipo_combustible() {
        return tipo_combustible;
    }

    public void setTipo_combustible(String tipo_combustible) {
        this.tipo_combustible = tipo_combustible;
    }

    public void Volar() {
        System.out.println("El avion esta volando");
    }

    @Override
    public void Dirigirse(int calle, int carrera) {
        System.out.println("El avion se dirige al aeropuerto dirigido en la calle: " + calle + "con carrera " + carrera);
    }

    public void Dirigirse(String aeropuerto) {
        System.out.println("El avion se dirige al aeropuero: " + aeropuerto);
    }

    public void Dirigirse() {
        System.out.println("El avion no tiene destino conocido");
    }

    @Override
    public String tipoDeTransporte() {
        return "Pasajeros en vuelo";
    }

    @Override
    public int revisarOctanaje() {
        return 100;
    }

    public int getNumero_motores() {
        return numero_motores;
    }

    public void setNumero_motores(int numero_motores) {
        this.numero_motores = numero_motores;
    }
}
