package edu.neu.hm3.alarm_reminder_with_voice_command.Database;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import edu.neu.hm3.alarm_reminder_with_voice_command.MainActivity;

public class Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intent1 = new Intent(context, MainActivity.class);
        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent1);
    }
}
