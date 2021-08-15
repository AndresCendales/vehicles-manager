/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;

public class clsTallerMecanico extends abstTalleres {
    private String nombre;
    private String direccion;
    private String telefono;
    private int nit;
    private ArrayList<clsMecanico> Mecanicos;

    public clsTallerMecanico(String nombre, String telefono, String direccion, ArrayList<clsMecanico> mecanicos, int nit) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.Mecanicos = mecanicos;
        this.nit = nit;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public void Recibir_vehiculo(clsVehiculo vehiculo) {
        System.out.println("El vehiculo con impronta de chasis: " + vehiculo.getImpronta_chasis() + " ha sido recibido en el taller.");
    }

    @Override
    public String getTipoMantenimiento() {
        return "Mecanico";
    }

    public ArrayList<clsMecanico> getMecanicos() {
        return this.Mecanicos;
    }

    public void setMecanicos(ArrayList<clsMecanico> mecanicos) {
        this.Mecanicos = mecanicos;
    }


    //Realización del CRUD de mecánicos
    //Create
    //Se puede asimilar a la contratación de mecánicos

    public void Contratar_mecanico(clsMecanico mecanico) {
        this.Mecanicos.add(mecanico);
    }

    //Read
    //Se puede asimilar con consultar la info de un mecánico

    public void Informacion_mecanico(clsMecanico mecanico) {
        clsMecanico mecanico_auxiliar = this.Mecanicos.get(Mecanicos.indexOf(mecanico));
        System.out.println("Nombre: " + mecanico_auxiliar.getNombre() + "\n" +
                "Apellido: " + mecanico_auxiliar.getapellidos() + "\n" +
                "Certificación: " + mecanico_auxiliar.getCertificado());
    }

    //Update
    //Actualizar información de un mecánico


    public void Actualizar_mecanico(clsMecanico mecanico, String certificado) {
        clsMecanico mecanico_auxiliar = Mecanicos.get(Mecanicos.indexOf(mecanico));
        mecanico_auxiliar.setCertificado(certificado);
        Mecanicos.set(Mecanicos.indexOf(mecanico), mecanico_auxiliar);
    }

    //Delete
    //Puede asociarse a despedir mecánico o aceptar su renuncia

    public void Aceptar_renuncia_mecanico(clsMecanico mecanico) {
        this.Mecanicos.remove(mecanico);
    }

    public void Despedir_mecanico(clsMecanico mecanico) {
        this.Mecanicos.remove(mecanico);
    }

    public String getIdsMecanicos(){
        StringBuilder ids;
        ids = new StringBuilder();
        for (clsMecanico mecanico: this.Mecanicos){
            ids.append(mecanico.getIdentificacion()).append(",");
        }
        return ids.toString();
    }

}