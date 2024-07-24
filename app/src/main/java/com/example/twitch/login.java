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

public class login extends AppCompatActivity {

    EditText editText1;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        editText1 = (EditText) findViewById(R.id.username_input);
        editText2 = (EditText) findViewById(R.id.password_input);
        CharSequence name = "MyChannel";
        String description = "MyChannelDescription";
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel channel = new NotificationChannel("default", name, importance);
        channel.setDescription(description);

        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
    }

    public void twoFactor(View v){

        if (validateFields()) {

            Intent intent = new Intent(this, two_factor.class);
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

        if (editText2.getText().toString().trim().isEmpty()) {
            editText2.setError("Please fill in the required field");
            isValid = false;
        }

        return isValid;
    }
    public void showNotification(View view) {

        Builder builder = new Builder(this, "default")
                .setSmallIcon(R.drawable.error)
                .setContentTitle("Error message")
                .setContentText("Something went wrong");


        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


        notificationManager.notify(0, builder.build());
    }

}

