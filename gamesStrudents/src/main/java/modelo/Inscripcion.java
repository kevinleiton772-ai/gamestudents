package modelo;

import java.time.LocalDate;

public class Inscripcion {

    private int idInscrip;
    private LocalDate fechaInscripcion;
    private Integer posicionObtenida;
    private int idTorneo;
    private int codigoEquipo;

    public Inscripcion() {
    }

    public Inscripcion(int idInscrip, LocalDate fechaInscripcion,
                       Integer posicionObtenida, int idTorneo,
                       int codigoEquipo) {
        this.idInscrip = idInscrip;
        this.fechaInscripcion = fechaInscripcion;
        this.posicionObtenida = posicionObtenida;
        this.idTorneo = idTorneo;
        this.codigoEquipo = codigoEquipo;
    }

    public Inscripcion(LocalDate fechaInscripcion,
                       Integer posicionObtenida, int idTorneo,
                       int codigoEquipo) {
        this.fechaInscripcion = fechaInscripcion;
        this.posicionObtenida = posicionObtenida;
        this.idTorneo = idTorneo;
        this.codigoEquipo = codigoEquipo;
    }

    public int getIdInscrip() {
        return idInscrip;
    }

    public void setIdInscrip(int idInscrip) {
        this.idInscrip = idInscrip;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public Integer getPosicionObtenida() {
        return posicionObtenida;
    }

    public void setPosicionObtenida(Integer posicionObtenida) {
        this.posicionObtenida = posicionObtenida;
    }

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public int getCodigoEquipo() {
        return codigoEquipo;
    }

    public void setCodigoEquipo(int codigoEquipo) {
        this.codigoEquipo = codigoEquipo;
    }

    @Override
    public String toString() {
        return "Inscripción #" + idInscrip;
    }
}