package com.example.allaboutviews.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.allaboutviews.MainActivity
import com.example.allaboutviews.R

private const val NOTIFICATION_ID = 1
private const val REQUEST_CODE = 0
private const val FLAGS = PendingIntent.FLAG_UPDATE_CURRENT
private const val CHANNEL_ID = "fun-stuff"
private const val CHANNEL_NAME = "Fun notifications"
private const val CHANNEL_DESCRIPTION = "These are pikachu notifications"

fun NotificationManager.showNotification(
    context: Context,
    intent: Intent?,
    messageTitle: String,
    messageBody: String,
) {
    // Create content intent for the notification which launches this activity

    // create intent
    val contentIntent = Intent(context, MainActivity::class.java)

    // create pending intent
    val contentPendingIntent = PendingIntent.getActivity(
        context,
        NOTIFICATION_ID,
        contentIntent,
        PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
    )

    // add style
    val pikachuImage = BitmapFactory.decodeResource(
        context.resources,
        R.drawable.pikachu
    )
    val bigPictureStyle = NotificationCompat.BigPictureStyle()
        .bigPicture(pikachuImage)

    // snooze action
//    val snoozeIntent = Intent(context, MySnoozeReceiver::class.java)
//    val snoozePendingIntent = PendingIntent.getBroadcast(
//        context,
//        REQUEST_CODE,
//        snoozeIntent,
//        FLAGS or PendingIntent.FLAG_IMMUTABLE,
//    )

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channel = NotificationChannel(
            CHANNEL_ID,
            CHANNEL_NAME,
            NotificationManager.IMPORTANCE_HIGH
        )
        channel.setShowBadge(false)
        channel.enableLights(true)
        channel.lightColor = Color.RED
        channel.enableVibration(true)
        channel.description = CHANNEL_DESCRIPTION
        this.createNotificationChannel(channel)
    }

    val message = NotificationCompat.Builder(context, CHANNEL_ID)
        .setSmallIcon(R.mipmap.ic_launcher_round)
        .setContentTitle(messageTitle)
        .setContentText(messageBody)
        .setContentIntent(contentPendingIntent)
        .setAutoCancel(true)
        .setStyle(bigPictureStyle)
        .setLargeIcon(pikachuImage)
//        .addAction(
//            R.drawable.baseline_snooze_24,
//            "Snooze",
//            snoozePendingIntent
//        )
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .build()

    this.notify(NOTIFICATION_ID, message)
}
