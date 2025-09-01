package com.example.playgroundmetro.ui

import com.example.playgroundmetro.AppRepository
import dev.zacsweers.metro.Inject

@Inject
class HomeViewModel(
    private val repository: AppRepository
) {
    fun updateText(newText: String) {
        repository.text = newText
    }
}