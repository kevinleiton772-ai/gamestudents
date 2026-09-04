package modelo;

import controlador.ConexionBDD;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Partido {

    private int idPartido;
    private LocalDate fecha;
    private LocalTime hora;
    private int marcadorEquipo1;
    private int marcadorEquipo2;
    private int ronda;
    private String fase;
    private String estado;
    private int idEquipo1;
    private int idEquipo2;
    private int idTorneo;
    private Integer idArbitro;
    private Integer idSede;

    public Partido() {
    }

    public Partido(
            LocalDate fecha,
            LocalTime hora,
            int marcadorEquipo1,
            int marcadorEquipo2,
            int ronda,
            String fase,
            String estado,
            int idEquipo1,
            int idEquipo2,
            int idTorneo,
            Integer idArbitro,
            Integer idSede) {

        this.fecha = fecha;
        this.hora = hora;
        this.marcadorEquipo1 = marcadorEquipo1;
        this.marcadorEquipo2 = marcadorEquipo2;
        this.ronda = ronda;
        this.fase = fase;
        this.estado = estado;
        this.idEquipo1 = idEquipo1;
        this.idEquipo2 = idEquipo2;
        this.idTorneo = idTorneo;
        this.idArbitro = idArbitro;
        this.idSede = idSede;
    }

    public void insertarPartido() {

        String sentenciaSQL =
                "{call gamestudents.sp_insertar_partido(?,?,?,?,?,?,?,?,?,?,?,?)}";

        ConexionBDD conectar = new ConexionBDD();

        try (
                Connection conectado = conectar.conectar();
                CallableStatement ejecutar =
                        conectado.prepareCall(sentenciaSQL)) {

            ejecutar.setDate(
                    1,
                    java.sql.Date.valueOf(fecha)
            );

            ejecutar.setTime(
                    2,
                    java.sql.Time.valueOf(hora)
            );

            ejecutar.setInt(
                    3,
                    marcadorEquipo1
            );

            ejecutar.setInt(
                    4,
                    marcadorEquipo2
            );

            ejecutar.setInt(
                    5,
                    ronda
            );

            ejecutar.setString(
                    6,
                    fase
            );

            ejecutar.setString(
                    7,
                    estado
            );

            ejecutar.setInt(
                    8,
                    idEquipo1
            );

            ejecutar.setInt(
                    9,
                    idEquipo2
            );

            ejecutar.setInt(
                    10,
                    idTorneo
            );

            if (idArbitro != null) {

                ejecutar.setInt(
                        11,
                        idArbitro
                );

            } else {

                ejecutar.setNull(
                        11,
                        java.sql.Types.INTEGER
                );
            }

            if (idSede != null) {

                ejecutar.setInt(
                        12,
                        idSede
                );

            } else {

                ejecutar.setNull(
                        12,
                        java.sql.Types.INTEGER
                );
            }

            ejecutar.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void listarPartidos(JTable tabla) {

        String sentenciaSQL =
                "{call gamestudents.sp_listar_partidos()}";

        ConexionBDD conectar =
                new ConexionBDD();

        DefaultTableModel modelo =
                new DefaultTableModel() {

            @Override
            public boolean isCellEditable(
                    int row,
                    int column) {

                return false;
            }
        };

        modelo.addColumn("ID Partido");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora");
        modelo.addColumn("Marcador Equipo 1");
        modelo.addColumn("Marcador Equipo 2");
        modelo.addColumn("Ronda");
        modelo.addColumn("Fase");
        modelo.addColumn("Estado");
        modelo.addColumn("ID Equipo 1");
        modelo.addColumn("ID Equipo 2");
        modelo.addColumn("ID Torneo");
        modelo.addColumn("ID Árbitro");
        modelo.addColumn("ID Sede");

        try (
                Connection conectado =
                        conectar.conectar();

                CallableStatement ejecutar =
                        conectado.prepareCall(sentenciaSQL);

                ResultSet resultado =
                        ejecutar.executeQuery()) {

            while (resultado.next()) {

                Object[] fila = {

                    resultado.getInt(
                            "id_partido"
                    ),

                    resultado.getDate(
                            "fecha"
                    ),

                    resultado.getTime(
                            "hora"
                    ),

                    resultado.getInt(
                            "marcador_equipo1"
                    ),

                    resultado.getInt(
                            "marcador_equipo2"
                    ),

                    resultado.getInt(
                            "ronda"
                    ),

                    resultado.getString(
                            "fase"
                    ),

                    resultado.getString(
                            "estado"
                    ),

                    resultado.getInt(
                            "id_equipo1"
                    ),

                    resultado.getInt(
                            "id_equipo2"
                    ),

                    resultado.getInt(
                            "id_torneo"
                    ),

                    resultado.getObject(
                            "id_arbitro"
                    ),

                    resultado.getObject(
                            "id_sede"
                    )
                };

                modelo.addRow(fila);
            }

            tabla.setModel(modelo);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void modificarPartido(
            int idPartido,
            LocalDate fecha,
            LocalTime hora,
            int marcadorEquipo1,
            int marcadorEquipo2,
            int ronda,
            String fase,
            String estado,
            int idEquipo1,
            int idEquipo2,
            int idTorneo,
            Integer idArbitro,
            Integer idSede) {

        String sentenciaSQL =
                "{call gamestudents.sp_modificar_partido(?,?,?,?,?,?,?,?,?,?,?,?,?)}";

        ConexionBDD conectar =
                new ConexionBDD();

        try (
                Connection conectado =
                        conectar.conectar();

                CallableStatement ejecutar =
                        conectado.prepareCall(sentenciaSQL)) {

            ejecutar.setInt(
                    1,
                    idPartido
            );

            ejecutar.setDate(
                    2,
                    java.sql.Date.valueOf(fecha)
            );

            ejecutar.setTime(
                    3,
                    java.sql.Time.valueOf(hora)
            );

            ejecutar.setInt(
                    4,
                    marcadorEquipo1
            );

            ejecutar.setInt(
                    5,
                    marcadorEquipo2
            );

            ejecutar.setInt(
                    6,
                    ronda
            );

            ejecutar.setString(
                    7,
                    fase
            );

            ejecutar.setString(
                    8,
                    estado
            );

            ejecutar.setInt(
                    9,
                    idEquipo1
            );

            ejecutar.setInt(
                    10,
                    idEquipo2
            );

            ejecutar.setInt(
                    11,
                    idTorneo
            );

            if (idArbitro != null) {

                ejecutar.setInt(
                        12,
                        idArbitro
                );

            } else {

                ejecutar.setNull(
                        12,
                        java.sql.Types.INTEGER
                );
            }

            if (idSede != null) {

                ejecutar.setInt(
                        13,
                        idSede
                );

            } else {

                ejecutar.setNull(
                        13,
                        java.sql.Types.INTEGER
                );
            }

            ejecutar.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void inhabilitarPartido(
            int idPartido) {

        String sentenciaSQL =
                "{call gamestudents.sp_inhabilitar_partido(?)}";

        ConexionBDD conectar =
                new ConexionBDD();

        try (
                Connection conectado =
                        conectar.conectar();

                CallableStatement ejecutar =
                        conectado.prepareCall(sentenciaSQL)) {

            ejecutar.setInt(
                    1,
                    idPartido
            );

            ejecutar.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void habilitarPartido(
            int idPartido) {

        String sentenciaSQL =
                "{call gamestudents.sp_habilitar_partido(?)}";

        ConexionBDD conectar =
                new ConexionBDD();

        try (
                Connection conectado =
                        conectar.conectar();

                CallableStatement ejecutar =
                        conectado.prepareCall(sentenciaSQL)) {

            ejecutar.setInt(
                    1,
                    idPartido
            );

            ejecutar.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(
            int idPartido) {

        this.idPartido = idPartido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(
            LocalDate fecha) {

        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(
            LocalTime hora) {

        this.hora = hora;
    }

    public int getMarcadorEquipo1() {
        return marcadorEquipo1;
    }

    public void setMarcadorEquipo1(
            int marcadorEquipo1) {

        this.marcadorEquipo1 =
                marcadorEquipo1;
    }

    public int getMarcadorEquipo2() {
        return marcadorEquipo2;
    }

    public void setMarcadorEquipo2(
            int marcadorEquipo2) {

        this.marcadorEquipo2 =
                marcadorEquipo2;
    }

    public int getRonda() {
        return ronda;
    }

    public void setRonda(
            int ronda) {

        this.ronda = ronda;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(
            String fase) {

        this.fase = fase;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(
            String estado) {

        this.estado = estado;
    }

    public int getIdEquipo1() {
        return idEquipo1;
    }

    public void setIdEquipo1(
            int idEquipo1) {

        this.idEquipo1 = idEquipo1;
    }

    public int getIdEquipo2() {
        return idEquipo2;
    }

    public void setIdEquipo2(
            int idEquipo2) {

        this.idEquipo2 = idEquipo2;
    }

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(
            int idTorneo) {

        this.idTorneo = idTorneo;
    }

    public Integer getIdArbitro() {
        return idArbitro;
    }

    public void setIdArbitro(
            Integer idArbitro) {

        this.idArbitro = idArbitro;
    }

    public Integer getIdSede() {
        return idSede;
    }

    public void setIdSede(
            Integer idSede) {

        this.idSede = idSede;
    }
}
