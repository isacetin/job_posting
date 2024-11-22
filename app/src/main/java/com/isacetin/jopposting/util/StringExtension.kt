package com.isacetin.jopposting.util

import android.text.TextUtils
import android.util.Patterns
import java.util.Locale

fun String.isValidEmail() = !TextUtils.isEmpty(this) && Patterns.EMAIL_ADDRESS.matcher(this).matches()

fun String.capitalizeWords(): String =
    split(" ").joinToString(" ") { it ->
        it.replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(Locale.forLanguageTag("tr-TR")) else it.toString()
        }
    }
