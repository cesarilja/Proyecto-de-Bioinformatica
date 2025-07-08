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
 * Representa una tripleta (codón) de bases nitrogenadas.
 * Almacena su valor, frecuencia de aparición y posiciones en la secuencia.
 */
public class Tripleta {
    private String valor;
    private int frecuencia;
    private ArregloEnteros posiciones;

    public Tripleta(String valor) {
        this.valor = valor;
        this.frecuencia = 0;
        this.posiciones = new ArregloEnteros();
    }

    public String getValor() {
        return valor;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void incrementarFrecuencia() {
        this.frecuencia++;
    }

    public void agregarPosicion(int pos) {
        this.posiciones.agregar(pos);
    }

    public ArregloEnteros getPosiciones() {
        return posiciones;
    }

    /**
     * Arreglo dinámico simple de enteros para posiciones, similar a lista.
     */
    public static class ArregloEnteros {
        private int[] datos;
        private int tamaño;

        public ArregloEnteros() {
            datos = new int[5];
            tamaño = 0;
        }

        public void agregar(int valor) {
            if (tamaño == datos.length) {
                int[] nuevo = new int[datos.length * 2];
                for (int i = 0; i < datos.length; i++) {
                    nuevo[i] = datos[i];
                }
                datos = nuevo;
            }
            datos[tamaño++] = valor;
        }

        public int tamaño() {
            return tamaño;
        }

        public int obtener(int idx) {
            if (idx < 0 || idx >= tamaño) throw new IndexOutOfBoundsException();
            return datos[idx];
        }

        @Override
        public String toString() {
            if (tamaño == 0) return "[]";
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < tamaño -1; i++) {
                sb.append(datos[i]).append(", ");
            }
            sb.append(datos[tamaño -1]).append("]");
            return sb.toString();
        }
    }
}
    

