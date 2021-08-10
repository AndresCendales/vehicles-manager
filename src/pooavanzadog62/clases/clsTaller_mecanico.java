/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooavanzadog62.clases;

import java.util.ArrayList;

/**
 *
 * @author samur
 */
public class clsTaller_mecanico extends abstTalleres{
    private String nombre;
    private String direccion;
    private String telefono;
    //private clsMecanico mecanico;
    private ArrayList<clsMecanico> mecanicos;

    public clsTaller_mecanico(String nombre, String direccion, String telefono, ArrayList<clsMecanico> mecanicos) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.mecanicos = mecanicos;
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
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public void Recibir_vehiculo(clsVehiculo vehiculo){
        System.out.println("El vehiculo con impronta de chasis: " + vehiculo.getImpronta_chasis()+" ha sido recibido en el taller.");
    }
    
    @Override
    public String getTipo_mantenimiento(){
        return "Mecánico";
    }

    /**
     * @return the mecanicos
     */
    public ArrayList<clsMecanico> getMecanicos() {
        return mecanicos;
    }

    /**
     * @param mecanicos the mecanicos to set
     */
    public void setMecanicos(ArrayList<clsMecanico> mecanicos) {
        this.mecanicos = mecanicos;
    }
    
    //Realización del CRUD de mecánicos
    //Create
    //Se puede asimilar a la contratación de mecánicos
    
    public void Contratar_mecanico(clsMecanico mecanico){
        this.mecanicos.add(mecanico);        
    }
    
    //Read
    //Se puede asimilar con consultar la info de un mecánico
    
    public void Informacion_mecanico(clsMecanico mecanico){
        clsMecanico mecanico_auxiliar = this.mecanicos.get(mecanicos.indexOf(mecanico));
        System.out.println("Nombre: " + mecanico_auxiliar.getNombre() +"\n"+
                "Apellido: " + mecanico_auxiliar.getApellidos() + "\n"+
                "Certificación: " + mecanico_auxiliar.getCertificación());
    }
    
    //Update
    //Actualizar información de un mecánico
    
    
    public void Actualizar_mecanico(clsMecanico mecanico, String certificado){
        clsMecanico mecanico_auxiliar = mecanicos.get(mecanicos.indexOf(mecanico));
        mecanico_auxiliar.setCertificación(certificado);
        mecanicos.set(mecanicos.indexOf(mecanico), mecanico_auxiliar);
    }
    
    //Delete
    //Puede asociarse a despedir mecánico o aceptar su renuncia
    
    public void Aceptar_renuncia_mecanico(clsMecanico mecanico){
        this.mecanicos.remove(mecanico);
    }
    
    public void Despedir_mecanico(clsMecanico mecanico){
        this.mecanicos.remove(mecanico);
    }
}
