package modelo;

import controlador.ConexionBDD;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Reporte {

    private int idTorneo;
    private String nombre;
    private String videojuego;
    private String fechaInicio;
    private String fechaFin;
    private String premioTotal;
    private int numRondas;
    private String estado;
    private int idOrganizador;

    public Reporte() {
    }

    public Reporte(
            int idTorneo,
            String nombre,
            String videojuego,
            String fechaInicio,
            String fechaFin,
            String premioTotal,
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

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getPremioTotal() {
        return premioTotal;
    }

    public void setPremioTotal(String premioTotal) {
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

    public static ArrayList<Reporte> listarReporte(
            String fechaInicio,
            String fechaFin,
            String estado,
            String videojuego) {

        ArrayList<Reporte> lista = new ArrayList<>();

        ConexionBDD conexion = new ConexionBDD();

        String sql =
                "{CALL gamestudents.sp_reporte_torneos(?,?,?,?)}";

        try (
                Connection cn = conexion.conectar();
                CallableStatement cs = cn.prepareCall(sql)
        ) {

            cs.setString(1, fechaInicio);
            cs.setString(2, fechaFin);
            cs.setString(3, estado);
            cs.setString(4, videojuego);

            try (ResultSet rs = cs.executeQuery()) {

                while (rs.next()) {

                    Reporte reporte = new Reporte();

                    reporte.setIdTorneo(
                            rs.getInt("id_torneo")
                    );

                    reporte.setNombre(
                            rs.getString("nombre")
                    );

                    reporte.setVideojuego(
                            rs.getString("videojuego")
                    );

                    reporte.setFechaInicio(
                            rs.getString("fecha_inicio")
                    );

                    reporte.setFechaFin(
                            rs.getString("fecha_fin")
                    );

                    reporte.setPremioTotal(
                            rs.getString("premio_total")
                    );

                    reporte.setNumRondas(
                            rs.getInt("num_rondas")
                    );

                    reporte.setEstado(
                            rs.getString("estado")
                    );

                    reporte.setIdOrganizador(
                            rs.getInt("id_organizador")
                    );

                    lista.add(reporte);
                }
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error al generar reporte: "
                    + e.getMessage()
            );

            e.printStackTrace();
        }

        return lista;
    }
}
