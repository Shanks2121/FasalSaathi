package com.shanks.fasalsaathi.utils

import android.content.Context
import com.shanks.fasalsaathi.utils.Constants.TOKEN_KEY
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class TokenManager @Inject constructor(@ApplicationContext context : Context) {

    private val sharedPref = context.getSharedPreferences(TOKEN_KEY, Context.MODE_PRIVATE)

    fun clearData() {
        sharedPref.edit()
            .clear()
            .apply()
    }
}
