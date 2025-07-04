/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto.bioinformática;

import java.awt.Dimension;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import proyecto.bioinformática.AnalizadorAminoacidos.InfoTripleta;
import proyecto.bioinformática.Tripleta;
import proyecto.bioinformática.AnalizadorAminoacidos.InfoTripleta;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Dell
 */
public class InterfazProyecto extends javax.swing.JFrame {
private HashTableTripletas tablaHash;
private GestorSecuencia gestorSecuencia;

    /**
     * Creates new form InterfazProyecto
     */
    public InterfazProyecto() {
        tablaHash = new HashTableTripletas();
        gestorSecuencia = new GestorSecuencia();
        initComponents();
    }
    
    private void llenarTablaTripletas() {
    DefaultTableModel model = (DefaultTableModel) tablaTripletas.getModel();
    model.setRowCount(0); // Limpia la tabla
    for (Tripleta t : tablaHash.obtenerTodas()) {
        model.addRow(new Object[]{
            t.getValor(),
            t.getFrecuencia(),
            t.getPosiciones().toString()
            });
        }
        }

    private void llenarComboBoxTripletas() {
        comboTripletas.removeAllItems();
        for (Tripleta t : tablaHash.obtenerTodas()) {
            comboTripletas.addItem(t.getValor());
        }
    }
    
    private void mostrarMasYMenosFrecuente() {
    Tripleta mas = tablaHash.getMasFrecuente();
    Tripleta menos = tablaHash.getMenosFrecuente();
    lblMasFrecuente.setText(mas != null ? mas.getValor() : "");
    lblMenosFrecuente.setText(menos != null ? menos.getValor() : "");
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCargarArchivo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        btnAnalizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTripletas = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        comboTripletas = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        lblResultadoBusqueda = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        lblMenosFrecuente = new javax.swing.JLabel();
        lblMasFrecuente = new javax.swing.JLabel();
        btnColisiones = new javax.swing.JButton();
        btnAminoacidos = new javax.swing.JButton();
        btnReporteAminoacidos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, -1, -1));

        btnCargarArchivo.setText("CARGAR SECUENCIA");
        btnCargarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarArchivoActionPerformed(evt);
            }
        });
        getContentPane().add(btnCargarArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 570, 20));

        jLabel1.setText("ARCHIVO:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, 20));

        btnAnalizar.setText("ANALIZAR SECUENCIA");
        getContentPane().add(btnAnalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        tablaTripletas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "TRIPLETA", "FRECUENCIA", "POSICIONES"
            }
        ));
        jScrollPane1.setViewportView(tablaTripletas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 360, 200));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 570, 20));

        jLabel2.setText("BUSCAR TRIPLETA:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, -1));

        comboTripletas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(comboTripletas, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, -1, -1));

        btnBuscar.setText("BUSCAR");
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, -1, -1));

        lblResultadoBusqueda.setText("RESULTADO:    FRECUENICA:          POSICIONES:        ");
        getContentPane().add(lblResultadoBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 540, -1));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 570, 20));

        lblMenosFrecuente.setText("MENOS FRECUENTE:  ");
        getContentPane().add(lblMenosFrecuente, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 460, -1, -1));

        lblMasFrecuente.setText("MÁS FRECUENTE:  ");
        getContentPane().add(lblMasFrecuente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, -1, -1));

        btnColisiones.setText("VER COLISIONES");
        btnColisiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColisionesActionPerformed(evt);
            }
        });

        getContentPane().add(btnColisiones, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, -1, -1));
        getContentPane().add(btnColisiones, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 510, -1, -1));

        btnAminoacidos.setText("VER AMINOÁCIDOS");
        btnAminoacidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAminoacidosActionPerformed(evt);
            }
        });

        getContentPane().add(btnAminoacidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 510, -1, -1));

        btnReporteAminoacidos.setText("REPORTE COMPLETO AMINOACIDOS");
        btnReporteAminoacidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteAminoacidosActionPerformed(evt);
            }
        });
        getContentPane().add(btnReporteAminoacidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 510, -1, -1));
        getContentPane().add(btnAminoacidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 510, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnColisionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColisionesActionPerformed
       List<List<Tripleta>> colisiones = tablaHash.obtenerColisiones();
    StringBuilder sb = new StringBuilder();
    for (List<Tripleta> bucket : colisiones) {
        sb.append("Colisión en bucket:\n");
        for (Tripleta t : bucket) {
            sb.append(" - ").append(t.getValor()).append("\n");
        }
    }
    JOptionPane.showMessageDialog(this, sb.length() > 0 ? sb.toString() : "No hay colisiones.");

    }//GEN-LAST:event_btnColisionesActionPerformed

    private void btnCargarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarArchivoActionPerformed
    tablaHash.limpiar(); // Limpia la tabla por si ya había datos

    String secuencia = gestorSecuencia.leerSecuenciaDeArchivo();
    if (secuencia == null || secuencia.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No se pudo leer la secuencia.");
        return;
    }

    // Divide en tripletas e inserta en la hash
    for (int i = 0; i + 2 < secuencia.length(); i += 3) {
        String tripleta = secuencia.substring(i, i + 3);
        tablaHash.insertarTripleta(tripleta, i);
    }

    llenarTablaTripletas();
    llenarComboBoxTripletas();
    mostrarMasYMenosFrecuente();
    JOptionPane.showMessageDialog(this, "Secuencia cargada y analizada.");

    }//GEN-LAST:event_btnCargarArchivoActionPerformed

    private void btnAminoacidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAminoacidosActionPerformed
        StringBuilder resultado = new StringBuilder();
    for (Tripleta t : tablaHash.obtenerTodas()) {
        resultado.append(t.getValor())
                 .append(" → ")
                 .append(AminoacidosMapper.traducir(t.getValor()))
                 .append("\n");
    }
    JOptionPane.showMessageDialog(this, resultado.toString());

    }//GEN-LAST:event_btnAminoacidosActionPerformed


    private void btnReporteAminoacidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteAminoacidosActionPerformed
        java.util.List<InfoTripleta> reporte = AnalizadorAminoacidos.analizar(tablaHash);

    // Construir tabla
    String[] columnas = {"Tripleta ADN", "Tripleta ARN", "Aminoácido", "Frecuencia", "Posiciones", "Inicio", "Paro", "Presente"};
    Object[][] datos = new Object[reporte.size()][columnas.length];
    int i = 0;
    for (InfoTripleta info : reporte) {
        datos[i][0] = info.tripletaADN;
        datos[i][1] = info.tripletaARN;
        datos[i][2] = info.aminoacido;
        datos[i][3] = info.frecuencia;
        datos[i][4] = info.posiciones.toString();
        datos[i][5] = info.esInicio ? "Sí" : "";
        datos[i][6] = info.esParo ? "Sí" : "";
        datos[i][7] = info.presente ? "✔" : "";
        i++;
    }
    JTable tabla = new JTable(datos, columnas);
    JScrollPane scroll = new JScrollPane(tabla);
    tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    tabla.setPreferredScrollableViewportSize(new Dimension(700, 400));

    JOptionPane.showMessageDialog(this, scroll, "Reporte de Aminoácidos", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnReporteAminoacidosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazProyecto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAminoacidos;
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCargarArchivo;
    private javax.swing.JButton btnColisiones;
    private javax.swing.JButton btnReporteAminoacidos;
    private javax.swing.JComboBox<String> comboTripletas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblMasFrecuente;
    private javax.swing.JLabel lblMenosFrecuente;
    private javax.swing.JLabel lblResultadoBusqueda;
    private javax.swing.JTable tablaTripletas;
    // End of variables declaration//GEN-END:variables
}
