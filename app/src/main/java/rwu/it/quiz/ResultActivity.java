package rwu.it.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    TextView resultText;      // TextView to show score
    Button restartBtn;        // Button to restart quiz
    Button exitBtn;           // Button to exit the app

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result); // Set layout file

        // Link views to layout elements
        resultText = findViewById(R.id.resultText);
        restartBtn = findViewById(R.id.restartBtn);
        exitBtn = findViewById(R.id.exitBtn); // Exit button from XML

        // Receive score from QuizActivity via Intent
        int score = getIntent().getIntExtra("score", 0);
        resultText.setText("You scored " + score + " out of 5");

        // Restart button logic
        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open QuizActivity again
                Intent intent = new Intent(ResultActivity.this, QuizActivity.class);
                startActivity(intent);
                finish(); // Close ResultActivity
            }
        });

        // Exit button logic
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity(); // Exit the app and close all activities
            }
        });
    }
}