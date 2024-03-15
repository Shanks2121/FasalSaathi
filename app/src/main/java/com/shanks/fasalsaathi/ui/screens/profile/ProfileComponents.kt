package com.shanks.fasalsaathi.ui.screens.profile
import android.content.Context
import android.net.Uri

fun getVideoUri(context: Context): Uri {
    val packageName = context.packageName
    val resources = context.resources
    val rawId = resources.getIdentifier("village4", "raw", packageName)
    return Uri.parse("android.resource://$packageName/$rawId")
}
