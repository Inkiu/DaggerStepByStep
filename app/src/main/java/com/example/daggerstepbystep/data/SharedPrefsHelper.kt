package com.example.daggerstepbystep.data

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

const val PREF_KEY_ACCESS_TOKEN = "access-token"

@Singleton
class SharedPrefsHelper @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {

    fun put(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun put(key: String, value: Int) {
        sharedPreferences.edit().putInt(key, value).apply()
    }

    fun put(key: String, value: Float) {
        sharedPreferences.edit().putFloat(key, value).apply()
    }

    fun put(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    fun get(key: String, defaultValue: String): String {
        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }

    fun get(key: String, defaultValue: Int): Int {
        return sharedPreferences.getInt(key, defaultValue)
    }

    fun get(key: String, defaultValue: Float): Float {
        return sharedPreferences.getFloat(key, defaultValue)
    }

    fun get(key: String, defaultValue: Boolean): Boolean {
        return sharedPreferences.getBoolean(key, defaultValue)
    }

    fun deleteSavedData(key: String) {
        sharedPreferences.edit().remove(key).apply()
    }
}