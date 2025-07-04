package Task_8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnlineQuizApp {

    // Question class to hold question data
    static class Question {
        String questionText;
        List<String> options;
        int correctAnswerIndex;

        public Question(String questionText, List<String> options, int correctAnswerIndex) {
            this.questionText = questionText;
            this.options = options;
            this.correctAnswerIndex = correctAnswerIndex;
        }
    }

    public static void main(String[] args) {
        // Initialize quiz questions
        List<Question> questions = initializeQuestions();

        // Welcome message
        System.out.println("Welcome to the Online Quiz App!");
        System.out.println("You will be presented with " + questions.size() + " questions.");
        System.out.println("For each question, enter the number of your answer (1-4).\n");

        // Start quiz
        int score = 0;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.size(); i++) {
            Question currentQuestion = questions.get(i);

            // Display question
            System.out.println("Question " + (i + 1) + ": " + currentQuestion.questionText);
            for (int j = 0; j < currentQuestion.options.size(); j++) {
                System.out.println((j + 1) + ". " + currentQuestion.options.get(j));
            }

            // Get user input with validation
            int userAnswer = 0;
            while (userAnswer < 1 || userAnswer > 4) {
                System.out.print("Your answer (1-4): ");
                try {
                    userAnswer = Integer.parseInt(scanner.nextLine());
                    if (userAnswer < 1 || userAnswer > 4) {
                        System.out.println("Please enter a number between 1 and 4.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                }
            }

            // Check answer
            if (userAnswer - 1 == currentQuestion.correctAnswerIndex) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect! The correct answer was: " +
                        (currentQuestion.correctAnswerIndex + 1) + "\n");
            }
        }

        // Display results
        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + " out of " + questions.size());
        double percentage = (double) score / questions.size() * 100;
        System.out.printf("Percentage: %.1f%%\n", percentage);

        // Close scanner
        scanner.close();
    }

    // Method to initialize quiz questions
    private static List<Question> initializeQuestions() {
        List<Question> questions = new ArrayList<>();

        // Question 1
        List<String> options1 = new ArrayList<>();
        options1.add("Hyper Text Markup Language");
        options1.add("Hyperlinks and Text Markup Language");
        options1.add("Home Tool Markup Language");
        options1.add("Hyper Transfer Markup Language");
        questions.add(new Question("What does HTML stand for?", options1, 0));

        // Question 2
        List<String> options2 = new ArrayList<>();
        options2.add("Static");
        options2.add("Dynamic");
        options2.add("Strong");
        options2.add("Interpreted");
        questions.add(new Question("Java is a _____ typed language.", options2, 2));

        // Question 3
        List<String> options3 = new ArrayList<>();
        options3.add("1991");
        options3.add("1995");
        options3.add("2000");
        options3.add("1989");
        questions.add(new Question("In which year was Java first released?", options3, 1));

        // Question 4
        List<String> options4 = new ArrayList<>();
        options4.add("JVM");
        options4.add("JRE");
        options4.add("JDK");
        options4.add("JAR");
        questions.add(new Question("Which component is responsible for running Java bytecode?", options4, 0));

        // Question 5
        List<String> options5 = new ArrayList<>();
        options5.add("ArrayList");
        options5.add("HashMap");
        options5.add("HashSet");
        options5.add("LinkedList");
        questions.add(new Question("Which collection class allows you to associate keys with values?", options5, 1));

        return questions;
    }
}
