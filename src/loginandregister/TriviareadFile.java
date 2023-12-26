/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginandregister;

import java.util.ArrayList;
import java.io.*;

public class TriviareadFile {
    private String filePath;
    private ArrayList<String> arrayQuestions;
    private ArrayList<String> arrayAnswers;
    
    //Default constructor
    public TriviareadFile(){
        arrayQuestions = new ArrayList<>();
        arrayAnswers = new ArrayList<>();
    }
    
      public void readFile(String filePath, ArrayList<String> questions, ArrayList<String> answers) {
        this.filePath = filePath;
        this.arrayQuestions = questions;
        this.arrayAnswers = answers;
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Check if the line contains a question (ends with ?)
                if (line.matches(".*[?]")) {
                    // Add the question to the list
                    arrayQuestions.add(line.trim());
                } else {
                    // Split the line by comma into answers and add them to the list
                    String[] answerArray = line.split(",");
                    for (String answer : answerArray) {
                        arrayAnswers.add(answer.trim());
                        answers.removeIf(String::isBlank);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}

