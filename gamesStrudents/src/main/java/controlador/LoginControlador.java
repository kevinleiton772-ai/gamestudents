package controlador;

import javax.swing.JOptionPane;
import modelo.Login;
import modelo.Menu;
import vista.LoginVista;
import vista.MenuVista;

public class LoginControlador {

    private Login umodelo;
    private LoginVista uvista;

    public LoginControlador() {
    }

    public LoginControlador(
            Login umodelo,
            LoginVista uvista) {

        this.umodelo = umodelo;
        this.uvista = uvista;
    }

    public void recuperarUsuario() {

        try {

            String usuario =
                    uvista.getTxtUsuario();

            String contrasena =
                    uvista.getTxtContrasena();

            if (usuario == null ||
                    usuario.trim().isEmpty()) {

                mensaje("Ingrese el usuario.");
                return;
            }

            if (contrasena == null ||
                    contrasena.trim().isEmpty()) {

                mensaje("Ingrese la contraseña.");
                return;
            }

            umodelo.setUsuario(
                    usuario.trim()
            );

            umodelo.setContrasena(
                    contrasena
            );

            if (umodelo.iniciarSesion()) {

                uvista.dispose();

                abrirMenu();

            } else {

                mensaje(
                        "Usuario o contraseña incorrectos "
                        + "o usuario inactivo."
                );

                uvista.setTxtContrasena("");
            }

        } catch (Exception e) {

            mensaje(
                    "Error al iniciar sesión:\n"
                    + e.getMessage()
            );

            e.printStackTrace();
        }
    }

    private void abrirMenu() {

        try {

            Menu modeloMenu =
                    new Menu();

            MenuVista vistaMenu =
                    new MenuVista();

            menuControlador controladorMenu =
                    new menuControlador(
                            modeloMenu,
                            vistaMenu,
                            null
                    );

            controladorMenu.iniciar();

        } catch (Exception e) {

            mensaje(
                    "Error al abrir el menú:\n"
                    + e.getMessage()
            );

            e.printStackTrace();
        }
    }

    public void iniciar() {

        uvista.getBtnIniciarSesion()
                .addActionListener(
                        e -> recuperarUsuario()
                );

        uvista.setVisible(true);
    }

    public void mensaje(String mensaje) {

        JOptionPane.showMessageDialog(
                null,
                mensaje
        );
    }
}
