package mahmoudi.ali.firstprofessionaljetpackcomposeapplication.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.model.Article

@Composable
fun TabScreen(
    navController: NavHostController,
    breakingNewsIsLoading: Boolean,
    breakingNewsArticles: List<Article>,
    savedNewsIsLoading: Boolean,
    savedNewsArticles: List<Article>
) {
    var tabIndex by remember { mutableStateOf(0) }

    val tabs = listOf("Home", "Saved")

    Scaffold(bottomBar = {
        BottomAppBar(
            modifier = Modifier.fillMaxWidth(),
            backgroundColor = MaterialTheme.colors.secondary,
            content = {
                TabRow(
                    modifier = Modifier.fillMaxWidth(),
                    backgroundColor = MaterialTheme.colors.secondary,
                    contentColor = Color.White,
                    selectedTabIndex = tabIndex
                ) {

                    tabs.forEachIndexed { index, title ->
                        val tabWidthFraction =
                            if (index == 0) (1.0F / tabs.size) else if (index == tabs.size - 1) 1.0F else (1.0F / (tabs.size - 1))
                        Tab(
                            modifier = Modifier.fillMaxWidth(tabWidthFraction),
                            text = { Text(title) },
                            selected = tabIndex == index,
                            onClick = { tabIndex = index },
                            icon = {
                                Icon(
                                    if (index == 0) Icons.Default.Home else Icons.Default.Star,
                                    "Home"
                                )
                            }
                        )
                    }
                }
            }
        )
    }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            when (tabIndex) {
                0 -> ArticleList(
                    navController = navController,
                    isLoading = breakingNewsIsLoading,
                    articles = breakingNewsArticles,
                    tabIndex = 0
                )
                1 -> ArticleList(
                    navController = navController,
                    isLoading = savedNewsIsLoading,
                    articles = savedNewsArticles,
                    tabIndex = 1
                )
                //2 -> SettingsScreen()
            }
        }
    }

}

