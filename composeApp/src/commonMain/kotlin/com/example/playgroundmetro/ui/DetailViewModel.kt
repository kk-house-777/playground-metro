package com.example.playgroundmetro.ui

import com.example.playgroundmetro.AppRepository
import dev.zacsweers.metro.Inject

@Inject
class DetailViewModel(
    repository: AppRepository
) {
    val text = repository.text
}