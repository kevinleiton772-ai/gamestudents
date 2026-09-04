package controlador;

import java.time.LocalDate;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Jugador;
import vista.JugadoresVista;

public class jugadorControlador {

    private Jugador modelo;
    private JugadoresVista vista;
    private JFrame ventanaAnterior;

    private int idJugadorSeleccionado = -1;

    public jugadorControlador() {
    }

    public jugadorControlador(
            Jugador modelo,
            JugadoresVista vista,
            JFrame ventanaAnterior) {

        this.modelo = modelo;
        this.vista = vista;
        this.ventanaAnterior = ventanaAnterior;
    }

    public void iniciar() {

        vista.getBtnCrear().addActionListener(
                e -> insertarJugador()
        );

        vista.getBtnModificar().addActionListener(
                e -> modificarJugador()
        );

        vista.getBtnInhabilitar().addActionListener(
                e -> inhabilitarJugador()
        );

        vista.getBtnHabilitar().addActionListener(
                e -> habilitarJugador()
        );

        vista.getBtnSalir().addActionListener(
                e -> salir()
        );

        vista.getTblJugadores()
                .getSelectionModel()
                .addListSelectionListener(e -> {

                    if (!e.getValueIsAdjusting()) {
                        seleccionarJugador();
                    }
                });

        cargarJugadores();

        vista.setVisible(true);
    }

    public void cargarJugadores() {

        modelo.listarJugadores(
                vista.getTblJugadores()
        );
    }

    public void insertarJugador() {

        String nickname =
                vista.getTxtNickname()
                        .getText()
                        .trim();

        String nombreReal =
                vista.getTxtNombreReal()
                        .getText()
                        .trim();

        String fechaTexto =
                vista.getTxtFechaNacimiento()
                        .getText()
                        .trim();

        String equipoTexto =
                vista.getTxtIdEquipo()
                        .getText()
                        .trim();

        String rol =
                vista.getCmbRol();

        if (rol != null) {
            rol = rol.trim();
        }

        if (nickname.isEmpty()
                || nombreReal.isEmpty()
                || fechaTexto.isEmpty()
                || rol == null
                || rol.isEmpty()
                || rol.equalsIgnoreCase("Seleccione...")) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Todos los campos son obligatorios."
            );

