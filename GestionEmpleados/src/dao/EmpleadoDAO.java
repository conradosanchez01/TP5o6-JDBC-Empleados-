package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import gestionempleados.ConexionDB; 
import modelo.Empleado;

public class EmpleadoDAO implements OperacionesDAO {

    @Override
    public boolean insertar(Empleado emp) {
        String sql = "INSERT INTO empleados (nombre, departamento) VALUES (?, ?)";
        
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, emp.getNombre());
            pstmt.setString(2, emp.getDepartamento());
            
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al insertar en DAO: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean modificar(Empleado emp) {
        String sql = "UPDATE empleados SET nombre = ?, departamento = ? WHERE id = ?";
        
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, emp.getNombre());
            pstmt.setString(2, emp.getDepartamento());
            pstmt.setInt(3, emp.getId());
            
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al modificar en DAO: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM empleados WHERE id = ?";
        
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al eliminar en DAO: " + e.getMessage());
            return false;
        }
    }

    @Override
    public ArrayList<Empleado> consultarTodos() {
        ArrayList<Empleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM empleados";
        
        // Aquí usamos ResultSet para iterar las filas que devuelva la base de datos
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                // Creamos el objeto Empleado con los datos de la fila actual
                Empleado emp = new Empleado(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("departamento")
                );
                // Lo sumamos a la lista
                lista.add(emp);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al consultar todos en DAO: " + e.getMessage());
        }
        
        return lista;
    }
}