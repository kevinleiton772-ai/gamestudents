package modelo;

import controlador.ConexionBDD;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    String sentenciaSQL =
            "{call gamestudents.sp_insertar_jugador(?,?,?,?,?,?)}";

    ConexionBDD conectar = new ConexionBDD();

    try (
            Connection conectado = conectar.conectar();
            CallableStatement ejecutar =
                    conectado.prepareCall(sentenciaSQL)) {

        ejecutar.setString(1, nickname);
        ejecutar.setString(2, nombreReal);

        if (fechaNacimiento != null) {
            ejecutar.setDate(
                    3,
                    java.sql.Date.valueOf(fechaNacimiento)
            );
        } else {
            ejecutar.setNull(
                    3,
                    java.sql.Types.DATE
            );
        }

        ejecutar.setString(4, rol);

        if (idEquipo != null) {
            ejecutar.setInt(5, idEquipo);
        } else {
            ejecutar.setNull(
                    5,
                    java.sql.Types.INTEGER
            );
        }

        ejecutar.setInt(6, estado);

        ejecutar.execute();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public void listarJugadores(JTable tabla) {

    String sentenciaSQL =
            "{call gamestudents.sp_listar_jugadores()}";

    ConexionBDD conectar = new ConexionBDD();

    DefaultTableModel modelo =
            new DefaultTableModel() {

        @Override
        public boolean isCellEditable(
                int row,
                int column) {

            return false;
        }
    };

    modelo.addColumn("ID Jugador");
    modelo.addColumn("Nickname");
    modelo.addColumn("Nombre Real");
    modelo.addColumn("Fecha Nacimiento");
    modelo.addColumn("Rol");
    modelo.addColumn("ID Equipo");
    modelo.addColumn("Estado");

    try (
            Connection conectado = conectar.conectar();
            CallableStatement ejecutar =
                    conectado.prepareCall(sentenciaSQL);
            ResultSet resultado =
                    ejecutar.executeQuery()) {

        while (resultado.next()) {

            String estadoTexto =
                    resultado.getInt("estado") == 1
                            ? "Activo"
                            : "Inactivo";

            Object[] fila = {

                resultado.getInt("id_jugador"),
                resultado.getString("nickname"),
                resultado.getString("nombre_real"),
                resultado.getDate("fecha_nacimiento"),
                resultado.getString("rol"),
                resultado.getObject("id_equipo"),
                estadoTexto
            };

            modelo.addRow(fila);
        }

        tabla.setModel(modelo);

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public void inhabilitarJugador(int idJugador) {

    String sentenciaSQL =
            "{call gamestudents.sp_inhabilitar_jugador(?)}";

    ConexionBDD conectar = new ConexionBDD();

    try (
            Connection conectado = conectar.conectar();
            CallableStatement ejecutar =
                    conectado.prepareCall(sentenciaSQL)) {

        ejecutar.setInt(1, idJugador);
        ejecutar.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public void habilitarJugador(int idJugador) {

    String sentenciaSQL =
            "{call gamestudents.sp_habilitar_jugador(?)}";

    ConexionBDD conectar = new ConexionBDD();

    try (
            Connection conectado = conectar.conectar();
            CallableStatement ejecutar =
                    conectado.prepareCall(sentenciaSQL)) {

        ejecutar.setInt(1, idJugador);
        ejecutar.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public void modificarJugador(
        int idJugador,
        String nickname,
        String nombreReal,
        LocalDate fechaNacimiento,
        String rol,
        Integer idEquipo) {

    String sentenciaSQL =
            "{call gamestudents.sp_modificar_jugador(?,?,?,?,?,?)}";

    ConexionBDD conectar = new ConexionBDD();

    try (
            Connection conectado = conectar.conectar();
            CallableStatement ejecutar =
                    conectado.prepareCall(sentenciaSQL)) {

        ejecutar.setInt(1, idJugador);
        ejecutar.setString(2, nickname);
        ejecutar.setString(3, nombreReal);

        if (fechaNacimiento != null) {

            ejecutar.setDate(
                    4,
                    java.sql.Date.valueOf(
                            fechaNacimiento
                    )
            );

        } else {

            ejecutar.setNull(
                    4,
                    java.sql.Types.DATE
            );
        }

        ejecutar.setString(5, rol);

        if (idEquipo != null) {

            ejecutar.setInt(
                    6,
                    idEquipo
            );

        } else {

            ejecutar.setNull(
                    6,
                    java.sql.Types.INTEGER
            );
        }

        ejecutar.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public ArrayList<String[]> listarJugadoresCombo() {

    ArrayList<String[]> lista =
            new ArrayList<>();

    String sentenciaSQL =
            "{call gamestudents.sp_listar_jugadores()}";

    ConexionBDD conectar =
            new ConexionBDD();

    try (
            Connection conectado =
                    conectar.conectar();

            CallableStatement ejecutar =
                    conectado.prepareCall(sentenciaSQL);

            ResultSet resultado =
                    ejecutar.executeQuery()) {

        while (resultado.next()) {

            if (resultado.getInt("estado") == 1) {

                String[] jugador =
                        new String[2];

                jugador[0] =
                        String.valueOf(
                                resultado.getInt(
                                        "id_jugador"
                                )
                        );

                jugador[1] =
                        resultado.getString(
                                "nickname"
                        );

                lista.add(jugador);
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
}

@Override
public String toString() {
    return nickname;
}
}