/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapostg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneLayout;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Manuel
 */
public class Recompensas extends javax.swing.JFrame {
public Connection conexion = null;
    public ResultSet rs = null;
    public Statement s = null;
    DefaultTableModel Modelo_Tabla;
    /**
     * Creates new form Recompensas
     */
    public Recompensas() {
        initComponents();
        
    }

        public void AbrirConexion(){
         if(conexion != null){
            return;
        }
        
        String url ="jdbc:postgresql://localhost:5432/CoperachaSA";
        String username = "postgres";
	String password ="manuel123";
        try{
            Class.forName("org.postgresql.Driver");
            
            conexion = DriverManager.getConnection(url, username, password);
            
            if(conexion != null){
               JOptionPane.showMessageDialog(null, "Conexión realizada :D.");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Conexión fallida.");
        }
    }
        
        public void CerrarConexion(){
            try{
                conexion.close();
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error para cerrar base de datos D:");
        }
        }
        
        public void InsertarRecompensa(String Codigo, String NoPropuesta, String Tipo, String Estado, Integer precioI, Integer precioF){
            Connection conexion1 = null;
            Statement s = null;
            PreparedStatement ps = null;
            String insertarRecompensa = "INSERT INTO recompensa(cod_recompensa, cod_propuesta, tipo, estado, precio_inicial, monto_recaudado) VALUES (?, ?, ?, ?, ?, ?);";
            try{
                conexion1 = new Ejecuciones().AbrirConexion() ;
                ps = conexion1.prepareStatement(insertarRecompensa);
                ps.setString(1, Codigo);
                ps.setString(2, NoPropuesta);
                ps.setString(3, Tipo);
                ps.setString(4, Estado);
                ps.setInt(5, precioI);
                ps.setInt(6, precioF);
                ps.executeUpdate();
                conexion1.close();
                JOptionPane.showMessageDialog(null, "Se ha agregado exitosamente :D");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error de inserción D:");
            }
            
        }
        
        public void EliminarRecompensa(String codigo){
            Connection conexion1 = null;
            Statement s = null;
            PreparedStatement ps = null;
            String eliminarRecompensa = "DELETE FROM recompensa where cod_recompensa = (?)";
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar la recompensa?","Confirmar Eliminacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(confirmacion == 0){
                try{
                    conexion1 = new Ejecuciones().AbrirConexion();
                    ps = conexion1.prepareStatement(eliminarRecompensa);
                    ps.setString(1, codigo);
                    ps.executeUpdate();
                    conexion1.close();
                    JOptionPane.showMessageDialog(null, "Eliminado correctamente :D");
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Error en la eliminación D:");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Se han conservado los datos");
            }
        }
        
        public void ModificarRecompensa(String Codigo, String NoPropuesta, String Tipo, String Estado, Integer precioI, Integer precioF){
            Connection conexion1 = null;
            Statement s = null;
            PreparedStatement ps = null;
            String modificar = "UPDATE recompensa SET cod_propuesta = (?), tipo = (?), estado = (?), precio_inicial = (?), monto_recaudado = (?)  where cod_recompensa = (?);";
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea modificar la recompensa?","Confirmar Eliminacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(confirmacion == 0){
                try{
                    conexion1 = new Ejecuciones().AbrirConexion();
                    ps = conexion1.prepareStatement(modificar);
                    ps.setString(1, NoPropuesta);
                    ps.setString(2, Tipo);
                    ps.setString(3, Estado);
                    ps.setInt(4, precioI);
                    ps.setInt(5, precioF);
                    ps.setString(6, Codigo);
                    ps.executeUpdate();
                    conexion1.close();
                    JOptionPane.showMessageDialog(null, "Modificado correctamente :D");
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Error en la actualizacion D:");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Se han conservado los datos");
            }
        }
        
        
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TxtCod = new javax.swing.JTextField();
        TxtNo = new javax.swing.JTextField();
        TxtTipo = new javax.swing.JTextField();
        TxtEstado = new javax.swing.JTextField();
        TxtMontoI = new javax.swing.JTextField();
        TxtMontoR = new javax.swing.JTextField();
        BtnInsert = new javax.swing.JButton();
        BtnMod = new javax.swing.JButton();
        BtnDelete = new javax.swing.JButton();
        BtnHistorial = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("No. Recompensa: ");

        jLabel2.setText("No. Propuesta: ");

        jLabel3.setText("Tipo:");

        jLabel4.setText("Estado:");

        jLabel6.setText("Monto Inicial:");

        jLabel7.setText("Monto Recaudado:");

        BtnInsert.setText("Insertar");
        BtnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInsertActionPerformed(evt);
            }
        });

        BtnMod.setText("Modificar");
        BtnMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModActionPerformed(evt);
            }
        });

        BtnDelete.setText("Eliminar");
        BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteActionPerformed(evt);
            }
        });

        BtnHistorial.setText("Ir a Historial");
        BtnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHistorialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(TxtEstado, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtCod, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtNo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtTipo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(TxtMontoI, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                                    .addComponent(TxtMontoR, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnDelete)
                            .addComponent(BtnInsert))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnMod)
                        .addGap(26, 26, 26)
                        .addComponent(BtnHistorial)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(1, 1, 1)
                        .addComponent(TxtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(TxtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(TxtMontoI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtMontoR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnInsert)
                    .addComponent(BtnMod)
                    .addComponent(BtnHistorial))
                .addGap(18, 18, 18)
                .addComponent(BtnDelete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInsertActionPerformed
        
            String Codigo = TxtCod.getText(); 
            String No_Propuesta = TxtNo.getText();
            String Tipo = TxtTipo.getText();
            String Estado = TxtEstado.getText();
            String precio = TxtMontoI.getText();
            Integer precioI = Integer.parseInt(precio);
            String precios = TxtMontoR.getText();
            Integer precioF = Integer.parseInt(precios);
            System.out.println(Codigo);
             System.out.println(No_Propuesta);
              System.out.println(Tipo);
               System.out.println(Estado);
                System.out.println(precioI);
                 System.out.println(precioF);
            this.InsertarRecompensa(Codigo, No_Propuesta, Tipo, Estado, precioI, precioF);
    }//GEN-LAST:event_BtnInsertActionPerformed

    private void BtnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHistorialActionPerformed
        Historial h = new Historial();
        h.setVisible(true);
    }//GEN-LAST:event_BtnHistorialActionPerformed

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
        String Codigo = TxtCod.getText(); 
        this.EliminarRecompensa(Codigo);
    }//GEN-LAST:event_BtnDeleteActionPerformed

    private void BtnModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModActionPerformed
        String Codigo = TxtCod.getText(); 
            String No_Propuesta = TxtNo.getText();
            String Tipo = TxtTipo.getText();
            String Estado = TxtEstado.getText();
            String precio = TxtMontoI.getText();
            Integer precioI = Integer.parseInt(precio);
            String precios = TxtMontoR.getText();
            Integer precioF = Integer.parseInt(precios);
            this.ModificarRecompensa(Codigo, No_Propuesta, Tipo, Estado, precioI, precioF);
    }//GEN-LAST:event_BtnModActionPerformed

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
            java.util.logging.Logger.getLogger(Recompensas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Recompensas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Recompensas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Recompensas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Recompensas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDelete;
    private javax.swing.JButton BtnHistorial;
    private javax.swing.JButton BtnInsert;
    private javax.swing.JButton BtnMod;
    private javax.swing.JTextField TxtCod;
    private javax.swing.JTextField TxtEstado;
    private javax.swing.JTextField TxtMontoI;
    private javax.swing.JTextField TxtMontoR;
    private javax.swing.JTextField TxtNo;
    private javax.swing.JTextField TxtTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
