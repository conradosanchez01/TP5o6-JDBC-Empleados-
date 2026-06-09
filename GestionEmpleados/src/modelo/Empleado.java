package modelo;

public class Empleado {
    private int id;
    private String nombre;
    private String departamento;

    // Constructor vacío
    public Empleado() {
    }

    // Constructor con todos los parámetros (útil para cuando traemos datos de la BD)
    public Empleado(int id, String nombre, String departamento) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
    }

    // Constructor sin ID (útil para cuando creamos un empleado nuevo que todavía no se guardó)
    public Empleado(String nombre, String departamento) {
        this.nombre = nombre;
        this.departamento = departamento;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }
}