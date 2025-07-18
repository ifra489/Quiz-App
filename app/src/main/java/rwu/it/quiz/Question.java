package rwu.it.quiz;

// Model class to represent each question, options, correct answer, and image
public class Question {
    String questionText;
    String[] options;
    int correctAnswerIndex;


    // Constructor with image
    public Question(String questionText, String[] options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;

    }
}