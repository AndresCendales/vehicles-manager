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
public class clsAutomovil extends clsVehiculo{
    private String tipo_combustible;

    public clsAutomovil(String tipo_combustible, int pasajeros, int combustible, String impronta_chasis, String estado_vehiculo) {
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
    
    public void Rodar(){
        System.out.println("El automóvil está rodando");
    }
    
    @Override
    public String Dirigirse(int calle, int carrera){
        System.out.println("El automovil se dirige a la calle: "+calle+" con carrera: "+carrera);
        return "El automovil va en camino";
    }
    
    @Override
    public String Tipo_de_Transporte(){        
        return "Pasajeros en vehiculo terrestre";
    }
    
    @Override
    public int Revisar_octanaje(){
        return 87;
    }
}
