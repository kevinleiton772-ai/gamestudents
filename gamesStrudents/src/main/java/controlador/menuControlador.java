package controlador;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modelo.Jugador;
import modelo.Equipo;
import modelo.Partido;
import modelo.Menu;
import modelo.Torneo;

import vista.MenuVista;
import vista.JugadoresVista;
import vista.EquipoVista;
import vista.PartidoVista;
import vista.TorneoVista;

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

    vista.getBtnTorneos().addActionListener(
            e -> abrirTorneos()
    );

    vista.setLocationRelativeTo(null);
    vista.setVisible(true);
}

private void abrirJugadores() {

    try {

        Jugador modeloJugador = new Jugador();

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
                "Error al abrir jugadores:\n"
                + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
}

private void abrirEquipos() {

    try {

        Equipo modeloEquipo = new Equipo();

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
                "Error al abrir equipos:\n"
                + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
}

private void abrirPartidos() {

    try {

        Partido modeloPartido = new Partido();

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
                "Error al abrir partidos:\n"
                + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
}

private void abrirTorneos() {

    try {

        Torneo modeloTorneo =
                new Torneo();

        TorneoVista vistaTorneo =
                new TorneoVista();

        TorneoControlador controladorTorneo =
                new TorneoControlador(
                        modeloTorneo,
                        vistaTorneo,
                        vista
                );

        vista.setVisible(false);

        controladorTorneo.iniciar();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
                vista,
                "Error al abrir torneos:\n"
                + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
        );

        e.printStackTrace();
    }
}


}