package dev.toke.groovyapp

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import dev.toke.groovyapp.homescreen.HomeScreen
import dev.toke.groovyapp.ui.theme.GroovyAppTheme

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 * Ref: https://developer.android.com/jetpack/compose/testing
 * Cheat Sheet: https://developer.android.com/jetpack/compose/testing-cheatsheet
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class PlaylistFeature {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun displayScreenTitle() {
        composeTestRule.setContent {
            GroovyAppTheme {
                HomeScreen()
            }
        }
        composeTestRule.onNodeWithText("Groovy").assertIsDisplayed()
    }

    @Test
    fun displaysAListOfPlaylists() {
        composeTestRule.onAllNodesWithText("Playlist", substring = true).assertCountEquals(31)
    }
}