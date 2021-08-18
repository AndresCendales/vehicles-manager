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

import java.util.ArrayList;

/**
 * @author andres
 */
public class ctrlVehiculo {
    private mdlAutomovil mdlAutomovil;
    private mdlAvion mdlAvion;
    private mdlVehiculo mdlVehiculo;

    public ctrlVehiculo() {
        this.mdlAutomovil = new mdlAutomovil();
        this.mdlAvion = new mdlAvion();
        this.mdlVehiculo = new mdlVehiculo();
    }

    public boolean CrearVehiculo(clsVehiculo vehiculo) {
        try {
            if (vehiculo.tipoDeTransporte().equals("Pasajeros en vuelo")) {
                this.mdlAvion.CrearAvion((clsAvion) vehiculo);
            } else if (vehiculo.tipoDeTransporte().equals("Pasajeros en vehiculo terrestre")) {
                this.mdlAutomovil.CrearAutomovil((clsAutomovil) vehiculo);
            } else {
                this.mdlVehiculo.CrearVehiculo(vehiculo);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public clsVehiculo ConsultarVehiculo(String impronta_vehiculo, String tipo_vehiculo) {
        clsVehiculo vehiculo = null;
        try {
            if (tipo_vehiculo.equals("Pasajeros en vuelo")) {
                vehiculo = this.mdlAvion.ConsultarAvion(impronta_vehiculo);
                return vehiculo;
            } else if (tipo_vehiculo.equals("Pasajeros en vehiculo terrestre")) {
                vehiculo = this.mdlAutomovil.ConsultarAutomovil(impronta_vehiculo);
                return vehiculo;
            } else {
                vehiculo = this.mdlVehiculo.ConsultarVehiculo(impronta_vehiculo);
                return vehiculo;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<clsVehiculo> ConsultarVehiculos(){
        ArrayList<clsVehiculo> vehiculos = new ArrayList<>();
        try {
            this.mdlVehiculo.ConsultarVehiculos(vehiculos);
            this.mdlAvion.ConsultarAviones(vehiculos);
            this.mdlAutomovil.ConsultarAutomoviles(vehiculos);
            return vehiculos;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean EditarVehiculo(clsVehiculo vehiculo) {
        boolean bandera = false;
        try {
            if (vehiculo.tipoDeTransporte().equals("Pasajeros en vuelo")) {
                bandera = this.mdlAvion.EditarAvion((clsAvion) vehiculo);
                return bandera;
            } else if (vehiculo.tipoDeTransporte().equals("Pasajeros en vehiculo terrestre")) {
                bandera = this.mdlAutomovil.EditarAutomovil((clsAutomovil) vehiculo);
                return bandera;
            } else {
                bandera = this.mdlVehiculo.EditarVehiculo(vehiculo);
                return bandera;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean EliminarVehiculo(String improntaVehiculo, String tipoTransporte) {
        boolean bandera = false;
        try {
            if (tipoTransporte == "Pasajeros en vuelo") {
                bandera = this.mdlAvion.EliminarAvion(improntaVehiculo);
                return bandera;
            } else if (tipoTransporte == "Pasajeros en vehiculo terrestre") {
                bandera = this.mdlAutomovil.EliminarAutomovil(improntaVehiculo);
                return bandera;
            } else {
                bandera = this.mdlVehiculo.EliminarVehiculo(improntaVehiculo);
                return bandera;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
