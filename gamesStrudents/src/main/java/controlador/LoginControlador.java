package controlador;

import javax.swing.JOptionPane;

import modelo.Login;
import modelo.Menu;
import modelo.Jugador;

import vista.LoginVista;
import vista.MenuVista;

public class LoginControlador {

    private Login modelo;
    private LoginVista vista;

    public LoginControlador() {
    }

    public LoginControlador(
            Login modelo,
            LoginVista vista) {

        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {

        vista.getBtnIniciarSesion().addActionListener(
                e -> ingresar()
        );

        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    private void ingresar() {

        try {

            String usuario =
                    vista.getTxtUsuario()
                            .trim();

            String contrasena =
                    vista.getTxtContrasena()
                            .trim();

            if (usuario.isEmpty()
                    || contrasena.isEmpty()) {

                JOptionPane.showMessageDialog(
                        vista,
                        "Ingrese usuario y contraseña.",
                        "Advertencia",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            modelo.setUsuario(usuario);
            modelo.setContrasena(contrasena);

            boolean resultado =
                    modelo.iniciarSesion();

            if (!resultado) {

                JOptionPane.showMessageDialog(
                        vista,
                        "Usuario o contraseña incorrectos.",
                        "Error de inicio de sesión",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            String rol =
                    modelo.getTipo();

            if (rol == null) {

                JOptionPane.showMessageDialog(
                        vista,
                        "No se pudo obtener el rol del usuario.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            rol = rol.trim();

            

            if (rol.equalsIgnoreCase("ADMIN")
                    || rol.equalsIgnoreCase("ADMINISTRADOR")) {

                abrirMenu();

        

            } else if (rol.equalsIgnoreCase("JUGADOR")) {

//                abrirJugador();

            } else {

                JOptionPane.showMessageDialog(
                        vista,
                        "Rol de usuario no reconocido: "
                        + rol,
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Error al iniciar sesión:\n"
                    + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
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
                            vista
                    );

            vista.setVisible(false);

            controladorMenu.iniciar();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Error al abrir el menú:\n"
                    + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );

            e.printStackTrace();
        }
    }

}
