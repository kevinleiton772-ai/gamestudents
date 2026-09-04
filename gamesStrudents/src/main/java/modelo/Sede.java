package modelo;

import controlador.ConexionBDD;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

public class Sede {

    private int idSede;
    private String nombre;

    public Sede() {
    }

    public Sede(int idSede, String nombre) {
        this.idSede = idSede;
        this.nombre = nombre;
    }

    public Sede(String nombre) {
        this.nombre = nombre;
    }

    public int getIdSede() {
        return idSede;
    }

    public void setIdSede(int idSede) {
        this.idSede = idSede;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void listarSedesCombo(JComboBox<String> combo) {

        combo.removeAllItems();

        combo.addItem("Seleccione...");

        String sql =
                "SELECT id_sede, nombre " +
                "FROM sede " +
                "WHERE estado = 1 " +
                "ORDER BY nombre";

        ConexionBDD conexion = new ConexionBDD();

        try (
                Connection con = conexion.conectar();
                java.sql.PreparedStatement ps =
                        con.prepareStatement(sql);
                ResultSet rs =
                        ps.executeQuery()
        ) {

            while (rs.next()) {

                combo.addItem(
                        rs.getInt("id_sede")
                        + " - "
                        + rs.getString("nombre")
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return idSede + " - " + nombre;
    }
}