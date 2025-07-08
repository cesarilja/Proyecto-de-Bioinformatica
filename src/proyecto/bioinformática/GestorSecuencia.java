/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.bioinformática;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author Dell
 */

/**
 * Clase encargada de gestionar la carga y manipulación de secuencias genéticas desde archivos.
 * Proporciona métodos para leer, validar y acceder a la secuencia.
 */
public class GestorSecuencia {
    private String secuencia;
    private String nombreArchivoActual = "";

    // Carga la secuencia desde un archivo de tu computador
    public boolean cargarSecuenciaDeArchivo(File archivo) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                sb.append(linea.trim().toUpperCase());
            }
            this.secuencia = sb.toString();
            this.nombreArchivoActual = archivo.getName();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            this.secuencia = "";
            this.nombreArchivoActual = "";
            return false;
        }
    }

    public String getSecuencia() {
        return secuencia;
    }

    public ArregloStrings obtenerTripletas() {
        ArregloStrings tripletas = new ArregloStrings();
        if (secuencia == null) return tripletas;
        for (int i = 0; i <= secuencia.length() - 3; i += 3) {
            tripletas.agregar(secuencia.substring(i, i + 3));
        }
        return tripletas;
    }

    // Lee la secuencia desde un archivo usando un JFileChooser y guarda el nombre
    public String leerSecuenciaDeArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt");
        fileChooser.setFileFilter(filtro);

        int seleccion = fileChooser.showOpenDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            if (!archivo.getName().toLowerCase().endsWith(".txt")) {
                JOptionPane.showMessageDialog(null, "Por favor selecciona un archivo con extensión .txt.");
                return null;
            }
            StringBuilder secuenciaLeida = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    if (!linea.startsWith(">")) {
                        secuenciaLeida.append(linea.trim().toUpperCase());
                    }
                }
                this.nombreArchivoActual = archivo.getName();
                this.secuencia = secuenciaLeida.toString();
                return this.secuencia;
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage());
                this.nombreArchivoActual = "";
            }
        }
        return null;
    }

    public String getNombreArchivoActual() {
        return nombreArchivoActual;
    }

    /**
     * Arreglo dinámico simple para cadenas.
     */
    public static class ArregloStrings {
        private String[] datos;
        private int tamaño;

        public ArregloStrings() {
            datos = new String[10];
            tamaño = 0;
        }

        public void agregar(String valor) {
            if (tamaño == datos.length) {
                String[] nuevo = new String[datos.length * 2];
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

        public String obtener(int idx) {
            if (idx < 0 || idx >= tamaño) {
                throw new IndexOutOfBoundsException();
            }
            return datos[idx];
        }
    }
}
