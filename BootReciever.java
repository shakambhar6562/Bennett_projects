package com.example.eyes;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i =new Intent(context,Homepage.class);
        context.startService(i);
    }
}
