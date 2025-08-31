package com.example.playgroundmetro

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform