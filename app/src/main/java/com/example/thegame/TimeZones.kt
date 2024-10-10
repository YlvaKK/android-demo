package com.example.thegame

import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.util.TimeZone

class TimeZones {

    fun updateTimeZone(timeZone: TimeZone): TimeZone {
        val localDateTime = LocalDateTime.now()
        val currentTimeZoneOffset = secondsToHours(timeZone.toZoneId().rules.getOffset(localDateTime).totalSeconds)
        return TimeZone.getTimeZone(ZoneId.ofOffset("GMT", ZoneOffset.ofHours(getNormalizedOffset(currentTimeZoneOffset + -1))))
    }

    private fun getNormalizedOffset(offset: Int): Int {
        if (offset > 12)
            return offset - 25
        if (offset < -12)
            return offset + 25
        return offset
    }

    private fun secondsToHours(offsetSeconds: Int): Int {
        return offsetSeconds / (60 * 60)
    }
}