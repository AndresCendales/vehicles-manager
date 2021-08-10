/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooavanzadog62;

import java.util.ArrayList;
import pooavanzadog62.clases.clsAutomovil;
import pooavanzadog62.clases.clsMecanico;
import pooavanzadog62.clases.clsTaller_mecanico;

/**
 *
 * @author samur
 */
public class Agregación {
    public static void main(String[] args) {
        clsAutomovil mi_automovil = new clsAutomovil("GC", 5, 10, "KLMF3241", "Averiado");
        clsMecanico mecanico = new clsMecanico("Guido", "Bonferroni", "Mecánico Automotriz");
        clsMecanico mecanico1 = new clsMecanico("Santiago", "Murillo", "Mecánico Automotriz");
        clsMecanico mecanico2 = new clsMecanico("Hugo", "Pato", "Mecánico Automotriz");        
        clsMecanico mecanico3 = new clsMecanico("Luis", "Pato", "Mecánico Automotriz");
        
        ArrayList<clsMecanico> mecanicos = new ArrayList();
        mecanicos.add(mecanico);
        mecanicos.add(mecanico1);
        mecanicos.add(mecanico2);     

        
        clsTaller_mecanico taller = new clsTaller_mecanico("Reparamos de todo", "Route 66", "300000000", mecanicos);
        mi_automovil.setTaller(taller);
        
        System.out.println("El taller de mi_vehiculo es: " + mi_automovil.getTaller().getNombre()+ " ubicado en: " + mi_automovil.getTaller().getDireccion());
        
        mecanico.Reparar_vehiculo(mi_automovil);
        
        System.out.println("mi_automovil se encuentra: " + mi_automovil.getEstado_vehiculo()+" y se encuentra en la dirección: "+ mi_automovil.getTaller().getDireccion());

        taller.Contratar_mecanico(mecanico3);
        taller.Informacion_mecanico(mecanico3);
        taller.Actualizar_mecanico(mecanico3, "Mecánico Toyota");
        taller.Informacion_mecanico(mecanico3);
        taller.Despedir_mecanico(mecanico3);
        
        for (clsMecanico m : taller.getMecanicos()){
            System.out.println(m.getNombre()+"\n");
        }
        }
        
        
    
}
