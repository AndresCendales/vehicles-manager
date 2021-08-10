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
public abstract class abstTalleres {
    private String datos;
    
    
    public abstract String getTipo_mantenimiento();
    
    
   public String getInformacion_taller(){
       return "Los datos del taller son: " + this.getDatos();
   }

    /**
     * @return the datos
     */
    public String getDatos() {
        return datos;
    }

    /**
     * @param datos the datos to set
     */
    public void setDatos(String datos) {
        this.datos = datos;
    }
    
    
}
