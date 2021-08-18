package modelos;


import classes.clsVehiculo;

import java.sql.*;
import java.util.ArrayList;

public class mdlVisitaTaller {
    datosJDBC datosJDBC;

    public mdlVisitaTaller() {
        this.datosJDBC = new datosJDBC();
    }

    public boolean CrearVisita(String improntaChasis, int nit) {
        try (Connection connection = DriverManager.getConnection(datosJDBC.getUrl(), datosJDBC.getUser(), datosJDBC.getPassword())) {
            String query = "INSERT INTO tb_visitas_taller(ID_VEHICULO, ID_TALLER) VALUES (" +
                        "(SELECT id from tb_vehiculo where impronta_chasis=?), " +
                        "(SELECT id FROM tb_taller WHERE nit = ?))";
            PreparedStatement statementVehiculo = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statementVehiculo.setString(1, improntaChasis);
            statementVehiculo.setInt(2, nit);

            int filaInsertada = statementVehiculo.executeUpdate();
            return filaInsertada > 0;
        } catch (SQLException e) {
            System.out.println("Error en la conexion con la base de datos: " + e.getMessage());
            return false;
        }
    }
}

