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
public class clsMecanico {
    private String nombre;
    private String apellidos;
    private String certificado;

    public clsMecanico(String nombre, String apellidos, String certificado) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.certificado = certificado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getapellidos() {
        return apellidos;
    }

    public void setapellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public void repararVehiculo(clsVehiculo vehiculo) {
        vehiculo.setEstado_vehiculo("Reparado");
        System.out.println("El mecanico" + this.nombre + " esta reparando el vehiculo con la impronta de chasis " + vehiculo.getImpronta_chasis() + ", el estado es " + vehiculo.getEstado_vehiculo());
    }
}
