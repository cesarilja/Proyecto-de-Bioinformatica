/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.bioinformática;
import java.util.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 *
 * @author Dell
 */
public class AnalizadorAminoacidos {
    /**
     * Genera el reporte de todas las tripletas posibles del ADN
     */
    public static List<InfoTripleta> analizar(HashTableTripletas hash) {
        List<InfoTripleta> resultado = new ArrayList<>();
        char[] bases = {'A','C','G','T'};
        Set<String> tripletasPresentes = new HashSet<>();
        for (Tripleta t : hash.obtenerTodas()) {
            tripletasPresentes.add(t.getValor());
        }
        for (char b1 : bases) {
            for (char b2 : bases) {
                for (char b3 : bases) {
                    String tripletaADN = "" + b1 + b2 + b3;
                    String tripletaARN = tripletaADN.replace('T','U');
                    String aminoacido = AminoacidosMapper.traducir(tripletaARN);
                    boolean esInicio = tripletaADN.equals("ATG");
                    boolean esParo = tripletaADN.equals("TAA") || tripletaADN.equals("TAG") || tripletaADN.equals("TGA");
                    int frecuencia = 0;
                    List<Integer> posiciones = new ArrayList<>();
                    Tripleta trip = hash.buscarTripleta(tripletaADN);
                    if (trip != null) {
                        frecuencia = trip.getFrecuencia();
                        posiciones = trip.getPosiciones();
                    }
                    resultado.add(new InfoTripleta(tripletaADN, tripletaARN, aminoacido, frecuencia, posiciones, esInicio, esParo, trip != null));
                }
            }
        }
        return resultado;
    }

    /**
     * Contenedor de información para el reporte.
     */
    public static class InfoTripleta {
        public String tripletaADN;
        public String tripletaARN;
        public String aminoacido;
        public int frecuencia;
        public List<Integer> posiciones;
        public boolean esInicio;
        public boolean esParo;
        public boolean presente;

        public InfoTripleta(String tripletaADN, String tripletaARN, String aminoacido, int frecuencia, List<Integer> posiciones, boolean esInicio, boolean esParo, boolean presente) {
            this.tripletaADN = tripletaADN;
            this.tripletaARN = tripletaARN;
            this.aminoacido = aminoacido;
            this.frecuencia = frecuencia;
            this.posiciones = posiciones;
            this.esInicio = esInicio;
            this.esParo = esParo;
            this.presente = presente;
        }
    }
}
