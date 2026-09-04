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

        vista.setVisible(true);
    }

    public void cargarEquipos() {

        if (modelo == null) {
            modelo = new Equipo();
        }

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
                    "Todos los campos son obligatorios."
            );

            return;
        }

        int codigo;

        try {

            codigo =
                    Integer.parseInt(codigoTexto);

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    vista,
                    "El código debe ser un número."
            );

            return;
        }

        if (codigo <= 0) {

            JOptionPane.showMessageDialog(
                    vista,
                    "El código debe ser mayor que cero."
            );

            return;
        }

        LocalDate fechaFundacion;

        try {

            fechaFundacion =
                    LocalDate.parse(fechaTexto);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    vista,
                    "La fecha debe tener el formato yyyy-MM-dd."
            );

            return;
        }

        modelo = new Equipo(
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
                "Equipo registrado correctamente."
        );
    }

    public void seleccionarEquipo() {

        int fila =
                vista.getTblEquipos()
                        .getSelectedRow();

        if (fila == -1) {
            return;
        }

        Object codigo =
                vista.getTblEquipos()
                        .getValueAt(fila, 0);

        if (codigo == null) {
            return;
        }

        codigoEquipoSeleccionado =
                Integer.parseInt(
                        codigo.toString()
                );

        vista.setTxtCodigo(
                codigo.toString()
        );

        vista.setTxtNombre(
                vista.getTblEquipos()
                        .getValueAt(fila, 1)
                        .toString()
        );

        vista.setTxtPaisProcedencia(
                vista.getTblEquipos()
                        .getValueAt(fila, 2)
                        .toString()
        );

        vista.setTxtFechaFundacion(
                vista.getTblEquipos()
                        .getValueAt(fila, 3)
                        .toString()
        );

        vista.setTxtEntrenador(
                vista.getTblEquipos()
                        .getValueAt(fila, 4)
                        .toString()
        );
    }

    public void modificarEquipo() {

        if (codigoEquipoSeleccionado == -1) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Seleccione un equipo de la tabla."
            );

            return;
        }

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
                    "Todos los campos son obligatorios."
            );

            return;
        }

        int codigo;

        try {

            codigo =
                    Integer.parseInt(codigoTexto);

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    vista,
                    "El código debe ser un número."
            );

            return;
        }

        LocalDate fechaFundacion;

        try {

            fechaFundacion =
                    LocalDate.parse(fechaTexto);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    vista,
                    "La fecha debe tener el formato yyyy-MM-dd."
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

        if (modelo == null) {
            modelo = new Equipo();
        }

        modelo.modificarEquipo(
                codigoEquipoSeleccionado,
                codigo,
                nombre,
                paisProcedencia,
                fechaFundacion,
                entrenador
        );

        cargarEquipos();

        limpiarCampos();

        JOptionPane.showMessageDialog(
                vista,
                "Equipo modificado correctamente."
        );
    }

    public void inhabilitarEquipo() {

        if (codigoEquipoSeleccionado == -1) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Seleccione un equipo de la tabla."
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

        if (modelo == null) {
            modelo = new Equipo();
        }

        modelo.inhabilitarEquipo(
                codigoEquipoSeleccionado
        );

        cargarEquipos();

        limpiarCampos();

        JOptionPane.showMessageDialog(
                vista,
                "Equipo inhabilitado correctamente."
        );
    }

    public void habilitarEquipo() {

        if (codigoEquipoSeleccionado == -1) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Seleccione un equipo de la tabla."
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

        if (modelo == null) {
            modelo = new Equipo();
        }

        modelo.habilitarEquipo(
                codigoEquipoSeleccionado
        );

        cargarEquipos();

        limpiarCampos();

        JOptionPane.showMessageDialog(
                vista,
                "Equipo habilitado correctamente."
        );
    }

    private void limpiarCampos() {

        vista.setTxtCodigo("");
        vista.setTxtNombre("");
        vista.setTxtPaisProcedencia("");
        vista.setTxtFechaFundacion("");
        vista.setTxtEntrenador("");

        codigoEquipoSeleccionado = -1;
    }

    public void salir() {

        vista.dispose();

        if (ventanaAnterior != null) {
            ventanaAnterior.setVisible(true);
        }
    }
}
