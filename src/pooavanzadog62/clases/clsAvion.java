/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooavanzadog62.clases;

/**
 *
 * @author samur
 */
public class clsAvion extends clsVehiculo{
    private String tipo_combustible;
    /*clsAutomovil carro;*/

    public clsAvion(String tipo_combustible, int pasajeros, int combustible, String impronta_chasis, String estado_vehiculo) {
        super(pasajeros, combustible, impronta_chasis, estado_vehiculo);
        this.tipo_combustible = tipo_combustible;
    }
    
    /**
     * @return the tipo_combustible
     */
    public String getTipo_combustible() {
        return tipo_combustible;
    }

    /**
     * @param tipo_combustible the tipo_combustible to set
     */
    public void setTipo_combustible(String tipo_combustible) {
        this.tipo_combustible = tipo_combustible;
    }
    
    public void Volar(){
        System.out.println("El avión está volando");
    }
    
    public void Dirigirse(String aeropuerto){
        System.out.println("El avión se dirige al aeropuerto: " + aeropuerto);
    }
    
    public void Dirigirse(){
        System.out.println("El avión no tiene destino conocido");
    }
    
    @Override
    public String Dirigirse(int calle, int carrera){
        System.out.println("El avión se dirige al aeropuerto ubicado en la dirección calle: "+calle+" carrera: "+carrera );
        return "El avión se dirige al aeropuerto ubicado en la dirección calle: "+calle+" carrera: "+carrera;
    }

    
    @Override
    public String Tipo_de_Transporte(){        
        return "Pasajeros en vuelo";
    }
    
    @Override
    public int Revisar_octanaje(){
        return 100;
    }
    /*public clsAutomovil Retornar_auto(){
        clsAutomovil micarro = new clsAutomovil("gasolina", 0, 0, "safdia134", "bien");
        return micarro;
    }*/
}
