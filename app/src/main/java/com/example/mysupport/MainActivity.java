package com.example.mysupport;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.LoginButton);

        btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                EditText user = (EditText) findViewById(R.id.Username);
                userName = user.getText().toString();
                // opening a new intent to open settings activity.
                Intent i = new Intent(MainActivity.this, HomeScreen.class);
                startActivity(i);
            }
        });

        private void createNotificationChannel(); {
            // Create the NotificationChannel, but only on API 26+ because
            // the NotificationChannel class is new and not in the support library
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CharSequence name = getString(R.string.channel_name);
                String description = getString(R.string.channel_description);
                int importance = NotificationManager.IMPORTANCE_DEFAULT;
                NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
                channel.setDescription(description);
                // Register the channel with the system; you can't change the importance
                // or other notification behaviors after this
                NotificationManager notificationManager = getSystemService(NotificationManager.class);
                notificationManager.createNotificationChannel(channel);
            }
        }

        final Button button = (Button) findViewById(R.id.notify);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                final Timer mytimer = new Timer(true);

                final TimerTask mytask = new TimerTask() {
                    public void run() {
                        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                                .setSmallIcon(R.drawable.notification_icon)
                                .setContentTitle(textTitle)
                                .setContentText(textContent)
                                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                    }
                };

                mytimer.schedule(mytask, 1000L, 3000L);

                final Button button = (Button) findViewById(R.id.send);
                button.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        mytimer.cancel();
                    }
                });

            }
        });
    }
}