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
public class clsAutomovil extends clsVehiculo {
    private String tipo_combustible;

    public clsAutomovil(String tipo_combustible, int pasajeros, int combustible, String impronta_chasis, String estado_vehiculo) {
        super(pasajeros, combustible, impronta_chasis, estado_vehiculo);
        this.tipo_combustible = tipo_combustible;
    }

    public String getTipo_combustible() {
        return tipo_combustible;
    }

    public void setTipo_combustible(String tipo_combustible) {
        this.tipo_combustible = tipo_combustible;
    }

    public void Rodar() {
        System.out.println("El automovil esta rodando");
    }

    @Override
    public void Dirigirse(int calle, int carrera){
        System.out.println(" el automovil se dirigue a" + calle + "con " + carrera);
    }
    @Override
    public String tipoDeTransporte(){
        return "Pasajeros en vehiculo terrestre";
    }

    @Override
    public int revisarOctanaje(){
        return 87;
    }
}
