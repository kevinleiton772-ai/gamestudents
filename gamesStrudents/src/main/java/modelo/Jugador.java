package modelo;

import controlador.ConexionBDD;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Jugador {

    private int idJugador;
    private String nickname;
    private String nombreReal;
    private LocalDate fechaNacimiento;
    private String rol;
    private Integer idEquipo;
    private int estado;

    public Jugador() {
    }

    public Jugador(
            int idJugador,
            String nickname,
            String nombreReal,
            LocalDate fechaNacimiento,
            String rol,
            Integer idEquipo,
            int estado) {

        this.idJugador = idJugador;
        this.nickname = nickname;
        this.nombreReal = nombreReal;
        this.fechaNacimiento = fechaNacimiento;
        this.rol = rol;
        this.idEquipo = idEquipo;
        this.estado = estado;
    }

    public Jugador(
            String nickname,
            String nombreReal,
            LocalDate fechaNacimiento,
            String rol,
            Integer idEquipo) {

        this.nickname = nickname;
        this.nombreReal = nombreReal;
        this.fechaNacimiento = fechaNacimiento;
        this.rol = rol;
        this.idEquipo = idEquipo;
        this.estado = 1;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNombreReal() {
        return nombreReal;
    }

    public void setNombreReal(String nombreReal) {
        this.nombreReal = nombreReal;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void insertarJugador() {

        String sql = "{call gamestudents.sp_insertar_jugador(?,?,?,?,?,?)}";

        ConexionBDD conectar = new ConexionBDD();

        try (
                Connection conexion = conectar.conectar();
                CallableStatement cs = conexion.prepareCall(sql)) {

            cs.setString(1, nickname);
            cs.setString(2, nombreReal);

            if (fechaNacimiento != null) {
                cs.setDate(3, java.sql.Date.valueOf(fechaNacimiento));
            } else {
                cs.setNull(3, Types.DATE);
            }

            cs.setString(4, rol);

            if (idEquipo != null) {
                cs.setInt(5, idEquipo);
            } else {
                cs.setNull(5, Types.INTEGER);
            }

            cs.setInt(6, estado);

            cs.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Error al insertar jugador: " + e.getMessage(), e
            );
        }
    }

    public void listarJugadores(JTable tabla) {

        String sql = "{call gamestudents.sp_listar_jugadores()}";

        ConexionBDD conectar = new ConexionBDD();

        DefaultTableModel modeloTabla = new DefaultTableModel(
                new Object[]{
                    "ID Jugador",
                    "Nickname",
                    "Nombre Real",
                    "Fecha Nacimiento",
                    "Rol",
                    "ID Equipo",
                    "Estado"
                }, 0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        try (
                Connection conexion = conectar.conectar();
                CallableStatement cs = conexion.prepareCall(sql);
                ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {

                Object equipo = rs.getObject("id_equipo");

                String estadoTexto =
                        rs.getInt("estado") == 1
                                ? "Activo"
                                : "Inactivo";

                modeloTabla.addRow(new Object[]{
                    rs.getInt("id_jugador"),
                    rs.getString("nickname"),
                    rs.getString("nombre_real"),
                    rs.getDate("fecha_nacimiento"),
                    rs.getString("rol"),
                    equipo,
                    estadoTexto
                });
            }

            tabla.setModel(modeloTabla);

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Error al listar jugadores: " + e.getMessage(), e
            );
        }
    }

    public void modificarJugador(
            int idJugador,
            String nickname,
            String nombreReal,
            LocalDate fechaNacimiento,
            String rol,
            Integer idEquipo) {

        String sql =
                "{call gamestudents.sp_modificar_jugador(?,?,?,?,?,?)}";

        ConexionBDD conectar = new ConexionBDD();

        try (
                Connection conexion = conectar.conectar();
                CallableStatement cs = conexion.prepareCall(sql)) {

            cs.setInt(1, idJugador);
            cs.setString(2, nickname);
            cs.setString(3, nombreReal);

            if (fechaNacimiento != null) {
                cs.setDate(
                        4,
                        java.sql.Date.valueOf(fechaNacimiento)
                );
            } else {
                cs.setNull(4, Types.DATE);
            }

            cs.setString(5, rol);

            if (idEquipo != null) {
                cs.setInt(6, idEquipo);
            } else {
                cs.setNull(6, Types.INTEGER);
            }

            cs.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Error al modificar jugador: " + e.getMessage(), e
            );
        }
    }

    public void inhabilitarJugador(int idJugador) {

        String sql =
                "{call gamestudents.sp_inhabilitar_jugador(?)}";

        ConexionBDD conectar = new ConexionBDD();

        try (
                Connection conexion = conectar.conectar();
                CallableStatement cs = conexion.prepareCall(sql)) {

            cs.setInt(1, idJugador);
            cs.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Error al inhabilitar jugador: " + e.getMessage(), e
            );
        }
    }

    public void habilitarJugador(int idJugador) {

        String sql =
                "{call gamestudents.sp_habilitar_jugador(?)}";

        ConexionBDD conectar = new ConexionBDD();

        try (
                Connection conexion = conectar.conectar();
                CallableStatement cs = conexion.prepareCall(sql)) {

            cs.setInt(1, idJugador);
            cs.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Error al habilitar jugador: " + e.getMessage(), e
            );
        }
    }

   public ArrayList<String[]> listarEquiposCombo() {

    ArrayList<String[]> lista = new ArrayList<>();

    String sql =
            "{call gamestudents.sp_listar_equipos()}";

    ConexionBDD conectar = new ConexionBDD();

    try (
            Connection conexion = conectar.conectar();
            CallableStatement cs = conexion.prepareCall(sql);
            ResultSet rs = cs.executeQuery()) {

        while (rs.next()) {

            String[] equipo = new String[2];

            equipo[0] =
                    String.valueOf(
                            rs.getInt("codigo")
                    );

            equipo[1] =
                    rs.getString("nombre");

            lista.add(equipo);
        }

    } catch (SQLException e) {
        throw new RuntimeException(
                "Error al listar equipos: " + e.getMessage(), e
        );
    }

    return lista;
}


    public ArrayList<String[]> listarJugadoresCombo() {

        ArrayList<String[]> lista = new ArrayList<>();

        String sql =
                "{call gamestudents.sp_listar_jugadores()}";

        ConexionBDD conectar = new ConexionBDD();

        try (
                Connection conexion = conectar.conectar();
                CallableStatement cs = conexion.prepareCall(sql);
                ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {

                if (rs.getInt("estado") == 1) {

                    String[] jugador = new String[2];

                    jugador[0] =
                            String.valueOf(
                                    rs.getInt("id_jugador")
                            );

                    jugador[1] =
                            rs.getString("nickname");

                    lista.add(jugador);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Error al listar jugadores: " + e.getMessage(), e
            );
        }

        return lista;
    }

    public Jugador buscarJugadorPorUsuario(String usuario) {

        String sql =
                "SELECT "
                + "j.id_jugador, "
                + "j.nickname, "
                + "j.nombre_real, "
                + "j.fecha_nacimiento, "
                + "j.rol, "
                + "j.id_equipo, "
                + "j.estado "
                + "FROM gamestudents.usuario u "
                + "INNER JOIN gamestudents.jugador j "
                + "ON u.usuario = j.nickname "
                + "WHERE u.usuario = ?";

        ConexionBDD conectar = new ConexionBDD();

        try (
                Connection conexion = conectar.conectar();
                PreparedStatement ps =
                        conexion.prepareStatement(sql)) {

            ps.setString(1, usuario);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    Jugador jugador = new Jugador();

                    jugador.setIdJugador(
                            rs.getInt("id_jugador")
                    );

                    jugador.setNickname(
                            rs.getString("nickname")
                    );

                    jugador.setNombreReal(
                            rs.getString("nombre_real")
                    );

                    java.sql.Date fecha =
                            rs.getDate("fecha_nacimiento");

                    if (fecha != null) {
                        jugador.setFechaNacimiento(
                                fecha.toLocalDate()
                        );
                    }

                    jugador.setRol(
                            rs.getString("rol")
                    );

                    Object equipo =
                            rs.getObject("id_equipo");

                    if (equipo != null) {
                        jugador.setIdEquipo(
                                rs.getInt("id_equipo")
                        );
                    }

                    jugador.setEstado(
                            rs.getInt("estado")
                    );

                    return jugador;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Error al buscar jugador: " + e.getMessage(), e
            );
        }

        return null;
    }

    @Override
    public String toString() {
        return nickname;
    }
}