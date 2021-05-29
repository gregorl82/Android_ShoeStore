package com.udacity.shoestore.ui

import androidx.lifecycle.ViewModel
import timber.log.Timber

class ShoeViewModel: ViewModel() {

    init {
        Timber.i("ShoeViewModel created")
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("ShoeViewModel destroyed")
    }
}