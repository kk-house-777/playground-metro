package com.example.playgroundmetro.ui

import androidx.lifecycle.ViewModel
import com.example.playgroundmetro.AppRepository
import dev.zacsweers.metro.Inject

@Inject
class DetailViewModel(
    repository: AppRepository
) : ViewModel() {
    val text = repository.text
}