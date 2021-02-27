package com.example.assignment.presentation.components

import androidx.compose.animation.transition
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.WithConstraints
import androidx.compose.ui.platform.AmbientDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.assignment.presentation.components.ShimmerAnimationDefinitions.AnimationState.*

@Composable
fun LoadingJobShimmer (
    imageHeight: Dp,
    padding: Dp = 16.dp
) {
    WithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        val cardWidthPx = with(AmbientDensity.current) { (maxWidth - (padding*2)).toPx() }
        val cardHeightPx = with(AmbientDensity.current) { (imageHeight - padding).toPx() }

        val cardAnimationDefinition = remember{
            ShimmerAnimationDefinitions(
                widthPx = cardWidthPx,
                heightPx = cardHeightPx,
            )
        }

        val cardShimmerTranslateAnim = transition(
            definition = cardAnimationDefinition.shimmerTransitionDefinition,
            initState = START,
            toState = END
        )

        val colors = listOf(
            Color.LightGray.copy(alpha = .9f),
            Color.LightGray.copy(alpha = .3f),
            Color.LightGray.copy(alpha = .9f),
        )
        val xCardShimmer = cardShimmerTranslateAnim[cardAnimationDefinition.xShimmerPropKey]
        val yCardShimmer = cardShimmerTranslateAnim[cardAnimationDefinition.yShimmerPropKey]

        ScrollableColumn {
            repeat(5){
                ShimmerJobCard(
                    colors = colors,
                    xShimmer = xCardShimmer,
                    yShimmer = yCardShimmer,
                    cardHeight = imageHeight,
                    gradientWidth = cardAnimationDefinition.gradientWidth,
                    padding = padding
                )
            }
        }
    }


}