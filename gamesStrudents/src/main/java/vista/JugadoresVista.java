
package vista;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;


public class JugadoresVista extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JugadoresVista.class.getName());

  
    public JugadoresVista() {
        initComponents();
    }
    public JTextField getTxtNickname() {
        return txtNickname;
    }

    public void setTxtNickname(String texto) {
        txtNickname.setText(texto);
    }

    public JTextField getTxtNombreReal() {
        return txtNombreReal;
    }

    public void setTxtNombreReal(String texto) {
        txtNombreReal.setText(texto);
    }

    public JTextField getTxtFechaNacimiento() {
        return txtFechaNacimiento;
    }

    public void setTxtFechaNacimiento(String texto) {
        txtFechaNacimiento.setText(texto);
    }

    public JTextField getTxtIdEquipo() {
        return txtIdEquipo;
    }

    public void setTxtIdEquipo(String texto) {
        txtIdEquipo.setText(texto);
    }

  

    public String getCmbRol() {

        if (cmbRolJ.getSelectedItem() == null) {
            return "";
        }

        return cmbRolJ
                .getSelectedItem()
                .toString();
    }

    public void setCmbRol(String rol) {
        cmbRolJ.setSelectedItem(rol);
    }

    public JTable getTblJugadores() {
        return tblJugadores;
    }

    public JButton getBtnCrear() {
        return btnCrear;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }

    public JButton getBtnInhabilitar() {
        return btnInhabilitar;
    }

    public JButton getBtnHabilitar() {
        return btnHabilitar;
    }

    public JButton getBtnSalir() {
        return btnSalir;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCrear = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblJugadores = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnHabilitar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnInhabilitar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtNickname = new javax.swing.JTextField();
        IdEquipo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lol = new javax.swing.JLabel();
        txtFechaNacimiento = new javax.swing.JTextField();
        txtNombreReal = new javax.swing.JTextField();
        txtIdEquipo = new javax.swing.JTextField();
        cmbRolJ = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCrear.setText("Crear");

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("NombreReal:");

        tblJugadores.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblJugadores);

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nickname:");

        btnSalir.setText("Salir");

        btnHabilitar.setText("Habilitar");
        btnHabilitar.addActionListener(this::btnHabilitarActionPerformed);

        btnModificar.setText("Modificar");

        btnInhabilitar.setText("Inabilitar");
        btnInhabilitar.addActionListener(this::btnInhabilitarActionPerformed);

        jPanel7.setBackground(new java.awt.Color(5, 35, 75));
        jPanel7.setForeground(new java.awt.Color(5, 35, 75));

        jLabel3.setFont(new java.awt.Font("Elephant", 0, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Gestion Jugadores");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        txtNickname.setForeground(new java.awt.Color(153, 153, 153));

        IdEquipo.setBackground(new java.awt.Color(204, 204, 204));
        IdEquipo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        IdEquipo.setForeground(new java.awt.Color(0, 0, 0));
        IdEquipo.setText("IdEquipo:");

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("FechaNacimiento:");

        lol.setBackground(new java.awt.Color(204, 204, 204));
        lol.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lol.setForeground(new java.awt.Color(0, 0, 0));
        lol.setText("Rol:");

        txtFechaNacimiento.setForeground(new java.awt.Color(153, 153, 153));

        txtNombreReal.setForeground(new java.awt.Color(153, 153, 153));

        txtIdEquipo.setForeground(new java.awt.Color(153, 153, 153));

        cmbRolJ.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IdEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(btnInhabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(35, 35, 35)
                            .addComponent(btnHabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(35, 35, 35)
                            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(62, 62, 62))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lol, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(58, 58, 58)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(58, 58, 58)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNickname)
                                .addComponent(txtNombreReal)
                                .addComponent(txtFechaNacimiento)
                                .addComponent(txtIdEquipo)
                                .addComponent(cmbRolJ, 0, 204, Short.MAX_VALUE)))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtNombreReal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IdEquipo)
                    .addComponent(txtIdEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lol)
                    .addComponent(cmbRolJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear)
                    .addComponent(btnModificar)
                    .addComponent(btnInhabilitar)
                    .addComponent(btnHabilitar)
                    .addComponent(btnSalir))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHabilitarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHabilitarActionPerformed

    private void btnInhabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInhabilitarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInhabilitarActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new JugadoresVista().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IdEquipo;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnHabilitar;
    private javax.swing.JButton btnInhabilitar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbRolJ;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lol;
    private javax.swing.JTable tblJugadores;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtIdEquipo;
    private javax.swing.JTextField txtNickname;
    private javax.swing.JTextField txtNombreReal;
    // End of variables declaration//GEN-END:variables
}
