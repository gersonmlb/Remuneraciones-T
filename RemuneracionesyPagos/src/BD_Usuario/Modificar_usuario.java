/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BD_Usuario;


import Control_BD.Control_Usuario;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author richard
 */
public class Modificar_usuario extends javax.swing.JFrame {
String iddUsuario="";
    /**
     * Creates new form frmusuario
     */
    public Modificar_usuario() {
        initComponents();
         this.setLocationRelativeTo(null);
         this.getContentPane().setBackground(Color.orange);
               this.setTitle("Mantenimiento Usuario ");
               iniciar();
    }
    public void iniciar(){
        //ACA CARGARE LA TABLA INICIAL USUARIO SIN PARAMETROS
            try {
            DefaultTableModel modelo;
                Control_Usuario func = new Control_Usuario();
            modelo = func.mostrar_inicial();

            jTable_listado.setModel(modelo);
  //          ocultar_columnas();
//            lbltotalregistros.setText("Total Registros " + Integer.toString(func.totalregistros));

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
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

        btn_salir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_listado = new javax.swing.JTable();
        txt_buscar = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txt_usuario = new javax.swing.JTextField();
        txt_pasword = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_modificar = new javax.swing.JButton();
        btn_salir2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_pasword1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel_idUsuario = new javax.swing.JLabel();

        btn_salir.setForeground(new java.awt.Color(11, 7, 7));
        btn_salir.setText("Salir");
        btn_salir.setEnabled(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 204));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(900, 200));

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));

        jTable_listado.setBackground(new java.awt.Color(0, 102, 255));
        jTable_listado.setForeground(new java.awt.Color(255, 255, 255));
        jTable_listado.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable_listado.setGridColor(new java.awt.Color(255, 204, 0));
        jTable_listado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_listadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_listado);

        txt_buscar.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        txt_buscar.setForeground(new java.awt.Color(138, 138, 138));
        txt_buscar.setText("Usuario");

        btn_buscar.setBackground(new java.awt.Color(153, 255, 153));
        btn_buscar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_buscar.setForeground(new java.awt.Color(0, 51, 153));
        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/busqueda (1).png"))); // NOI18N
        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Usuarios");

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));

        txt_usuario.setBackground(new java.awt.Color(0, 102, 153));
        txt_usuario.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        txt_usuario.setForeground(new java.awt.Color(255, 255, 255));

        txt_pasword.setBackground(new java.awt.Color(0, 102, 153));
        txt_pasword.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        txt_pasword.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuario");

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");

        btn_modificar.setBackground(new java.awt.Color(153, 255, 153));
        btn_modificar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_modificar.setForeground(new java.awt.Color(0, 0, 153));
        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/guardar.png"))); // NOI18N
        btn_modificar.setText("Modificar");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        btn_salir2.setBackground(new java.awt.Color(153, 255, 153));
        btn_salir2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_salir2.setForeground(new java.awt.Color(0, 0, 153));
        btn_salir2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/error.png"))); // NOI18N
        btn_salir2.setText("Salir");
        btn_salir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salir2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Repetir Pass");

        txt_pasword1.setBackground(new java.awt.Color(0, 102, 153));
        txt_pasword1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        txt_pasword1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("idUsuario");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_pasword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_pasword1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel5))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_salir2)
                            .addComponent(btn_modificar)))
                    .addComponent(jLabel6))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(btn_salir2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_pasword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_pasword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_modificar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_buscar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_buscar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(513, 513, 513)
                .addComponent(jLabel_idUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel_idUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        // TODO add your handling code here:
                //ACA CARGARE LA TABLA USUARIO CON UN PARAMETROS QUE ES EL DNI,APELLIDOS O NOMBRE
            try {
            DefaultTableModel modelo;
                Control_Usuario func = new Control_Usuario();
            modelo = func.mostrar(txt_buscar.getText());

            jTable_listado.setModel(modelo);
  //          ocultar_columnas();
//            lbltotalregistros.setText("Total Registros " + Integer.toString(func.totalregistros));

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        // TODO add your handling code here:
        //ACA REGISTRAMOS EL USUARIO

        if(txt_pasword.getText().equals(txt_pasword1.getText()) ){
            if( txt_usuario.getText().length() ==0 || txt_pasword.getText().length() == 0 ){

                JOptionPane.showMessageDialog(rootPane, "rellene todos los campos");

            }
            else{
                //
                ///////////////
                //////////
                if(jLabel_idUsuario.getText().equals("") ){

          JOptionPane.showMessageDialog(rootPane, "Selecona un usuario");    
           }    
    else
    {
        Control_Usuario change = new Control_Usuario();
        
     //   String code = jTextField_busqueda.getText();
      
                   
      
         String Iduser=jLabel_idUsuario.getText();
        
         String usuario=   txt_usuario.getText();
        String pasword= txt_pasword.getText();
 
        
        
        change.ModificarUsuario(Integer.parseInt(Iduser), usuario, pasword);
         /* Control_BD.Control_Establecimiento load = new Control_Establecimiento();
        load.CargarDocenteconsultaReporteEstablecimiento();
            ocultar_columnas_establecimiento();
        tam_columnas_establecimiento(); */
            }
                
                
                //////////
                /////
                //
                
            }
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Los pasword no son iguales");
        }
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_salir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salir2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btn_salir2ActionPerformed

    private void jTable_listadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_listadoMouseClicked
        // TODO add your handling code here:
                try {
                    int fila = jTable_listado.rowAtPoint(evt.getPoint());

       jLabel_idUsuario.setText(jTable_listado.getValueAt(fila, 0).toString());
        iddUsuario=(jTable_listado.getValueAt(fila, 0).toString());
       txt_usuario.setText(jTable_listado.getValueAt(fila, 1).toString());
          txt_pasword.setText((jTable_listado.getValueAt(fila, 2).toString()));
            txt_pasword1.setText((jTable_listado.getValueAt(fila, 2).toString()));
          
        } catch (Exception e) {
            System.out.println(e.getMessage());

            
            
        }
    }//GEN-LAST:event_jTable_listadoMouseClicked

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
            java.util.logging.Logger.getLogger(Modificar_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificar_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificar_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificar_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modificar_usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_salir;
    private javax.swing.JButton btn_salir2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_idUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_listado;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_pasword;
    private javax.swing.JTextField txt_pasword1;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
