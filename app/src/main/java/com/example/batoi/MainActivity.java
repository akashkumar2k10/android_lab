package com.example.batoi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    Button register,login;
    EditText email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth=FirebaseAuth.getInstance();
        register=findViewById(R.id.register);
        email=findViewById(R.id.username);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),name.getText().toString(),Toast.LENGTH_LONG).show();
               // if(name.getText().toString().equals("akash")){
                    Toast.makeText(getApplicationContext(),"You are in",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this,Register.class);
                    startActivity(intent);



            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"login",Toast.LENGTH_LONG).show();
                String e=email.getText().toString().trim();
                String pass=password.getText().toString().trim();
                Intent intent = new Intent(MainActivity.this,Confirm.class);
                intent.putExtra("e",e);
                intent.putExtra("pass",pass);
                startActivity(intent);


            }
        });


    }
}