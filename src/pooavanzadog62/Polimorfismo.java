/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooavanzadog62;

import java.util.ArrayList;
import pooavanzadog62.clases.clsAvion;
import pooavanzadog62.clases.clsMecanico;
import pooavanzadog62.clases.clsTaller_mecanico;

/**
 *
 * @author samur
 */
public class Polimorfismo {
    public static void main(String[] args) {
        clsAvion avion =new clsAvion("Gasolina de avion", 100, 500, "SAFS2145", "Requiere revisión");
        clsMecanico mecanico1 = new clsMecanico("Guido", "Bonferroni", "Mecánico Automotriz");
        clsMecanico mecanico2 = new clsMecanico("Guido", "Bonferroni", "Mecánico Automotriz");        
        clsMecanico mecanico3 = new clsMecanico("Guido", "Bonferroni", "Mecánico Automotriz");
        
        ArrayList<clsMecanico> mecanicos = new ArrayList();
        
        clsTaller_mecanico taller = new clsTaller_mecanico("Reparamos de todo", "Route 66", "300000000", mecanicos);
        
        
        taller.Recibir_vehiculo(avion);
        //mecanico.Reparar_vehiculo(avion);//Polimorfismo Puro
        
        
        //System.out.println(mecanico.getNombre()+mecanico.getApellidos()+mecanico.getCertificación());
        System.out.println(avion.getTipo_combustible() + avion.getImpronta_chasis() + avion.getCombustible());
        
        System.out.println(taller.getInformacion_taller());
        System.out.println(taller.getTipo_mantenimiento());
        
        taller.setDatos(taller.getNombre()+" "+taller.getDireccion()+" "+taller.getTelefono());
        System.out.println(taller.getInformacion_taller());
    }
}
