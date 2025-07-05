/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.bioinformática;
import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Dell
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTableTripletas {
    private static final int DEFAULT_SIZE = 67; // Número primo para mejor dispersión
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

    // Hash simple pero eficiente para tripletas (codones)
    private int hash(String tripleta) {
        // Puede usar hashCode() pero lo limitamos y nos aseguramos que sea positivo
        return Math.abs(tripleta.hashCode()) % size;
    }

    // Inserta o actualiza una tripleta, guarda frecuencia y posiciones
    public void insertarTripleta(String tripleta, int posicion) {
        int idx = hash(tripleta);
        for (Tripleta t : table[idx]) {
            if (t.getValor().equals(tripleta)) {
                t.incrementarFrecuencia();
                t.agregarPosicion(posicion);
                return;
            }
        }
        // No estaba, la agregamos
        Tripleta nueva = new Tripleta(tripleta);
        nueva.agregarPosicion(posicion);
        table[idx].add(nueva);
    }

    // Buscar una tripleta (devuelve el objeto Tripleta o null)
    public Tripleta buscarTripleta(String tripleta) {
        int idx = hash(tripleta);
        for (Tripleta t : table[idx]) {
            if (t.getValor().equals(tripleta)) return t;
        }
        return null;
    }

    // Devuelve todas las tripletas (para mostrar en tabla o recorrer)
    public List<Tripleta> obtenerTodas() {
        List<Tripleta> lista = new ArrayList<>();
        for (LinkedList<Tripleta> bucket : table) {
            lista.addAll(bucket);
        }
        return lista;
    }

    // Devuelve la tripleta más frecuente
    public Tripleta getMasFrecuente() {
        Tripleta max = null;
        for (Tripleta t : obtenerTodas()) {
            if (max == null || t.getFrecuencia() > max.getFrecuencia())
                max = t;
        }
        return max;
    }

    // Devuelve la tripleta menos frecuente
    public Tripleta getMenosFrecuente() {
        Tripleta min = null;
        for (Tripleta t : obtenerTodas()) {
            if (min == null || t.getFrecuencia() < min.getFrecuencia())
                min = t;
        }
        return min;
    }

    // Devuelve una lista de buckets con colisiones (>1 elemento)
    public List<List<Tripleta>> obtenerColisiones() {
        List<List<Tripleta>> colisiones = new ArrayList<>();
        for (LinkedList<Tripleta> bucket : table) {
            if (bucket.size() > 1) {
                colisiones.add(new ArrayList<>(bucket));
            }
        }
        return colisiones;
    }

    // Limpia la tabla hash (útil para cargar nuevo archivo)
    public void limpiar() {
        for (LinkedList<Tripleta> bucket : table) {
            bucket.clear();
        }
    }
}