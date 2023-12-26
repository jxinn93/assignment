/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginandregister;

/**
 *
 * @author SCSM11
 */
public class ResponsePrinter {
     private int attempt;

    public ResponsePrinter(int attempt) {
        this.attempt = attempt;
    }

    public String getRespondText(boolean isCorrect) {
        if (isCorrect) {
            return "Congratulations! You answered it correctly!\nYou have been awarded " +
                   (attempt == 1 ? "2" : "1") + " mark" + (attempt == 1 ? "s." : ".");
        } else {
            if (attempt < 2) {
                return "Whoops, that doesn’t look right. Try again!";
            } else {
                return "Sorry, you've used all your attempts.";
            }
        }
    }
}


