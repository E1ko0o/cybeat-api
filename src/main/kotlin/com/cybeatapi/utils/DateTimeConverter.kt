package com.cybeatapi.utils

import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

class DateTimeConverter { // https://www.baeldung.com/java-date-to-localdate-and-localdatetime
    fun convertToLocalDateTime(dateToConvert: Date): LocalDateTime =
        dateToConvert.toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDateTime()

    fun convertToDate(dateToConvert: LocalDateTime): Date =
        Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant())
}