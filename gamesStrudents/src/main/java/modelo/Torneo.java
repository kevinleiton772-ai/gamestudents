package modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Torneo {

    private int idTorneo;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private BigDecimal premioTotal;
    private int numRondas;

    public Torneo() {
    }

    public Torneo(int idTorneo, String nombre,
                  LocalDate fechaInicio, LocalDate fechaFin,
                  BigDecimal premioTotal, int numRondas) {
        this.idTorneo = idTorneo;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.premioTotal = premioTotal;
        this.numRondas = numRondas;
    }

    public Torneo(String nombre,
                  LocalDate fechaInicio, LocalDate fechaFin,
                  BigDecimal premioTotal, int numRondas) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.premioTotal = premioTotal;
        this.numRondas = numRondas;
    }

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public BigDecimal getPremioTotal() {
        return premioTotal;
    }

    public void setPremioTotal(BigDecimal premioTotal) {
        this.premioTotal = premioTotal;
    }

    public int getNumRondas() {
        return numRondas;
    }

    public void setNumRondas(int numRondas) {
        this.numRondas = numRondas;
    }

    @Override
    public String toString() {
        return nombre;
    }
}