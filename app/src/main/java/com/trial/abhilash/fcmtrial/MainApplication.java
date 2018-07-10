package com.trial.abhilash.fcmtrial;

import android.app.Application;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.iifl.libraries.fcmnotification.interfaces.OnNotificationReceivedListener;

public class MainApplication extends Application implements OnNotificationReceivedListener {
    @Override
    public void notificationReceived(NotificationCompat.Builder mBuilder, int i) {
        Log.i("Main","Notification Recieved");
        Intent intent = new Intent(getApplicationContext(), TripRequest.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent,
                PendingIntent.FLAG_ONE_SHOT);
        mBuilder.setContentIntent(pendingIntent);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mBuilder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));

        NotificationManager  mNotificationManager = (NotificationManager) getSystemService(getApplicationContext().NOTIFICATION_SERVICE);
        mNotificationManager.notify(i, mBuilder.build());

    }
}
