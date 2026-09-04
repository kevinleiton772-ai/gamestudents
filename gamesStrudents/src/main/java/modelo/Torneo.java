package modelo;

import controlador.ConexionBDD;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Torneo {

    private int idTorneo;
    private String nombre;
    private String videojuego;
    private Date fechaInicio;
    private Date fechaFin;
    private BigDecimal premioTotal;
    private int numRondas;
    private String estado;
    private int idOrganizador;

    public Torneo() {
    }

    public Torneo(
            int idTorneo,
            String nombre,
            String videojuego,
            Date fechaInicio,
            Date fechaFin,
            BigDecimal premioTotal,
            int numRondas,
            String estado,
            int idOrganizador) {

        this.idTorneo = idTorneo;
        this.nombre = nombre;
        this.videojuego = videojuego;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.premioTotal = premioTotal;
        this.numRondas = numRondas;
        this.estado = estado;
        this.idOrganizador = idOrganizador;
    }

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVideojuego() {
        return videojuego;
    }

    public void setVideojuego(String videojuego) {
        this.videojuego = videojuego;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public BigDecimal getPremioTotal() {
        return premioTotal;
    }

    public void setPremioTotal(BigDecimal premioTotal) {
        this.premioTotal = premioTotal;
    }

    public int getNumRondas() {
        return numRondas;
    }

    public void setNumRondas(int numRondas) {
        this.numRondas = numRondas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdOrganizador() {
        return idOrganizador;
    }

    public void setIdOrganizador(int idOrganizador) {
        this.idOrganizador = idOrganizador;
    }

    public void insertarTorneo() {

        String sql =
                "{CALL gamestudents.sp_crear_torneo(?,?,?,?,?,?,?,?)}";

        ConexionBDD conexion = new ConexionBDD();

        try (
                Connection con = conexion.conectar();
                CallableStatement cs = con.prepareCall(sql)
        ) {

            cs.setString(1, nombre);
            cs.setString(2, videojuego);
            cs.setDate(3, fechaInicio);
            cs.setDate(4, fechaFin);
            cs.setBigDecimal(5, premioTotal);
            cs.setInt(6, numRondas);
            cs.setString(7, estado);
            cs.setInt(8, idOrganizador);

            cs.execute();

            JOptionPane.showMessageDialog(
                    null,
                    "Torneo creado correctamente."
            );

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Error al insertar torneo:\n"
                    + e.getMessage(),
                    "Error SQL",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public DefaultTableModel listarTorneos() {

        DefaultTableModel model =
                new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Videojuego");
        model.addColumn("Fecha Inicio");
        model.addColumn("Fecha Fin");
        model.addColumn("Premio Total");
        model.addColumn("Rondas");
        model.addColumn("Estado");
        model.addColumn("ID Organizador");

        String sql =
                "{CALL gamestudents.sp_listar_torneos()}";

        ConexionBDD conexion =
                new ConexionBDD();

        try (
                Connection con = conexion.conectar();
                CallableStatement cs =
                        con.prepareCall(sql);
                ResultSet rs =
                        cs.executeQuery()
        ) {

            while (rs.next()) {

                Object[] fila = {

                    rs.getInt("id_torneo"),
                    rs.getString("nombre"),
                    rs.getString("videojuego"),
                    rs.getDate("fecha_inicio"),
                    rs.getDate("fecha_fin"),
                    rs.getBigDecimal("premio_total"),
                    rs.getInt("num_rondas"),
                    rs.getString("estado"),
                    rs.getObject("id_organizador")
                };

                model.addRow(fila);
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Error SQL al listar torneos:\n"
                    + e.getMessage(),
                    "Error SQL",
                    JOptionPane.ERROR_MESSAGE
            );
        }

        return model;
    }

    public void modificarTorneo(
            int idTorneo,
            String nombre,
            String videojuego,
            Date fechaInicio,
            Date fechaFin,
            BigDecimal premioTotal,
            int numRondas,
            String estado,
            int idOrganizador) {

        String sql =
                "{CALL gamestudents.sp_actualizar_torneo(?,?,?,?,?,?,?,?,?)}";

        ConexionBDD conexion =
                new ConexionBDD();

        try (
                Connection con = conexion.conectar();
                CallableStatement cs =
                        con.prepareCall(sql)
        ) {

            cs.setInt(1, idTorneo);
            cs.setString(2, nombre);
            cs.setString(3, videojuego);
            cs.setDate(4, fechaInicio);
            cs.setDate(5, fechaFin);
            cs.setBigDecimal(6, premioTotal);
            cs.setInt(7, numRondas);
            cs.setString(8, estado);
            cs.setInt(9, idOrganizador);

            cs.execute();

            JOptionPane.showMessageDialog(
                    null,
                    "Torneo modificado correctamente."
            );

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Error al modificar torneo:\n"
                    + e.getMessage(),
                    "Error SQL",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void inhabilitarTorneo(int idTorneo) {

        String sql =
                "{CALL gamestudents.sp_inhabilitar_torneo(?)}";

        ConexionBDD conexion =
                new ConexionBDD();

        try (
                Connection con = conexion.conectar();
                CallableStatement cs =
                        con.prepareCall(sql)
        ) {

            cs.setInt(1, idTorneo);
            cs.execute();

            JOptionPane.showMessageDialog(
                    null,
                    "Torneo inhabilitado correctamente."
            );

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Error al inhabilitar torneo:\n"
                    + e.getMessage(),
                    "Error SQL",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void habilitarTorneo(int idTorneo) {

        String sql =
                "{CALL gamestudents.sp_habilitar_torneo(?)}";

        ConexionBDD conexion =
                new ConexionBDD();

        try (
                Connection con = conexion.conectar();
                CallableStatement cs =
                        con.prepareCall(sql)
        ) {

            cs.setInt(1, idTorneo);
            cs.execute();

            JOptionPane.showMessageDialog(
                    null,
                    "Torneo habilitado correctamente."
            );

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Error al habilitar torneo:\n"
                    + e.getMessage(),
                    "Error SQL",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    public java.util.ArrayList<String[]> listarTorneosCombo() {

    java.util.ArrayList<String[]> lista =
            new java.util.ArrayList<>();

    String sql =
            "{CALL gamestudents.sp_listar_torneos()}";

    ConexionBDD conexion =
            new ConexionBDD();

    try (
            Connection con = conexion.conectar();
            CallableStatement cs = con.prepareCall(sql);
            ResultSet rs = cs.executeQuery()
    ) {

        while (rs.next()) {

            String[] torneo = new String[2];

            torneo[0] =
                    String.valueOf(
                            rs.getInt("id_torneo")
                    );

            torneo[1] =
                    rs.getString("nombre");

            lista.add(torneo);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
}

}
