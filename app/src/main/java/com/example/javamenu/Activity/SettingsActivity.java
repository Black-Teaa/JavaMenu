 package com.example.javamenu.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.javamenu.Activity.Auth_activity;
import com.example.javamenu.R;

 public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        TextView welcomeMessage = findViewById(R.id.welcome_message);
        String username = getUsername();
        welcomeMessage.setText("Вы вошли как " + username);
    }
     private String getUsername() {
         SharedPreferences preferences = getSharedPreferences("UserData", MODE_PRIVATE);
         return preferences.getString("email", "");
     }

    public void onLogoutClick(View view) {
        clearUserData();
        Intent intent = new Intent(this, Auth_activity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    private void clearUserData() {
        SharedPreferences preferences = getSharedPreferences("UserData", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
    }
}