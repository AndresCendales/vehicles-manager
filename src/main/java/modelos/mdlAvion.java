/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import classes.clsAvion;
import classes.clsVehiculo;

/**
 *
 * @author andres
 */
public class mdlAvion {

    public mdlAvion() {
    }
    
    public boolean CrearVehiculo(clsAvion avion){
        try{
            //Conexión con la base de datos.
            return true;
        }catch (Exception e){
            return false;
        }
    }
    
    public boolean EditarVehiculo(clsAvion avion){
        try{
            //Conexión con la base de datos.
            return true;
        }catch (Exception e){
            return false;
        }
    }
    
    public boolean EliminarVehiculo(String placa){
        try{
            //Conexión con la base de datos.
            return true;
        }catch (Exception e){
            return false;
        }
    }
    
    public clsVehiculo ConsultarVehiculo(String impronta){
        clsAvion avion =null;
        try{
            //Conexión con la base de datos.
            return avion;
        }catch (Exception e){
            return null;
        }
    }
    
}
