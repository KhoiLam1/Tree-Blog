package com.example.tree

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.TreeTheme
import com.example.tree.tips.TipMainScreenContainer
import com.example.tree.ui.BottomNavigationBar
import com.example.tree.ui.Screen
import com.example.tree.users.activities.UserProfileScreenContainer
import com.example.tree.utils.AuthHandler
import com.example.tree.utils.PermissionManager
import com.google.accompanist.insets.ProvideWindowInsets

class MainActivity : ComponentActivity() {

    private lateinit var permissionManager: PermissionManager

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Check user authentication
        checkUserAuthentication()

        // Check permissions
        setupPermissions()

        setContent {
            TreeTheme {
                ProvideWindowInsets {
                    MainScreen()
                }
            }
        }
    }

    private fun checkUserAuthentication() {
        if (!AuthHandler.isUserAuthenticated) {
            AuthHandler.redirectToSignIn(this)
            finish()
        } else {
            AuthHandler.storeUserIdInSharedPreferences(this)
        }
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun setupPermissions() {
        permissionManager = PermissionManager(this)
        permissionManager.checkPermissions()
    }

    @Composable
    fun MainScreen() {
        val navController = rememberNavController()
        Scaffold(
            bottomBar = {
                BottomNavigationBar(navController)
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = Screen.MainTip.route,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(Screen.MainTip.route) { TipMainScreenContainer() }
                composable(Screen.Profile.route) { UserProfileScreenContainer() }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun MainScreenPreview() {
        TreeTheme {
            MainScreen()
        }
    }
}