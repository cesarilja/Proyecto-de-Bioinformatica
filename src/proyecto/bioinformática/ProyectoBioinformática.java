/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto.bioinformática;

/**
 *
 * @author Dell
 */

/**
 * Clase principal de arranque del proyecto de bioinformática.
 * Contiene el método main y lanza la aplicación.
 */
public class ProyectoBioinformática {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new InterfazProyecto().setVisible(true);
        }
    });
    }
    
}
