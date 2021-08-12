/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import classes.clsAutomovil;
import classes.clsAvion;
import classes.clsVehiculo;
import modelos.mdlAutomovil;
import modelos.mdlAvion;
import modelos.mdlVehiculo;

/**
 *
 * @author andres
 */
public class ctrlVehiculo {
    private mdlAutomovil mdlAutomovil;
    private mdlAvion mdlAvion;
    private mdlVehiculo mdlVehiculo;

    public ctrlVehiculo() {
        this.mdlAutomovil = new mdlAutomovil();
        this.mdlAvion =new mdlAvion();
        this.mdlVehiculo = new mdlVehiculo();
    }
    
    public boolean CrearVehiculo(clsVehiculo vehiculo){
        try{
            if (vehiculo.tipoDeTransporte().equals("Pasajeros en vuelo"))  {
                this.mdlAvion.CrearVehiculo((clsAvion) vehiculo);
            }else if (vehiculo.tipoDeTransporte().equals("Pasajeros en vehiculo terrestre")){
                this.mdlAutomovil.CrearVehiculo((clsAutomovil) vehiculo);
            }else{
                this.mdlVehiculo.CrearVehiculo(vehiculo);
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }
    
    public boolean EditarVehiculo(clsVehiculo vehiculo){
        try{
            //Falta código
            return true;
        }catch (Exception e){
            return false;
        }
    }
    
    public boolean EliminarVehiculo(clsVehiculo vehiculo){
        try{
            //Falta código
            return true;
        }catch (Exception e){
            return false;
        }
    }
    
    public clsVehiculo ConsultarVehiculo(String impronta_vehiculo,String tipo_vehiculo){
        clsVehiculo vehiculo = null;
        try{
            //Falta código
            return vehiculo;
        }catch (Exception e){
            return null;
        }
    }
}