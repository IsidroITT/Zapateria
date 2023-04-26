
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Toshiba-PC
 */
public class InicioSeccion extends javax.swing.JFrame {
    MetodosSql meto=new MetodosSql();

    /**
     * Creates new form InicioSeccion
     */
    public InicioSeccion() {
        initComponents();
        this.setLocationRelativeTo(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        recuperar = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtContra = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        recuperar.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        recuperar.setForeground(new java.awt.Color(255, 255, 255));
        recuperar.setText("Recuperar");
        recuperar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recuperarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                recuperarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                recuperarMouseExited(evt);
            }
        });
        getContentPane().add(recuperar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 570, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Perdi mi contraseña. Presione aqui");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 550, -1, -1));

        btnIngresar.setBackground(new java.awt.Color(51, 255, 255));
        btnIngresar.setFont(new java.awt.Font("Monotype Corsiva", 2, 24)); // NOI18N
        btnIngresar.setText("Ingresar");
        btnIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIngresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnIngresarMouseExited(evt);
            }
        });
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 480, 180, 60));

        jLabel2.setFont(new java.awt.Font("Freestyle Script", 1, 36)); // NOI18N
        jLabel2.setText("Contraseña");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, -1, -1));

        jLabel3.setFont(new java.awt.Font("Freestyle Script", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 204));
        jLabel3.setText("Zapateria Angelina");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        txtUser.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserKeyPressed(evt);
            }
        });
        getContentPane().add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 250, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/free-30-instagram-stories-icons08_122555 (1).png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, -1, 270));

        txtContra.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraActionPerformed(evt);
            }
        });
        txtContra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContraKeyPressed(evt);
            }
        });
        getContentPane().add(txtContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, 250, 50));

        jLabel6.setFont(new java.awt.Font("Freestyle Script", 1, 36)); // NOI18N
        jLabel6.setText("Usuario");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/morado.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 619));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        Empleados e=new Empleados();
        Principal a=new Principal();
        
        String usuario="Angelina";
        String contra="12345";
        
        
        
        String Pass=new String(txtContra.getPassword());
        
        
        if (meto.BuscarUsuario(txtUser.getText(), Pass)==1) {
            JOptionPane.showMessageDialog(null,"Inicio Exitoso" );
            
            e.setVisible(true);
            this.dispose();
            
        }else{
        JOptionPane.showMessageDialog(null, "Contraseña INCORRECTA");
        
        }
        
        String user=txtUser.getText();
        Principal.usuario.setText(user);
        
   
        
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void txtContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraActionPerformed

    private void recuperarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recuperarMouseClicked
        JOptionPane.showInputDialog(null,"Escriba su correo aqui: ");
    }//GEN-LAST:event_recuperarMouseClicked

    private void recuperarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recuperarMouseEntered
        recuperar.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_recuperarMouseEntered

    private void recuperarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recuperarMouseExited
        recuperar.setForeground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_recuperarMouseExited

    private void btnIngresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseEntered
        btnIngresar.setBackground(new java.awt.Color(204,255,255));
    }//GEN-LAST:event_btnIngresarMouseEntered

    private void btnIngresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseExited
        btnIngresar.setBackground(new java.awt.Color(51,255,255));
    }//GEN-LAST:event_btnIngresarMouseExited

    private void txtUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
        Empleados e=new Empleados();
        Principal a=new Principal();
        
        String usuario="Angelina";
        String contra="12345";
        
        String usuario2="Maria";
        String contra2="12345";
        
        
        String Pass=new String(txtContra.getPassword());
        if (txtUser.getText().equals(usuario) && Pass.equals(contra)) {
            a.setVisible(true);
            this.dispose();
        }else{
        if (txtUser.getText().equals(usuario2) && Pass.equals(contra2)) {
            e.setVisible(true);
            this.dispose();
            
        }else{
        JOptionPane.showMessageDialog(null, "Contraseña INCORRECTA");
        
        }
        }
        String user=txtUser.getText();
        Principal.usuario.setText(user);
        }
    }//GEN-LAST:event_txtUserKeyPressed

    private void txtContraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
        Empleados e=new Empleados();
        Principal a=new Principal();
        
        String usuario="Angelina";
        String contra="12345";
        
        String usuario2="Maria";
        String contra2="12345";
        
        
        String Pass=new String(txtContra.getPassword());
        if (txtUser.getText().equals(usuario) && Pass.equals(contra)) {
            a.setVisible(true);
            this.dispose();
        }else{
        if (txtUser.getText().equals(usuario2) && Pass.equals(contra2)) {
            e.setVisible(true);
            this.dispose();
            
        }else{
        JOptionPane.showMessageDialog(null, "Contraseña INCORRECTA");
        txtContra.setText("");
        txtContra.requestFocus();
        }
        }
        String user=txtUser.getText();
        Principal.usuario.setText(user);
        }
    }//GEN-LAST:event_txtContraKeyPressed

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
            java.util.logging.Logger.getLogger(InicioSeccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioSeccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioSeccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioSeccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioSeccion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel recuperar;
    private javax.swing.JPasswordField txtContra;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}