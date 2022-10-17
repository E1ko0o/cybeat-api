package com.cybeatapi.utils

const val SEPARATOR = ":"

class Converters {
    fun getIntegersFromString(value: String): List<Int> {
        return value.split(SEPARATOR).map { it.toInt() }.toTypedArray().toList()
    }

    fun getStringFromIntegers(value: List<Int>): String {
        return value.joinToString(SEPARATOR)
    }
}
