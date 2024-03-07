package org.example;

import models.Questions;

import java.sql.SQLException;
import java.util.*;

public class Playroom  {




    public static void main(String name) throws SQLException {
        Scanner scanner=new Scanner(System.in);
        Questions q1 = new Questions();
        List<String[]> quizQuestions = q1.getQuizQuestions();
        List<String> answers = new ArrayList<>();

        int questionCount = 0;
        Collections.shuffle(quizQuestions);
        quizQuestions = quizQuestions.subList(0, 10);
        for (String[] question : quizQuestions) {
            System.out.println(question[0]);
            for (int i = 1; i <= 4; i++) {
                System.out.println(question[i]);
            }
            System.out.println("Your answer ----->");
            String userAnswer = scanner.nextLine();
            answers.add(userAnswer);

            questionCount++;

            if (questionCount == 10) {
                break;
            }
        }
        q1.checker(quizQuestions,answers,name);

    }

}