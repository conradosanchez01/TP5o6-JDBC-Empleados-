package modelo;

public class Departamento {
    private int idDepto;
    private String nombreDepto;

    public Departamento(int idDepto, String nombreDepto) {
        this.idDepto = idDepto;
        this.nombreDepto = nombreDepto;
    }

    public int getIdDepto() { return idDepto; }
    public void setIdDepto(int idDepto) { this.idDepto = idDepto; }

    public String getNombreDepto() { return nombreDepto; }
    public void setNombreDepto(String nombreDepto) { this.nombreDepto = nombreDepto; }

    // Este método es CLAVE. Hace que el JComboBox muestre el NOMBRE en la pantalla
    @Override
    public String toString() {
        return nombreDepto;
    }
}