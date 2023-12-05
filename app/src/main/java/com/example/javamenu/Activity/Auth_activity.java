package com.example.javamenu.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.javamenu.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Auth_activity extends AppCompatActivity {
    private EditText authEmail, authPass;
    private CheckBox rememberMeCheckBox;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        init();
        loadSavedPreferences();

    }

    protected void onStart() {
        super.onStart();
        FirebaseUser cUser = mAuth.getCurrentUser();
        if(cUser != null)
        {
            Toast.makeText(this, "Вы успешно вошли!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Выполните авторизацию", Toast.LENGTH_SHORT).show();
        }
    }

    private void init() {
        authEmail = findViewById(R.id.email_text);
        authPass = findViewById(R.id.pass_text);
        rememberMeCheckBox = findViewById(R.id.remember_me_checkbox);
        mAuth = FirebaseAuth.getInstance();
    }


    public void onClickAuth(View view) {
        if(!TextUtils.isEmpty(authEmail.getText().toString()) && !TextUtils.isEmpty(authPass.getText().toString())) {
            mAuth.signInWithEmailAndPassword(authEmail.getText().toString(), authPass.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful()){
                        Toast.makeText(getApplicationContext(), "Пользователь успешно вошел", Toast.LENGTH_SHORT).show();
                        if (rememberMeCheckBox.isChecked()) {
                            saveUserData(authEmail.getText().toString(), authPass.getText().toString());
                        }
                        Intent intent = new Intent(getApplicationContext(), MenuListActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Ошибка входа", Toast.LENGTH_SHORT).show();
                        Log.e("Auth_activity", "Ошибка входа", task.getException());
                    }
                }
            });
        }
    }
    private void saveUserData(String email, String password) {
        SharedPreferences preferences = getSharedPreferences("UserData", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("email", email);
        editor.putString("password", password);
        editor.apply();
    }

    private void loadSavedPreferences() {
        SharedPreferences preferences = getSharedPreferences("UserData", MODE_PRIVATE);
        String savedEmail = preferences.getString("email", "");
        String savedPassword = preferences.getString("password", "");

        authEmail.setText(savedEmail);
        authPass.setText(savedPassword);
        rememberMeCheckBox.setChecked(!TextUtils.isEmpty(savedEmail) && !TextUtils.isEmpty(savedPassword));
    }

    public void onClickGoReg(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}