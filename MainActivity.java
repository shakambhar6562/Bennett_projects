package com.example.eyes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    DatabaseReference ref;
    DatabaseReference ref1;
    EditText username;
    EditText password;
    Member m;
    SignUp s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button signup=findViewById(R.id.button);
        final Button signin=findViewById(R.id.login);
        username=findViewById(R.id.username);
        password = findViewById(R.id.password);
        m = new Member();
        s=new SignUp();
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
                ref = FirebaseDatabase.getInstance().getReference().child("Member").child("1");
                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        //for(int i=1;i<=(int)snapshot.getChildrenCount();i++)
                            String pass = snapshot.child("password").getValue().toString();
                            String user = snapshot.child("username").getValue().toString();
                            if ((username.getText().toString().equals(user)) && (password.getText().toString().equals(pass))) {
                                homepage();

                            } else if ((username.getText().toString().equals(user)) && (!password.getText().toString().equals(pass))) {
                                Toast.makeText(MainActivity.this, "Password is not Correct", Toast.LENGTH_LONG).show();
                            }
                        }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                }
        });
    }

    void homepage()
    {

        Intent intents=new Intent(this,Homepage.class);
        startActivity(intents);
    }
    void openNewActivity()
    {
        Intent intents=new Intent(this,SignUp.class);
        startActivity(intents);
    }
}