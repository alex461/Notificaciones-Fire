package com.example.alex.notification_fire;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FbMessagingService extends FirebaseMessagingService {


    private static final String TAG ="AlexMessaging" ;
    private static final String KEY_DESCOUNT ="key_descount";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.w(TAG,"From: "+remoteMessage.getFrom());
        Model1 notiAlex = new Model1();
        notiAlex.setId(remoteMessage.getFrom());
        notiAlex.setTittle(remoteMessage.getNotification().getTitle());
        notiAlex.setDescription(remoteMessage.getNotification().getBody());
        notiAlex.setDescount(remoteMessage.getData().get(KEY_DESCOUNT));

        showNotification(notiAlex);
    }




    private void showNotification(Model1 notiAlex){
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra(KEY_DESCOUNT,notiAlex.getDescount());


        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
        Uri defaultSounUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(notiAlex.getTittle())
                .setContentText(notiAlex.getDescription())
                .setAutoCancel(true)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setSound(defaultSounUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager
                = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


        notificationManager.notify(0,notificationBuilder.build());

    }

}
