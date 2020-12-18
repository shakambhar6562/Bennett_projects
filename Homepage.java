package com.example.eyes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.channels.Channel;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;


import static com.example.eyes.NotificationActivity.Channel_1_ID;

public class Homepage extends AppCompatActivity {
    Timer timer;
    Dialog dialog;
    EditText custom;
    public static final int PRIMARY_FOREGROUND_NOTIF_SERVICE_ID = 1001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        SeekBar simpleSeekBar=(SeekBar)findViewById(R.id.seekBar3);
        int seekBarValue= simpleSeekBar.getProgress();
        simpleSeekBar.setMax(60);
        simpleSeekBar.setProgress(20);
        final ProgressBar p1 = findViewById(R.id.progressBar);
        final TextView text = findViewById(R.id.textView4);
        final Button start = findViewById(R.id.button2);
        simpleSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int z=i%10;
                if(i>=0 && i<=10) {
                    p1.setProgress(10);
                    text.setText(""+"10 sec");
                }
                else if(i>10 && i<=20) {
                    p1.setProgress(20);
                    text.setText("" + "20 sec");
                }
                else if(i>20 && i<=30) {
                    p1.setProgress(30);
                    text.setText("" +"30 sec");
                }
                else if(i>30 && i<=40) {
                    p1.setProgress(40);
                    text.setText("" +"40 sec");
                }
                else if(i>40 && i<=50) {
                    p1.setProgress(50);
                    text.setText("" + "50 sec");
                }
                else if(i>50 && i<=60) {
                    p1.setProgress(60);
                    text.setText("" + "60 sec");
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        final Switch not = findViewById(R.id.switch1);
        final Switch pop = findViewById(R.id.switch2);
        custom = findViewById(R.id.editTextTextMultiLine);
        final Button sett = findViewById(R.id.settings);
        final Button screen = findViewById(R.id.screen);
        final Button ads = findViewById(R.id.Ads);

        sett.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent1();

            }
        });
        screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent2();
            }
        });
        ads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent3();
            }
        });
        custom.setEnabled(false);
        not.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    pop.setEnabled(false);
                    custom.setEnabled(true);
                }
                else {
                    pop.setEnabled(true);
                    custom.setEnabled(false);
                }
            }
        });
        dialog = new Dialog(Homepage.this);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations=R.style.animation;
        Button button = dialog.findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Homepage.this,"PopUP",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(not.isChecked())
                {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            paster();
                        }
                    },p1.getProgress()*1000);
                }
                else if(pop.isChecked())
                {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            //dialog.show();
                            Intent intent = new Intent(Homepage.this,Check1.class);
                            startActivity(intent);
                            finish();
                        }
                    },p1.getProgress()*1000);
                }
            }
        });
    }
    void intent1()
    {
        Intent intents=new Intent(this,Homepage.class);
        startActivity(intents);
    }
    void intent2()
    {
        Intent intents=new Intent(this,Screen.class);
        startActivity(intents);
    }
    void intent3()
    {
        Intent intents=new Intent(this,Ads.class);
        startActivity(intents);
    }
    void paster()
    {
        String c = custom.getText().toString();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            String id = "_channel_01";
            int importance = NotificationManager.IMPORTANCE_LOW;
            NotificationChannel mChannel = new NotificationChannel(id, "notification", importance);
            mChannel.enableLights(true);

            Notification notification = new NotificationCompat.Builder(this, id)
                    .setSmallIcon(R.drawable.ic_baseline)
                    .setContentTitle("Eyes")
                    .setContentText(c)
                    .build();

            NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            if (mNotificationManager != null) {
                mNotificationManager.createNotificationChannel(mChannel);
                mNotificationManager.notify(PRIMARY_FOREGROUND_NOTIF_SERVICE_ID, notification);
            }
            startForegroundService(getIntent());
        }
    }
}
