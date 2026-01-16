package com.jclavijo.picoplaca.notifications

import android.content.Context
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import java.time.Duration
import java.time.LocalDateTime
import java.util.concurrent.TimeUnit

object NotificationScheduler {

    fun schedule(
        context: Context,
        notifyAt: LocalDateTime
    ) {
        val delay = Duration.between(LocalDateTime.now(), notifyAt)

        if (delay.isNegative || delay.isZero) return

        val request = OneTimeWorkRequestBuilder<NotificationWorker>()
            .setInitialDelay(delay.toMillis(), TimeUnit.MILLISECONDS)
            .build()

        WorkManager.getInstance(context).enqueue(request)
    }
}
