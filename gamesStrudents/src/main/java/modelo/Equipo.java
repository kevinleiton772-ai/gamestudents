package modelo;

import controlador.ConexionBDD;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Equipo {

    private int codigo;
    private String nombre;
    private String paisProcedencia;
    private LocalDate fechaFundacion;
    private String entrenador;
    private int estado;

    public Equipo() {
    }

    public Equipo(
            int codigo,
            String nombre,
            String paisProcedencia,
            LocalDate fechaFundacion,
            String entrenador) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.paisProcedencia = paisProcedencia;
        this.fechaFundacion = fechaFundacion;
        this.entrenador = entrenador;
        this.estado = 1;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaisProcedencia() {
        return paisProcedencia;
    }

    public void setPaisProcedencia(String paisProcedencia) {
        this.paisProcedencia = paisProcedencia;
    }

    public LocalDate getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(LocalDate fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void insertarEquipo() {

        String sentenciaSQL =
                "{CALL gamestudents.sp_insertar_equipo(?,?,?,?,?,?)}";

        ConexionBDD conectar = new ConexionBDD();

        try (
                Connection conectado = conectar.conectar();
                CallableStatement ejecutar =
                        conectado.prepareCall(sentenciaSQL)) {

            ejecutar.setInt(1, codigo);
            ejecutar.setString(2, nombre);
            ejecutar.setString(3, paisProcedencia);

            if (fechaFundacion != null) {
                ejecutar.setDate(
                        4,
                        java.sql.Date.valueOf(fechaFundacion)
                );
            } else {
                ejecutar.setNull(
                        4,
                        java.sql.Types.DATE
                );
            }

            ejecutar.setString(5, entrenador);
            ejecutar.setInt(6, estado);

            ejecutar.executeUpdate();

        } catch (SQLException e) {

            System.out.println(
                    "Error al insertar equipo: "
                    + e.getMessage()
            );

            e.printStackTrace();
        }
    }

    public void listarEquipos(JTable tabla) {

        String sentenciaSQL =
                "{CALL gamestudents.sp_listar_equipos()}";

        ConexionBDD conectar = new ConexionBDD();

        DefaultTableModel modelo =
                new DefaultTableModel() {

            @Override
            public boolean isCellEditable(
                    int fila,
                    int columna) {

                return false;
            }
        };

        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("País de Procedencia");
        modelo.addColumn("Fecha Fundación");
        modelo.addColumn("Entrenador");
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

                    resultado.getInt("codigo"),
                    resultado.getString("nombre"),
                    resultado.getString("pais_procedencia"),
                    resultado.getDate("fecha_fundacion"),
                    resultado.getString("entrenador"),
                    estadoTexto
                };

                modelo.addRow(fila);
            }

            tabla.setModel(modelo);

        } catch (SQLException e) {

            System.out.println(
                    "Error al listar equipos: "
                    + e.getMessage()
            );

            e.printStackTrace();
        }
    }

    public boolean modificarEquipo(
            int codigo,
            String nombre,
            String paisProcedencia,
            LocalDate fechaFundacion,
            String entrenador) {

        String sentenciaSQL =
                "{CALL gamestudents.sp_modificar_equipo(?,?,?,?,?)}";

        ConexionBDD conectar = new ConexionBDD();

        try (
                Connection conectado = conectar.conectar();
                CallableStatement ejecutar =
                        conectado.prepareCall(sentenciaSQL)) {

            ejecutar.setInt(1, codigo);
            ejecutar.setString(2, nombre);
            ejecutar.setString(3, paisProcedencia);

            if (fechaFundacion != null) {

                ejecutar.setDate(
                        4,
                        java.sql.Date.valueOf(
                                fechaFundacion
                        )
                );

            } else {

                ejecutar.setNull(
                        4,
                        java.sql.Types.DATE
                );
            }

            ejecutar.setString(
                    5,
                    entrenador
            );

            int filasAfectadas =
                    ejecutar.executeUpdate();

            System.out.println(
                    "Filas modificadas: "
                    + filasAfectadas
            );

            return filasAfectadas > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Error al modificar equipo: "
                    + e.getMessage()
            );

            e.printStackTrace();

            return false;
        }
    }

    public void inhabilitarEquipo(
            int codigoEquipo) {

        String sentenciaSQL =
                "{CALL gamestudents.sp_inhabilitar_equipo(?)}";

        ConexionBDD conectar = new ConexionBDD();

        try (
                Connection conectado = conectar.conectar();
                CallableStatement ejecutar =
                        conectado.prepareCall(sentenciaSQL)) {

            ejecutar.setInt(
                    1,
                    codigoEquipo
            );

            ejecutar.executeUpdate();

        } catch (SQLException e) {

            System.out.println(
                    "Error al inhabilitar equipo: "
                    + e.getMessage()
            );

            e.printStackTrace();
        }
    }

    public void habilitarEquipo(
            int codigoEquipo) {

        String sentenciaSQL =
                "{CALL gamestudents.sp_habilitar_equipo(?)}";

        ConexionBDD conectar = new ConexionBDD();

        try (
                Connection conectado = conectar.conectar();
                CallableStatement ejecutar =
                        conectado.prepareCall(sentenciaSQL)) {

            ejecutar.setInt(
                    1,
                    codigoEquipo
            );

            ejecutar.executeUpdate();

        } catch (SQLException e) {

            System.out.println(
                    "Error al habilitar equipo: "
                    + e.getMessage()
            );

            e.printStackTrace();
        }
    }

    public Equipo buscarEquipo(
            int codigoEquipo) {

        String sentenciaSQL =
                "{CALL gamestudents.sp_buscar_equipo(?)}";

        ConexionBDD conectar = new ConexionBDD();

        try (
                Connection conectado = conectar.conectar();
                CallableStatement ejecutar =
                        conectado.prepareCall(sentenciaSQL)) {

            ejecutar.setInt(
                    1,
                    codigoEquipo
            );

            try (
                    ResultSet resultado =
                            ejecutar.executeQuery()) {

                if (resultado.next()) {

                    Equipo equipo =
                            new Equipo();

                    equipo.setCodigo(
                            resultado.getInt(
                                    "codigo"
                            )
                    );

                    equipo.setNombre(
                            resultado.getString(
                                    "nombre"
                            )
                    );

                    equipo.setPaisProcedencia(
                            resultado.getString(
                                    "pais_procedencia"
                            )
                    );

                    if (resultado.getDate(
                            "fecha_fundacion"
                    ) != null) {

                        equipo.setFechaFundacion(
                                resultado.getDate(
                                        "fecha_fundacion"
                                ).toLocalDate()
                        );
                    }

                    equipo.setEntrenador(
                            resultado.getString(
                                    "entrenador"
                            )
                    );

                    equipo.setEstado(
                            resultado.getInt(
                                    "estado"
                            )
                    );

                    return equipo;
                }
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error al buscar equipo: "
                    + e.getMessage()
            );

            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    public java.util.ArrayList<String[]> listarEquiposCombo() {

    java.util.ArrayList<String[]> lista =
            new java.util.ArrayList<>();

    String sql =
            "{CALL gamestudents.sp_listar_equipos()}";

    ConexionBDD conexion =
            new ConexionBDD();

    try (
            Connection con = conexion.conectar();
            CallableStatement cs = con.prepareCall(sql);
            ResultSet rs = cs.executeQuery()
    ) {

        while (rs.next()) {

            if (rs.getInt("estado") == 1) {

                String[] equipo = new String[2];

                equipo[0] =
                        String.valueOf(
                                rs.getInt("codigo")
                        );

                equipo[1] =
                        rs.getString("nombre");

                lista.add(equipo);
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
}

}