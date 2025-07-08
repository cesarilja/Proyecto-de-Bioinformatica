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
 * Clase genérica simple para lista enlazada.
 */
public class ListaEnlazada<T> {
    private Nodo<T> cabeza;
    private int tamaño;

    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    public ListaEnlazada() {
        cabeza = null;
        tamaño = 0;
    }

    public void agregar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        tamaño++;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public int tamaño() {
        return tamaño;
    }

    public T obtener(int indice) {
        if (indice < 0 || indice >= tamaño) {
            throw new IndexOutOfBoundsException();
        }
        Nodo<T> actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.siguiente;
        }
        return actual.dato;
    }

    /**
     * Busca en la lista un elemento que cumpla con el evaluador.
     * @param evaluador interfaz funcional para evaluar cada elemento.
     * @return el elemento si se encuentra, o null.
     */
    public T buscar(Evaluador<T> evaluador) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            if (evaluador.evaluar(actual.dato)) {
                return actual.dato;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    /**
     * Interfaz funcional para evaluar elementos.
     */
    public interface Evaluador<T> {
        boolean evaluar(T dato);
    }

    /**
     * Extrae todos los elementos en un arreglo simple para facilitar iteración.
     */
    public Object[] toArray() {
        Object[] arreglo = new Object[tamaño];
        Nodo<T> actual = cabeza;
        int idx = 0;
        while(actual != null){
            arreglo[idx++] = actual.dato;
            actual = actual.siguiente;
        }
        return arreglo;
    }

    public void limpiar() {
        cabeza = null;
        tamaño = 0;
    }
}
