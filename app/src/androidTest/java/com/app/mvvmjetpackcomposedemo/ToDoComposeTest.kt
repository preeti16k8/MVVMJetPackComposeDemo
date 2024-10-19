package com.app.mvvmjetpackcomposedemo

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import com.app.mvvmjetpackcomposedemo.compose.Navigation
import com.app.mvvmjetpackcomposedemo.compose.OnlineDealScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ToDoComposeTest {

    private lateinit var navController:TestNavHostController

    @get:Rule
    val composeTestRule= createComposeRule()

    @Before
    fun setUp() {
        navController = TestNavHostController(ApplicationProvider.getApplicationContext())
    }

    @Test
    fun testForAddTodoClick() {
        composeTestRule.onNodeWithText("Protect yourself and \n" +
                " your family")

        composeTestRule.onNodeWithText("Schedule covid-19, flu and other vaccines")

        composeTestRule.onNodeWithText("Schedule Appointment")

        composeTestRule.onNodeWithText("Online Deals")
        composeTestRule.onNodeWithText("Rewards")
        composeTestRule.onNodeWithText("Transfer Rx")
        composeTestRule.onNodeWithText("Refill by Scan")
        composeTestRule.onNodeWithText("Online Deals").performClick()


    }

}