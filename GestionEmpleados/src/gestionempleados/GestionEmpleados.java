package gestionempleados;

import vista.VentanaPrincipal;

public class GestionEmpleados {
    public static void main(String[] args) {
        // Hace que al ejecutar el proyecto, lo primero que se abra sea tu ventana
        java.awt.EventQueue.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }
}