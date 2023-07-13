package com.bacon.pexels.presentation.extensions

import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDirections


/**
 * Safely navigate to a destination from the current navigation graph.
 *
 * Safer than usual because there is a check if we are already at the destination.
 *
 * @param actionId an [action][NavDestination.getAction] id or a destination id to navigate to
 *
 * @see [NavDestination.getAction]
 */
fun NavController.navigateSafely(@IdRes actionId: Int) {
    currentDestination?.getAction(actionId)?.let { navigate(actionId) }
}

/**
 * Safely navigate to a destination from the current navigation graph.
 *
 * Safer than usual because there is a check if we are already at the destination.
 *
 * @param directions directions that describe this navigation operation
 *
 * @see [NavDestination.getAction]
 */
fun NavController.navigateSafely(directions: NavDirections) {
    currentDestination?.getAction(directions.actionId)?.let { navigate(directions) }
}

/**
 * Extension for easy override on back pressed
 *
 * @receiver [Fragment]
 *
 * @param onBackPressed custom back pressed implementation
 *
 * @see OnBackPressedCallback
 */
fun Fragment.overrideOnBackPressed(onBackPressed: OnBackPressedCallback.() -> Unit) {
    requireActivity().onBackPressedDispatcher.addCallback(this) {
        onBackPressed()
    }
}