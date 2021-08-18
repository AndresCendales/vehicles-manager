/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import classes.clsAutomovil;
import classes.clsVehiculo;

import java.sql.*;

/**
 * @author andres
 */
public class mdlVehiculo {
    datosJDBC datosJDBC;

    public mdlVehiculo() {
        this.datosJDBC = new datosJDBC();
    }
    
    public boolean CrearVehiculo(clsVehiculo vehiculo) {
        try (Connection connection = DriverManager.getConnection(datosJDBC.getUrl(), datosJDBC.getUser(), datosJDBC.getPassword())) {
            String query = "INSERT INTO tb_vehiculo(impronta_chasis,pasajeros,combustible,estado)VALUES(?,?,?,?)";
            PreparedStatement statementVehiculo = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statementVehiculo.setString(1, vehiculo.getImpronta_chasis());
            statementVehiculo.setInt(2, vehiculo.getPasajeros());
            statementVehiculo.setInt(3, vehiculo.getCombustible());
            statementVehiculo.setString(4, vehiculo.getEstado_vehiculo());

            int filaInsertada = statementVehiculo.executeUpdate();

            return filaInsertada > 0;
        } catch (SQLException e) {
            System.out.println("Error en la conexion con la base de datos: " + e.getMessage());
            return false;
        }
    }

    public boolean EditarVehiculo(clsVehiculo vehiculo) {
        try (Connection connection = DriverManager.getConnection(datosJDBC.getUrl(), datosJDBC.getUser(), datosJDBC.getPassword())) {
            String query = "UPDATE tb_vehiculo SET pasajeros=?,combustible=?,estado=? WHERE impronta_chasis=?";
            PreparedStatement statementVehiculo = connection.prepareStatement(query);
            statementVehiculo.setInt(1, vehiculo.getPasajeros());
            statementVehiculo.setInt(2, vehiculo.getCombustible());
            statementVehiculo.setString(3, vehiculo.getEstado_vehiculo());
            statementVehiculo.setString(4, vehiculo.getImpronta_chasis());
            int filas_modificadas = statementVehiculo.executeUpdate();
            return filas_modificadas > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean EliminarVehiculo(String impronta) {
        try (Connection connection = DriverManager.getConnection(datosJDBC.getUrl(), datosJDBC.getUser(), datosJDBC.getPassword())) {
            String query = "DELETE FROM tb_vehiculo WHERE impronta_chasis = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, impronta);
            int filas_modificadas = statement.executeUpdate();
            if (filas_modificadas > 0) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public clsVehiculo ConsultarVehiculo(String impronta) {
        clsVehiculo vehiculo = null;
        try (Connection connection = DriverManager.getConnection(datosJDBC.getUrl(), datosJDBC.getUser(), datosJDBC.getPassword())) {
            String query = "SELECT * FROM tb_vehiculo WHERE impronta_chasis=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, impronta);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String impronta_chasis = resultSet.getString(2);
                int pasajeros = resultSet.getInt(3);
                int combustible = resultSet.getInt(4);
                String estado_vehiculo = resultSet.getString(5);
                vehiculo = new clsVehiculo(pasajeros,combustible,impronta_chasis,estado_vehiculo);
            }
            return vehiculo;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}