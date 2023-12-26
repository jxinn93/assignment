/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package loginandregister;

/**
 *
 * @author SCSM11
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Trivia extends javax.swing.JFrame {
    private Date registrationDate;
    private String Username;
    
  

   public Trivia(String name, Date registrationDate){
       this.Username = name;
       this.registrationDate = registrationDate;
       initComponents();
   }
    
 public void setRegistrationDate (Date registrationDate){
     this.registrationDate = registrationDate;
 }

 private Date getDate() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "");
            System.out.println("Connected to the database");

            // Convert both stored username and input username to lowercase for case-insensitive comparison
            String query = "SELECT * FROM user_table3 WHERE LOWER(Username) = LOWER(?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, Username);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                System.out.println("Query executed successfully");
                if (rs.next()) {
                    Date registrationDate = rs.getDate("registration_date");
                    if (registrationDate != null) {
                        return registrationDate;
                    } else {
                        System.out.println("Registration date is NULL for the given email");
                    }
                } else {
                    System.out.println("No matching records for the given email");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    // ... other code ...

  public void showTrivia() {
    setVisible(true);
    pack();
    setLocationRelativeTo(null);
}

            


            
              
   
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TODAY = new javax.swing.JButton();
        before = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("trivia");

        TODAY.setBackground(new java.awt.Color(255, 204, 204));
        TODAY.setFont(new java.awt.Font("OCR A Extended", 1, 36)); // NOI18N
        TODAY.setForeground(new java.awt.Color(0, 0, 0));
        TODAY.setText("TODAY QUESTION");
        TODAY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TODAYActionPerformed(evt);
            }
        });

        before.setBackground(new java.awt.Color(204, 255, 204));
        before.setFont(new java.awt.Font("OCR A Extended", 1, 36)); // NOI18N
        before.setForeground(new java.awt.Color(51, 51, 51));
        before.setText("CHECK TRIVIA");
        before.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beforeActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\SCSM11\\Downloads\\valley.jpg")); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(725, 500));
        jLabel1.setMinimumSize(new java.awt.Dimension(725, 500));
        jLabel1.setPreferredSize(new java.awt.Dimension(725, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(before, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TODAY, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(before, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(TODAY, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TODAYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TODAYActionPerformed
         if (registrationDate != null) {
            Today TodayFrame = new Today();
            TodayFrame.setDate(registrationDate);
            TodayFrame.setVisible(true);
            TodayFrame.pack();
            TodayFrame.setLocationRelativeTo(null);
        } else {
            System.out.println("Failed to retrieve registration date.");
        }
        
        
 
     
    }//GEN-LAST:event_TODAYActionPerformed

    private void beforeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beforeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_beforeActionPerformed

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
            java.util.logging.Logger.getLogger(Trivia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Trivia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Trivia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Trivia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton TODAY;
    private javax.swing.JButton before;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables



}


