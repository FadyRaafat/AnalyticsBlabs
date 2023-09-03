package com.blabs.analytics.combined.utils

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import com.blabs.analytics.combined.utils.enums.ApiKeys
import java.io.Serializable

fun Context.getValuesFromMetaData(apiKey: ApiKeys): String? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        packageManager.getApplicationInfo(
            packageName, PackageManager.ApplicationInfoFlags.of(0)
        )
    } else {
        packageManager.getApplicationInfo(
            packageName, PackageManager.GET_META_DATA
        )
    }.metaData?.getString(apiKey.key)?.valueOrNull()
}

fun String.valueOrNull() = this.ifEmpty { null }


operator fun <T : Any> Bundle.set(key: String, value: T?) {
    when (value) {
        is String -> putString(key, value)
        is Int -> putInt(key, value)
        is Boolean -> putBoolean(key, value)
        is Float -> putFloat(key, value)
        is Long -> putLong(key, value)
        is Double -> putDouble(key, value)
        is Parcelable -> putParcelable(key, value)
        is Serializable -> putSerializable(key, value)
        else -> throw UnsupportedOperationException(
            "$key is: ${value?.javaClass}, This data type not yet implemented in: ${this.javaClass}"
        )
    }
}


