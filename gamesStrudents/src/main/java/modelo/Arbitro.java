package modelo;

public class Arbitro {

    private int idArbitro;
    private String nombre;

    public Arbitro() {
    }

    public Arbitro(int idArbitro, String nombre) {
        this.idArbitro = idArbitro;
        this.nombre = nombre;
    }

    public Arbitro(String nombre) {
        this.nombre = nombre;
    }

    public int getIdArbitro() {
        return idArbitro;
    }

    public void setIdArbitro(int idArbitro) {
        this.idArbitro = idArbitro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}