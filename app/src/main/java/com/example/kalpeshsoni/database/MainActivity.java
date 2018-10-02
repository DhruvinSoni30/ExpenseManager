package com.example.kalpeshsoni.database;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText Email,Password,Confirm_Password,Username;
    Button Register;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.Password);
        Confirm_Password = findViewById(R.id.Cpassword);
        Register = findViewById(R.id.Register);
        t1 = findViewById(R.id.loinHere);
        Username = findViewById(R.id.Uname);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(i);
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Email_ID = Email.getText().toString();
                String Pwd = Password.getText().toString();
                String cPwd = Confirm_Password.getText().toString();
                String Uname = Username.getText().toString();

                if(Username.equals("") || Email_ID.equals("") || Pwd.equals("") || cPwd.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Please enter blank details",Toast.LENGTH_SHORT).show();
                }
                else
                {
                     if(Pwd.equals(cPwd))
                    {
                        Boolean chkemail = db.chkemail(Email_ID);
                        if(chkemail == true)
                        {
                            Boolean insert = db.insert(Uname,Email_ID,Pwd);
                            if(insert == true)
                            {
                                Toast.makeText(getApplicationContext(),"Registeration Successfull",Toast.LENGTH_SHORT).show();
                                Intent i2 = new Intent(getApplicationContext(),Main2Activity.class);
                                startActivity(i2);
                            }
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Email Already exixts",Toast.LENGTH_SHORT).show();
                        }
                    }

                }

            }
        });
    }
}
