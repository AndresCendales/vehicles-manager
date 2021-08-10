/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooavanzadog62;

import pooavanzadog62.clases.clsAvion;

/**
 *
 * @author samur
 */
public class PolimorfismoSobrecarga {
    public static void main(String[] args) {
        clsAvion avion = new clsAvion("Gasolina de avion", 50, 100, "ATVS1250", "En funcionamiento");
        
        
        avion.Dirigirse(12, 54);
        avion.Dirigirse();
        avion.Dirigirse("Madrid Barajas");
        
        
    }
}
