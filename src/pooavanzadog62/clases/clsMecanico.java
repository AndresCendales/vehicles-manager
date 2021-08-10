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
public class clsMecanico {
    private String nombre;
    private String apellidos;
    private String certificación;

    public clsMecanico(String nombre, String apellidos, String certificación) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.certificación = certificación;
    }
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the certificación
     */
    public String getCertificación() {
        return certificación;
    }

    /**
     * @param certificación the certificación to set
     */
    public void setCertificación(String certificación) {
        this.certificación = certificación;
    }
    
    public void Reparar_vehiculo(clsVehiculo vehiculo){
        vehiculo.setEstado_vehiculo("Reparado");
        System.out.println("El mecánico " + this.nombre + " está reparando el vehiculo con impronta de chasis " + vehiculo.getImpronta_chasis() + ", el estado de este vehiculo es: "+vehiculo.getEstado_vehiculo());
    }
}
