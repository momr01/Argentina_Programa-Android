package com.example.finalapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.finalapp.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setUp(){
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_CheckInitialValue() = runTest {
        val value = viewModel.compare.value?.result
        assertEquals("", value)
    }

    @Test
    fun mainViewModel_TestEqualText() = runTest {
        launch {
            viewModel.compareStrings("texto1", "texto1")
        }

        advanceUntilIdle()

        val value = viewModel.compare.value?.result
        assertEquals("Los textos ingresados SON IGUALES!", value)
    }

    @Test
    fun mainViewModel_TestDifferentText() = runTest {
        launch {
            viewModel.compareStrings("texto1", "texto2")
        }

        advanceUntilIdle()

        val value = viewModel.compare.value?.result
        assertEquals("Los textos ingresados NO SON IGUALES!", value)
    }

}