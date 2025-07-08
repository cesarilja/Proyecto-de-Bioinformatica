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
 * Implementa una tabla hash para almacenar y gestionar tripletas de ADN.
 * Ahora usa ListaEnlazada propia para manejar colisiones.
 */
public class HashTableTripletas {
    private static final int DEFAULT_SIZE = 67; 
    private ListaEnlazada<Tripleta>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public HashTableTripletas() {
        this.size = DEFAULT_SIZE;
        this.table = new ListaEnlazada[size];
        for (int i = 0; i < size; i++) {
            table[i] = new ListaEnlazada<>();
        }
    }

    private int hash(String tripleta) {
        return Math.abs(tripleta.hashCode()) % size;
    }

    public void insertarTripleta(String tripleta, int posicion) {
        int idx = hash(tripleta);
        // Buscar si ya existe la tripleta
        Tripleta encontrada = table[idx].buscar(new ListaEnlazada.Evaluador<Tripleta>() {
            public boolean evaluar(Tripleta t) {
                return t.getValor().equals(tripleta);
            }
        });
        if (encontrada != null) {
            encontrada.incrementarFrecuencia();
            encontrada.agregarPosicion(posicion);
            return;
        }
        Tripleta nueva = new Tripleta(tripleta);
        nueva.incrementarFrecuencia(); // Aumenta la frecuencia al crear la tripleta
        nueva.agregarPosicion(posicion);
        table[idx].agregar(nueva);
    }

    public Tripleta buscarTripleta(String tripleta) {
        int idx = hash(tripleta);
        return table[idx].buscar(new ListaEnlazada.Evaluador<Tripleta>() {
            public boolean evaluar(Tripleta t) {
                return t.getValor().equals(tripleta);
            }
        });
    }

    public Tripleta[] obtenerTodas() {
        // Contar total de tripletas
        int total = 0;
        for (int i = 0; i < size; i++) {
            total += table[i].tamaño();
        }
        Tripleta[] todas = new Tripleta[total];
        int pos = 0;
        for (int i = 0; i < size; i++) {
            Object[] arr = table[i].toArray();
            for (Object obj : arr) {
                todas[pos++] = (Tripleta) obj;
            }
        }
        return todas;
    }

    public Tripleta getMasFrecuente() {
        Tripleta max = null;
        Tripleta[] todas = obtenerTodas();
        for (Tripleta t : todas) {
            if (max == null || t.getFrecuencia() > max.getFrecuencia())
                max = t;
        }
        return max;
    }

    public Tripleta getMenosFrecuente() {
        Tripleta min = null;
        Tripleta[] todas = obtenerTodas();
        for (Tripleta t : todas) {
            if (min == null || t.getFrecuencia() < min.getFrecuencia())
                min = t;
        }
        return min;
    }

    public ListaEnlazada<Tripleta>[] obtenerColisiones() {
        // Solo los buckets con tamaño > 1
        // Contamos cuántos buckets con colisiones tenemos
        int cuentaColisiones = 0;
        for (int i = 0; i < size; i++) {
            if (table[i].tamaño() > 1)
                cuentaColisiones++;
        }
        @SuppressWarnings("unchecked")
        ListaEnlazada<Tripleta>[] resultado = new ListaEnlazada[cuentaColisiones];
        int pos = 0;
        for (int i = 0; i < size; i++) {
            if (table[i].tamaño() > 1) {
                resultado[pos++] = table[i];
            }
        }
        return resultado;
    }

    public void limpiar() {
        for (int i = 0; i < size; i++) {
            table[i].limpiar();
        }
    }
}