package com.example.calculatorwithcompose.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorwithcompose.ui.theme.CalculatorWithComposeTheme

@Composable
internal fun UpperButton(
    symbol: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Transparent,
    foregroundColor: Color = MaterialTheme.colorScheme.onSecondaryContainer,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(backgroundColor)
            .clip(CircleShape)
            .clickable { onClick() }
            .then(modifier)
    ) {
        Text(
            text = symbol,
            fontSize = 40.sp,
            color = foregroundColor
        )
    }
}


@Composable
internal fun CalculatorRoundButton(
    symbol: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.surfaceVariant,
    foregroundColor: Color = MaterialTheme.colorScheme.onSecondaryContainer,
    size: Dp = 90.dp,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val radius = if (isPressed) 25.dp else size / 2f
    val cornerRadius by animateDpAsState(targetValue = radius, label = "")

    Surface(
        modifier = modifier.clip(RoundedCornerShape(cornerRadius)),
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(backgroundColor)
                .size(size)
                .clip(RoundedCornerShape(cornerRadius))
                .clickable(
                    interactionSource = interactionSource,
                    indication = rememberRipple()
                ) { onClick.invoke() }
                .then(modifier),
        ) {
            Text(
                text = symbol,
                fontSize = 40.sp,
                color = foregroundColor
            )
        }
    }
}

@Preview
@Composable
fun CalculateButtonPreview() {
    CalculatorWithComposeTheme {
        Column {
            CalculatorRoundButton(
                symbol = "1",
                backgroundColor = MaterialTheme.colorScheme.surfaceVariant,
                foregroundColor = MaterialTheme.colorScheme.onSecondaryContainer,
                size = 90.dp,
                onClick = {}
            )
            UpperButton(
                symbol = "sin",
                onClick = {}
            )
        }
    }
}