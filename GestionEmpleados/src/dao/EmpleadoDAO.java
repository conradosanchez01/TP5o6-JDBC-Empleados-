package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import gestionempleados.ConexionDB;
import modelo.Empleado;
import modelo.Departamento;

public class EmpleadoDAO {

    // 1. INSERTAR (Ahora recibe id_departamento y ruta_foto)
    public boolean insertar(Empleado emp) {
        String sql = "INSERT INTO empleados (nombre, id_departamento, ruta_foto) VALUES (?, ?, ?)";
        
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, emp.getNombre());
            pstmt.setInt(2, emp.getIdDepartamento());
            pstmt.setString(3, emp.getRutaFoto());
            
            return pstmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al insertar en DAO: " + e.getMessage());
            return false;
        }
    }

    // 2. MODIFICAR (Actualiza datos y foto por ID)
    public boolean modificar(Empleado emp) {
        String sql = "UPDATE empleados SET nombre = ?, id_departamento = ?, ruta_foto = ? WHERE id = ?";
        
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, emp.getNombre());
            pstmt.setInt(2, emp.getIdDepartamento());
            pstmt.setString(3, emp.getRutaFoto());
            pstmt.setInt(4, emp.getId());
            
            return pstmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al modificar en DAO: " + e.getMessage());
            return false;
        }
    }

    // 3. ELIMINAR (Sigue igual, borra por ID)
    public boolean eliminar(int id) {
        String sql = "DELETE FROM empleados WHERE id = ?";
        
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al eliminar en DAO: " + e.getMessage());
            return false;
        }
    }

    // 4. CONSULTAR TODOS (Usa INNER JOIN para traer el nombre del departamento)
    public ArrayList<Empleado> consultarTodos() {
        ArrayList<Empleado> lista = new ArrayList<>();
        // Cruzamos las tablas para poder leer los datos correctos
        String sql = "SELECT e.id, e.nombre, e.id_departamento, e.ruta_foto " +
                     "FROM empleados e " +
                     "INNER JOIN departamentos d ON e.id_departamento = d.id_depto";
        
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                Empleado emp = new Empleado(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("id_departamento"),
                    rs.getString("ruta_foto")
                );
                lista.add(emp);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al consultar todos en DAO: " + e.getMessage());
        }
        
        return lista;
    }

    // 5. MÉTODO EXTRA: Traer la lista de departamentos para el JComboBox
    public ArrayList<Departamento> consultarDepartamentos() {
        ArrayList<Departamento> lista = new ArrayList<>();
        String sql = "SELECT * FROM departamentos";
        
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                Departamento depto = new Departamento(
                    rs.getInt("id_depto"),
                    rs.getString("nombre_depto")
                );
                lista.add(depto);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al consultar departamentos: " + e.getMessage());
        }
        
        return lista;
    }
}