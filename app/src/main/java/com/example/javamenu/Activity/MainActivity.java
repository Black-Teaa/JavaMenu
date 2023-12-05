package com.example.javamenu.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.javamenu.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText loginText, emailText, passwordText;
    private DatabaseReference mDataBase;
    private FirebaseAuth mAuth;
    private String USER_KEY = "User";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        loginText = findViewById(R.id.login_text);
        emailText = findViewById(R.id.email_text);
        passwordText = findViewById(R.id.pass_text);
        mAuth = FirebaseAuth.getInstance();
        mDataBase = FirebaseDatabase.getInstance().getReference(USER_KEY);
    }
    public void onClickReg(View view) {
        String login = loginText.getText().toString().trim();
        String email = emailText.getText().toString().trim();
        String pass = passwordText.getText().toString().trim();

        if (TextUtils.isEmpty(login) || TextUtils.isEmpty(email) || TextUtils.isEmpty(pass)) {
            Toast.makeText(this, "Все поля должны быть заполнены", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    sendEmailVer();
                    Toast.makeText(getApplicationContext(), "Пользователь зарегистрирован", Toast.LENGTH_SHORT).show();
                } else {
                    if (task.getException() != null) {
                        Toast.makeText(getApplicationContext(), "Ошибка: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Пользователь не зарегистрирован", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public void onClickAuth(View view){
        String email = emailText.getText().toString().trim();
        String password = passwordText.getText().toString().trim();

        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        if (user != null && user.isEmailVerified()) {
                            Toast.makeText(getApplicationContext(), "Вы успешно вошли", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, Auth_activity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), "Ваш E-mail не подтвержден", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        if (task.getException() != null) {
                            Toast.makeText(getApplicationContext(), "Ошибка: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Не удалось войти", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "Пожалуйста, введите Email и Пароль", Toast.LENGTH_SHORT).show();
        }
    }

    private void sendEmailVer(){
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Проверьте вашу почту для подтверждения E-mail адреса", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Не удалось отправить сообщение на E-mail", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    public void onClickGoAuth(View view) {
        Intent intent = new Intent(this, Auth_activity.class);
        startActivity(intent);
    }
}