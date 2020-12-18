package com.example.eyes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {
    static long MAXid=0;
    DatabaseReference ref;
    Member m;
    private Button signup;
    private EditText email;
    private EditText password;
    private EditText confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signup=findViewById(R.id.letsgo);
        email=findViewById(R.id.email);
        password=findViewById(R.id.Password);
        confirm=findViewById(R.id.ConfirmPassword);
        m = new Member();
        ref = FirebaseDatabase.getInstance().getReference().child("Member");
        signup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(isEmailValid()==1 && passvalid()==1 && confirmPassword()==1)
                {
                    String user = email.getText().toString().trim();
                    String pass = password.getText().toString().trim();
                    m.setPassword(pass);
                    m.setUsername(user);
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.exists())
                            {
                                MAXid=snapshot.getChildrenCount();
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    ref.child(String.valueOf(MAXid+1)).setValue(m);
                    Toast.makeText(SignUp.this,"Data inserted",Toast.LENGTH_LONG).show();
                    openNewActivity();
                }
            }
        });
    }
    void openNewActivity()
    {
        Intent intents=new Intent(this,terms_condition.class);
        startActivity(intents);
    }
    int isEmailValid()
    {
        String copy=email.getText().toString();
        for (int i=0;i<copy.length();i++)
        {
            if(copy.charAt(i)=='@')
                return 1;
        }
        return 0;
    }
    int passvalid()
    {
        String copy=password.getText().toString();
        int i;
        int c1=0,c2=0,c3=0,c4=0;
        for(i=0;i<copy.length();i++)
        {
            if(copy.charAt(i)>='1' && copy.charAt(i)<='9')
                c1++;
            else if(copy.charAt(i)>='A' && copy.charAt(i)<='Z')
                c2++;
            else if(copy.charAt(i)>='a' && copy.charAt(i)<='z')
                c3++;
            else if(copy.charAt(i)=='#'|| copy.charAt(i)=='@'|| copy.charAt(i)=='&'|| copy.charAt(i)=='!'|| copy.charAt(i)=='$')
                c4++;
        }
        if(c1>=1 && c2>=1 && c3>=1 && c4>=1 && copy.length()>=8)
            return 1;
        return 0;
    }
    int confirmPassword()
    {
        String c=password.getText().toString();
        String c1=confirm.getText().toString();
        if(c.equals(c1))
            return 1;
        return 0;
    }
    long returner()
    {
        return MAXid;
    }
}