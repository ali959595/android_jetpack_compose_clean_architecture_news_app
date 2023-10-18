package mahmoudi.ali.firstprofessionaljetpackcomposeapplication.presentation.ui.components

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

@Composable
fun ShimmerAnimationBox(
    isLoading: Boolean,
    contentAfterLoading: @Composable () -> Unit
) {
    if (isLoading) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .border(
                    width = 4.dp,
                    color = MaterialTheme.colors.primary,
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(4.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(225.dp)
                    .shimmerEffect(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Loading...",
                    modifier = Modifier
                        .wrapContentHeight()
                        .align(Alignment.Center),
                    textAlign = TextAlign.Center,
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.8F)
                    .height(32.dp)
                    .shimmerEffect()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
                    .shimmerEffect()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.4F)
                    .height(20.dp)
                    .shimmerEffect()
            )
        }
    } else {
        contentAfterLoading()
    }


}

fun Modifier.shimmerEffect(): Modifier = composed {
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }

    val transition = rememberInfiniteTransition()

    val colors = listOf(
        Color.LightGray.copy(alpha = 0.9F),
        Color.LightGray.copy(alpha = 0.2F),
        Color.LightGray.copy(alpha = 0.9F)
    )


    val startOffsetX by transition.animateFloat(
        initialValue = -2 * size.width.toFloat(),
        targetValue = 2 * size.width.toFloat(),
        animationSpec = infiniteRepeatable(animation = tween(durationMillis = 1000))
    )

    val brush = Brush.linearGradient(
        colors = colors,
        start = Offset(startOffsetX, 0F),
        end = Offset(startOffsetX + size.width.toFloat(), size.height.toFloat())
    )

    background(brush = brush)
        .onGloballyPositioned {
            size = it.size
        }
}