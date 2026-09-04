package modelo;

import controlador.ConexionBDD;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

    private String usuario;
    private String contrasena;
    private String tipo;
    private int idUsuario;

    ConexionBDD conectar = new ConexionBDD();

    public Login() {
    }

    public Login(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

public boolean iniciarSesion() {

    boolean resultado = false;

    String sentenciaSQL =
            "{CALL gamestudents.sp_login(?, ?)}";

    try (
            Connection conexion =
                    conectar.conectar();

            CallableStatement ejecutar =
                    conexion.prepareCall(sentenciaSQL)
    ) {

        ejecutar.setString(1, usuario);
        ejecutar.setString(2, contrasena);

        try (
                ResultSet res =
                        ejecutar.executeQuery()
        ) {

            if (res.next()) {

                idUsuario =
                        res.getInt("id_usuario");

                resultado = true;

                System.out.println(
                        "Inicio de sesión exitoso"
                );

                System.out.println(
                        "ID Usuario: "
                        + idUsuario
                );

            } else {

                System.out.println(
                        "Usuario o contraseña incorrectos."
                );
            }
        }

    } catch (SQLException e) {

        System.out.println(
                "Error al iniciar sesión: "
                + e.getMessage()
        );

        e.printStackTrace();
    }

    return resultado;
}
}