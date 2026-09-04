
package vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;


public class PartidoVista extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PartidoVista.class.getName());
public PartidoVista() {
        initComponents();
    }
public JTextField getTxtIdPartido() {
    return txtIdPartido;
}

public void setTxtIdPartido(String texto) {
    txtIdPartido.setText(texto);
}

public JTextField getTxtFecha() {
    return txtFecha;
}

public void setTxtFecha(String texto) {
    txtFecha.setText(texto);
}

public JTextField getTxtHora() {
    return txtHora;
}

public void setTxtHora(String texto) {
    txtHora.setText(texto);
}

public JTextField getTxtMarcadorEquipo1() {
    return txtMarcadorEquipo1;
}

public void setTxtMarcadorEquipo1(String texto) {
    txtMarcadorEquipo1.setText(texto);
}

public JTextField getTxtMarcadorEquipo2() {
    return txtMarcadorEquipo2;
}

public void setTxtMarcadorEquipo2(String texto) {
    txtMarcadorEquipo2.setText(texto);
}

public JTextField getTxtRonda() {
    return txtRonda;
}

public void setTxtRonda(String texto) {
    txtRonda.setText(texto);
}

public JTextField getTxtFase() {
    return txtFase;
}

public void setTxtFase(String texto) {
    txtFase.setText(texto);
}

public JTextField getTxtEstado() {
    return txtEstado;
}

public void setTxtEstado(String texto) {
    txtEstado.setText(texto);
}

public JComboBox<String> getCmbEquipo1() {
    return cmbEquipo1;
}

public JComboBox<String> getCmbEquipo2() {
    return cmbEquipo2;
}

public JComboBox<String> getCmbTorneo() {
    return cmbTorneo;
}

public JComboBox<String> getCmbArbitro() {
    return cmbArbitro;
}

public JComboBox<String> getCmbSede() {
    return cmbSede;
}

public JTable getTblPartidos() {
    return tblPartidos;
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
        tblPartidos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnHabilitar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnInhabilitar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        IdEquipo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lol = new javax.swing.JLabel();
        txtMarcadorEquipo2 = new javax.swing.JTextField();
        txtRonda = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        txtMarcadorEquipo1 = new javax.swing.JTextField();
        IdEquipo1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lol1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        IdEquipo2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lol2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmbEquipo1 = new javax.swing.JComboBox<>();
        cmbEquipo2 = new javax.swing.JComboBox<>();
        txtEstado = new javax.swing.JTextField();
        cmbTorneo = new javax.swing.JComboBox<>();
        cmbArbitro = new javax.swing.JComboBox<>();
        cmbSede = new javax.swing.JComboBox<>();
        IdEquipo3 = new javax.swing.JLabel();
        txtFase = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtIdPartido = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCrear.setText("Crear");

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Fecha: ");

        tblPartidos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPartidos);

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));

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
        jLabel3.setText("Gestion Partido");

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

        txtFecha.setForeground(new java.awt.Color(153, 153, 153));

        IdEquipo.setBackground(new java.awt.Color(204, 204, 204));
        IdEquipo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        IdEquipo.setForeground(new java.awt.Color(0, 0, 0));
        IdEquipo.setText("Equipo 1: ");

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Hora: ");

        lol.setBackground(new java.awt.Color(204, 204, 204));
        lol.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lol.setForeground(new java.awt.Color(0, 0, 0));
        lol.setText("Equipo 2:   ");

        txtMarcadorEquipo2.setForeground(new java.awt.Color(153, 153, 153));

        txtRonda.setForeground(new java.awt.Color(153, 153, 153));

        txtHora.setForeground(new java.awt.Color(153, 153, 153));

        txtMarcadorEquipo1.setForeground(new java.awt.Color(153, 153, 153));

        IdEquipo1.setBackground(new java.awt.Color(204, 204, 204));
        IdEquipo1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        IdEquipo1.setForeground(new java.awt.Color(0, 0, 0));
        IdEquipo1.setText("Ronda: ");

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Marcador Equipo 2:");

        lol1.setBackground(new java.awt.Color(204, 204, 204));
        lol1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lol1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Marcador Equipo 1:");

        IdEquipo2.setBackground(new java.awt.Color(204, 204, 204));
        IdEquipo2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        IdEquipo2.setForeground(new java.awt.Color(0, 0, 0));
        IdEquipo2.setText("Árbitro: ");

        jLabel8.setBackground(new java.awt.Color(204, 204, 204));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Torneo: ");

        lol2.setBackground(new java.awt.Color(204, 204, 204));
        lol2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lol2.setForeground(new java.awt.Color(0, 0, 0));
        lol2.setText("Sede:  ");

        jLabel9.setBackground(new java.awt.Color(204, 204, 204));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Estado:");

        cmbEquipo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbEquipo1.addActionListener(this::cmbEquipo1ActionPerformed);

        cmbEquipo2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtEstado.setForeground(new java.awt.Color(153, 153, 153));

        cmbTorneo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbArbitro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbSede.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        IdEquipo3.setBackground(new java.awt.Color(204, 204, 204));
        IdEquipo3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        IdEquipo3.setForeground(new java.awt.Color(0, 0, 0));
        IdEquipo3.setText("Fase:");

        txtFase.setForeground(new java.awt.Color(153, 153, 153));

        jLabel10.setBackground(new java.awt.Color(204, 204, 204));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Partido:");

        txtIdPartido.setForeground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(IdEquipo2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lol2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbTorneo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbArbitro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbSede, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(IdEquipo1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(IdEquipo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lol, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(21, 21, 21))
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(IdEquipo3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(53, 53, 53)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtRonda, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbEquipo2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMarcadorEquipo1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHora, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbEquipo1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMarcadorEquipo2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFase)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtIdPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lol1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnInhabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnHabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtIdPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IdEquipo)
                            .addComponent(cmbEquipo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lol)
                            .addComponent(cmbEquipo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtMarcadorEquipo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtMarcadorEquipo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRonda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IdEquipo1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addComponent(IdEquipo3))
                    .addComponent(txtFase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnCrear)
                        .addGap(19, 19, 19)
                        .addComponent(btnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnInhabilitar)
                        .addGap(19, 19, 19)
                        .addComponent(btnHabilitar)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir)
                        .addGap(51, 51, 51)
                        .addComponent(lol1)
                        .addGap(28, 28, 28)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IdEquipo2)
                    .addComponent(cmbArbitro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lol2)
                    .addComponent(cmbSede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHabilitarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHabilitarActionPerformed

    private void btnInhabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInhabilitarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInhabilitarActionPerformed

    private void cmbEquipo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEquipo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEquipo1ActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new PartidoVista().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IdEquipo;
    private javax.swing.JLabel IdEquipo1;
    private javax.swing.JLabel IdEquipo2;
    private javax.swing.JLabel IdEquipo3;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnHabilitar;
    private javax.swing.JButton btnInhabilitar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbArbitro;
    private javax.swing.JComboBox<String> cmbEquipo1;
    private javax.swing.JComboBox<String> cmbEquipo2;
    private javax.swing.JComboBox<String> cmbSede;
    private javax.swing.JComboBox<String> cmbTorneo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lol;
    private javax.swing.JLabel lol1;
    private javax.swing.JLabel lol2;
    private javax.swing.JTable tblPartidos;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFase;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtIdPartido;
    private javax.swing.JTextField txtMarcadorEquipo1;
    private javax.swing.JTextField txtMarcadorEquipo2;
    private javax.swing.JTextField txtRonda;
    // End of variables declaration//GEN-END:variables
}
