package modelos;

import classes.clsMecanico;
import classes.clsTallerMecanico;

import java.sql.*;
import java.util.ArrayList;

public class mdlTallerMecanico {
    datosJDBC datosJDBC;

    public mdlTallerMecanico() {
        this.datosJDBC = new datosJDBC();
    }

    public boolean CrearTallerMecanico(clsTallerMecanico Tallermecanico) {
        try (Connection connection = DriverManager.getConnection(datosJDBC.getUrl(), datosJDBC.getUser(), datosJDBC.getPassword())) {
            String query = "SELECT id FROM tb_mecanico WHERE identificacion=?";
            PreparedStatement statementMecanico = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statementMecanico.setInt(1, Tallermecanico.getMecanicos().get(0).getIdentificacion());

            ResultSet resultSet = statementMecanico.executeQuery();;
            if (resultSet.next()) {
                int id_mecanico = resultSet.getInt(1);
                String query2 = "INSERT INTO tb_taller(nombre, telefono, direccion, tipo_mantenimiento, id_mecanico, nit)VALUES(?,?,?,?,?,?)";
                PreparedStatement statementTaller = connection.prepareStatement(query2, Statement.RETURN_GENERATED_KEYS);
                statementTaller.setString(1, Tallermecanico.getNombre());
                statementTaller.setString(2, Tallermecanico.getTelefono());
                statementTaller.setString(3, Tallermecanico.getDireccion());
                statementTaller.setString(4, Tallermecanico.getTipoMantenimiento());
                statementTaller.setInt(5,id_mecanico);
                statementTaller.setInt(6,Tallermecanico.getNit());
                int filaInsertada = statementTaller.executeUpdate();
                if (filaInsertada > 0) {
                    return true;
                }
            }
            System.out.println("No registro el taller");
            return false;
        } catch (SQLException e) {
            System.out.println("Error en la conexion con la base de datos: " + e.getMessage());
            return false;
        }
    }

    public boolean EditarTallerMecanico(clsTallerMecanico Tallermecanico) {
        try (Connection connection = DriverManager.getConnection(datosJDBC.getUrl(), datosJDBC.getUser(), datosJDBC.getPassword())) {

            String query = "SELECT id FROM tb_mecanico WHERE identificacion=?";
            PreparedStatement statementMecanico = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statementMecanico.setInt(1, Tallermecanico.getMecanicos().get(0).getIdentificacion());

            ResultSet resultSet = statementMecanico.executeQuery();;
            if (resultSet.next()) {
                int id_mecanico = resultSet.getInt(1);

                String query2 = "UPDATE tb_taller SET nombre=?,direccion=?,telefono=?, tipo_mantenimiento=?, id_mecanico=? WHERE nit=?";
                PreparedStatement statementTaller = connection.prepareStatement(query2);
                statementTaller.setString(1, Tallermecanico.getNombre());
                statementTaller.setString(2, Tallermecanico.getDireccion());
                statementTaller.setString(3, Tallermecanico.getTelefono());
                statementTaller.setString(4, Tallermecanico.getTipoMantenimiento());
                statementTaller.setInt(5,id_mecanico);
                statementTaller.setInt(6, Tallermecanico.getNit());
                int filas_modificadas = statementTaller.executeUpdate();
                return filas_modificadas > 0;
            }
            return false;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean EliminarTallerMecanico(int nit) {
        try (Connection connection = DriverManager.getConnection(datosJDBC.getUrl(), datosJDBC.getUser(), datosJDBC.getPassword())) {
            String query = "DELETE FROM tb_taller WHERE nit = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, nit);
            int filas_modificadas = statement.executeUpdate();
            return filas_modificadas > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public clsTallerMecanico ConsultarTallerMecanico(int nit) {
        clsTallerMecanico tallerMecanico = null;
        try (Connection connection = DriverManager.getConnection(datosJDBC.getUrl(), datosJDBC.getUser(), datosJDBC.getPassword())) {
            String query = "SELECT * FROM tb_taller " +
                    "join tb_mecanico tm on tm.id = tb_taller.id_mecanico " +
                    "WHERE nit=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, nit);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String nombreTaller = resultSet.getString(2);
                String telefono = resultSet.getString(3);
                String direccion = resultSet.getString(4);
                String tipoMantenimiento = resultSet.getString(5);
                int idMecanico = resultSet.getInt(6);
                //int nit = resultSet.getInt(7);
                String nombres = resultSet.getString(9);
                String apellidos = resultSet.getString(10);
                String certificado = resultSet.getString(11);
                int identificacion = resultSet.getInt(12);

                ArrayList<clsMecanico> mecanicos = new ArrayList<>();
                clsMecanico mecanico = new clsMecanico(nombres,apellidos,certificado,identificacion);
                mecanicos.add(mecanico);

                tallerMecanico = new clsTallerMecanico(nombreTaller,telefono,direccion,mecanicos,nit);
            }
            return tallerMecanico;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ArrayList<clsTallerMecanico> ConsultarTalleresMecanico(){
        ArrayList<clsTallerMecanico> talleresMecanico = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(datosJDBC.getUrl(), datosJDBC.getUser(), datosJDBC.getPassword())) {
            String query = "SELECT * FROM tb_taller " +
                    "join tb_mecanico tm on tm.id = tb_taller.id_mecanico";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String nombreTaller = resultSet.getString(2);
                String telefono = resultSet.getString(3);
                String direccion = resultSet.getString(4);
                String tipoMantenimiento = resultSet.getString(5);
                int idMecanico = resultSet.getInt(6);
                int nit = resultSet.getInt(7);
                String nombres = resultSet.getString(9);
                String apellidos = resultSet.getString(10);
                String certificado = resultSet.getString(11);
                int identificacion = resultSet.getInt(12);

                ArrayList<clsMecanico> mecanicos = new ArrayList<>();
                clsMecanico mecanico = new clsMecanico(nombres,apellidos,certificado,identificacion);
                mecanicos.add(mecanico);

                clsTallerMecanico tallerMecanico = new clsTallerMecanico(nombreTaller,telefono,direccion,mecanicos,nit);
                talleresMecanico.add(tallerMecanico);
            }
            return talleresMecanico;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
