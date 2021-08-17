/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import classes.clsAutomovil;
import classes.clsVehiculo;

/**
 *
 * @author andres
 */
public class mdlAutomovil {
    public mdlAutomovil() {
        }
    
    
    public boolean CrearVehiculo(clsAutomovil automovil){
        try{
            //Conexión con la base de datos.
            return true;
        }catch (Exception e){
            return false;
        }
    }
    
    public boolean EditarVehiculo(clsAutomovil automovil){
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
        clsAutomovil automovil =null;
        try{
            //Conexión con la base de datos.
            return automovil;
        }catch (Exception e){
            return null;
        }
    }
    
}
