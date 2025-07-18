package rwu.it.quiz;

// Model class to represent each question, options, correct answer, and image
public class Question {
    String questionText;
    String[] options;
    int correctAnswerIndex;
    int imageResId; // New field: image resource ID (R.drawable.image)

    // Constructor with image
    public Question(String questionText, String[] options, int correctAnswerIndex, int imageResId) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
        this.imageResId = imageResId;
    }
}