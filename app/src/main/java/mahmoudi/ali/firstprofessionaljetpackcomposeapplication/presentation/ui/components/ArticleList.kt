package mahmoudi.ali.firstprofessionaljetpackcomposeapplication.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.domain.model.Article

@Composable
fun ArticleList(
    isLoading: Boolean,
    articles: List<Article>,
    navController: NavHostController,
    tabIndex: Int
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(articles) { article ->
            ShimmerAnimationBox(
                isLoading = isLoading, contentAfterLoading = {
                    ArticleListItem(
                        navController = navController,
                        article = article,
                        isClickable = tabIndex == 0
                    )
                }
            )
        }
    }
}