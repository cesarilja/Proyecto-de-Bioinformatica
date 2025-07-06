/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.bioinformática;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Dell
 */

/**
 * Implementa una tabla hash para almacenar y gestionar tripletas de ADN.
 * Permite insertar, buscar y obtener estadísticas de tripletas y sus posiciones.
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTableTripletas {
    private static final int DEFAULT_SIZE = 67; 
    private LinkedList<Tripleta>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public HashTableTripletas() {
        this.size = DEFAULT_SIZE;
        this.table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(String tripleta) {
        return Math.abs(tripleta.hashCode()) % size;
    }

    public void insertarTripleta(String tripleta, int posicion) {
        int idx = hash(tripleta);
        for (Tripleta t : table[idx]) {
            if (t.getValor().equals(tripleta)) {
                t.incrementarFrecuencia();
                t.agregarPosicion(posicion);
                return;
            }
        }
        Tripleta nueva = new Tripleta(tripleta);
    nueva.incrementarFrecuencia(); // Aumenta la frecuencia al crear la tripleta
    nueva.agregarPosicion(posicion);
    table[idx].add(nueva);
    }

    public Tripleta buscarTripleta(String tripleta) {
        int idx = hash(tripleta);
        for (Tripleta t : table[idx]) {
            if (t.getValor().equals(tripleta)) return t;
        }
        return null;
    }

    public List<Tripleta> obtenerTodas() {
        List<Tripleta> lista = new ArrayList<>();
        for (LinkedList<Tripleta> bucket : table) {
            lista.addAll(bucket);
        }
        return lista;
    }

    public Tripleta getMasFrecuente() {
        Tripleta max = null;
        for (Tripleta t : obtenerTodas()) {
            if (max == null || t.getFrecuencia() > max.getFrecuencia())
                max = t;
        }
        return max;
    }

    public Tripleta getMenosFrecuente() {
        Tripleta min = null;
        for (Tripleta t : obtenerTodas()) {
            if (min == null || t.getFrecuencia() < min.getFrecuencia())
                min = t;
        }
        return min;
    }

    public List<List<Tripleta>> obtenerColisiones() {
        List<List<Tripleta>> colisiones = new ArrayList<>();
        for (LinkedList<Tripleta> bucket : table) {
            if (bucket.size() > 1) {
                colisiones.add(new ArrayList<>(bucket));
            }
        }
        return colisiones;
    }

    public void limpiar() {
        for (LinkedList<Tripleta> bucket : table) {
            bucket.clear();
        }
    }
}