package com.wtf.sootheapp

import AppNavRail
import NavBar
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.wtf.sootheapp.Screens.HomeScreen
import com.wtf.sootheapp.ui.theme.SootheAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val windowSizeClass = calculateWindowSizeClass(this)
            SootheApp(windowSizeClass)
        }
    }
}


    @Composable
    fun SootheAppPortrait() {
        SootheAppTheme {
            Scaffold(
                bottomBar = { NavBar() }
            ) { padding ->
                HomeScreen(Modifier.padding(padding))
            }
        }
    }


    @Composable
    fun SootheAppLandscape(){
        SootheAppTheme {
            Surface(color = MaterialTheme.colorScheme.background) {
                Row {
                    AppNavRail()
                    HomeScreen()
                }
            }
        }

    }



    // Step: MySoothe App
    @Composable
    fun SootheApp(windowSize: WindowSizeClass) {
        when (windowSize.widthSizeClass) {
            WindowWidthSizeClass.Compact -> {
                SootheAppPortrait()
            }
            WindowWidthSizeClass.Expanded -> {
                SootheAppLandscape()
            }
        }
    }

    val alignYourBodyData = listOf(
        R.drawable.ab1_inversions to R.string.ab1_inversions,
        R.drawable.ab2_quick_yoga to R.string.ab2_quick_yoga,
        R.drawable.ab3_stretching to R.string.ab3_stretching,
        R.drawable.ab4_tabata to R.string.ab4_tabata,
        R.drawable.ab5_hiit to R.string.ab5_hiit,
        R.drawable.ab6_pre_natal_yoga to R.string.ab6_pre_natal_yoga
    ).map { DrawableStringPair(it.first, it.second) }

    val favoriteCollectionsData = listOf(
        R.drawable.fc1_short_mantras to R.string.fc1_short_mantras,
        R.drawable.fc2_nature_meditations to R.string.fc2_nature_meditations,
        R.drawable.fc3_stress_and_anxiety to R.string.fc3_stress_and_anxiety,
        R.drawable.fc4_self_massage to R.string.fc4_self_massage,
        R.drawable.fc5_overwhelmed to R.string.fc5_overwhelmed,
        R.drawable.fc6_nightly_wind_down to R.string.fc6_nightly_wind_down
    ).map { DrawableStringPair(it.first, it.second) }


//    data class DrawableStringPair(
//        @DrawableRes val drawable: Int,
//        @StringRes val text: Int
//    )

    @Preview(showBackground = true,  backgroundColor = 0xFFF5F0EE, heightDp = 180)
    @Composable
    fun HomeScreenPreview() {
        SootheAppTheme { SootheAppPortrait() }
    }
