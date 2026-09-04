package controlador;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Partido;
import vista.PartidoVista;

public class partidoControlador {

    private Partido modelo;
    private PartidoVista vista;
    private JFrame ventanaAnterior;

    private int idPartidoSeleccionado = -1;

    public partidoControlador() {
    }

    public partidoControlador(
            Partido modelo,
            PartidoVista vista,
            JFrame ventanaAnterior) {

        this.modelo = modelo;
        this.vista = vista;
        this.ventanaAnterior = ventanaAnterior;
    }

    public void iniciar() {

        vista.getBtnCrear().addActionListener(
                e -> insertarPartido()
        );

        vista.getBtnModificar().addActionListener(
                e -> modificarPartido()
        );

        vista.getBtnInhabilitar().addActionListener(
                e -> inhabilitarPartido()
        );

        vista.getBtnHabilitar().addActionListener(
                e -> habilitarPartido()
        );

        vista.getBtnSalir().addActionListener(
                e -> salir()
        );

        vista.getTblPartidos()
                .getSelectionModel()
                .addListSelectionListener(e -> {

                    if (!e.getValueIsAdjusting()) {
                        seleccionarPartido();
                    }
                });

        cargarPartidos();

        vista.setVisible(true);
    }

    public void cargarPartidos() {

        modelo = new Partido();

        modelo.listarPartidos(
                vista.getTblPartidos()
        );
    }

    private void insertarPartido() {

        String fechaTexto =
                vista.getTxtFecha()
                        .getText()
                        .trim();

        String horaTexto =
                vista.getTxtHora()
                        .getText()
                        .trim();

        String marcador1Texto =
                vista.getTxtMarcadorEquipo1()
                        .getText()
                        .trim();

        String marcador2Texto =
                vista.getTxtMarcadorEquipo2()
                        .getText()
                        .trim();

        String rondaTexto =
                vista.getTxtRonda()
                        .getText()
                        .trim();

        String fase =
                vista.getTxtFase()
                        .getText()
                        .trim();

        String estado =
                vista.getTxtEstado()
                        .getText()
                        .trim();

        String equipo1Texto =
                obtenerValorCombo(
                        vista.getCmbEquipo1()
                );

        String equipo2Texto =
                obtenerValorCombo(
                        vista.getCmbEquipo2()
                );

        String torneoTexto =
                obtenerValorCombo(
                        vista.getCmbTorneo()
                );

        String arbitroTexto =
                obtenerValorCombo(
                        vista.getCmbArbitro()
                );

        String sedeTexto =
                obtenerValorCombo(
                        vista.getCmbSede()
                );

        if (fechaTexto.isEmpty()
                || horaTexto.isEmpty()
                || marcador1Texto.isEmpty()
                || marcador2Texto.isEmpty()
                || rondaTexto.isEmpty()
                || fase.isEmpty()
                || estado.isEmpty()
                || equipo1Texto.isEmpty()
                || equipo2Texto.isEmpty()
                || torneoTexto.isEmpty()) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Complete todos los campos obligatorios."
            );

