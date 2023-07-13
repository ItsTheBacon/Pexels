package com.bacon.pexels.presentation.extensions

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment


// region Fragment extensions

/**
 * Fast show [Toast]
 *
 * @receiver [Fragment]
 */
fun Fragment.showToastShort(text: String) {
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}

/**
 * Fast show [Toast]
 *
 * @receiver [Fragment]
 */
fun Fragment.showToastShort(@StringRes textFromRes: Int) {
    Toast.makeText(context, textFromRes, Toast.LENGTH_SHORT).show()
}

/**
 * Fast show [Toast]
 *
 * @receiver [Fragment]
 */
fun Fragment.showToastLong(text: String) {
    Toast.makeText(context, text, Toast.LENGTH_LONG).show()
}

/**
 * Fast show [Toast]
 *
 * @receiver [Fragment]
 */
fun Fragment.showToastLong(@StringRes textFromRes: Int) {
    Toast.makeText(context, textFromRes, Toast.LENGTH_LONG).show()
}

// endregion