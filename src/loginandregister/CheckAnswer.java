/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginandregister;
import java.util.ArrayList;
public class CheckAnswer {
    
   public boolean checkAns(int selectedAnswerIndex, int day, ArrayList<String> answerList, int[] shuffledIndices) {
        String correctAns = answerList.get((day * 5) - 1);
        String selectedAnswer = answerList.get(shuffledIndices[selectedAnswerIndex]);
        return selectedAnswer.equals(correctAns);
    }
}
