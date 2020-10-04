package com.example.eyes;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class Check1 extends AppCompatActivity{
    private Button signup;
    private EditText email;
    private EditText lastname;
    private EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check1);
        signup = findViewById(R.id.button3);
        email = findViewById(R.id.EmailAddress);
        name = findViewById(R.id.name);
        lastname = findViewById(R.id.lastname);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urllink="http://localhost/Chiranjibdocs/insert2.php?email="+email.getText().toString()
                        +"&name="+name.getText().toString();
                try {

                    URL newlink=new URL(urllink);
                    HttpURLConnection conn=(HttpURLConnection) newlink.openConnection();
                    conn.setRequestMethod("GET");
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuffer sb = new StringBuffer();
                    String line;
                    while ((line=in.readLine())!=null){
                        sb.append(line);
                    }
                    in.close();

                }catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
}
