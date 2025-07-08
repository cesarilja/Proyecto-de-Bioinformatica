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
 * Proporciona utilidades para analizar tripletas de ADN y su correspondencia con aminoácidos.
 * Permite generar reportes y extraer información relevante para bioinformática.
 */
public class AnalizadorAminoacidos {

    /** Clase contenedora de información para el reporte. */
    public static class InfoTripleta {
        public String tripletaADN;
        public String tripletaARN;
        public String aminoacido;
        public int frecuencia;
        public Tripleta.ArregloEnteros posiciones;
        public boolean esInicio;
        public boolean esParo;
        public boolean presente;

        public InfoTripleta(String tripletaADN, String tripletaARN, String aminoacido,
           int frecuencia, Tripleta.ArregloEnteros posiciones, boolean esInicio,
           boolean esParo, boolean presente) {
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

    /**
     * Clase para manejar conjunto simple de strings
     */
    private static class ConjuntoString {
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
                return;
            }
            if (tamaño == elementos.length) {
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

    /**
     * Método principal para analizar las tripletas de la tabla hash.
     */
    public static InfoTripleta[] analizar(HashTableTripletas hash) {
        char[] bases = {'A', 'C', 'G', 'T'};

        // Guardamos las tripletas presentes para control
        ConjuntoString tripletasPresentes = new ConjuntoString();

        Tripleta[] todas = hash.obtenerTodas();
        for (int i = 0; i < todas.length; i++) {
            tripletasPresentes.agregar(todas[i].getValor());
        }

        // 64 combinaciones de tripletas
        InfoTripleta[] resultado = new InfoTripleta[64];
        int idx = 0;
        for (int i1 = 0; i1 < bases.length; i1++) {
            for (int i2 = 0; i2 < bases.length; i2++) {
                for (int i3 = 0; i3 < bases.length; i3++) {
                    String tripletaADN = "" + bases[i1] + bases[i2] + bases[i3];
                    String tripletaARN = tripletaADN.replace('T', 'U');
                    String aminoacido = AminoacidosMapper.traducir(tripletaARN);
                    boolean esInicio = tripletaADN.equals("ATG");
                    boolean esParo = tripletaADN.equals("TAA") || tripletaADN.equals("TAG") || tripletaADN.equals("TGA");

                    int frecuencia = 0;
                    Tripleta.ArregloEnteros posiciones = new Tripleta.ArregloEnteros();
                    Tripleta trip = hash.buscarTripleta(tripletaADN);

                    if (trip != null) {
                        frecuencia = trip.getFrecuencia();
                        posiciones = trip.getPosiciones();
                    }

                    boolean presente = trip != null;
                    resultado[idx++] = new InfoTripleta(tripletaADN, tripletaARN, aminoacido,
                            frecuencia, posiciones, esInicio, esParo, presente);
                }
            }
        }
        return resultado;
    }
}
