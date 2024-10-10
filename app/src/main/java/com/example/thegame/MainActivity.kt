package com.example.thegame

import android.os.Bundle
import android.widget.Button
import android.widget.TextClock
import android.widget.TextView
import androidx.activity.ComponentActivity
import java.util.TimeZone
import java.util.TimeZone.LONG

class MainActivity : ComponentActivity() {
    private val timeZones = TimeZones()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textField: TextView = findViewById(R.id.textView)
        val button = findViewById<Button>(R.id.button)
        val textClock = findViewById<TextClock>(R.id.textClock)

        var currentTimeZone = TimeZone.getDefault()

        textField.text = updateTextField(currentTimeZone)

        button.setOnClickListener {
            currentTimeZone = updateTimeZone(currentTimeZone)
            textField.text = updateTextField(currentTimeZone)
            textClock.timeZone = currentTimeZone.getDisplayName(true, LONG)
        }
    }

    private fun updateTextField(timeZone: TimeZone): String {
        return getString(R.string.time_zone).format(timeZone.displayName)
    }

    private fun updateTimeZone(timeZone: TimeZone): TimeZone {
       return  timeZones.updateTimeZone(timeZone)
    }
}