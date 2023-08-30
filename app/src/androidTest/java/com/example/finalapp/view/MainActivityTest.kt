package com.example.finalapp.view

import android.widget.Toast
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import com.example.finalapp.R

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get: Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun mainActivity_compareEqualsButton(){
        Espresso.onView(
            ViewMatchers.withId(R.id.first_text)
        ).perform(
            ViewActions.typeText("texto1")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.second_text)
        ).perform(
            ViewActions.typeText("texto1")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.compare_button)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.result_compare)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Los textos ingresados SON IGUALES!")
            )
        )
    }


    @Test
    fun mainActivity_compareDifferentButton(){
        Espresso.onView(
            ViewMatchers.withId(R.id.first_text)
        ).perform(
            ViewActions.typeText("texto1")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.second_text)
        ).perform(
            ViewActions.typeText("texto2")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.compare_button)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.result_compare)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Los textos ingresados NO SON IGUALES!")
            )
        )
    }

    @Test
    fun mainActivity_compareEmptyButton(){
        Espresso.onView(
            ViewMatchers.withId(R.id.first_text)
        ).perform(
            ViewActions.typeText("")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.second_text)
        ).perform(
            ViewActions.typeText("")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.compare_button)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.result_compare)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("")
            )
        )
    }
}