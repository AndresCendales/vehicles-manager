/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooavanzadog62;

import java.util.Scanner;
import pooavanzadog62.clases.clsAutomovil;
import pooavanzadog62.clases.clsAvion;
import pooavanzadog62.clases.clsVehiculo;

/**
 *
 * @author samur
 */
public class POOAvanzadoG62 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        clsVehiculo automovil = new clsVehiculo(5, 10, "ABCD1234", "En funcionamiento");
        
        automovil.Encender();
        automovil.Acelerar(5);
        automovil.Frenar();
        int vf = automovil.Frenar();
        System.out.println(vf);
        automovil.Dirigirse(12, 14);
        String mensaje = automovil.Dirigirse(12, 45);
        System.out.println(mensaje);
        float velocidad_final = automovil.Velocidad_final(5.3f, 10.3f);
        System.out.println(velocidad_final);
        automovil.setCombustible(3);
        System.out.println("Al vehiculo le quedan: "+ automovil.getCombustible()+" galones");
        
        clsVehiculo barco = new clsVehiculo(700, 1000, "ERTY2943", "En mantenimietno");
        
        clsAutomovil automovil_1 = new clsAutomovil("Gasolina corriente", 5, 10, "LDSAMF1829", "Averiado");
        automovil_1.Encender();
        automovil_1.Acelerar(3);
        automovil_1.Frenar();
        automovil_1.Dirigirse(12, 23);
        automovil_1.Velocidad_final(14,2);
        automovil_1.Rodar();
        
        System.out.println(automovil_1.getTipo_combustible());
        
        
        clsAvion avion = new clsAvion("Gasolina avión", 100, 500, "JALF1235", "En funcionamiento");
        
        avion.Encender();
        //...//
        
        avion.Volar();
        
        avion.setTipo_combustible("Gasolina para carro");
        System.out.println(avion.getTipo_combustible());
        
       
        






//clsAutomovil otrocarro = avion.Retornar_auto();
        
        
        
        
        
        /*
        final int ESTO_ES_CONSTATE=10;
        
        Scanner lector = new Scanner(System.in);
        System.out.print("Candidad de dinero que desea enviar: ");
        int cantidadDinero = lector.nextInt();
        //lector.nextLine();
        String cadenaForma = lector.nextLine();
        //lector.nextLine(); //Para "limpiar" el lector
        System.out.print(
        "Forma de envío: consignación, transferencia o giro ");
        
        //char formaEnvio = cadenaForma.charAt(0);
        
        
        */
        /*
        Scanner lector = new Scanner(System.in);
        System.out.print("Candidad de dinero que desea enviar: ");
        double cantidadDinero = lector.nextDouble();
        lector.nextLine(); //Para "limpiar" el lector
        System.out.print(
        "Forma de envío: consignación, transferencia o giro ");
        String cadenaForma = lector.nextLine();
        char formaEnvio = cadenaForma.charAt(0);
        */
    }
    
}
