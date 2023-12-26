/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package loginandregister;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JFramePass extends javax.swing.JFrame {
   
    private int day = 5;
    private ArrayList<String> arrayQuestion = new ArrayList<>();
    private ArrayList<String> arrayAnswer = new ArrayList<>();
    private TriviareadFile reader = new TriviareadFile();
    private String filePath = "C:\\users\\scsm11\\Documents\\TriviaSample.txt";

    public JFramePass() {
        initComponents();
        initializeComponents();
    }

    private void initializeComponents() {
        passQuestion.setText("Enter the day of trivia");
        passQuestion.setEditable(false); // Make the text area non-editable
        passQuestion.setLineWrap(true); // Enable line wrapping
        passQuestion.setWrapStyleWord(true); // Wrap at word boundaries
        jButton1.setText("Submit");

        // Add ActionListener to the submit button
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkDay();
            }
        });
        readFile();
    }

    private void readFile() {
        // Pass the ArrayLists to the ReadFile instance to populate them
        reader.readFile(filePath, arrayQuestion, arrayAnswer);
    }

    // Assuming checkDay is a method that takes user input
    private void checkDay() {
        String userInput = jTextField1.getText();

        // Check if user input is null or empty
        if (userInput == null || userInput.trim().isEmpty()) {
            passQuestion.setText("Please enter a valid input.");
            return;  // Exit the method if input is null or empty
        }

        userInput = userInput.trim();

        try {
            int inputDay = Integer.parseInt(userInput);

            if (isValidCheckDay(day, inputDay, arrayQuestion.size())) {
                String triviaOutput = checkPassTrivia(day, inputDay, arrayQuestion, arrayAnswer);
                passQuestion.setText(triviaOutput);
                
                // Add ActionListener to the button for checking another day
                jButton1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Reset the button text to "Submit"
                        jButton1.setText("Submit");
                        checkDay();
                    }
                });
            } else {
                passQuestion.setText("Invalid day. Please enter a valid day.");
            }
        } catch (NumberFormatException ex) {
            passQuestion.setText("Invalid input. Please enter a valid integer.");
        }
    }

    private boolean isValidCheckDay(int day, int checkDay, int maxQuestionSize) {
        return day > checkDay && checkDay > 0 && checkDay <= maxQuestionSize;
    }

    public static String checkPassTrivia(int day, int checkDay, ArrayList<String> question, ArrayList<String> answer) {
        if (day > checkDay && checkDay > 0 && checkDay <= question.size()) {
            String originalQuestion = question.get(checkDay - 1);
            String correctAns = answer.get((checkDay * 5) - 1);
            return "\n" + originalQuestion + "\nThe answer is " + correctAns + ".\n";
        } else {
            return "Invalid day. Please enter a valid day.";
        }
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        passQuestion = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        passQuestion.setColumns(20);
        passQuestion.setRows(5);
        jScrollPane1.setViewportView(passQuestion);

        jTextField1.setText("jTextField1");

        jButton1.setText("jButton1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(466, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(182, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(JFramePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFramePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFramePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFramePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFramePass().setVisible(true);
            }
        });
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextArea passQuestion;
    // End of variables declaration//GEN-END:variables
}
