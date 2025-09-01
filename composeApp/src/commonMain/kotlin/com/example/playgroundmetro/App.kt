package com.example.playgroundmetro

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.playgroundmetro.data.sampleItems
import com.example.playgroundmetro.ui.DetailScreen
import com.example.playgroundmetro.ui.DetailViewModel
import com.example.playgroundmetro.ui.HomeScreen
import com.example.playgroundmetro.ui.HomeViewModel
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.DependencyGraph
import kotlinx.serialization.Serializable
import org.jetbrains.compose.ui.tooling.preview.Preview
import dev.zacsweers.metro.Provides
import dev.zacsweers.metro.createGraph

@Serializable
object Home

@Serializable
data class Detail(val itemId: Int)

@DependencyGraph(AppScope::class)
interface AppGraph {
    val homeViewModel: HomeViewModel
    val detailViewModel: DetailViewModel
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
                    viewModel = appGraph.homeViewModel,
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
                        viewModel = appGraph.detailViewModel,
                        onBackClick = {
                            navController.popBackStack()
                        }
                    )
                }
            }
        }
    }
}