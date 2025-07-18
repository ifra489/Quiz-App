package rwu.it.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    Button startQuizBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        startQuizBtn = findViewById(R.id.startQuizBtn);

        // Replaced anonymous class with lambda
        startQuizBtn.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, QuizActivity.class);
            startActivity(intent);
        });
    }
}