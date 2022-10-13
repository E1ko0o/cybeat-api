package com.cybeatapi.utils

const val SEPARATOR = ":"

class IdsUtil {
    fun getIdsFromString(value: String): List<Int> {
        return value.split(SEPARATOR).map { it.toInt() }.toTypedArray().toList()
    }

    fun getStringFromIds(value: List<Int>): String {
        return value.joinToString(SEPARATOR)
    }
}
