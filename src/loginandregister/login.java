/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package loginandregister;

import java.sql.Connection ;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;
import loginandregister.PasswordHashing;
import java.io.* ;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

/**
 *
 * @author SCSM11
 */
public class login extends javax.swing.JFrame {
    private Today todayFrame;
    public login() {
        initComponents();
        todayFrame = new Today();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        EMAIL = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        PASSWORD = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        LOGIN = new javax.swing.JToggleButton();
        RegisterButton = new javax.swing.JToggleButton();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(808, 588));
        getContentPane().setLayout(null);

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\SCSM11\\Downloads\\forest.jpg")); // NOI18N
        jLabel5.setText("CODE OF NATURE");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 530, 560);

        jPanel1.setBackground(new java.awt.Color(0, 150, 143));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LOGIN");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Email :");

        PASSWORD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PASSWORDActionPerformed(evt);
            }
        });

        jTextField3.setText("Don't have an account?");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        LOGIN.setBackground(new java.awt.Color(0, 102, 102));
        LOGIN.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LOGIN.setForeground(new java.awt.Color(255, 255, 255));
        LOGIN.setText("LOGIN");
        LOGIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOGINActionPerformed(evt);
            }
        });

        RegisterButton.setBackground(new java.awt.Color(255, 255, 255));
        RegisterButton.setForeground(new java.awt.Color(0, 0, 0));
        RegisterButton.setText("REGISTER");
        RegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RegisterButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(PASSWORD, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(EMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(LOGIN))))
                .addGap(16, 47, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(85, 85, 85))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PASSWORD, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(LOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RegisterButton))
                .addGap(112, 112, 112))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(520, 0, 290, 560);

        jInternalFrame1.setVisible(true);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setText("code for nature");

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(184, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(398, Short.MAX_VALUE))
        );

        getContentPane().add(jInternalFrame1);
        jInternalFrame1.setBounds(0, 0, 732, 560);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void LOGINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOGINActionPerformed
    String Email = EMAIL.getText().trim();
    String Password = PASSWORD.getText();
    System.out.println("Email: " + Email);
    System.out.println("Password: " + Password);
    
    if (Email.isEmpty()|| Password.isEmpty()){
        JOptionPane.showMessageDialog(new JFrame(), "All Fields are required","Error", JOptionPane.ERROR_MESSAGE);
    }else{
        Connection con = null;
    
   try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "");
        System.out.println("Connected to the database");
        
        String selectQuery = "SELECT * FROM user_table3 WHERE LOWER(Email) = ?";
        
        try (PreparedStatement ps = con.prepareStatement(selectQuery)){
            ps.setString(1, Email.toLowerCase());
            try (ResultSet rs = ps.executeQuery()){
                System.out.println("Query executed successfully");
            
                if(rs.next()){
                    String hashedPasswordFromDB = rs.getString("hashedPassword");
                    String name=rs.getString("Username");
                    Date date = rs.getDate("registration_date");
                   
                    if (PasswordHashing.PasswordCheck(Password, hashedPasswordFromDB)){
                        System.out.println("Login successful!");
                        Home HomeFrame = new Home();
                        HomeFrame.setUser(name);
                        HomeFrame.setDate(date);
                        HomeFrame.setVisible(true);
                        HomeFrame.pack();
                        HomeFrame.setLocationRelativeTo(null);
                        
                        
                        Trivia triviaFrame = new Trivia(name, date);
                        triviaFrame.setVisible(false);
                        triviaFrame.pack();
                        triviaFrame.setLocationRelativeTo(null);
                        
                        HomeFrame.setTriviaFrame(triviaFrame);
                    } else {
                        System.out.println("Incorrect Email or Password");
                    JOptionPane.showMessageDialog(new JFrame(), "Incorrect email or password", "Error", JOptionPane.ERROR_MESSAGE); 
                    }
               //Reset fields
               EMAIL.setText("");
               PASSWORD.setText("");
                
               rs.close();
        }else {
               System.out.println("Email not found");
               JOptionPane.showMessageDialog(new JFrame(), "Email not found", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
   }catch (Exception e){
       e.printStackTrace();
       JOptionPane.showMessageDialog(new JFrame() , "Error: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
   } finally {
       try {
           if (con != null) {
               con.close(); }
           }catch  (Exception e){
               e.printStackTrace();
       }
   }
   }                                   
  
    
                                
     
  

    }//GEN-LAST:event_LOGINActionPerformed
    
    private void PASSWORDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PASSWORDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PASSWORDActionPerformed

    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterButtonActionPerformed
        register registerFrame = new register();
        registerFrame.setVisible(true);
        registerFrame.pack ();
        registerFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_RegisterButtonActionPerformed


  
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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EMAIL;
    private javax.swing.JToggleButton LOGIN;
    private javax.swing.JTextField PASSWORD;
    private javax.swing.JToggleButton RegisterButton;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
