package rwu.it.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import rwu.it.quiz.HomeActivity;
import rwu.it.quiz.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Load and apply animation to logo
        ImageView logo = findViewById(R.id.logo);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.splash_logo_anim);
        logo.startAnimation(anim);

        // Move to HomeActivity after 2.5 seconds
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
            startActivity(intent);
            finish(); // don't return to splash
        }, 2500);
    }
}