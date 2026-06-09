package modelo;

public class Empleado {
    private int id;
    private String nombre;
    private int idDepartamento; // Cambiado a int para la clave foránea
    private String rutaFoto;    // Nuevo campo para la imagen

    public Empleado() {
    }

    // Constructor completo
    public Empleado(int id, String nombre, int idDepartamento, String rutaFoto) {
        this.id = id;
        this.nombre = nombre;
        this.idDepartamento = idDepartamento;
        this.rutaFoto = rutaFoto;
    }

    // Constructor sin ID (para inserciones)
    public Empleado(String nombre, int idDepartamento, String rutaFoto) {
        this.nombre = nombre;
        this.idDepartamento = idDepartamento;
        this.rutaFoto = rutaFoto;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getIdDepartamento() { return idDepartamento; }
    public void setIdDepartamento(int idDepartamento) { this.idDepartamento = idDepartamento; }

    public String getRutaFoto() { return rutaFoto; }
    public void setRutaFoto(String rutaFoto) { this.rutaFoto = rutaFoto; }
}