package com.example.eyes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button signup=findViewById(R.id.button);
        final Button signin=findViewById(R.id.login);
        signup.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view) {
                        openNewActivity();
                    }
                }
        );
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homepage();
            }
        });
    }
    void homepage()
    {
        Intent intents=new Intent(this,Check1.class);
        startActivity(intents);
    }
    void openNewActivity()
    {
        Intent intents=new Intent(this,SignUp.class);
        startActivity(intents);
    }
}