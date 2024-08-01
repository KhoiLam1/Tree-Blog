package com.example.tree

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.TreeTheme
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
        Box(){
            Text(text = "This is main screen")
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