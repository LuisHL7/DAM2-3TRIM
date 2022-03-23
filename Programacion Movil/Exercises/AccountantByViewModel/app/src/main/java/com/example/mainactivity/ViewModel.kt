package com.example.mainactivity

import androidx.lifecycle.ViewModel

class ViewModel:  ViewModel() {
    private val model = Model()
    fun stateCount(): Int {

        return model.count
    }

    fun increaseCount(): Int {
        return model.count++
    }
}