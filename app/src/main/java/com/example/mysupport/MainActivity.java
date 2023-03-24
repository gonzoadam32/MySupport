package com.example.mysupport;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationChannelCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    String userName;
    private final String CHANNEL_ID = "123456";

    ArrayList<String> notifMsg;

    Timer mytimer = new Timer(true);
    TimerTask mytask;
    final Handler handler = new Handler();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notifMsg = new ArrayList<>();
        notifMsg.add("You are doing amazing, I know you can keep going!");
        notifMsg.add("Don't stop now, you will soon reach your goal.");
        notifMsg.add("Once you pass this obstacle it will get easier.");
        notifMsg.add("You look down on yourself, you shouldn't,there is no reason to.");
        notifMsg.add("I believe in you, me sitting on the other side of the screen typing this out, I  know you can do it.");

        let randomValue = notifMsg[Math.floor(Math.random() * notifMsg.5)];


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


        // setup the notification channel, etc
        setupNotification();

        // setup the onClick for the button
        //
        // eventually I thikn this needs to be on its own screen after they user logs in
        //  so that screen comes up and in the onCreate for that activity you run this code...
        //
        // but for now launching with a button to test is fine...
        final Button button = (Button) findViewById(R.id.notify);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Handler handler = new Handler();
                if(mytask == null)
                    initializeTimerTask();
                mytimer.schedule(mytask, 1000L, 5000L);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void setupNotification() {
        NotificationChannel newChannel = new NotificationChannel(CHANNEL_ID, "View Encouragement Notifications", NotificationManager.IMPORTANCE_HIGH);
        newChannel.setLightColor(Color.BLUE);

        // get the notification system manager
        NotificationManager mgr =  (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        // add our notification
        mgr.createNotificationChannel(newChannel);
    }

    public void initializeTimerTask () {
        mytask = new TimerTask() {
            public void run () {
                handler .post( new Runnable() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    public void run () {
                        Notification.Builder builder = new Notification.Builder(MainActivity.this)
                                .setSmallIcon(R.drawable.ic_action_name)
                                .setContentTitle("title")
                                .setContentText("body")
                                .setChannelId(CHANNEL_ID)
                                .setPriority(Notification.PRIORITY_DEFAULT);

                        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(MainActivity.this);
                        notificationManager.notify("tag",( int ) System. currentTimeMillis (), builder.build());
                    }
                }) ;
            }
        } ;
    }
}