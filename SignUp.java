package com.example.eyes;

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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {
    private SqlHandler db;
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
        db = new SqlHandler(getApplicationContext());
        final String em=email.getText().toString();
        final String pw=password.getText().toString();
        signup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                if(isEmailValid()==1 && passvalid()==1 && confirmPassword()==1)
                {
                    registerUser(em,pw);
                    openNewActivity();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),
                            "Please enter you details",Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
    }
    private void registerUser(final String email, final String password) {
        RequestQueue req = Volley.newRequestQueue(SignUp.this);
        StringRequest request = new StringRequest(Request.Method.POST, "http://localhost:8080/phpmyadmin/tbl_sql.php?db=android_api&table=products", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject job = new JSONObject((response));
                    boolean error = job.getBoolean(("Error print"));
                    if (!error) {
                        JSONObject user = job.getJSONObject("user");
                        String email = user.getString("email");
                        String pass = user.getString("createdat");
                        db.addUser(email, pass);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(),"ERROR", Toast.LENGTH_LONG).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG)
                        .show();
            }
        })
        {


            protected Map<String, String> getparams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("tag", "register");

                params.put("email", email);
                params.put("password", password);

                return params;
            }
        };
        Volley.newRequestQueue(getApplicationContext());
    }


    void openNewActivity()
    {

        Intent intents=new Intent(this,Homepage.class);
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
}