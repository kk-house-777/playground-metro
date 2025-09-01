package com.example.playgroundmetro.ui

import androidx.lifecycle.ViewModel
import com.example.playgroundmetro.AppRepository
import dev.zacsweers.metro.Inject

@Inject
class HomeViewModel(
    private val repository: AppRepository
) : ViewModel() {
    fun updateText(newText: String) {
        repository.text = newText
    }
}