/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package loginandregister;


/**
 *
 * @author SCSM11
 */





import java.awt.Color;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.sql.Date;
import javax.swing.JOptionPane;
import loginandregister.PrintQuestion;


public class Today extends javax.swing.JFrame {
    private ArrayList<String> arrayQuestions;
    private ArrayList<String> arrayAnswers;
    private int day = 1;
    
    private PrintQuestion printQuestion ;
    public Today() {
        initComponents();
        arrayQuestions = new ArrayList<>();
        arrayAnswers = new ArrayList<>();
        TriviareadFile triviaReader = new TriviareadFile();
        triviaReader.readFile("C:\\Users\\SCSM11\\Documents\\TriviaSample.txt", arrayQuestions, arrayAnswers);
        printQuestion = new PrintQuestion();
        setQuestionAndAnswer(); }
    
    private void setQuestionAndAnswer(){
        PrintQuestion printQuestion = new PrintQuestion();
        String formattedQuestion = printQuestion.printFormattedQuestion(day, arrayQuestions);
        triviaArea.setText(formattedQuestion);
        
        PrintAnswer printAnswer = new PrintAnswer();
        int[] indices = printAnswer.getAnswerIndices(day, arrayAnswers.size());
        String[] answers = printAnswer.getAnswers(day, arrayAnswers, indices);
        
        jButton1.setText(answers[0]);
        jButton2.setText(answers[1]);
        jButton3.setText(answers[2]);
        jButton4.setText(answers[3]);
        
    }
    
    private void jButtonActionPerformed(java.awt.event.ActionEvent evt) {
      int selectedAnswerIndex = -1;
      if(evt.getSource() == jButton1){
          selectedAnswerIndex = 0;
      }else if (evt.getSource() == jButton2){
          selectedAnswerIndex = 1;
      }else if (evt.getSource() == jButton3){
          selectedAnswerIndex = 2;
          
      }else if (evt.getSource() == jButton4){
          selectedAnswerIndex = 3;
      }
         boolean isCorrect = checkAnswer(selectedAnswerIndex);
         if(isCorrect){
             
         }else {
            JFrameWrong JFrameWrong = new JFrameWrong(this);
            JFrameWrong.setVisible(true);
            JFrameWrong.pack();
            JFrameWrong.setLocationRelativeTo(null);
        
    }
    }
    private boolean checkAnswer (int selectedAnswerIndex){
        CheckAnswer check = new CheckAnswer();
        return check.checkAns(selectedAnswerIndex, day, arrayAnswers, shuffledIndices);
    }
      public void setDate(Date registrationDate) {
        Instant instant = registrationDate.toLocalDate().atStartOfDay(ZoneOffset.UTC).toInstant();
        dateArea.setText(instant.toString());
        //Calculation
        int daysAfterRegistration = calculation(registrationDate);
        //Display
        String triviaQuestion = getTriviaQ (daysAfterRegistration);
        triviaArea.setText(triviaQuestion);
    }    

    private int calculation (Date registrationDate){
      LocalDate localRD = ((java.sql.Date) registrationDate).toLocalDate();
      LocalDate current = LocalDate.now();
      return (int) localRD.until(current).getDays();
     } 
    
    private String getTriviaQ (int day){
        if(day >= 1 && day<= arrayQuestions.size()){
            return arrayQuestions.get(day -1); }
        else {
         return "No trivia question available for this day."  ; 
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateArea = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        triviaArea = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jlabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dateArea.setFont(new java.awt.Font("Eras Light ITC", 1, 18)); // NOI18N
        dateArea.setForeground(new java.awt.Color(0, 0, 0));
        dateArea.setLabelFor(dateArea);
        dateArea.setText("RegistrationDate");
        getContentPane().add(dateArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 250, 60));

        triviaArea.setColumns(20);
        triviaArea.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        triviaArea.setRows(5);
        jScrollPane1.setViewportView(triviaArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 460, 200));

        jButton1.setText("jButton1");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 170, 60));

        jButton2.setText("jButton2");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 170, 50));

        jButton3.setText("jButton3");
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, 170, 60));

        jButton4.setText("jButton4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 410, 170, 50));

        jlabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\SCSM11\\Downloads\\mount fuji2.0.jpg")); // NOI18N
        jlabel1.setText("jLabel1");
        jlabel1.setPreferredSize(new java.awt.Dimension(725, 500));
        getContentPane().add(jlabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Today.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Today.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Today.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Today.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dateArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabel1;
    private javax.swing.JTextArea triviaArea;
    // End of variables declaration//GEN-END:variables


    }

