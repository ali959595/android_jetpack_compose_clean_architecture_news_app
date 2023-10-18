package mahmoudi.ali.firstprofessionaljetpackcomposeapplication.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.R
import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.domain.model.Article
import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.util.loadPicture

@Composable
fun ArticleDetails(
    article: Article, onSaveArticle: (Article) -> Unit
) {
    val snackbarHostState =
        remember { SnackbarHostState() } // this contains the `SnackbarHostState`
    val coroutineScope = rememberCoroutineScope()

    val defaultImage: Int = R.drawable.default_placeholder_foreground

    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.primary,
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
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
                article.description?.let { it1 ->
                    Text(
                        text = it1,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.W600,
                        color = MaterialTheme.colors.onPrimary
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                article.publishedAt?.let { it1 ->
                    Text(
                        text = "publishedAt: $it1",
                        textAlign = TextAlign.Start,
                        color = MaterialTheme.colors.onPrimary,
                        fontWeight = FontWeight.W400
                    )
                }
            }

            FloatingActionButton(modifier = Modifier
                .align(
                    Alignment.BottomEnd
                )
                .padding(32.dp), onClick = {
                onSaveArticle(article)
                coroutineScope.launch { // using the `coroutineScope` to `launch` showing the snackbar
                    // taking the `snackbarHostState` from the attached `scaffoldState`
                    snackbarHostState.showSnackbar(
                        message = "Item saved successfully",
                        duration = SnackbarDuration.Short
//                        actionLabel = "Do something."
                    )
                }
            }) {
                Icon(Icons.Default.Star, "Save")
            }
            DecoupledSnackbar(
                message = "Item saved successfully",
                snackbarHostState = snackbarHostState
            )
        }

    }
}