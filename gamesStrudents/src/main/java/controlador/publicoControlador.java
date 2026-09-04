package controlador;

import javax.swing.JFrame;
import modelo.Partido;
import vista.publicoVista;

public class publicoControlador {

    private Partido modelo;
    private publicoVista vista;
    private JFrame ventanaAnterior;

    public publicoControlador(
            Partido modelo,
            publicoVista vista,
            JFrame ventanaAnterior) {

        this.modelo = modelo;
        this.vista = vista;
        this.ventanaAnterior = ventanaAnterior;
    }

    public void iniciar() {

        cargarPartidos();

        vista.getBtnSalir().addActionListener(
                e -> salir()
        );

        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    private void cargarPartidos() {

        modelo.listarPartidosPublicos(
                vista.getTblPartidos()
        );
    }

    private void salir() {

        vista.dispose();

        if (ventanaAnterior != null) {
            ventanaAnterior.setVisible(true);
        }
    }
}
