package com.example.mysupport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.LoginButton);

        btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                // opening a new intent to open settings activity.
                Intent i = new Intent(MainActivity.this, HomeScreen.class);
                startActivity(i);
            }
        });
    }
}