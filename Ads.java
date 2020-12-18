package com.example.eyes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Toast;
import android.widget.VideoView;

public class Ads extends AppCompatActivity {
    //VideoView video_View;
    //String url = "http://dev.exiv2.org/attachments/344/MOV_0234.mp4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads);
        //video_View = findViewById(R.id.videoView);
        //Uri u = Uri.parse(url);
        //video_View.setVideoURI(u);
        //video_View.start();
        /*video_View.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                Toast.makeText(Ads.this,"Dismissed",Toast.LENGTH_SHORT).show();
            }
        });*/
    }
}