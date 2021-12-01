package uz.azizbekxurramov.lesson_42_notification

import android.app.*
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.graphics.drawable.IconCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//
    }

    fun simple(view: View) {

        /**Channnel ID bu misol uchun telefonimizg aturli xil joylardan notificationlar kelsa ularni bir
         * biridan farqlash uchun ishlatiladi bittasi telegrmdan yana bitasi sms dan kelgan noticationlar
         *   lo' ushalarni bir biridan farqlash uchuin ishlatiladi*/

        val channelId = "1"
        val channeName = "1"
       val notificationId = 1

        val notificationManagerCompat = NotificationManagerCompat.from(this)
        val builder = NotificationCompat.Builder(this, channelId)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            builder.setSmallIcon(IconCompat.createWithResource(this, R.drawable.ic_launcher_foreground))
        }

        builder.setContentTitle("Simple notification")
        builder.setContentText("Hello Devlopper, this my first notification")
        builder.setAutoCancel(false)

        val  intent = intent

        val stacBuilder = TaskStackBuilder.create(applicationContext)
        stacBuilder.addNextIntent(intent)

        val pendingIntent = stacBuilder.getPendingIntent(2,PendingIntent.FLAG_CANCEL_CURRENT)
        builder.setContentIntent(pendingIntent)




           if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
               val channel = NotificationChannel(channelId, channeName, NotificationManager.IMPORTANCE_HIGH)
               channel.enableVibration(true)
               channel.setShowBadge(true)
               builder.setChannelId(channelId)

               notificationManagerCompat.createNotificationChannel(channel)
            }


        val notification =builder.build()
        notificationManagerCompat.notify(notificationId, notification)
    }
}