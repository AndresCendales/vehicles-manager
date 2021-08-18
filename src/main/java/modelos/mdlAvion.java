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
import java.util.ArrayList;

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
        try(Connection connection = DriverManager.getConnection(datosJDBC.getUrl(),datosJDBC.getUser(),datosJDBC.getPassword())){
            String query = "INSERT INTO tb_vehiculo(impronta_chasis,pasajeros,combustible,estado)VALUES(?,?,?,?)";
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
                    query = "INSERT INTO tb_avion (tipo_combustible,numero_motores,id_vehiculo) VALUES (?,?,?)";
                    PreparedStatement statementAvion = connection.prepareStatement(query);
                    statementAvion.setString(1, avion.getTipo_combustible());
                    statementAvion.setInt(2,avion.getNumero_motores());
                    statementAvion.setInt(3,id_vehiculo);
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
        try(Connection connection = DriverManager.getConnection(datosJDBC.getUrl(),datosJDBC.getUser(),datosJDBC.getPassword())){
            //Editar los datos de la tb_vehiculo
            String query = "UPDATE tb_vehiculo SET pasajeros=?,combustible=?,estado=? WHERE impronta_chasis=?";
            PreparedStatement statementVehiculo = connection.prepareStatement(query);
            statementVehiculo.setInt(1, avion.getPasajeros());
            statementVehiculo.setInt(2, avion.getCombustible());
            statementVehiculo.setString(3, avion.getEstado_vehiculo());
            statementVehiculo.setString(4, avion.getImpronta_chasis());
            int filas_modificadas = statementVehiculo.executeUpdate();
            //Consulta intermedia para recuperar el id de la tb_vehiculo
            if (filas_modificadas>0){
                query = "SELECT id FROM tb_vehiculo WHERE impronta_chasis = ?";
                PreparedStatement statementConsulta = connection.prepareStatement(query);
                statementConsulta.setString(1, avion.getImpronta_chasis());
                ResultSet resultado = statementConsulta.executeQuery();
                if (resultado.next()){
                    int id_vehiculo = resultado.getInt(1);
                    //Editar los datos de la tb_avión
                    query = "UPDATE tb_avion SET tipo_combustible=?, numero_motores=? WHERE id_vehiculo=?";
                    PreparedStatement statementAvion = connection.prepareStatement(query);
                    statementAvion.setString(1, avion.getTipo_combustible());
                    statementAvion.setInt(2, avion.getNumero_motores());
                    statementAvion.setInt(3, id_vehiculo);
                    filas_modificadas = statementAvion.executeUpdate();
                    if (filas_modificadas>0){
                        return true;
                    }
                }
            }
            return false;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean EliminarAvion(String placa){
        try(Connection connection = DriverManager.getConnection(datosJDBC.getUrl(),datosJDBC.getUser(),datosJDBC.getPassword())){
            //Conexión con la base de datos.
            String query = "DELETE FROM tb_vehiculo WHERE impronta_chasis = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, placa);
            int filas_modificadas = statement.executeUpdate();
            if (filas_modificadas>0){
                return true;
            }
            return false;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public clsVehiculo ConsultarAvion(String impronta){
        clsAvion avion =null;
        try(Connection connection = DriverManager.getConnection(datosJDBC.getUrl(),datosJDBC.getUser(),datosJDBC.getPassword())){
            String query = "SELECT * FROM tb_vehiculo INNER JOIN tb_avion ON tb_vehiculo.id=tb_avion.id_vehiculo WHERE impronta_chasis=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, impronta);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                int id = resultSet.getInt(1);
                String impronta_chasis = resultSet.getString(2);
                int pasajeros = resultSet.getInt(3);
                int combustible = resultSet.getInt(4);
                String estado_vehiculo = resultSet.getString(5);
                int id_avion = resultSet.getInt(6);
                String tipo_combustible = resultSet.getString(7);
                int numero_motores = resultSet.getInt(8);
                int id_vehiculo = resultSet.getInt(9);
                avion = new clsAvion(tipo_combustible,pasajeros,combustible,impronta_chasis,estado_vehiculo,numero_motores);
            }
            return avion;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void ConsultarAviones(ArrayList<clsVehiculo> vehiculos) {
        //ArrayList<clsVehiculo> vehiculos = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(datosJDBC.getUrl(), datosJDBC.getUser(), datosJDBC.getPassword())) {
            String query = "SELECT * FROM tb_vehiculo INNER JOIN tb_avion ON tb_vehiculo.id=tb_avion.id_vehiculo";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String impronta_chasis = resultSet.getString(2);
                int pasajeros = resultSet.getInt(3);
                int combustible = resultSet.getInt(4);
                String estado_vehiculo = resultSet.getString(5);
                int id_avion = resultSet.getInt(6);
                String tipo_combustible = resultSet.getString(7);
                int numero_motores = resultSet.getInt(8);
                int id_vehiculo = resultSet.getInt(9);
                clsAvion avion = new clsAvion(tipo_combustible, pasajeros, combustible, impronta_chasis, estado_vehiculo, numero_motores);
                vehiculos.add(avion);
            }
            //  return vehiculos;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //return null;
        }
    }
}
