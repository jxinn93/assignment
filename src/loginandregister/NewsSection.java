/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package loginandregister;

/**
 *
 * @author SCSM11
 */
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class NewsSection extends javax.swing.JFrame {
    private static List<NewsFilter.NewsArticle> allNews;
    private static List<NewsFilter.NewsArticle> apiNewsList;
    /**
     * Creates new form NewsSection
     */
    public NewsSection() {
        initComponents();
        allNews = readAllNewsFromFile();
        
 List<NewsFilter.NewsArticle> apiNewsList = Api.getNewsNature();
 printNews(apiNewsList);
 NewsSection.setApiNewsList(apiNewsList);
// Proceed to the next stage

    }
    public static List<NewsFilter.NewsArticle> getNewsNature() {
    List<NewsFilter.NewsArticle> natureNews = Api.getNewsNature();
    NewsSection.setApiNewsList(natureNews);
    return natureNews;
}
    public static void  setApiNewsList(List<NewsFilter.NewsArticle> apiNewsList){
    NewsSection.apiNewsList = apiNewsList;
}
    private List<NewsFilter.NewsArticle> readAllNewsFromFile(){
        String filePath = "C:/Users/SCSM11/Documents/NewsSample.txt";
        List<NewsFilter.NewsArticle> allNews = NewsFilter.readNewsFromFile(filePath);
        System.out.println("Total articles read from file: " + allNews.size());
        System.out.println("Titles before filtering:");
        allNews.forEach(news -> System.out.println(news.title));

        return allNews;
    }
    public void printNews(List<NewsFilter.NewsArticle> newsList) {
    for (NewsFilter.NewsArticle news : newsList) {
        System.out.println("Title: " + news.title);
        System.out.println("URL: " + news.url);
        System.out.println("Date: " + news.date);
        System.out.println();
    }
}
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        keyword = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Welcome to News Section");
        jLabel2.setToolTipText("");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 520, 70));

        keyword.setBackground(new java.awt.Color(204, 204, 204));
        keyword.setFont(new java.awt.Font("MS PGothic", 1, 18)); // NOI18N
        keyword.setForeground(new java.awt.Color(0, 0, 0));
        keyword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keywordActionPerformed(evt);
            }
        });
        getContentPane().add(keyword, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 270, 60));

        jLabel3.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Enter The Keyword");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 330, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\SCSM11\\Downloads\\sunflower.jpg")); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setPreferredSize(new java.awt.Dimension(720, 500));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 531));

        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 250, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void keywordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keywordActionPerformed
       
        String userKeyword = keyword.getText().trim();
        List<NewsFilter.NewsArticle> filteredFileNews = NewsFilter.filterNews(allNews, userKeyword);
        if (!filteredFileNews.isEmpty() && apiNewsList != null && !apiNewsList.isEmpty()){
        DisplayNews displayFrame = new DisplayNews(filteredFileNews, apiNewsList);
        displayFrame.setVisible(true);
    } else {
        System.out.println("No matching news found for the entered keyword.");
    
        }    
    }//GEN-LAST:event_keywordActionPerformed
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
            java.util.logging.Logger.getLogger(NewsSection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewsSection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewsSection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewsSection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewsSection().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField keyword;
    // End of variables declaration//GEN-END:variables
}
