package com.example.finalapp.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalapp.model.Compare
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val compare: LiveData<Compare> get() = _compare
    private var _compare = MutableLiveData<Compare>(Compare(""))

    fun compareStrings(text1: String, text2: String){
        val result = text1 == text2
        var next: String = if(result){
            "Los textos ingresados SON IGUALES!"
        } else {
            "Los textos ingresados NO SON IGUALES!"
        }

        updateCompare(next)
    }

    private fun updateCompare(next: String){
        viewModelScope.launch {
            _compare.value = Compare(next)
        }

    }


}


