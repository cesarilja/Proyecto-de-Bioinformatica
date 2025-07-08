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
 * Implementa un árbol binario para ordenar tripletas por frecuencia.
 * Permite obtener tripletas más y menos frecuentes, así como recorridos ordenados.
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

    // Devuelve la lista de tripletas ordenadas por frecuencia ascendente.
    public Tripleta[] inOrder() {
        ArregloTripletas lista = new ArregloTripletas();
        inOrderRec(raiz, lista);
        return lista.toArray();
    }

    private void inOrderRec(NodoFrecuencia nodo, ArregloTripletas lista) {
        if (nodo != null) {
            inOrderRec(nodo.izquierdo, lista);
            lista.agregar(nodo.tripleta);
            inOrderRec(nodo.derecho, lista);
        }
    }

    // Devuelve la tripleta con máxima frecuencia (más frecuente).
    public Tripleta getMasFrecuente() {
        NodoFrecuencia actual = raiz;
        if (actual == null) return null;
        while (actual.derecho != null)
            actual = actual.derecho;
        return actual.tripleta;
    }

    // Devuelve la tripleta con mínima frecuencia (menos frecuente).
    public Tripleta getMenosFrecuente() {
        NodoFrecuencia actual = raiz;
        if (actual == null) return null;
        while (actual.izquierdo != null)
            actual = actual.izquierdo;
        return actual.tripleta;
    }

    public void limpiar() {
        raiz = null;
    }

    /**
     * Arreglo dinámico para almacenar Tripletas sin usar librerías.
     */
    public static class ArregloTripletas {
        private Tripleta[] datos;
        private int tamaño;

        public ArregloTripletas() {
            datos = new Tripleta[10];
            tamaño = 0;
        }

        public void agregar(Tripleta t) {
            if (tamaño == datos.length) {
                Tripleta[] nuevo = new Tripleta[datos.length * 2];
                for (int i = 0; i < datos.length; i++) {
                    nuevo[i] = datos[i];
                }
                datos = nuevo;
            }
            datos[tamaño++] = t;
        }

        public Tripleta[] toArray() {
            Tripleta[] copia = new Tripleta[tamaño];
            for (int i = 0; i < tamaño; i++) {
                copia[i] = datos[i];
            }
            return copia;
        }
    }
}