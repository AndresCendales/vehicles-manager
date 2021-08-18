package modelos;

import classes.clsMecanico;
import classes.clsVehiculo;

import java.sql.*;
import java.util.ArrayList;

public class mdlMecanico {
    datosJDBC datosJDBC;

    public mdlMecanico() {
        this.datosJDBC = new datosJDBC();
    }


    public boolean CrearMecanico(clsMecanico mecanico) {
        try (Connection connection = DriverManager.getConnection(datosJDBC.getUrl(), datosJDBC.getUser(), datosJDBC.getPassword())) {
            String query = "INSERT INTO tb_mecanico(nombre,apellidos,certificado, identificacion)VALUES(?,?,?,?)";
            PreparedStatement statementVehiculo = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statementVehiculo.setString(1, mecanico.getNombre());
            statementVehiculo.setString(2, mecanico.getapellidos());
            statementVehiculo.setString(3, mecanico.getCertificado());
            statementVehiculo.setInt(4, mecanico.getIdentificacion());

            int filaInsertada = statementVehiculo.executeUpdate();

            return filaInsertada > 0;
        } catch (SQLException e) {
            System.out.println("Error en la conexion con la base de datos: " + e.getMessage());
            return false;
        }
    }

    public boolean EditarMecanico(clsMecanico mecanico) {
        try (Connection connection = DriverManager.getConnection(datosJDBC.getUrl(), datosJDBC.getUser(), datosJDBC.getPassword())) {
            String query = "UPDATE tb_mecanico SET nombre=?,apellido=?,certificado=? WHERE identificacion=?";
            PreparedStatement statementVehiculo = connection.prepareStatement(query);
            statementVehiculo.setString(1, mecanico.getNombre());
            statementVehiculo.setString(2, mecanico.getapellidos());
            statementVehiculo.setString(3, mecanico.getCertificado());
            statementVehiculo.setInt(4, mecanico.getIdentificacion());
            int filas_modificadas = statementVehiculo.executeUpdate();
            return filas_modificadas > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean EliminarMecanico(int identificacion) {
        try (Connection connection = DriverManager.getConnection(datosJDBC.getUrl(), datosJDBC.getUser(), datosJDBC.getPassword())) {
            String query = "DELETE FROM tb_mecanico WHERE identificacion = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, identificacion);
            int filas_modificadas = statement.executeUpdate();
            return filas_modificadas > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public clsMecanico ConsultarMecanico(int identificacion) {
        clsMecanico mecanico = null;
        try (Connection connection = DriverManager.getConnection(datosJDBC.getUrl(), datosJDBC.getUser(), datosJDBC.getPassword())) {
            String query = "SELECT * FROM tb_mecanico WHERE identificacion=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, identificacion);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String nombres = resultSet.getString(2);
                String apellidos = resultSet.getString(3);
                String certificado = resultSet.getString(4);
                mecanico = new clsMecanico(nombres, apellidos, certificado, identificacion);
            }
            return mecanico;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ArrayList<clsMecanico> ConsultarMecanicos() {
        ArrayList<clsMecanico> mecanicos = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(datosJDBC.getUrl(), datosJDBC.getUser(), datosJDBC.getPassword())) {
            String query = "SELECT * FROM tb_mecanico";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String nombres = resultSet.getString(2);
                String apellidos = resultSet.getString(3);
                String certificado = resultSet.getString(4);
                int identificacion = resultSet.getInt(5);
                clsMecanico mecanico = new clsMecanico(nombres, apellidos, certificado, identificacion);
                mecanicos.add(mecanico);
            }
            return mecanicos;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
