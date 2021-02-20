package com.example.myapplication.furiousladle;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;


public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        Button btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText userNameEdit = findViewById(R.id.username_input);
                EditText passwdEdit = findViewById(R.id.password_input);
                String userStr = userNameEdit.getText().toString();
                String passwdStr = passwdEdit.getText().toString();

                if(userStr.matches("") || passwdStr.matches("")){
                    Toast.makeText(LoginActivity.this, "username or password empty", Toast.LENGTH_SHORT).show();
                }else {
                 // TODO: Go to a new activity code
                }
            }
        });
    }
}
