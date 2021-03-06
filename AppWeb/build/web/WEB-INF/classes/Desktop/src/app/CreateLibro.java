/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import Utilerias.Comprobacion;
import Utilerias.ConexionSQLServer;
import app.Daos.DaoArea;
import app.Daos.DaoAutor;
import app.Daos.DaoEditorial;
import app.Daos.DaoEjemplar;
import app.Daos.DaoEstante;

import app.Daos.DaoLibro;
import app.model.BeanArea;
import app.model.BeanAutor;
import app.model.BeanEditorial;
import app.model.BeanEjemplar;
import app.model.BeanEstante;
import app.model.BeanLibro;
import java.awt.GraphicsConfiguration;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


/**
 *
 * @author Eliel David
 */
public class CreateLibro extends javax.swing.JFrame {
private Connection conexion;
private BeanLibro beanLibro;
private List<BeanEditorial>editorial;
private List<BeanArea>area;
private List <BeanAutor>autores;
private List <BeanEstante>estantes;
private DaoArea daoArea;
private DaoEditorial daoEditorial;
private DaoAutor daoAutor;
private DaoEstante daoEstante;
private DefaultListModel modelo = new DefaultListModel();
private List<BeanAutor> agregar= new ArrayList<>();
private BeanAutor bean= new BeanAutor();
Comprobacion com = new Comprobacion();


 

