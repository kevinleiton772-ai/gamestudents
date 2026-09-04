package modelo;

import java.math.BigDecimal;

public class Patrocinio {

    private int idPatrocinio;
    private int idPatrocinador;
    private int idTorneo;
    private BigDecimal montoAportado;

    public Patrocinio() {
    }

    public Patrocinio(int idPatrocinio, int idPatrocinador,
                      int idTorneo, BigDecimal montoAportado) {
        this.idPatrocinio = idPatrocinio;
        this.idPatrocinador = idPatrocinador;
        this.idTorneo = idTorneo;
        this.montoAportado = montoAportado;
    }

    public Patrocinio(int idPatrocinador, int idTorneo,
                      BigDecimal montoAportado) {
        this.idPatrocinador = idPatrocinador;
        this.idTorneo = idTorneo;
        this.montoAportado = montoAportado;
    }

    public int getIdPatrocinio() {
        return idPatrocinio;
    }

    public void setIdPatrocinio(int idPatrocinio) {
        this.idPatrocinio = idPatrocinio;
    }

    public int getIdPatrocinador() {
        return idPatrocinador;
    }

    public void setIdPatrocinador(int idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
    }

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public BigDecimal getMontoAportado() {
        return montoAportado;
    }

    public void setMontoAportado(BigDecimal montoAportado) {
        this.montoAportado = montoAportado;
    }

    @Override
    public String toString() {
        return "Patrocinio #" + idPatrocinio;
    }
}