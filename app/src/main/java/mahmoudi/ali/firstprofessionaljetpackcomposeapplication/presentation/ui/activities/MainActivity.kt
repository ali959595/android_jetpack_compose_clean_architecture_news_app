package mahmoudi.ali.firstprofessionaljetpackcomposeapplication.presentation.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.domain.model.Article
import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.presentation.ui.components.ArticleDetails
import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.presentation.ui.components.TabsScreen
import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.presentation.ui.theme.FirstProfessionalJetpackComposeApplicationTheme
import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.presentation.ui.viewmodel.NewsViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstProfessionalJetpackComposeApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    Greeting("Android")
                    val breakingNewsIsLoading = viewModel.breakingNewsIsLoading.value
                    val savedNewsIsLoading = viewModel.savedNewsIsLoading.value
                    val navController = rememberNavController()
                    NavigationHost(
                        navController = navController,
                        breakingNewsIsLoading = breakingNewsIsLoading,
                        savedNewsIsLoading = savedNewsIsLoading,
                        breakingNewsArticles = viewModel.breakingNews.value,
                        savedNewsArticles = viewModel.savedArticles.value,
                        onSaveArticle = {
                            viewModel.saveArticle(it)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun NavigationHost(
    navController: NavHostController,
    breakingNewsIsLoading: Boolean,
    savedNewsIsLoading: Boolean,
    breakingNewsArticles: List<Article>,
    savedNewsArticles: List<Article>,
    onSaveArticle: (Article) -> Unit
) {

    NavHost(navController = navController, startDestination = "home") {

        composable("home") {
            TabsScreen(
                navController = navController,
                breakingNewsIsLoading = breakingNewsIsLoading,
                savedNewsIsLoading = savedNewsIsLoading,
                savedNewsArticles = savedNewsArticles,
                breakingNewsArticles = breakingNewsArticles
            )
        }
        composable("article") {
            val article =
                navController.previousBackStackEntry?.savedStateHandle?.get<Article>("article")
            if (article != null) ArticleDetails(article = article, onSaveArticle = {
                onSaveArticle(it)
            })
        }
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FirstProfessionalJetpackComposeApplicationTheme {
        Greeting("Android")
    }
}