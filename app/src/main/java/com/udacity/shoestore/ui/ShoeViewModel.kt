package com.udacity.shoestore.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<List<Shoe>>(mutableListOf())
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList


    init {
        _shoeList.value = mutableListOf(
            Shoe(
                name = "Air Max",
                company = "Nike",
                size = 9.5,
                description = "Latest stylish sneakers"
            ),
            Shoe(
                name = "Adrenaline 21 GTS",
                company = "Brooks",
                size = 11.0,
                description = "Running shoes"
            )
        )

        Timber.i("ShoeViewModel created")
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("ShoeViewModel destroyed")
    }
}