            return;
        }

        try {

            LocalDate fecha =
                    LocalDate.parse(fechaTexto);

            LocalTime hora =
                    LocalTime.parse(horaTexto);

            int marcador1 =
                    Integer.parseInt(marcador1Texto);

            int marcador2 =
                    Integer.parseInt(marcador2Texto);

            int ronda =
                    Integer.parseInt(rondaTexto);

            int idEquipo1 =
                    obtenerId(equipo1Texto);

            int idEquipo2 =
                    obtenerId(equipo2Texto);

            int idTorneo =
                    obtenerId(torneoTexto);

            Integer idArbitro = null;

            Integer idSede = null;

            if (!arbitroTexto.isEmpty()) {

                idArbitro =
                        obtenerId(arbitroTexto);
            }

            if (!sedeTexto.isEmpty()) {

                idSede =
                        obtenerId(sedeTexto);
            }

            if (idEquipo1 == idEquipo2) {

                JOptionPane.showMessageDialog(
                        vista,
                        "El equipo 1 y el equipo 2 deben ser diferentes."
                );

                return;
            }

            if (marcador1 < 0
                    || marcador2 < 0) {

                JOptionPane.showMessageDialog(
                        vista,
                        "Los marcadores no pueden ser negativos."
                );

                return;
            }

            if (ronda <= 0) {

                JOptionPane.showMessageDialog(
                        vista,
                        "La ronda debe ser mayor que cero."
                );

                return;
            }

            modelo = new Partido(
                    fecha,
                    hora,
                    marcador1,
                    marcador2,
                    ronda,
                    fase,
                    estado,
                    idEquipo1,
                    idEquipo2,
                    idTorneo,
                    idArbitro,
                    idSede
            );

            modelo.insertarPartido();

            cargarPartidos();

            limpiarCampos();

            JOptionPane.showMessageDialog(
                    vista,
                    "Partido registrado correctamente."
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Error al registrar el partido:\n"
                    + e.getMessage()
            );
        }
    }

    private void seleccionarPartido() {

        int fila =
                vista.getTblPartidos()
                        .getSelectedRow();

        if (fila == -1) {
            return;
        }

        idPartidoSeleccionado =
                Integer.parseInt(
                        vista.getTblPartidos()
                                .getValueAt(
                                        fila,
                                        0
                                )
                                .toString()
                );

        vista.setTxtIdPartido(
                vista.getTblPartidos()
                        .getValueAt(
                                fila,
                                0
                        )
                        .toString()
        );

        vista.setTxtFecha(
                vista.getTblPartidos()
                        .getValueAt(
                                fila,
                                1
                        )
                        .toString()
        );

        vista.setTxtHora(
                vista.getTblPartidos()
                        .getValueAt(
                                fila,
                                2
                        )
                        .toString()
        );

        vista.setTxtMarcadorEquipo1(
                vista.getTblPartidos()
                        .getValueAt(
                                fila,
                                3
                        )
                        .toString()
        );

        vista.setTxtMarcadorEquipo2(
                vista.getTblPartidos()
                        .getValueAt(
                                fila,
                                4
                        )
                        .toString()
        );

        vista.setTxtRonda(
                vista.getTblPartidos()
                        .getValueAt(
                                fila,
                                5
                        )
                        .toString()
        );

        vista.setTxtFase(
                vista.getTblPartidos()
                        .getValueAt(
                                fila,
                                6
                        )
                        .toString()
        );

        vista.setTxtEstado(
                vista.getTblPartidos()
                        .getValueAt(
                                fila,
                                7
                        )
                        .toString()
        );

        seleccionarCombo(
                vista.getCmbEquipo1(),
                vista.getTblPartidos()
                        .getValueAt(fila, 8)
        );

        seleccionarCombo(
                vista.getCmbEquipo2(),
                vista.getTblPartidos()
                        .getValueAt(fila, 9)
        );

        seleccionarCombo(
                vista.getCmbTorneo(),
                vista.getTblPartidos()
                        .getValueAt(fila, 10)
        );

        seleccionarCombo(
                vista.getCmbArbitro(),
                vista.getTblPartidos()
                        .getValueAt(fila, 11)
        );

        seleccionarCombo(
                vista.getCmbSede(),
                vista.getTblPartidos()
                        .getValueAt(fila, 12)
        );
    }

    private void modificarPartido() {

        if (idPartidoSeleccionado == -1) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Seleccione un partido de la tabla."
            );

            return;
        }

        String fechaTexto =
                vista.getTxtFecha()
                        .getText()
                        .trim();

        String horaTexto =
                vista.getTxtHora()
                        .getText()
                        .trim();

        String marcador1Texto =
                vista.getTxtMarcadorEquipo1()
                        .getText()
                        .trim();

        String marcador2Texto =
                vista.getTxtMarcadorEquipo2()
                        .getText()
                        .trim();

        String rondaTexto =
                vista.getTxtRonda()
                        .getText()
                        .trim();

        String fase =
                vista.getTxtFase()
                        .getText()
                        .trim();

        String estado =
                vista.getTxtEstado()
                        .getText()
                        .trim();

        String equipo1Texto =
                obtenerValorCombo(
                        vista.getCmbEquipo1()
                );

        String equipo2Texto =
                obtenerValorCombo(
                        vista.getCmbEquipo2()
                );

        String torneoTexto =
                obtenerValorCombo(
                        vista.getCmbTorneo()
                );

        String arbitroTexto =
                obtenerValorCombo(
                        vista.getCmbArbitro()
                );

        String sedeTexto =
                obtenerValorCombo(
                        vista.getCmbSede()
                );

        if (fechaTexto.isEmpty()
                || horaTexto.isEmpty()
                || marcador1Texto.isEmpty()
                || marcador2Texto.isEmpty()
                || rondaTexto.isEmpty()
                || fase.isEmpty()
                || estado.isEmpty()
                || equipo1Texto.isEmpty()
                || equipo2Texto.isEmpty()
                || torneoTexto.isEmpty()) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Complete todos los campos obligatorios."
            );

            return;
        }

        try {

            LocalDate fecha =
                    LocalDate.parse(fechaTexto);

            LocalTime hora =
                    LocalTime.parse(horaTexto);

            int marcador1 =
                    Integer.parseInt(marcador1Texto);

            int marcador2 =
                    Integer.parseInt(marcador2Texto);

            int ronda =
                    Integer.parseInt(rondaTexto);

            int idEquipo1 =
                    obtenerId(equipo1Texto);

            int idEquipo2 =
                    obtenerId(equipo2Texto);

            int idTorneo =
                    obtenerId(torneoTexto);

            Integer idArbitro = null;

            Integer idSede = null;

            if (!arbitroTexto.isEmpty()) {

                idArbitro =
                        obtenerId(arbitroTexto);
            }

            if (!sedeTexto.isEmpty()) {

                idSede =
                        obtenerId(sedeTexto);
            }

            if (idEquipo1 == idEquipo2) {

                JOptionPane.showMessageDialog(
                        vista,
                        "Los equipos deben ser diferentes."
                );

                return;
            }

            int respuesta =
                    JOptionPane.showConfirmDialog(
                            vista,
                            "¿Está seguro de modificar este partido?",
                            "Modificar partido",
                            JOptionPane.YES_NO_OPTION
                    );

            if (respuesta != JOptionPane.YES_OPTION) {
                return;
            }

            modelo = new Partido();

            modelo.modificarPartido(
                    idPartidoSeleccionado,
                    fecha,
                    hora,
                    marcador1,
                    marcador2,
                    ronda,
                    fase,
                    estado,
                    idEquipo1,
                    idEquipo2,
                    idTorneo,
                    idArbitro,
                    idSede
            );

            cargarPartidos();

            limpiarCampos();

            JOptionPane.showMessageDialog(
                    vista,
                    "Partido modificado correctamente."
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Error al modificar el partido:\n"
                    + e.getMessage()
            );
        }
    }

    private void inhabilitarPartido() {

        if (idPartidoSeleccionado == -1) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Seleccione un partido de la tabla."
            );

            return;
        }

        int respuesta =
                JOptionPane.showConfirmDialog(
                        vista,
                        "¿Está seguro de inhabilitar este partido?",
                        "Inhabilitar partido",
                        JOptionPane.YES_NO_OPTION
                );

        if (respuesta != JOptionPane.YES_OPTION) {
            return;
        }

        modelo = new Partido();

        modelo.inhabilitarPartido(
                idPartidoSeleccionado
        );

        cargarPartidos();

        limpiarCampos();

        JOptionPane.showMessageDialog(
                vista,
                "Partido inhabilitado correctamente."
        );
    }

    private void habilitarPartido() {

        if (idPartidoSeleccionado == -1) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Seleccione un partido de la tabla."
            );

            return;
        }

        int respuesta =
                JOptionPane.showConfirmDialog(
                        vista,
                        "¿Está seguro de habilitar este partido?",
                        "Habilitar partido",
                        JOptionPane.YES_NO_OPTION
                );

        if (respuesta != JOptionPane.YES_OPTION) {
            return;
        }

        modelo = new Partido();

        modelo.habilitarPartido(
                idPartidoSeleccionado
        );

        cargarPartidos();

        limpiarCampos();

        JOptionPane.showMessageDialog(
                vista,
                "Partido habilitado correctamente."
        );
    }

    private String obtenerValorCombo(
            JComboBox<String> combo) {

        if (combo.getSelectedItem() == null) {
            return "";
        }

        String valor =
                combo.getSelectedItem()
                        .toString()
                        .trim();

        if (valor.equalsIgnoreCase("Seleccione...")
                || valor.equalsIgnoreCase("Seleccione")) {

            return "";
        }

        return valor;
    }

    private int obtenerId(String valor) {

        valor = valor.trim();

        if (valor.contains("-")) {

            String id =
                    valor.substring(
                            0,
                            valor.indexOf("-")
                    ).trim();

            return Integer.parseInt(id);
        }

        return Integer.parseInt(valor);
    }

    private void seleccionarCombo(
            JComboBox<String> combo,
            Object valor) {

        if (valor == null) {
            return;
        }

        String id =
                valor.toString().trim();

        for (int i = 0;
                i < combo.getItemCount();
                i++) {

            String item =
                    combo.getItemAt(i);

            if (item == null) {
                continue;
            }

            if (item.equals(id)
                    || item.startsWith(id + " -")
                    || item.startsWith(id + "-")) {

                combo.setSelectedIndex(i);
                return;
            }
        }
    }

    private void limpiarCampos() {

        vista.setTxtIdPartido("");
        vista.setTxtFecha("");
        vista.setTxtHora("");
        vista.setTxtMarcadorEquipo1("0");
        vista.setTxtMarcadorEquipo2("0");
        vista.setTxtRonda("1");
        vista.setTxtFase("FASE DE GRUPOS");
        vista.setTxtEstado("PROGRAMADO");

        if (vista.getCmbEquipo1().getItemCount() > 0) {
            vista.getCmbEquipo1().setSelectedIndex(0);
        }

        if (vista.getCmbEquipo2().getItemCount() > 0) {
            vista.getCmbEquipo2().setSelectedIndex(0);
        }

        if (vista.getCmbTorneo().getItemCount() > 0) {
            vista.getCmbTorneo().setSelectedIndex(0);
        }

        if (vista.getCmbArbitro().getItemCount() > 0) {
            vista.getCmbArbitro().setSelectedIndex(0);
        }

        if (vista.getCmbSede().getItemCount() > 0) {
            vista.getCmbSede().setSelectedIndex(0);
        }

        idPartidoSeleccionado = -1;
    }

    public void salir() {

        vista.dispose();

        if (ventanaAnterior != null) {
            ventanaAnterior.setVisible(true);
        }
    }
}
