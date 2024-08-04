package com.example.tree.admin.activities

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.TreeTheme
import com.example.tree.admin.screens.TipListScreen

class AdminMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TreeTheme {
                AdminMainScreen(this)
            }
        }
    }
}

@Composable
fun AdminMainScreen(context: Context) {
    val navController = rememberNavController()
    NavHost(navController, "admin_tip_list"){
        composable("admin_tip_list"){
            Log.d("AdminMainActivity", "Navigating Admin Tip List")
            TipListScreen(navController, context)
        }
    }
}
//@PreviewParameter(getContextForLanguage())
//@Composable
//fun PreviewMyApp(context: Context) {
//    AdminMainScreen(this)
//}
