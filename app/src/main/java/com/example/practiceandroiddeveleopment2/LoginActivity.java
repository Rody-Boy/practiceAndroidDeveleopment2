package com.example.practiceandroiddeveleopment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.IllegalFormatCodePointException;

public class LoginActivity extends AppCompatActivity {
    EditText username,password;
    Button btnlogin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=(EditText) findViewById(R.id.username1);
        password=(EditText) findViewById(R.id.password1);
        btnlogin= (Button) findViewById(R.id.btnsignin1);
        DB= new DBHelper(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=username.getText().toString();
                String pass=password.getText().toString();

                if (user.equals("") || pass.equals("")) {
                    Toast.makeText(LoginActivity.this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
                }else {
                    Boolean checkuserpass=DB.chekcusernamepassword(user,pass);
                    if (checkuserpass==true) {
                        Toast.makeText(LoginActivity.this, "Sign in successful", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(LoginActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }
}