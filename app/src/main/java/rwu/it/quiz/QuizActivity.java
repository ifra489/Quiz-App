package rwu.it.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    TextView questionTitle, timerText,questionText; // Displays question and timer
    Button[] optionButtons = new Button[4]; // Array to hold 4 option buttons
    List<Question> questionList = new ArrayList<>(); // List of questions
    int currentQuestionIndex = 0; // Tracks current question number
    int score = 0; // Stores user's score
    CountDownTimer timer; // Countdown timer for each question

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Link UI elements with IDs
        questionTitle = findViewById(R.id.questionTitle);
        questionText = findViewById(R.id.questionText);
        timerText = findViewById(R.id.timerText);

        optionButtons[0] = findViewById(R.id.option1);
        optionButtons[1] = findViewById(R.id.option2);
        optionButtons[2] = findViewById(R.id.option3);
        optionButtons[3] = findViewById(R.id.option4);

        // Load questions into the list
        loadQuestions();

        // Display the first question
        showNextQuestion();
    }

    // Add questions to the question list
    private void loadQuestions() {
        questionList.add(new Question("Which device is used to measure earthquakes?",
                new String[]{"Barometer", "Seismograph", "Accelerometer", "Voltmeter"},
                1)); // Correct answer index is 1

        questionList.add(new Question("How many neurons are in the human brain (approx.)?",
                new String[]{"1 billion", "100 billion", "10 million", "500 million"},
                1)); // Correct answer index is 1

        questionList.add(new Question("Which was the first country to land on the moon?",
                new String[]{"Russia", "USA", "China", "Japan"},
                1)); // Correct answer index

        questionList.add(new Question("Which of these animals can sleep while standing up?",
                new String[]{"Cow", "Dog", "Snake", "Kangaroo"},
                0)); // Correct answer index is 0

        questionList.add(new Question("Which planet is known as the “Morning Star”?",
                new String[]{"Mars", "Saturn", "Venus", "Jupiter"},
                2)); // Correct answer index is 2

        // Shuffle questions for randomness
        Collections.shuffle(questionList);
    }

    // Show the next question on the screen
    private void showNextQuestion() {
        String questionNumText=getString(R.string.question_number,currentQuestionIndex +1);
        questionTitle.setText(questionNumText);
        // If all questions are answered, go to ResultActivity
        if (currentQuestionIndex >= questionList.size()) {
            Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
            intent.putExtra("score", score); // Pass score to ResultActivity
            startActivity(intent);
            finish();
            return;
        }
        
        // Get current question
        Question currentQuestion = questionList.get(currentQuestionIndex);

        questionText.setText(currentQuestion.questionText);

        // Set text for option buttons and add click listeners
        for (int i = 0; i < 4; i++) {
            optionButtons[i].setText(currentQuestion.options[i]);

            int finalI = i;
            optionButtons[i].setOnClickListener(v -> {
                // Cancel timer when an option is clicked
                timer.cancel();

                // Check if selected option is correct
                if (finalI == currentQuestion.correctAnswerIndex) {
                    score++; // Increase score for correct answer
                }

                // Move to next question
                currentQuestionIndex++;
                showNextQuestion();
            });
        }

        // Start the countdown timer for this question
        startTimer();
    }

    // Start countdown timer (10 seconds per question)
    private void startTimer() {
        timer = new CountDownTimer(10000, 1000) { // 10 seconds, 1-second interval
            public void onTick(long millisUntilFinished) {
                // Update timer text every second
                timerText.setText(getString(R.string.time_label, millisUntilFinished / 1000));
            }

            public void onFinish() {
                // If time is up, move to next question
                currentQuestionIndex++;
                showNextQuestion();
            }
        }.start();
    }
}
