package com.jclavijo.picoplaca.notifications

import android.content.Context
import android.util.Log
import androidx.work.*
import com.jclavijo.picoplaca.ui.notification.NotificationWorker
import java.util.concurrent.TimeUnit

class NotificationScheduler(private val context: Context) {

    fun scheduleTestNotification() {
        val request = OneTimeWorkRequestBuilder<NotificationWorker>()
            .setInitialDelay(5, TimeUnit.SECONDS)
            .build()

        WorkManager.getInstance(context).enqueue(request)
        Log.d("NotificationScheduler", "Agendando worker")
    }
}
