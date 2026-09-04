package controlador;

import java.time.LocalDate;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Equipo;
import vista.EquipoVista;

public class equipoControlador {

    private Equipo modelo;
    private EquipoVista vista;
    private JFrame ventanaAnterior;

    private int codigoEquipoSeleccionado = -1;

    public equipoControlador() {
    }

    public equipoControlador(
            Equipo modelo,
            EquipoVista vista,
            JFrame ventanaAnterior) {

        this.modelo = modelo;
        this.vista = vista;
        this.ventanaAnterior = ventanaAnterior;
    }

    public void iniciar() {

        vista.getBtnCrear().addActionListener(
                e -> insertarEquipo()
        );

        vista.getBtnModificar().addActionListener(
                e -> modificarEquipo()
        );

        vista.getBtnInhabilitar().addActionListener(
                e -> inhabilitarEquipo()
        );

        vista.getBtnHabilitar().addActionListener(
                e -> habilitarEquipo()
        );

        vista.getBtnSalir().addActionListener(
                e -> salir()
        );

        vista.getTblEquipos()
                .getSelectionModel()
                .addListSelectionListener(e -> {

                    if (!e.getValueIsAdjusting()) {
                        seleccionarEquipo();
                    }
                });

        cargarEquipos();

        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    public void cargarEquipos() {

        modelo.listarEquipos(
                vista.getTblEquipos()
        );
    }

    public void insertarEquipo() {

        String codigoTexto =
                vista.getTxtCodigo()
                        .getText()
                        .trim();

        String nombre =
                vista.getTxtNombre()
                        .getText()
                        .trim();

        String paisProcedencia =
                vista.getTxtPaisProcedencia()
                        .getText()
                        .trim();

        String fechaTexto =
                vista.getTxtFechaFundacion()
                        .getText()
                        .trim();

        String entrenador =
                vista.getTxtEntrenador()
                        .getText()
                        .trim();

        if (codigoTexto.isEmpty()
                || nombre.isEmpty()
                || paisProcedencia.isEmpty()
                || fechaTexto.isEmpty()
                || entrenador.isEmpty()) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Todos los campos son obligatorios.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        int codigo;

        try {

            codigo =
                    Integer.parseInt(
                            codigoTexto
                    );

            if (codigo <= 0) {

                JOptionPane.showMessageDialog(
                        vista,
                        "El código debe ser mayor que cero.",
                        "Código incorrecto",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    vista,
                    "El código debe ser un número.",
                    "Código incorrecto",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        LocalDate fechaFundacion;

        try {

            fechaFundacion =
                    LocalDate.parse(
                            fechaTexto
                    );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    vista,
                    "La fecha debe tener el formato yyyy-MM-dd.",
                    "Fecha incorrecta",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        modelo =
                new Equipo(
                        codigo,
                        nombre,
                        paisProcedencia,
                        fechaFundacion,
                        entrenador
                );

        modelo.insertarEquipo();

        cargarEquipos();

        limpiarCampos();

        JOptionPane.showMessageDialog(
                vista,
                "Equipo registrado correctamente.",
                "Equipo",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public void seleccionarEquipo() {

        int fila =
                vista.getTblEquipos()
                        .getSelectedRow();

        if (fila == -1) {
            return;
        }

        try {

            codigoEquipoSeleccionado =
                    Integer.parseInt(
                            vista.getTblEquipos()
                                    .getValueAt(
                                            fila,
                                            0
                                    )
                                    .toString()
                    );

        } catch (Exception e) {

            codigoEquipoSeleccionado = -1;

            return;
        }

        Object nombre =
                vista.getTblEquipos()
                        .getValueAt(
                                fila,
                                1
                        );

        Object pais =
                vista.getTblEquipos()
                        .getValueAt(
                                fila,
                                2
                        );

        Object fecha =
                vista.getTblEquipos()
                        .getValueAt(
                                fila,
                                3
                        );

        Object entrenador =
                vista.getTblEquipos()
                        .getValueAt(
                                fila,
                                4
                        );

        vista.setTxtCodigo(
                String.valueOf(
                        codigoEquipoSeleccionado
                )
        );

        vista.setTxtNombre(
                nombre == null
                        ? ""
                        : nombre.toString()
        );

        vista.setTxtPaisProcedencia(
                pais == null
                        ? ""
                        : pais.toString()
        );

        vista.setTxtFechaFundacion(
                fecha == null
                        ? ""
                        : fecha.toString()
        );

        vista.setTxtEntrenador(
                entrenador == null
                        ? ""
                        : entrenador.toString()
        );
    }

    public void modificarEquipo() {

        if (codigoEquipoSeleccionado == -1) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Seleccione un equipo de la tabla.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        String nombre =
                vista.getTxtNombre()
                        .getText()
                        .trim();

        String paisProcedencia =
                vista.getTxtPaisProcedencia()
                        .getText()
                        .trim();

        String fechaTexto =
                vista.getTxtFechaFundacion()
                        .getText()
                        .trim();

        String entrenador =
                vista.getTxtEntrenador()
                        .getText()
                        .trim();

        if (nombre.isEmpty()
                || paisProcedencia.isEmpty()
                || fechaTexto.isEmpty()
                || entrenador.isEmpty()) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Todos los campos son obligatorios.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        LocalDate fechaFundacion;

        try {

            fechaFundacion =
                    LocalDate.parse(
                            fechaTexto
                    );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    vista,
                    "La fecha debe tener el formato yyyy-MM-dd.",
                    "Fecha incorrecta",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        int respuesta =
                JOptionPane.showConfirmDialog(
                        vista,
                        "¿Está seguro de modificar este equipo?",
                        "Modificar equipo",
                        JOptionPane.YES_NO_OPTION
                );

        if (respuesta != JOptionPane.YES_OPTION) {
            return;
        }

        boolean actualizado =
                modelo.modificarEquipo(
                        codigoEquipoSeleccionado,
                        nombre,
                        paisProcedencia,
                        fechaFundacion,
                        entrenador
                );

        if (actualizado) {

            cargarEquipos();

            limpiarCampos();

            JOptionPane.showMessageDialog(
                    vista,
                    "Equipo modificado correctamente.",
                    "Equipo",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } else {

            JOptionPane.showMessageDialog(
                    vista,
                    "No se pudo modificar el equipo.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void inhabilitarEquipo() {

        if (codigoEquipoSeleccionado == -1) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Seleccione un equipo de la tabla.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        int respuesta =
                JOptionPane.showConfirmDialog(
                        vista,
                        "¿Está seguro de inhabilitar este equipo?",
                        "Inhabilitar equipo",
                        JOptionPane.YES_NO_OPTION
                );

        if (respuesta != JOptionPane.YES_OPTION) {
            return;
        }

        modelo.inhabilitarEquipo(
                codigoEquipoSeleccionado
        );

        cargarEquipos();

        limpiarCampos();

        JOptionPane.showMessageDialog(
                vista,
                "Equipo inhabilitado correctamente.",
                "Equipo",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public void habilitarEquipo() {

        if (codigoEquipoSeleccionado == -1) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Seleccione un equipo de la tabla.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        int respuesta =
                JOptionPane.showConfirmDialog(
                        vista,
                        "¿Está seguro de habilitar este equipo?",
                        "Habilitar equipo",
                        JOptionPane.YES_NO_OPTION
                );

        if (respuesta != JOptionPane.YES_OPTION) {
            return;
        }

        modelo.habilitarEquipo(
                codigoEquipoSeleccionado
        );

        cargarEquipos();

        limpiarCampos();

        JOptionPane.showMessageDialog(
                vista,
                "Equipo habilitado correctamente.",
                "Equipo",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private void limpiarCampos() {

        vista.setTxtCodigo("");
        vista.setTxtNombre("");
        vista.setTxtPaisProcedencia("");
        vista.setTxtFechaFundacion("");
        vista.setTxtEntrenador("");

        codigoEquipoSeleccionado = -1;

        vista.getTblEquipos()
                .clearSelection();
    }

    public void salir() {

        vista.dispose();

        if (ventanaAnterior != null) {
            ventanaAnterior.setVisible(true);
        }
    }
}