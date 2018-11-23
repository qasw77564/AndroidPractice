package com.example.user.androidfcmdemo.Service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.example.user.androidfcmdemo.MainActivity;
import com.example.user.androidfcmdemo.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessaging extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        showNotification(remoteMessage.getNotification());




    }

    private void showNotification(RemoteMessage.Notification notification) {
        Intent intent=new Intent(this, MainActivity.class);/*把這個class的值丟給Mainactivity class,這樣就是!*背景執行*!*/
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);/*Message顯示在最上面*/
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
        /*↑Pending(左邊)  取用這個class,Code碼,從左邊顯示*/
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher).setContentTitle(notification.getTitle())
                .setContentText(notification.getBody())
                .setAutoCancel(true).setContentIntent(pendingIntent);
        NotificationManager notificationManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0,builder.build());/*從0開始做建立*/
    }
}
