/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginandregister;

/**
 *
 * @author SCSM11
 */
public class PrintAnswerResult {
    private int[] indices;
    private String[] formattedAnswers;

    public PrintAnswerResult(int[] indices, String[] formattedAnswers) {
        this.indices = indices;
        this.formattedAnswers = formattedAnswers;
    }

    public int[] getIndices() {
        return indices;
    }

    public String[] getFormattedAnswers() {
        return formattedAnswers;
    }
}
