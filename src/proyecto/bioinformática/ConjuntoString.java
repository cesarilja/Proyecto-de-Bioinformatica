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
 * Implementación simple de conjunto de String.
 */
public class ConjuntoString {
    private String[] elementos;
    private int tamaño;

    public ConjuntoString() {
        this.elementos = new String[10];
        this.tamaño = 0;
    }

    public boolean contiene(String s) {
        for (int i = 0; i < tamaño; i++) {
            if (elementos[i].equals(s)) {
                return true;
            }
        }
        return false;
    }

    public void agregar(String s) {
        if (contiene(s)) {
            return; // ya existe
        }
        if (tamaño == elementos.length) {
            // aumentar capacidad
            String[] nuevo = new String[elementos.length * 2];
            for (int i = 0; i < elementos.length; i++) {
                nuevo[i] = elementos[i];
            }
            elementos = nuevo;
        }
        elementos[tamaño++] = s;
    }

    public String[] obtenerElementos() {
        String[] copia = new String[tamaño];
        for (int i = 0; i < tamaño; i++) {
            copia[i] = elementos[i];
        }
        return copia;
    }
}
