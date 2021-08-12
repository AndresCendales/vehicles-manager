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
public abstract class abstTalleres {
    private String datos;
    public abstract String getTipoMantenimiento();

    public String getInformacionTaller() {
        return "los datos del taller son: " + this.getDatos();
    }

    public String getDatos() {
        return this.datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }
}

