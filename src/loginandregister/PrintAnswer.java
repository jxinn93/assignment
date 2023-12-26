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
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
public class PrintAnswer {
    public String[] getAnswers(int day, ArrayList<String> answer, int[] indices) {
        String[] answers = new String[4];

        answers[0] = "[A] " + answer.get(indices[0]);
        answers[1] = "[B] " + answer.get(indices[1]);
        answers[2] = "[C] " + answer.get(indices[2]);
        answers[3] = "[D] " + answer.get(indices[3]);

        return answers;
    }

    public int[] getAnswerIndices(int day, int size) {
        Random r = new Random();
        Set<Integer> set = new LinkedHashSet<>();
        int MAX = (day * 5) - 2, MIN = (day - 1) * 5;

        while (set.size() < 4) {
            set.add(r.nextInt(MAX - MIN + 1) + MIN);
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}
