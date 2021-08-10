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
public class PolimorfismoSobrescritura {
    public static void main(String[] args) {
        clsAutomovil mi_automovil = new clsAutomovil("Gasolina extra", 5, 10, "GHJD5478", "Averiado");
        clsAvion mi_avion = new clsAvion("GA", 100, 50, "POLI4364", "Funcionando");
        
        mi_avion.Dirigirse(13, 14);
        
        mi_automovil.Dirigirse(14, 45);
    }
}
