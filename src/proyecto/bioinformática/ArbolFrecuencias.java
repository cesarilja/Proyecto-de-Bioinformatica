/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.bioinformática;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */

/**
 * Árbol binario de búsqueda (BST) para ordenar Tripletas por frecuencia.
 */
public class ArbolFrecuencias {
    private NodoFrecuencia raiz;

    public void insertar(Tripleta tripleta) {
        raiz = insertarRec(raiz, tripleta);
    }

    // Inserta usando frecuencia como clave, si hay empate ordena por valor
    private NodoFrecuencia insertarRec(NodoFrecuencia actual, Tripleta tripleta) {
        if (actual == null)
            return new NodoFrecuencia(tripleta);

        int cmp = Integer.compare(tripleta.getFrecuencia(), actual.tripleta.getFrecuencia());
        if (cmp < 0) {
            actual.izquierdo = insertarRec(actual.izquierdo, tripleta);
        } else if (cmp > 0) {
            actual.derecho = insertarRec(actual.derecho, tripleta);
        } else { // Si frecuencia igual, ordenar lexicográficamente por valor
            if (tripleta.getValor().compareTo(actual.tripleta.getValor()) < 0) {
                actual.izquierdo = insertarRec(actual.izquierdo, tripleta);
            } else {
                actual.derecho = insertarRec(actual.derecho, tripleta);
            }
        }
        return actual;
    }

    
    //Devuelve la lista de tripletas ordenadas por frecuencia ascendente.
    public List<Tripleta> inOrder() {
        List<Tripleta> lista = new ArrayList<>();
        inOrderRec(raiz, lista);
        return lista;
    }

    private void inOrderRec(NodoFrecuencia nodo, List<Tripleta> lista) {
        if (nodo != null) {
            inOrderRec(nodo.izquierdo, lista);
            lista.add(nodo.tripleta);
            inOrderRec(nodo.derecho, lista);
        }
    }

    //Devuelve la tripleta con máxima frecuencia (más frecuente).
    public Tripleta getMasFrecuente() {
        NodoFrecuencia actual = raiz;
        if (actual == null) return null;
        while (actual.derecho != null)
            actual = actual.derecho;
        return actual.tripleta;
    }

    //Devuelve la tripleta con mínima frecuencia (menos frecuente).
    public Tripleta getMenosFrecuente() {
        NodoFrecuencia actual = raiz;
        if (actual == null) return null;
        while (actual.izquierdo != null)
            actual = actual.izquierdo;
        return actual.tripleta;
    }


    //Limpia el árbol.
    public void limpiar() {
        raiz = null;
    }
}
    
