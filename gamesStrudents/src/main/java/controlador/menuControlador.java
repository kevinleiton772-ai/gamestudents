package controlador;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Jugador;
import modelo.Equipo;
import modelo.Partido;
import modelo.Menu;
import vista.MenuVista;
import vista.JugadoresVista;
import vista.EquipoVista;
import vista.PartidoVista;

public class menuControlador {

    private Menu modelo;
    private MenuVista vista;
    private JFrame ventanaAnterior;

    public menuControlador() {
    }

    public menuControlador(
            Menu modelo,
            MenuVista vista,
            JFrame ventanaAnterior) {

        this.modelo = modelo;
        this.vista = vista;
        this.ventanaAnterior = ventanaAnterior;
    }

    public void iniciar() {

        vista.getBtnJugadores().addActionListener(
                e -> abrirJugadores()
        );

        vista.getBtnEquipos().addActionListener(
                e -> abrirEquipos()
        );

        vista.getBtnPartidos().addActionListener(
                e -> abrirPartidos()
        );

        vista.setVisible(true);
    }

    private void abrirJugadores() {

        try {

            Jugador modeloJugador =
                    new Jugador();

            JugadoresVista vistaJugador =
                    new JugadoresVista();

            jugadorControlador controladorJugador =
                    new jugadorControlador(
                            modeloJugador,
                            vistaJugador,
                            vista
                    );

            vista.setVisible(false);

            controladorJugador.iniciar();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Error al abrir la vista de jugadores:\n"
                    + e.getMessage()
            );

            e.printStackTrace();
        }
    }

    private void abrirEquipos() {

        try {

            Equipo modeloEquipo =
                    new Equipo();

            EquipoVista vistaEquipo =
                    new EquipoVista();

            equipoControlador controladorEquipo =
                    new equipoControlador(
                            modeloEquipo,
                            vistaEquipo,
                            vista
                    );

            vista.setVisible(false);

            controladorEquipo.iniciar();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Error al abrir la vista de equipos:\n"
                    + e.getMessage()
            );

            e.printStackTrace();
        }
    }

    private void abrirPartidos() {

        try {

            Partido modeloPartido =
                    new Partido();

            PartidoVista vistaPartido =
                    new PartidoVista();

            partidoControlador controladorPartido =
                    new partidoControlador(
                            modeloPartido,
                            vistaPartido,
                            vista
                    );

            vista.setVisible(false);

            controladorPartido.iniciar();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Error al abrir la vista de partidos:\n"
                    + e.getMessage()
            );

            e.printStackTrace();
        }
    }
}