            return;
        }

        if (!validarNickname(nickname)) {

            JOptionPane.showMessageDialog(
                    vista,
                    "El nickname solo puede contener letras, números, guion y guion bajo."
            );

            return;
        }

        if (!validarNombre(nombreReal)) {

            JOptionPane.showMessageDialog(
                    vista,
                    "El nombre solo puede contener letras y espacios."
            );

            return;
        }

        LocalDate fechaNacimiento;

        try {

            fechaNacimiento =
                    LocalDate.parse(fechaTexto);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    vista,
                    "La fecha debe tener el formato yyyy-MM-dd."
            );

            return;
        }

        Integer idEquipo = null;

        if (!equipoTexto.isEmpty()) {

            try {

                idEquipo =
                        Integer.parseInt(
                                equipoTexto
                        );

                if (idEquipo <= 0) {

                    JOptionPane.showMessageDialog(
                            vista,
                            "El ID del equipo debe ser válido."
                    );

                    return;
                }

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(
                        vista,
                        "El ID del equipo debe ser un número."
                );

                return;
            }
        }

        modelo =
                new Jugador(
                        nickname,
                        nombreReal,
                        fechaNacimiento,
                        rol,
                        idEquipo
                );

        modelo.insertarJugador();

        cargarJugadores();

        limpiarCampos();

        JOptionPane.showMessageDialog(
                vista,
                "Jugador registrado correctamente."
        );
    }

    public void seleccionarJugador() {

        int fila =
                vista.getTblJugadores()
                        .getSelectedRow();

        if (fila == -1) {
            return;
        }

        idJugadorSeleccionado =
                Integer.parseInt(
                        vista.getTblJugadores()
                                .getValueAt(
                                        fila,
                                        0
                                )
                                .toString()
                );

        Object nickname =
                vista.getTblJugadores()
                        .getValueAt(fila, 1);

        Object nombreReal =
                vista.getTblJugadores()
                        .getValueAt(fila, 2);

        Object fecha =
                vista.getTblJugadores()
                        .getValueAt(fila, 3);

        Object rol =
                vista.getTblJugadores()
                        .getValueAt(fila, 4);

        Object equipo =
                vista.getTblJugadores()
                        .getValueAt(fila, 5);

        vista.setTxtNickname(
                nickname == null
                        ? ""
                        : nickname.toString()
        );

        vista.setTxtNombreReal(
                nombreReal == null
                        ? ""
                        : nombreReal.toString()
        );

        vista.setTxtFechaNacimiento(
                fecha == null
                        ? ""
                        : fecha.toString()
        );

        vista.setCmbRol(
                rol == null
                        ? "Seleccione..."
                        : rol.toString()
        );

        vista.setTxtIdEquipo(
                equipo == null
                        ? ""
                        : equipo.toString()
        );
    }

    public void modificarJugador() {

        if (idJugadorSeleccionado == -1) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Seleccione un jugador de la tabla."
            );

            return;
        }

        String nickname =
                vista.getTxtNickname()
                        .getText()
                        .trim();

        String nombreReal =
                vista.getTxtNombreReal()
                        .getText()
                        .trim();

        String fechaTexto =
                vista.getTxtFechaNacimiento()
                        .getText()
                        .trim();

        String equipoTexto =
                vista.getTxtIdEquipo()
                        .getText()
                        .trim();

        String rol =
                vista.getCmbRol();

        if (rol != null) {
            rol = rol.trim();
        }

        if (nickname.isEmpty()
                || nombreReal.isEmpty()
                || fechaTexto.isEmpty()
                || rol == null
                || rol.isEmpty()
                || rol.equalsIgnoreCase("Seleccione...")) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Todos los campos son obligatorios."
            );

            return;
        }

        if (!validarNickname(nickname)) {

            JOptionPane.showMessageDialog(
                    vista,
                    "El nickname no es válido."
            );

            return;
        }

        if (!validarNombre(nombreReal)) {

            JOptionPane.showMessageDialog(
                    vista,
                    "El nombre no es válido."
            );

            return;
        }

        LocalDate fechaNacimiento;

        try {

            fechaNacimiento =
                    LocalDate.parse(fechaTexto);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    vista,
                    "La fecha debe tener el formato yyyy-MM-dd."
            );

            return;
        }

        Integer idEquipo = null;

        if (!equipoTexto.isEmpty()) {

            try {

                idEquipo =
                        Integer.parseInt(
                                equipoTexto
                        );

                if (idEquipo <= 0) {

                    JOptionPane.showMessageDialog(
                            vista,
                            "El ID del equipo debe ser válido."
                    );

                    return;
                }

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(
                        vista,
                        "El ID del equipo debe ser un número."
                );

                return;
            }
        }

        int respuesta =
                JOptionPane.showConfirmDialog(
                        vista,
                        "¿Está seguro de modificar este jugador?",
                        "Modificar jugador",
                        JOptionPane.YES_NO_OPTION
                );

        if (respuesta != JOptionPane.YES_OPTION) {
            return;
        }

        modelo.modificarJugador(
                idJugadorSeleccionado,
                nickname,
                nombreReal,
                fechaNacimiento,
                rol,
                idEquipo
        );

        cargarJugadores();

        limpiarCampos();

        JOptionPane.showMessageDialog(
                vista,
                "Jugador modificado correctamente."
        );
    }

    public void inhabilitarJugador() {

        if (idJugadorSeleccionado == -1) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Seleccione un jugador de la tabla."
            );

            return;
        }

        int respuesta =
                JOptionPane.showConfirmDialog(
                        vista,
                        "¿Está seguro de inhabilitar este jugador?",
                        "Inhabilitar jugador",
                        JOptionPane.YES_NO_OPTION
                );

        if (respuesta != JOptionPane.YES_OPTION) {
            return;
        }

        modelo.inhabilitarJugador(
                idJugadorSeleccionado
        );

        cargarJugadores();

        limpiarCampos();

        JOptionPane.showMessageDialog(
                vista,
                "Jugador inhabilitado correctamente."
        );
    }

    public void habilitarJugador() {

        if (idJugadorSeleccionado == -1) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Seleccione un jugador de la tabla."
            );

            return;
        }

        int respuesta =
                JOptionPane.showConfirmDialog(
                        vista,
                        "¿Está seguro de habilitar este jugador?",
                        "Habilitar jugador",
                        JOptionPane.YES_NO_OPTION
                );

        if (respuesta != JOptionPane.YES_OPTION) {
            return;
        }

        modelo.habilitarJugador(
                idJugadorSeleccionado
        );

        cargarJugadores();

        limpiarCampos();

        JOptionPane.showMessageDialog(
                vista,
                "Jugador habilitado correctamente."
        );
    }

    private void limpiarCampos() {

        vista.setTxtNickname("");
        vista.setTxtNombreReal("");
        vista.setTxtFechaNacimiento("");
        vista.setTxtIdEquipo("");
        vista.setCmbRol("Seleccione...");

        idJugadorSeleccionado = -1;
    }

    private boolean validarNickname(
            String nickname) {

        return nickname.matches(
                "[a-zA-Z0-9_-]+"
        );
    }

    private boolean validarNombre(
            String nombre) {

        return nombre.matches(
                "[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ ]+"
        );
    }

    public void salir() {

        vista.dispose();

        if (ventanaAnterior != null) {
            ventanaAnterior.setVisible(true);
        }
    }
}

