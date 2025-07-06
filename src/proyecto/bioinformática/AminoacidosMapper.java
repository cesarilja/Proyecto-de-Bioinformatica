/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.bioinformática;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author Dell
 */
/**
 /**
 * Clase utilitaria para mapear tripletas de ARN a aminoácidos.
 * Ofrece métodos para traducir tripletas y obtener equivalencias.
 */
public class AminoacidosMapper {
    private static final String[] codones = {
        "UUU", "UUC", // Fenilalanina
        "UUA", "UUG", "CUU", "CUC", "CUA", "CUG", // Leucina
        "UCU", "UCC", "UCA", "UCG", "AGU", "AGC", // Serina
        "UAU", "UAC", // Tirosina
        "UAA", "UAG", "UGA", // STOP
        "UGU", "UGC", // Cisteína
        "UGG", // Triptófano
        "CCU", "CCC", "CCA", "CCG", // Prolina
        "CAU", "CAC", // Histidina
        "CAA", "CAG", // Glutamina
        "CGU", "CGC", "CGA", "CGG", "AGA", "AGG", // Arginina
        "AUU", "AUC", "AUA", // Isoleucina
        "AUG", // Metionina (Inicio)
        "ACU", "ACC", "ACA", "ACG", // Treonina
        "AAU", "AAC", // Asparagina
        "AAA", "AAG", // Lisina
        "GUU", "GUC", "GUA", "GUG", // Valina
        "GCU", "GCC", "GCA", "GCG", // Alanina
        "GAU", "GAC", // Ácido aspártico
        "GAA", "GAG", // Ácido glutámico
        "GGU", "GGC", "GGA", "GGG"  // Glicina
    };

    private static final String[] aminoacidos = {
        "Fenilalanina", "Fenilalanina",
        "Leucina", "Leucina", "Leucina", "Leucina", "Leucina", "Leucina",
        "Serina", "Serina", "Serina", "Serina", "Serina", "Serina",
        "Tirosina", "Tirosina",
        "STOP", "STOP", "STOP",
        "Cisteína", "Cisteína",
        "Triptófano",
        "Prolina", "Prolina", "Prolina", "Prolina",
        "Histidina", "Histidina",
        "Glutamina", "Glutamina",
        "Arginina", "Arginina", "Arginina", "Arginina", "Arginina", "Arginina",
        "Isoleucina", "Isoleucina", "Isoleucina",
        "Metionina",
        "Treonina", "Treonina", "Treonina", "Treonina",
        "Asparagina", "Asparagina",
        "Lisina", "Lisina",
        "Valina", "Valina", "Valina", "Valina",
        "Alanina", "Alanina", "Alanina", "Alanina",
        "Ácido aspártico", "Ácido aspártico",
        "Ácido glutámico", "Ácido glutámico",
        "Glicina", "Glicina", "Glicina", "Glicina"
    };

    public static String traducir(String tripleta) {
        if (tripleta == null) return "?";
        String codon = tripleta.toUpperCase();
        for (int i = 0; i < codones.length; i++) {
            if (codones[i].equals(codon)) {
                return aminoacidos[i];
            }
        }
        return "?";
    }
}