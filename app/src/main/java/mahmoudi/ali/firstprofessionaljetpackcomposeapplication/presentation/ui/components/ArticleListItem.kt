package mahmoudi.ali.firstprofessionaljetpackcomposeapplication.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.R
import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.domain.model.Article
import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.util.loadPicture

@Composable
fun ArticleListItem(
    navController: NavHostController,
    article: Article,
    isClickable: Boolean
) {
    val defaultImage: Int = R.drawable.default_placeholder_foreground

    Card(
        modifier = Modifier.clickable {
            if (isClickable) {
                navController.currentBackStackEntry?.savedStateHandle?.set("article", article)
                navController.navigate("article")
            }
        },
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.secondary
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(4.dp)
        ) {
            article.urlToImage?.let { imageUrl
                ->
                val image =
                    loadPicture(
                        url = imageUrl,
                        defaultImage = defaultImage
                    ).value
                image?.let { img ->
                    Image(
                        bitmap = img.asImageBitmap(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .requiredHeight(225.dp),
                        contentScale = ContentScale.Crop,
                        contentDescription = article.url
                    )
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
            article.title?.let { it1 ->
                Text(
                    text = it1, textAlign = TextAlign.Start, fontWeight = FontWeight.W800,
                    color = MaterialTheme.colors.onPrimary,
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}