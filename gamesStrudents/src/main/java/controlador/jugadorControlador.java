package controlador;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Jugador;
import vista.JugadoresVista;

public class jugadorControlador {

    private Jugador modelo;
    private JugadoresVista vista;
    private JFrame ventanaAnterior;

    private int idJugadorSeleccionado = -1;

    private ArrayList<Integer> idsEquipos =
            new ArrayList<>();

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

        cargarEquipos();
        cargarJugadores();

        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    private void cargarEquipos() {

        if (modelo == null) {
            modelo = new Jugador();
        }

        vista.getCmbEquipo().removeAllItems();

        idsEquipos.clear();

        vista.getCmbEquipo().addItem("Sin equipo");

        idsEquipos.add(null);

        ArrayList<String[]> equipos =
                modelo.listarEquiposCombo();

        for (String[] equipo : equipos) {

            idsEquipos.add(
                    Integer.parseInt(equipo[0])
            );

            vista.getCmbEquipo().addItem(
                    equipo[1]
            );
        }
    }

    public void cargarJugadores() {

        if (modelo == null) {
            modelo = new Jugador();
        }

        modelo.listarJugadores(
                vista.getTblJugadores()
        );
    }

    private void insertarJugador() {

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

        String rol =
                vista.getRolSeleccionado();

        if (nickname.isEmpty()
                || nombreReal.isEmpty()
                || fechaTexto.isEmpty()
                || rol.isEmpty()
                || rol.equalsIgnoreCase("Seleccione...")) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Todos los campos son obligatorios.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        if (!validarNickname(nickname)) {

            JOptionPane.showMessageDialog(
                    vista,
                    "El nickname solo puede contener letras, números, guion y guion bajo.",
                    "Nickname incorrecto",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        if (!validarNombre(nombreReal)) {

            JOptionPane.showMessageDialog(
                    vista,
                    "El nombre solo puede contener letras y espacios.",
                    "Nombre incorrecto",
                    JOptionPane.WARNING_MESSAGE
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
                    "La fecha debe tener el formato yyyy-MM-dd.",
                    "Fecha incorrecta",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        Integer idEquipo =
                obtenerIdEquipo();

        try {

            Jugador nuevoJugador =
                    new Jugador(
                            nickname,
                            nombreReal,
                            fechaNacimiento,
                            rol,
                            idEquipo
                    );

            nuevoJugador.insertarJugador();

            cargarJugadores();
            limpiarCampos();

            JOptionPane.showMessageDialog(
                    vista,
                    "Jugador registrado correctamente.",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    vista,
                    e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void seleccionarJugador() {

        int fila =
                vista.getTblJugadores()
                        .getSelectedRow();

        if (fila == -1) {
            return;
        }

        try {

            idJugadorSeleccionado =
                    Integer.parseInt(
                            vista.getTblJugadores()
                                    .getValueAt(fila, 0)
                                    .toString()
                    );

            Object nickname =
                    vista.getTblJugadores()
                            .getValueAt(fila, 1);

            Object nombre =
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
                    nombre == null
                            ? ""
                            : nombre.toString()
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

            if (equipo == null) {

                vista.getCmbEquipo()
                        .setSelectedIndex(0);

            } else {

                seleccionarEquipo(
                        Integer.parseInt(
                                equipo.toString()
                        )
                );
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Error al seleccionar jugador:\n"
                    + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void seleccionarEquipo(int idEquipo) {

        for (int i = 0;
                i < idsEquipos.size();
                i++) {

            Integer id =
                    idsEquipos.get(i);

            if (id != null
                    && id.equals(idEquipo)) {

                vista.getCmbEquipo()
                        .setSelectedIndex(i);

                return;
            }
        }

        vista.getCmbEquipo()
                .setSelectedIndex(0);
    }

    private Integer obtenerIdEquipo() {

        int posicion =
                vista.getCmbEquipo()
                        .getSelectedIndex();

        if (posicion < 0
                || posicion >= idsEquipos.size()) {

            return null;
        }

        return idsEquipos.get(posicion);
    }

    private void modificarJugador() {

        if (idJugadorSeleccionado == -1) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Seleccione un jugador de la tabla.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE
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

        String rol =
                vista.getRolSeleccionado();

        if (nickname.isEmpty()
                || nombreReal.isEmpty()
                || fechaTexto.isEmpty()
                || rol.isEmpty()
                || rol.equalsIgnoreCase("Seleccione...")) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Todos los campos son obligatorios.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        if (!validarNickname(nickname)) {

            JOptionPane.showMessageDialog(
                    vista,
                    "El nickname no es válido.",
                    "Error",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        if (!validarNombre(nombreReal)) {

            JOptionPane.showMessageDialog(
                    vista,
                    "El nombre no es válido.",
                    "Error",
                    JOptionPane.WARNING_MESSAGE
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
                    "La fecha debe tener el formato yyyy-MM-dd.",
                    "Fecha incorrecta",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        Integer idEquipo =
                obtenerIdEquipo();

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

        try {

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
                    "Jugador modificado correctamente.",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    vista,
                    e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void inhabilitarJugador() {

        if (idJugadorSeleccionado == -1) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Seleccione un jugador de la tabla.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE
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

        try {

            modelo.inhabilitarJugador(
                    idJugadorSeleccionado
            );

            cargarJugadores();
            limpiarCampos();

            JOptionPane.showMessageDialog(
                    vista,
                    "Jugador inhabilitado correctamente.",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    vista,
                    e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void habilitarJugador() {

        if (idJugadorSeleccionado == -1) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Seleccione un jugador de la tabla.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE
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

        try {

            modelo.habilitarJugador(
                    idJugadorSeleccionado
            );

            cargarJugadores();
            limpiarCampos();

            JOptionPane.showMessageDialog(
                    vista,
                    "Jugador habilitado correctamente.",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    vista,
                    e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void limpiarCampos() {

        vista.setTxtNickname("");
        vista.setTxtNombreReal("");
        vista.setTxtFechaNacimiento("");
        vista.setCmbRol("Seleccione...");

        if (vista.getCmbEquipo().getItemCount() > 0) {
            vista.getCmbEquipo()
                    .setSelectedIndex(0);
        }

        idJugadorSeleccionado = -1;

        vista.getTblJugadores()
                .clearSelection();
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