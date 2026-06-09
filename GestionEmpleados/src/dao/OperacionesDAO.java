package dao;

import java.util.ArrayList;
import modelo.Empleado;

public interface OperacionesDAO {
    public boolean insertar(Empleado emp);
    public boolean modificar(Empleado emp);
    public boolean eliminar(int id);
    public ArrayList<Empleado> consultarTodos(); // Devuelve la lista completa de empleados
}