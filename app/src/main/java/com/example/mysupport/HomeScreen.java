package com.example.mysupport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeScreen extends AppCompatActivity {

    // creating a variable for our button.
    private Button settingsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        // initializing our button.
        settingsBtn = findViewById(R.id.BtnSettings);

        // adding on click listener for our button.
        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new intent to open settings activity.
                Intent i = new Intent(HomeScreen.this, SettingsActivity.class);
                startActivity(i);
            }
        });
    }
}
