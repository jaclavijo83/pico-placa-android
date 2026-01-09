package com.jclavijo.picoplaca.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.jclavijo.picoplaca.notifications.NotificationScheduler

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val scheduler = NotificationScheduler(application)

    fun scheduleNotification() {
        scheduler.scheduleTestNotification()
    }
}
