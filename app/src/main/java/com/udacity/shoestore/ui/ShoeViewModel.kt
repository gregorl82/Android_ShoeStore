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
        Timber.i("ShoeViewModel created")
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("ShoeViewModel destroyed")
    }

    fun addShoe(shoe: Shoe) {
        _shoeList.value = _shoeList.value?.plus(shoe)
    }
}