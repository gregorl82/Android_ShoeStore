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
                name = "Crossfit",
                company = "Nike",
                size = 7.5,
                description = "Wear these to look good at the gym"
            ),
            Shoe(
                name = "Stan Smith",
                company = "Adidas",
                size = 8.0,
                description = "Inspired by a tennis legend"
            ),
            Shoe(
                name = "Classic",
                company = "Reebok",
                size = 10.0,
                description = "As the name suggests, classic!"
            ),
            Shoe(
                name = "Adrenaline 21 GTS",
                company = "Brooks",
                size = 11.0,
                description = "Running shoes for the serious athlete"
            )
        )

        Timber.i("ShoeViewModel created")
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("ShoeViewModel destroyed")
    }
}