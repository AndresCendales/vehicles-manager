/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooavanzadog62;

import pooavanzadog62.clases.clsAutomovil;
import pooavanzadog62.clases.clsAvion;

/**
 *
 * @author samur
 */
public class Interfaces {
    public static void main(String[] args) {
        clsAvion avion =new clsAvion("Gasolina de avion", 100, 500, "SAFS2145", "Requiere revisión");
        clsAutomovil mi_automovil = new clsAutomovil("Gasolina extra", 5, 10, "GHJD5478", "Averiado");
        System.out.println(avion.Revisar_octanaje());
        System.out.println(avion.Tipo_de_Transporte());
        System.out.println(mi_automovil.Revisar_octanaje());
        System.out.println(mi_automovil.Tipo_de_Transporte());
    }
}
