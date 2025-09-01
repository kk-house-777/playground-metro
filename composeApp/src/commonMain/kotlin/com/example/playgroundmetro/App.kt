package com.example.playgroundmetro

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.playgroundmetro.data.sampleItems
import com.example.playgroundmetro.ui.DetailScreen
import com.example.playgroundmetro.ui.HomeScreen
import dev.zacsweers.metro.DependencyGraph
import kotlinx.serialization.Serializable
import org.jetbrains.compose.ui.tooling.preview.Preview
import dev.zacsweers.metro.Provides
import dev.zacsweers.metro.createGraph

@Serializable
object Home

@Serializable
data class Detail(val itemId: Int)

@DependencyGraph
interface AppGraph {
    val message: String

    @Provides
    fun provideMessage(): String = "This is DI String with Metro"
}

@Composable
@Preview
fun App() {
    val appGraph = remember { createGraph<AppGraph>() }
    MaterialTheme {
        val navController = rememberNavController()
        
        NavHost(
            navController = navController,
            startDestination = Home
        ) {
            composable<Home> {
                HomeScreen(
                    title = appGraph.message,
                    onItemClick = { item ->
                        navController.navigate(Detail(item.id))
                    }
                )
            }
            
            composable<Detail> { backStackEntry ->
                val detail = backStackEntry.toRoute<Detail>()
                val item = sampleItems.find { it.id == detail.itemId }
                
                item?.let {
                    DetailScreen(
                        item = it,
                        onBackClick = {
                            navController.popBackStack()
                        }
                    )
                }
            }
        }
    }
}