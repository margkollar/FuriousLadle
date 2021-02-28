package com.example.myapplication.furiousladle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.myapplication.furiousladle.db.UserDatabase;
import com.example.myapplication.furiousladle.db.UserEntity;
import com.example.myapplication.furiousladle.db.UserProfileAsyncTask;
import com.example.myapplication.furiousladle.db.UserProfileCallback;
import com.example.myapplication.furiousladle.recycler.RecyclerActivity;
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
                UserDatabase userDatabase= Room.databaseBuilder(getApplicationContext(),
                        UserDatabase.class,"furious_ladle_db")
                        .build();
                new UserProfileAsyncTask(new UserProfileCallback() {
                    @Override
                    public void onSuccessResult(UserEntity entity) {
                        EditText userNameEdit = findViewById(R.id.username_input);
                        EditText passwdEdit = findViewById(R.id.password_input);
                        String userStr = userNameEdit.getText().toString();
                        String passwdStr = passwdEdit.getText().toString();
                        if(!userStr.equalsIgnoreCase(entity.getUsername()) && !passwdStr.equalsIgnoreCase(entity.getPassword())){
                            Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                        }else {
                            // intent gia na paei sto search page
                            Intent intent = new Intent(LoginActivity.this, Search.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                }, userDatabase).execute();

            }
        });
    }
}