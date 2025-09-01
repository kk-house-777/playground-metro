package com.example.playgroundmetro

import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesTo
import dev.zacsweers.metro.Provides
import dev.zacsweers.metro.SingleIn

interface AppRepository {
    var text: String
}
class AppRepositoryImpl : AppRepository {
    override var text: String = "Initial Text"
}

@ContributesTo(AppScope::class)
interface AppRepositoryModule {
    @Provides
    @SingleIn(AppScope::class)
    fun provideAppRepository(): AppRepository = AppRepositoryImpl()
}