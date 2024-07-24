package com.example.twitch;

import static android.app.Notification.*;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;


public class two_factor extends AppCompatActivity {
    EditText editText1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_factor);
        editText1 = (EditText) findViewById(R.id.editTextNumberPassword);
        CharSequence name = "MyChannel";
        String description = "MyChannelDescription";
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel channel = new NotificationChannel("default", name, importance);
        channel.setDescription(description);

        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
    }

    public void login(View v) {
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }

    public void next(View v) {
        if (validateFields()) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {

        }

    }
    private boolean validateFields() {
        boolean isValid = true;

        if (editText1.getText().toString().trim().isEmpty()) {
            editText1.setError("Please fill in the required field");
            isValid = false;
        }



        return isValid;
    }
    public void showNotification(View view) {

        Builder builder = new Builder(this, "default")
                .setSmallIcon(R.drawable.error)
                .setContentTitle("Notification message")
                .setContentText("I NEED HELP!");


        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


        notificationManager.notify(0, builder.build());
    }
    public void showNotification1(View view) {

        Builder builder = new Builder(this, "default")
                .setSmallIcon(R.drawable.error)
                .setContentTitle("Code message")
                .setContentText("Your code is 11112");


        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


        notificationManager.notify(0, builder.build());
    }

}
