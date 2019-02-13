package com.radioactive.prosperous.shuta;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class broadcastRecever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent != null) {
            String action = intent.getAction();
            if(action != null) {
                if(action.equals("android.intent.action.BOOT_COMPLETED")) {
                    // DO YOUR STUFF
                    Toast.makeText(context,"Boot completed",Toast.LENGTH_LONG).show();

                } else if (action.equals("ANOTHER ACTION")) {
                    // DO ANOTHER STUFF
                }
            }
        }
    }
}
