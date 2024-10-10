package com.example.thegame

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TimeZonesTest {
    val timeZones: TimeZones = TimeZones()

    @Test
    fun name() {
        TODO("Not yet implemented")
    }

    @Test
    fun test() {
        val hour = timeZones.secondsToHours(3600)

        assertEquals(1, hour)
    }
}