    /**
     * Creates new form CreateAutor
     */
    public CreateLibro() {
    try {
        conexion= ConexionSQLServer.getConnection();
    } catch (SQLException ex) {
        Logger.getLogger(CreateLibro.class.getName()).log(Level.SEVERE, null, ex);
    }
     initComponents();
    daoArea=new DaoArea(conexion);
    daoAutor = new DaoAutor(conexion);
    daoEditorial= new DaoEditorial(conexion);
    daoEstante = new DaoEstante(conexion);
    area=daoArea.getAll();
        for (BeanArea list : area) {
            cmbArea.addItem(list.getNombre());
        }
        editorial=daoEditorial.getAll();
        for (BeanEditorial list : editorial) {
            cmbEditorial.addItem(list.getNombre());
            
        }
        autores=daoAutor.getAll();
        for (BeanAutor list : autores) {
            cmbAutor.addItem(list.getNombre());
        }
        
        estantes= daoEstante.getAll();
        for (BeanEstante list : estantes){
            cmbEstante.addItem(list.getId_estante());
        }
    
    
       
        
        setLocationRelativeTo(null);
        
        pack();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        txtISBN = new javax.swing.JTextField();
        txtPaginas = new javax.swing.JTextField();
        cmbArea = new javax.swing.JComboBox();
        cmbEditorial = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbAutor = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        btnAgregarAutor = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listAut = new javax.swing.JList();
        jLabel8 = new javax.swing.JLabel();
        txtEjemplar = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cmbEstante = new javax.swing.JComboBox();
        btnArea = new javax.swing.JButton();
        btnEditorial = new javax.swing.JButton();
        btnEstante = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Libro");

        jLabel2.setText("Titulo:");

        jLabel3.setText("ISBN");

        jLabel4.setText("Paginas");

        txtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloActionPerformed(evt);
            }
        });
        txtTitulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTituloKeyTyped(evt);
            }
        });

        txtISBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtISBNActionPerformed(evt);
            }
        });
        txtISBN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtISBNKeyTyped(evt);
            }
        });

        txtPaginas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPaginasKeyTyped(evt);
            }
        });

        cmbArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAreaActionPerformed(evt);
            }
        });

        jLabel5.setText("Area");

        jLabel6.setText("Editorial");

        jLabel7.setText("Autores");

        btnAgregarAutor.setText("Agregar");
        btnAgregarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAutorActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(listAut);

        jLabel8.setText("N. Ejemplares");

        txtEjemplar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEjemplarKeyTyped(evt);
            }
        });

        jLabel9.setText("Estante");

        btnArea.setText("Agregar");
        btnArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAreaActionPerformed(evt);
            }
        });

        btnEditorial.setText("Agregar");
        btnEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditorialActionPerformed(evt);
            }
        });

        btnEstante.setText("Agregar");
        btnEstante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstanteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                            .addComponent(txtISBN)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cmbArea, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnArea)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtPaginas)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cmbAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAgregarAutor)
                                    .addComponent(btnEditorial))
                                .addGap(32, 32, 32))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cmbEstante, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEstante))
                            .addComponent(txtEjemplar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtEjemplar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cmbEstante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEstante))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnArea))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditorial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAgregarAutor))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnAgregar.setText("Aceptar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
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
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar)
                    .addComponent(btnAgregar))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:         
         BeanLibro libro= new BeanLibro();
         DaoLibro daoLibro = new DaoLibro(conexion);
         
         BeanEditorial beanEditorial= new BeanEditorial();
         DaoEditorial daoeditorial = new DaoEditorial(conexion);   
        
         DaoArea daoarea= new DaoArea(conexion);
         BeanArea beanarea= new BeanArea();
         
         BeanEjemplar ejem = new BeanEjemplar();
         DaoEjemplar Daoejem = new DaoEjemplar(conexion);
        
         BeanEstante estan = new BeanEstante();
         DaoEstante DaoEst = new DaoEstante(conexion);
        
        String titulo=txtTitulo.getText();
        String ISBN=(txtISBN.getText());
        int paginas= Integer.parseInt(txtPaginas.getText());
        int ejemplares = Integer.parseInt(txtEjemplar.getText());
        int id_libro = Daoejem.idmax();
        int id_estante = Integer.parseInt(cmbEstante.getSelectedItem().toString());
        
        libro=daoLibro.get(id_libro);
        
        
        
       beanarea=daoArea.findByNombre(cmbArea.getSelectedItem().toString());
       beanEditorial=daoeditorial.findByNombre(cmbEditorial.getSelectedItem().toString());
        
        
        Comprobacion comprobacion=new Comprobacion();
        DaoLibro dao=new DaoLibro(conexion);
        
       if(titulo.length()==0 || ISBN.length()==0){
           String mensaje="Error de campos obligatorios vacios:\n";
           if(comprobacion.validarCampoTxt(titulo)){
               mensaje+="*Titulo\n";
           }
           if(comprobacion.validarCampoTxt(ISBN)){
               mensaje+="*Primer Apellido\n";
           }
           JOptionPane.showMessageDialog(rootPane, mensaje);
       }else{
           
           
           
          BeanLibro lib= new BeanLibro();
          BeanEjemplar eje = new BeanEjemplar();
           eje.setLibro(libro);
           eje.setEstante(estan);
           lib.setTitulo(titulo);
           lib.setISBN(Long.parseLong(ISBN));
           lib.setPaginas(paginas);
           lib.setEditorial(beanEditorial);
           lib.setArea(beanarea);
           lib.setAutores(agregar);
            
         
           if(dao.add(lib) && Daoejem.addLib(eje, ejemplares)){
           JOptionPane.showMessageDialog(rootPane, "Registro guardado con exito :)");
           this.dispose();
       }else{
                JOptionPane.showMessageDialog(rootPane, "Eror al guardar el registro :(");
           }
       }
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtISBNActionPerformed
       
    }//GEN-LAST:event_txtISBNActionPerformed

    private void txtTituloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTituloKeyTyped
        int CreateUsuario = 100;
           if ( txtTitulo.getText().length()>=CreateUsuario){
             evt.consume();         
    }//GEN-LAST:event_txtTituloKeyTyped
    }
    private void txtISBNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtISBNKeyTyped
        
        com.numeros(evt);
        int CreateLibro = 15;
           if ( txtISBN.getText().length()>=CreateLibro){
             evt.consume(); 
    }//GEN-LAST:event_txtISBNKeyTyped
    }
    private void txtPaginasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaginasKeyTyped
       com.numeros(evt);
        int CreateLibro = 4;
           if ( txtPaginas.getText().length()>=CreateLibro){
             evt.consume(); 
    }                      
    }//GEN-LAST:event_txtPaginasKeyTyped

    private void btnAgregarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAutorActionPerformed
        // TODO add your handling code here:
        daoAutor=new DaoAutor(conexion);
        bean=daoAutor.findByNombre(cmbAutor.getSelectedItem().toString());
       modelo.addElement(bean.getNombre()+" "+bean.getPrimer_apellido());
        listAut.setModel(modelo);
        
      agregar.add(bean);
        
        
    }//GEN-LAST:event_btnAgregarAutorActionPerformed

    private void cmbAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAreaActionPerformed

    private void btnEstanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstanteActionPerformed
       new CreateEstante().setVisible(true);
    }//GEN-LAST:event_btnEstanteActionPerformed

    private void btnAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAreaActionPerformed
        new CreateArea().setVisible(true);
    }//GEN-LAST:event_btnAreaActionPerformed

    private void btnEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditorialActionPerformed
        new CreateEditorial().setVisible(true);
    }//GEN-LAST:event_btnEditorialActionPerformed

    private void txtEjemplarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEjemplarKeyTyped
        com.numeros(evt);
        int CreateLibro = 4;
           if ( txtEjemplar.getText().length()>=CreateLibro){
             evt.consume(); 
    }
    }//GEN-LAST:event_txtEjemplarKeyTyped
    
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
            java.util.logging.Logger.getLogger(CreateLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateLibro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregarAutor;
    private javax.swing.JButton btnArea;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditorial;
    private javax.swing.JButton btnEstante;
    private javax.swing.JComboBox cmbArea;
    private javax.swing.JComboBox cmbAutor;
    private javax.swing.JComboBox cmbEditorial;
    private javax.swing.JComboBox cmbEstante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listAut;
    private javax.swing.JTextField txtEjemplar;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtPaginas;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
