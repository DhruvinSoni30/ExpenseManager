package com.example.kalpeshsoni.database;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    EditText Email,Password;
    Button Login;
    DatabaseHelper db;
    TextView newUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        db = new DatabaseHelper(this);
        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.Password);
        Login = findViewById(R.id.Login);
        newUser = findViewById(R.id.registerHere);


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = Email.getText().toString();
                String pwd = Password.getText().toString();
                Boolean Chkemailpwd = db.emailPwd(email,pwd);
                if(Chkemailpwd == true)
                {
                    Toast.makeText(getApplicationContext(),"Login Sucessfull",Toast.LENGTH_SHORT).show();
                    Intent i2 = new Intent(getApplicationContext(),Main5Activity.class);

                    startActivity(i2);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Invalid Email or Password", Toast.LENGTH_SHORT).show();
                }

            }
        });

        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}
