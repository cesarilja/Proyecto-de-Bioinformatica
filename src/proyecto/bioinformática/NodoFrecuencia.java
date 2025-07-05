/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.bioinformática;

/**
 *
 * @author Dell
 */
public class NodoFrecuencia {
    
    public Tripleta tripleta;
    public NodoFrecuencia izquierdo;
    public NodoFrecuencia derecho;

    public NodoFrecuencia(Tripleta tripleta) {
        this.tripleta = tripleta;
        this.izquierdo = null;
        this.derecho = null;
    }
}
    
