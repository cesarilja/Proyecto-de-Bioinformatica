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
    private java.util.List<Integer> posiciones;

    public Tripleta(String valor) {
        this.valor = valor;
        this.frecuencia = 0;
        this.posiciones = new java.util.ArrayList<>();
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
        this.posiciones.add(pos);
    }

    public java.util.List<Integer> getPosiciones() {
        return posiciones;
    }
}
    

