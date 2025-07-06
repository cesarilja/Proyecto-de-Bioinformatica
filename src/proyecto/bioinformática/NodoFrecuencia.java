/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.bioinformática;

/**
 *
 * @author Dell
 */

/**
 * Nodo para el árbol de frecuencias de tripletas.
 * Almacena una referencia a una tripleta y a sus nodos hijo izquierdo y derecho.
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
    
