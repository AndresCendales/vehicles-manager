/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import classes.clsVehiculo;

/**
 *
 * @author andres
 */
public class mdlVehiculo {

    public mdlVehiculo() {
    }
    
        
    public boolean CrearVehiculo(clsVehiculo vehiculo){
        try{
            //Conexión con la base de datos.
            return true;
        }catch (Exception e){
            return false;
        }
    }
    
    public boolean EditarVehiculo(clsVehiculo vehiculo){
        try{
            //Conexión con la base de datos.
            return true;
        }catch (Exception e){
            return false;
        }
    }
    
    public boolean EliminarVehiculo(clsVehiculo vehiculo){
        try{
            //Conexión con la base de datos.
            return true;
        }catch (Exception e){
            return false;
        }
    }
    
    public clsVehiculo ConsultarVehiculo(String impronta){
        clsVehiculo vehiculo =null;
        try{
            //Conexión con la base de datos.
            return vehiculo;
        }catch (Exception e){
            return null;
        }
    }
}