/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.bioinformática;
import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Dell
 */
public class GestorSecuencia {
    private String secuencia;

    public boolean cargarSecuenciaDeArchivo(File archivo) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                sb.append(linea.trim().toUpperCase());
            }
            this.secuencia = sb.toString();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            this.secuencia = "";
            return false;
        }
    }

    public String getSecuencia() {
        return secuencia;
    }

    public List<String> obtenerTripletas() {
        List<String> tripletas = new ArrayList<>();
        if (secuencia == null) return tripletas;
        for (int i = 0; i <= secuencia.length() - 3; i += 3) {
            tripletas.add(secuencia.substring(i, i + 3));
        }
        return tripletas;
    }
    
    // Método para mostrar diálogo y leer el archivo de la secuencia
    public String leerSecuenciaDeArchivo() {
    JFileChooser fileChooser = new JFileChooser();
    // Filtro: solo archivos .txt
    FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt");
    fileChooser.setFileFilter(filtro);

    int seleccion = fileChooser.showOpenDialog(null);
    if (seleccion == JFileChooser.APPROVE_OPTION) {
        File archivo = fileChooser.getSelectedFile();
        // Validación extra por si el usuario escribe el nombre manualmente
        if (!archivo.getName().toLowerCase().endsWith(".txt")) {
            JOptionPane.showMessageDialog(null, "Por favor selecciona un archivo con extensión .txt.");
            return null;
        }
        StringBuilder secuencia = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Opcional: ignorar encabezado FASTA
                if (!linea.startsWith(">")) {
                    secuencia.append(linea.trim().toUpperCase());
                }
            }
            return secuencia.toString();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage());
        }
    }
    return null;
}
}
