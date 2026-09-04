package vista;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class LoginVista extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LoginVista.class.getName());

    FondoPanel fondo = new FondoPanel();

    public LoginVista() {
        this.setContentPane(fondo);
        initComponents();
        // ventana estatica
        setSize(650, 650);
        setResizable(false);
        setLocationRelativeTo(null);

    }

    public String getTxtUsuario() {
        return txtUsuario.getText();
    }

    public void setTxtUsuario(String mensaje) {
        this.txtUsuario.setText(mensaje);
    }

    public String getTxtContrasena() {
        return txtContrasena.getText();
    }

    public void setTxtContrasena(String mensaje) {
        this.txtContrasena.setText(mensaje);
    }

    public JButton getBtnIniciarSesion() {
        return btnIniciar;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUsuario = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JPasswordField();
        btnIniciar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtUsuario.setBackground(new java.awt.Color(234, 244, 255));
        txtUsuario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtUsuario.setCaretColor(new java.awt.Color(230, 220, 200));
        txtUsuario.addActionListener(this::txtUsuarioActionPerformed);

        txtContrasena.setBackground(new java.awt.Color(234, 244, 255));
        txtContrasena.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtContrasena.setForeground(new java.awt.Color(250, 250, 250));
        txtContrasena.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtContrasena.setCaretColor(new java.awt.Color(230, 220, 200));

        btnIniciar.setBackground(new java.awt.Color(234, 244, 255));
        btnIniciar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnIniciar.setForeground(new java.awt.Color(0, 0, 0));
        btnIniciar.setText("Iniciar Sesion");
        btnIniciar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnIniciar.addActionListener(this::btnIniciarActionPerformed);

        jLabel1.setBackground(new java.awt.Color(230, 220, 200));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(230, 220, 200));
        jLabel1.setText("USUARIO:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(230, 220, 200));
        jLabel2.setText("CONTRASEÑA:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtContrasena)
                    .addComponent(btnIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(232, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(235, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(207, 207, 207))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIniciarActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new LoginVista().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
// para el fondo
class FondoPanel extends JPanel {

    private Image imagen;

    public FondoPanel() {

        java.net.URL url =
                getClass().getResource("/Imagenes/fondo.png");

        if (url == null) {

            System.out.println("❌ NO SE ENCONTRO portada2.png");

        } else {

            System.out.println("✅ IMAGEN ENCONTRADA");
            System.out.println(url);

            imagen = new ImageIcon(url).getImage();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        if (imagen != null) {

            g.drawImage(
                    imagen,
                    0,
                    0,
                    getWidth(),
                    getHeight(),
                    this
            );
        }
    }
}
}



