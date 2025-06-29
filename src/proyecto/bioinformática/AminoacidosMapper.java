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
 * Traductor de codones (tripletas de ARN) a aminoácidos.
 * Utiliza la tabla proporcionada en las instrucciones del proyecto.
 * Traduce a nombre completo del aminoácido, o "STOP" si aplica.
 */
public class AminoacidosMapper {
    private static final Map<String, String> codonToAminoacido = new HashMap<>();

    static {
        // FENILALANINA
        codonToAminoacido.put("UUU", "Fenilalanina");
        codonToAminoacido.put("UUC", "Fenilalanina");
        // LEUCINA
        codonToAminoacido.put("UUA", "Leucina");
        codonToAminoacido.put("UUG", "Leucina");
        codonToAminoacido.put("CUU", "Leucina");
        codonToAminoacido.put("CUC", "Leucina");
        codonToAminoacido.put("CUA", "Leucina");
        codonToAminoacido.put("CUG", "Leucina");
        // SERINA
        codonToAminoacido.put("UCU", "Serina");
        codonToAminoacido.put("UCC", "Serina");
        codonToAminoacido.put("UCA", "Serina");
        codonToAminoacido.put("UCG", "Serina");
        codonToAminoacido.put("AGU", "Serina");
        codonToAminoacido.put("AGC", "Serina");
        // TIROSINA
        codonToAminoacido.put("UAU", "Tirosina");
        codonToAminoacido.put("UAC", "Tirosina");
        // STOP (Ocre, Ámbar, Opalo)
        codonToAminoacido.put("UAA", "STOP");
        codonToAminoacido.put("UAG", "STOP");
        codonToAminoacido.put("UGA", "STOP");
        // CISTEÍNA
        codonToAminoacido.put("UGU", "Cisteína");
        codonToAminoacido.put("UGC", "Cisteína");
        // TRIPTÓFANO
        codonToAminoacido.put("UGG", "Triptófano");
        // PROLINA
        codonToAminoacido.put("CCU", "Prolina");
        codonToAminoacido.put("CCC", "Prolina");
        codonToAminoacido.put("CCA", "Prolina");
        codonToAminoacido.put("CCG", "Prolina");
        // HISTIDINA
        codonToAminoacido.put("CAU", "Histidina");
        codonToAminoacido.put("CAC", "Histidina");
        // GLUTAMINA
        codonToAminoacido.put("CAA", "Glutamina");
        codonToAminoacido.put("CAG", "Glutamina");
        // ARGININA
        codonToAminoacido.put("CGU", "Arginina");
        codonToAminoacido.put("CGC", "Arginina");
        codonToAminoacido.put("CGA", "Arginina");
        codonToAminoacido.put("CGG", "Arginina");
        codonToAminoacido.put("AGA", "Arginina");
        codonToAminoacido.put("AGG", "Arginina");
        // ISOLEUCINA
        codonToAminoacido.put("AUU", "Isoleucina");
        codonToAminoacido.put("AUC", "Isoleucina");
        codonToAminoacido.put("AUA", "Isoleucina");
        // METIONINA (Inicio)
        codonToAminoacido.put("AUG", "Metionina");
        // TREONINA
        codonToAminoacido.put("ACU", "Treonina");
        codonToAminoacido.put("ACC", "Treonina");
        codonToAminoacido.put("ACA", "Treonina");
        codonToAminoacido.put("ACG", "Treonina");
        // ASPARAGINA
        codonToAminoacido.put("AAU", "Asparagina");
        codonToAminoacido.put("AAC", "Asparagina");
        // LISINA
        codonToAminoacido.put("AAA", "Lisina");
        codonToAminoacido.put("AAG", "Lisina");
        // VALINA
        codonToAminoacido.put("GUU", "Valina");
        codonToAminoacido.put("GUC", "Valina");
        codonToAminoacido.put("GUA", "Valina");
        codonToAminoacido.put("GUG", "Valina");
        // ALANINA
        codonToAminoacido.put("GCU", "Alanina");
        codonToAminoacido.put("GCC", "Alanina");
        codonToAminoacido.put("GCA", "Alanina");
        codonToAminoacido.put("GCG", "Alanina");
        // ÁCIDO ASPÁRTICO
        codonToAminoacido.put("GAU", "Ácido aspártico");
        codonToAminoacido.put("GAC", "Ácido aspártico");
        // ÁCIDO GLUTÁMICO
        codonToAminoacido.put("GAA", "Ácido glutámico");
        codonToAminoacido.put("GAG", "Ácido glutámico");
        // GLICINA
        codonToAminoacido.put("GGU", "Glicina");
        codonToAminoacido.put("GGC", "Glicina");
        codonToAminoacido.put("GGA", "Glicina");
        codonToAminoacido.put("GGG", "Glicina");
    }

    /**
     * Traduce una tripleta de ARN a su aminoácido (nombre completo).
     * Si el codón no es válido, regresa "?".
     * @param tripleta Codón de ARN (ejemplo: "AUG")
     * @return Nombre completo del aminoácido, "STOP" para codones de paro, o "?" si es inválido.
     */
    public static String traducir(String tripleta) {
        if (tripleta == null) return "?";
        String codon = tripleta.toUpperCase();
        return codonToAminoacido.getOrDefault(codon, "?");
    }
}
