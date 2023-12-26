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

public class PrintCorrectAns {
        private static ArrayList<String> answerList;
    private static int[] indices;

    public static String printCorrectAns(int day, ArrayList<String> answerList, int[] indices, int selectedAnswerIndex) {
        PrintCorrectAns.answerList = answerList;
        PrintCorrectAns.indices = indices;

        String correctAns = answerList.get((day * 5) - 1);
        char alphabet = getAlphabet(correctAns);
        return "Your answer is still incorrect.\nThe correct answer is " + alphabet + ": " + correctAns;
    }

    private static char getAlphabet(String correctAns) {
        int i = 0;
        while (!correctAns.equals(answerList.get(indices[i]))) {
            i += 1;
        }

        char alphabet;
        switch (i) {
            case 0:
                alphabet = 'A';
                break;
            case 1:
                alphabet = 'B';
                break;
            case 2:
                alphabet = 'C';
                break;
            default:
                alphabet = 'D';
                break;
        }

        return alphabet;
    }

}
