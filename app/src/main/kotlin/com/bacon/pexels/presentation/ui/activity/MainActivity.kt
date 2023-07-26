package com.bacon.pexels.presentation.ui.activity

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bacon.pexels.R
import com.bacon.pexels.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var navController: NavController
    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setupNavigation()
        updateUIComponents()
    }

    private fun setupNavigation() = with(binding) {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navController = navHostFragment.navController
        toolbarMainActivity.setupWithNavController(
            navController, AppBarConfiguration.Builder(
                R.id.galleryFragment,
                R.id.videosFragment,
            ).build()
        )
        bottomNavigation.setupWithNavController(navController)
    }

    private fun updateUIComponents() = with(binding) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.photoViewingFragment -> {
                    toolbarMainActivity.isVisible = false
                    bottomNavigation.isVisible = false
                    setValueOfFlagNoLimits(true)
                }

                R.id.galleryFragment -> {
                    setValueOfFlagNoLimits(false)
                    toolbarMainActivity.isVisible = true
                    bottomNavigation.isVisible = true
                }

                R.id.videoDetailFragment -> {
                    toolbarMainActivity.isVisible = false
                    bottomNavigation.isVisible = false
                    setValueOfFlagNoLimits(true)
                }

                R.id.videosFragment -> {
                    setValueOfFlagNoLimits(false)
                    toolbarMainActivity.isVisible = true
                    bottomNavigation.isVisible = true
                }
            }
        }
    }

    private fun setValueOfFlagNoLimits(isFullScreen: Boolean) {
        if (isFullScreen) {
            window?.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        } else {
            window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }
}