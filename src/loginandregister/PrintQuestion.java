/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginandregister;

/**
 *
 * @author SCSM11
 */
 import java.util.ArrayList;
public class PrintQuestion {
   


    public String printFormattedQuestion(int day, ArrayList<String> questionList) {
        int attempt = 1;
        StringBuilder formattedQuestion = new StringBuilder();
        formattedQuestion.append("<html>"); // Start HTML
        formattedQuestion.append(String.format("Day %d Trivia (Attempt #%d)<br>", day, attempt));
        formattedQuestion.append("=======================================<br>");
        formattedQuestion.append(questionList.get(day - 1));
        formattedQuestion.append("</html>"); // End HTML
        return formattedQuestion.toString();
    }

    
}

