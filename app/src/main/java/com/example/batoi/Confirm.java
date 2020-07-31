package com.example.batoi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Confirm extends AppCompatActivity {

    TextView a;
    private FirebaseAuth mAuth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a);
        //user sign
        mAuth=FirebaseAuth.getInstance();
        a=findViewById(R.id.textView2);

        mAuth.signInWithEmailAndPassword(getIntent().getStringExtra("e"),getIntent().getStringExtra("pass")).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser user=mAuth.getCurrentUser();

                    String text=user.getEmail().toString()+"\n"+user.getUid().toString();
                    a.setText(text);


                }
            }
        });


    }

}
