/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import classes.clsAvion;
import classes.clsVehiculo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author andres
 */
public class mdlAvion {
    datosJDBC datosJDBC;
    public mdlAvion() {
        this.datosJDBC = new datosJDBC();
    }
    
    public boolean CrearAvion(clsAvion avion) throws ClassNotFoundException {
        //Class.forName("com.mysql.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(datosJDBC.getUrl(),datosJDBC.getUser(),datosJDBC.getPassword())){
            String query = "INSERT INTO tb_vehiculo(impronta_chasis,pasajeros,combustible,estado_vehiculo)VALUES(?,?,?,?)";
            PreparedStatement statementVehiculo = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statementVehiculo.setString(1,avion.getImpronta_chasis());
            statementVehiculo.setInt(2, avion.getPasajeros());
            statementVehiculo.setInt(3, avion.getCombustible());
            statementVehiculo.setString(4, avion.getEstado_vehiculo());

            int filaInsertada = statementVehiculo.executeUpdate();

            if (filaInsertada>0){
                ResultSet llaves_generadas = statementVehiculo.getGeneratedKeys();
                if (llaves_generadas.next()){
                    int id_vehiculo = llaves_generadas.getInt(1);
                    query = "INSERT INTO tb_avion (tipo_combustible,id_vehiculo) VALUES (?,?,?)";
                    PreparedStatement statementAvion = connection.prepareStatement(query);
                    statementAvion.setString(1, avion.getTipo_combustible());
                    statementAvion.setInt(2,id_vehiculo);
                    filaInsertada = statementAvion.executeUpdate();
                    if (filaInsertada>0) {
                        return true;
                    }
                }
            }
            System.out.println("No registro el avion pero si el vehiculo");
            return false;
        }catch (SQLException e){
            System.out.println("Error en la conexion con la base de datos: " + e.getMessage());
            return false;
        }
    }
    
    public boolean EditarAvion(clsAvion avion){
        try{
            //Conexión con la base de datos.
            return true;
        }catch (Exception e){
            return false;
        }
    }
    
    public boolean EliminarAvion(String placa){
        try{
            //Conexión con la base de datos.
            return true;
        }catch (Exception e){
            return false;
        }
    }
    
    public clsVehiculo ConsultarAvion(String impronta){
        clsAvion avion =null;
        try{
            //Conexión con la base de datos.
            return avion;
        }catch (Exception e){
            return null;
        }
    }
    
}
