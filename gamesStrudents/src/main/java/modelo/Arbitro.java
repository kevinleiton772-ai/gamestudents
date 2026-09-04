package modelo;

import controlador.ConexionBDD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

public class Arbitro {

    private int idArbitro;
    private String nombre;

    public Arbitro() {
    }

    public Arbitro(int idArbitro, String nombre) {
        this.idArbitro = idArbitro;
        this.nombre = nombre;
    }

    public Arbitro(String nombre) {
        this.nombre = nombre;
    }

    public int getIdArbitro() {
        return idArbitro;
    }

    public void setIdArbitro(int idArbitro) {
        this.idArbitro = idArbitro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void listarArbitrosCombo(JComboBox<String> combo) {

        combo.removeAllItems();

        combo.addItem("Seleccione...");

        String sql =
                "SELECT id_arbitro, nombre " +
                "FROM arbitro " +
                "WHERE estado = 1 " +
                "ORDER BY nombre";

        ConexionBDD conexion = new ConexionBDD();

        try (
                Connection con = conexion.conectar();
                PreparedStatement ps =
                        con.prepareStatement(sql);
                ResultSet rs =
                        ps.executeQuery()
        ) {

            while (rs.next()) {

                combo.addItem(
                        rs.getInt("id_arbitro")
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
        return idArbitro + " - " + nombre;
    }
}
