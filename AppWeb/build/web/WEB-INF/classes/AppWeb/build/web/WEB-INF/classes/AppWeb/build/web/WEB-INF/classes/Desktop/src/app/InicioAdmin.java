/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author Arakanox
 */
public class InicioAdmin extends javax.swing.JFrame {

    /**
     * Creates new form InicioAdmin
     */
    public InicioAdmin() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu8 = new javax.swing.JMenu();
        listaArea = new javax.swing.JMenuItem();
        listaAutor = new javax.swing.JMenuItem();
        listaEditorial = new javax.swing.JMenuItem();
        listaEstante = new javax.swing.JMenuItem();
        listaLibro = new javax.swing.JMenuItem();
        listaUsuario = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        CrearArea = new javax.swing.JMenuItem();
        CrearAutor = new javax.swing.JMenuItem();
        CrearEditorial = new javax.swing.JMenuItem();
        CrearEstante = new javax.swing.JMenuItem();
        CrearLibro = new javax.swing.JMenuItem();
        CrearUsuario = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jButton1.setText("Cerrar sesion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logovista.png"))); // NOI18N

        jMenu8.setText("Listas");

        listaArea.setText("Area");
        listaArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaAreaActionPerformed(evt);
            }
        });
        jMenu8.add(listaArea);

        listaAutor.setText("Autor");
        listaAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaAutorActionPerformed(evt);
            }
        });
        jMenu8.add(listaAutor);

        listaEditorial.setText("Editorial");
        listaEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaEditorialActionPerformed(evt);
            }
        });
        jMenu8.add(listaEditorial);

        listaEstante.setText("Estante");
        listaEstante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaEstanteActionPerformed(evt);
            }
        });
        jMenu8.add(listaEstante);

        listaLibro.setText("Libro");
        listaLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaLibroActionPerformed(evt);
            }
        });
        jMenu8.add(listaLibro);

        listaUsuario.setText("Usuario");
        listaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaUsuarioActionPerformed(evt);
            }
        });
        jMenu8.add(listaUsuario);

        jMenuBar1.add(jMenu8);

        jMenu2.setText("Crear");

        CrearArea.setText("Area");
        CrearArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearAreaActionPerformed(evt);
            }
        });
        jMenu2.add(CrearArea);

        CrearAutor.setText("Autor");
        CrearAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearAutorActionPerformed(evt);
            }
        });
        jMenu2.add(CrearAutor);

        CrearEditorial.setText("Editorial");
        CrearEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearEditorialActionPerformed(evt);
            }
        });
        jMenu2.add(CrearEditorial);

        CrearEstante.setText("Estante");
        CrearEstante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearEstanteActionPerformed(evt);
            }
        });
        jMenu2.add(CrearEstante);

        CrearLibro.setText("Libro");
        CrearLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearLibroActionPerformed(evt);
            }
        });
        jMenu2.add(CrearLibro);

        CrearUsuario.setText("Usuario");
        CrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearUsuarioActionPerformed(evt);
            }
        });
        jMenu2.add(CrearUsuario);

        jMenuBar1.add(jMenu2);

        jMenu1.setText("Estadisticas");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(334, 334, 334)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(logo)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(logo)
                .addGap(57, 57, 57)
                .addComponent(jButton1)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        new Inicio().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void listaAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaAreaActionPerformed
        new ReadArea().setVisible(true);
    }//GEN-LAST:event_listaAreaActionPerformed

    private void listaAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaAutorActionPerformed
        new ReadAutor().setVisible(true);
    }//GEN-LAST:event_listaAutorActionPerformed

    private void listaEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaEditorialActionPerformed
        new ReadEditorial().setVisible(true);
    }//GEN-LAST:event_listaEditorialActionPerformed

    private void listaEstanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaEstanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listaEstanteActionPerformed

    private void listaLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaLibroActionPerformed
        new ReadLibro().setVisible(true);
    }//GEN-LAST:event_listaLibroActionPerformed

    private void listaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaUsuarioActionPerformed
        new ReadUsuarios().setVisible(true);
    }//GEN-LAST:event_listaUsuarioActionPerformed

    private void CrearAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearAreaActionPerformed
        new CreateArea().setVisible(true);
    }//GEN-LAST:event_CrearAreaActionPerformed

    private void CrearAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearAutorActionPerformed
        new CreateAutor().setVisible(true);        
    }//GEN-LAST:event_CrearAutorActionPerformed

    private void CrearEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearEditorialActionPerformed
        new CreateEditorial().setVisible(true);
    }//GEN-LAST:event_CrearEditorialActionPerformed

    private void CrearEstanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearEstanteActionPerformed
        new CreateEstante().setVisible(true);
    }//GEN-LAST:event_CrearEstanteActionPerformed

    private void CrearLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearLibroActionPerformed
        new CreateLibro().setVisible(true);
    }//GEN-LAST:event_CrearLibroActionPerformed

    private void CrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearUsuarioActionPerformed
        new CreateUsuario().setVisible(true);
    }//GEN-LAST:event_CrearUsuarioActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        new Estadisticas().setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked

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
            java.util.logging.Logger.getLogger(InicioAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CrearArea;
    private javax.swing.JMenuItem CrearAutor;
    private javax.swing.JMenuItem CrearEditorial;
    private javax.swing.JMenuItem CrearEstante;
    private javax.swing.JMenuItem CrearLibro;
    private javax.swing.JMenuItem CrearUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem listaArea;
    private javax.swing.JMenuItem listaAutor;
    private javax.swing.JMenuItem listaEditorial;
    private javax.swing.JMenuItem listaEstante;
    private javax.swing.JMenuItem listaLibro;
    private javax.swing.JMenuItem listaUsuario;
    private javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables
}
