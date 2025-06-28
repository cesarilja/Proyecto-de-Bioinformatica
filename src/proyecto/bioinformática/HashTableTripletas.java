/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.bioinformática;
import java.util.*;

/**
 *
 * @author Dell
 */
public class HashTableTripletas {
    private Map<String, Tripleta> tabla;
    private Map<Integer, List<String>> colisiones;

    public HashTableTripletas() {
        tabla = new HashMap<>();
        colisiones = new HashMap<>();
    }

    public void agregarTripleta(String tripleta, int posicion) {
        int hash = tripleta.hashCode();
        colisiones.computeIfAbsent(hash, k -> new ArrayList<>());
        if (!colisiones.get(hash).contains(tripleta)) {
            colisiones.get(hash).add(tripleta);
        }
        Tripleta t = tabla.get(tripleta);
        if (t == null) {
            t = new Tripleta(tripleta);
            tabla.put(tripleta, t);
        }
        t.incrementarFrecuencia();
        t.agregarPosicion(posicion);
    }

    public Collection<Tripleta> obtenerTripletas() {
        return tabla.values();
    }

    // Solo devuelve las colisiones (más de una tripleta con el mismo hash)
    public Map<Integer, List<String>> getColisiones() {
        Map<Integer, List<String>> res = new HashMap<>();
        for (var entry : colisiones.entrySet()) {
            if (entry.getValue().size() > 1) res.put(entry.getKey(), entry.getValue());
        }
        return res;
    }

    public Tripleta getTripleta(String valor) {
        return tabla.get(valor);
    }

    public Tripleta getMasFrecuente() {
        return tabla.values().stream().max(Comparator.comparingInt(Tripleta::getFrecuencia)).orElse(null);
    }

    public Tripleta getMenosFrecuente() {
        return tabla.values().stream().min(Comparator.comparingInt(Tripleta::getFrecuencia)).orElse(null);
    }
}
