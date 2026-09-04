package controlador;

import modelo.Torneo;
import vista.TorneoVista;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;
import java.sql.Date;

public class TorneoControlador {

    private Torneo modelo;
    private TorneoVista vista;
    private JFrame ventanaAnterior;

    public TorneoControlador() {
    }

    public TorneoControlador(
            Torneo modelo,
            TorneoVista vista,
            JFrame ventanaAnterior) {

        this.modelo = modelo;
        this.vista = vista;
        this.ventanaAnterior = ventanaAnterior;
    }

    public void iniciar() {

        cargarTorneos();

        vista.getBtnCrear().addActionListener(
                e -> crearTorneo()
        );

        vista.getBtnModificar().addActionListener(
                e -> modificarTorneo()
        );

        vista.getBtnInhabilitar().addActionListener(
                e -> inhabilitarTorneo()
        );

        vista.getBtnHabilitar().addActionListener(
                e -> habilitarTorneo()
        );

        vista.getBtnSalir().addActionListener(
                e -> salir()
        );

        vista.getTblTorneo()
                .getSelectionModel()
                .addListSelectionListener(
                        e -> cargarDatosSeleccionados()
                );

        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    private void cargarTorneos() {

        DefaultTableModel tabla =
                modelo.listarTorneos();

        vista.getTblTorneo().setModel(tabla);
    }

    private void crearTorneo() {

        try {

            String nombre =
                    vista.getTxtNombre();

            String videojuego =
                    vista.getTxtVideojuego();

            String fechaInicioTexto =
                    vista.getTxtFechaInicio();

            String fechaFinTexto =
                    vista.getTxtIFin();

            String premioTexto =
                    vista.getTxtPremio();

            String organizadorTexto =
                    vista.getTxtidOrganizador();

            int rondas =
                    (Integer) vista
                            .getSpnNumeroRondas()
                            .getValue();

            if (nombre.isEmpty()
                    || videojuego.isEmpty()
                    || fechaInicioTexto.isEmpty()
                    || fechaFinTexto.isEmpty()
                    || premioTexto.isEmpty()
                    || organizadorTexto.isEmpty()) {

                JOptionPane.showMessageDialog(
                        vista,
                        "Complete todos los campos."
                );

                return;
            }

            Date fechaInicio =
                    Date.valueOf(fechaInicioTexto);

            Date fechaFin =
                    Date.valueOf(fechaFinTexto);

            BigDecimal premio =
                    new BigDecimal(premioTexto);

            int idOrganizador =
                    Integer.parseInt(organizadorTexto);

            if (fechaFin.before(fechaInicio)) {

                JOptionPane.showMessageDialog(
                        vista,
                        "La fecha fin no puede ser anterior a la fecha inicio."
                );

                return;
            }

            if (rondas <= 0) {

                JOptionPane.showMessageDialog(
                        vista,
                        "Las rondas deben ser mayores a 0."
                );

                return;
            }

            modelo.setNombre(nombre);
            modelo.setVideojuego(videojuego);
            modelo.setFechaInicio(fechaInicio);
            modelo.setFechaFin(fechaFin);
            modelo.setPremioTotal(premio);
            modelo.setNumRondas(rondas);
            modelo.setEstado("PLANIFICADO");
            modelo.setIdOrganizador(idOrganizador);

            modelo.insertarTorneo();

            cargarTorneos();
            limpiarCampos();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Error al crear torneo:\n"
                    + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void modificarTorneo() {

        try {

            int fila =
                    vista.getTblTorneo()
                            .getSelectedRow();

            if (fila == -1) {

                JOptionPane.showMessageDialog(
                        vista,
                        "Seleccione un torneo."
                );

                return;
            }

            int id =
                    Integer.parseInt(
                            vista.getTblTorneo()
                                    .getValueAt(fila, 0)
                                    .toString()
                    );

            String nombre =
                    vista.getTxtNombre();

            String videojuego =
                    vista.getTxtVideojuego();

            Date fechaInicio =
                    Date.valueOf(
                            vista.getTxtFechaInicio()
                    );

            Date fechaFin =
                    Date.valueOf(
                            vista.getTxtIFin()
                    );

            BigDecimal premio =
                    new BigDecimal(
                            vista.getTxtPremio()
                    );

            int rondas =
                    (Integer) vista
                            .getSpnNumeroRondas()
                            .getValue();

            int idOrganizador =
                    Integer.parseInt(
                            vista.getTxtidOrganizador()
                    );

            modelo.modificarTorneo(
                    id,
                    nombre,
                    videojuego,
                    fechaInicio,
                    fechaFin,
                    premio,
                    rondas,
                    "PLANIFICADO",
                    idOrganizador
            );

            cargarTorneos();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Error al modificar torneo:\n"
                    + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void inhabilitarTorneo() {

        try {

            int fila =
                    vista.getTblTorneo()
                            .getSelectedRow();

            if (fila == -1) {

                JOptionPane.showMessageDialog(
                        vista,
                        "Seleccione un torneo."
                );

                return;
            }

            int id =
                    Integer.parseInt(
                            vista.getTblTorneo()
                                    .getValueAt(fila, 0)
                                    .toString()
                    );

            modelo.inhabilitarTorneo(id);

            cargarTorneos();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Error al inhabilitar torneo:\n"
                    + e.getMessage()
            );
        }
    }

    private void habilitarTorneo() {

        try {

            int fila =
                    vista.getTblTorneo()
                            .getSelectedRow();

            if (fila == -1) {

                JOptionPane.showMessageDialog(
                        vista,
                        "Seleccione un torneo."
                );

                return;
            }

            int id =
                    Integer.parseInt(
                            vista.getTblTorneo()
                                    .getValueAt(fila, 0)
                                    .toString()
                    );

            modelo.habilitarTorneo(id);

            cargarTorneos();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Error al habilitar torneo:\n"
                    + e.getMessage()
            );
        }
    }

    private void cargarDatosSeleccionados() {

        int fila =
                vista.getTblTorneo()
                        .getSelectedRow();

        if (fila == -1) {
            return;
        }

        try {

            vista.setTxtNombre(
                    vista.getTblTorneo()
                            .getValueAt(fila, 1)
                            .toString()
            );

            vista.setTxtVideojuego(
                    vista.getTblTorneo()
                            .getValueAt(fila, 2)
                            .toString()
            );

            vista.setTxtFechaInicio(
                    vista.getTblTorneo()
                            .getValueAt(fila, 3)
                            .toString()
            );

            vista.setTxtIFin(
                    vista.getTblTorneo()
                            .getValueAt(fila, 4)
                            .toString()
            );

            vista.setTxtPremio(
                    vista.getTblTorneo()
                            .getValueAt(fila, 5)
                            .toString()
            );

            vista.getSpnNumeroRondas()
                    .setValue(
                            Integer.parseInt(
                                    vista.getTblTorneo()
                                            .getValueAt(fila, 6)
                                            .toString()
                            )
                    );

            Object organizador =
                    vista.getTblTorneo()
                            .getValueAt(fila, 8);

            if (organizador != null) {

                vista.setTxtidOrganizador(
                        organizador.toString()
                );
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Error al seleccionar torneo:\n"
                    + e.getMessage()
            );
        }
    }

    private void limpiarCampos() {

        vista.setTxtNombre("");
        vista.setTxtVideojuego("");
        vista.setTxtFechaInicio("");
        vista.setTxtIFin("");
        vista.setTxtPremio("");
        vista.setTxtidOrganizador("");

        vista.getSpnNumeroRondas()
                .setValue(1);
    }

    private void salir() {

        vista.dispose();

        if (ventanaAnterior != null) {
            ventanaAnterior.setVisible(true);
        }
    }
}
