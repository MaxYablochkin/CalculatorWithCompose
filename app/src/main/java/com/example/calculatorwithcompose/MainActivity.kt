package com.example.calculatorwithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculatorwithcompose.components.CalculatorRoundButton
import com.example.calculatorwithcompose.components.UpperButton
import com.example.calculatorwithcompose.ui.theme.CalculatorWithComposeTheme

@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorWithComposeTheme {
                val viewModel = viewModel<CalculatorViewModel>()
                val state = viewModel.state
                val buttonSpacing = 10.dp

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter),
                        verticalArrangement = Arrangement.spacedBy(buttonSpacing),
                    ) {
                        Surface(
                            color = MaterialTheme.colorScheme.secondaryContainer,
                            shape = RoundedCornerShape(30.dp)
                        ) {
                            Text(
                                text = state.num1 + (state.operation?.symbol ?: "") + state.num2,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 15.dp),
                                fontSize = 80.sp,
                                color = MaterialTheme.colorScheme.onBackground,
                                maxLines = 1,
                                textAlign = TextAlign.End,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp),
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
                        ) {
                            UpperButton(
                                modifier = Modifier
                                    .aspectRatio(2f)
                                    .weight(3f),
                                symbol = "√",
                                backgroundColor = Color.Transparent,
                                foregroundColor = MaterialTheme.colorScheme.onSecondaryContainer,
                                onClick = { }
                            )
                            UpperButton(
                                modifier = Modifier
                                    .aspectRatio(2f)
                                    .weight(3f),
                                symbol = "π",
                                backgroundColor = Color.Transparent,
                                foregroundColor = MaterialTheme.colorScheme.onSecondaryContainer,
                                onClick = { }
                            )
                            UpperButton(
                                modifier = Modifier
                                    .aspectRatio(2f)
                                    .weight(3f),
                                symbol = "sin",
                                backgroundColor = Color.Transparent,
                                foregroundColor = MaterialTheme.colorScheme.onSecondaryContainer,
                                onClick = { }
                            )
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(15.dp),
                            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                            ) {
                                CalculatorRoundButton(
                                    symbol = "AC",
                                    backgroundColor = MaterialTheme.colorScheme.tertiaryContainer,
                                    foregroundColor = MaterialTheme.colorScheme.onTertiaryContainer,
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f),
                                    onClick = { viewModel.onAction(Actions.Clear) }
                                )
                                CalculatorRoundButton(
                                    symbol = "^",
                                    backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
                                    foregroundColor = MaterialTheme.colorScheme.onSecondaryContainer,
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f),
                                    onClick = { viewModel.onAction(Actions.Operation(Operations.Pow)) }
                                )
                                CalculatorRoundButton(
                                    symbol = "%",
                                    backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
                                    foregroundColor = MaterialTheme.colorScheme.onSecondaryContainer,
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f),

                                    onClick = { viewModel.onAction(Actions.Operation(Operations.Percent)) }
                                )
                                CalculatorRoundButton(
                                    symbol = "÷",
                                    backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
                                    foregroundColor = MaterialTheme.colorScheme.onSecondaryContainer,
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f),
                                    onClick = { viewModel.onAction(Actions.Operation(Operations.Divide)) }
                                )
                            }
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                            ) {
                                CalculatorRoundButton(
                                    symbol = "7",
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f),
                                    onClick = { viewModel.onAction(Actions.Number(7)) }
                                )
                                CalculatorRoundButton(
                                    symbol = "8",
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f),
                                    onClick = { viewModel.onAction(Actions.Number(8)) }
                                )
                                CalculatorRoundButton(
                                    symbol = "9",
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f),
                                    onClick = { viewModel.onAction(Actions.Number(9)) }
                                )
                                CalculatorRoundButton(
                                    symbol = "×",
                                    backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
                                    foregroundColor = MaterialTheme.colorScheme.onSecondaryContainer,
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f),
                                    onClick = { viewModel.onAction(Actions.Operation(Operations.Multiply)) }
                                )
                            }
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                            ) {
                                CalculatorRoundButton(
                                    symbol = "4",
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f),
                                    onClick = { viewModel.onAction(Actions.Number(4)) }
                                )
                                CalculatorRoundButton(
                                    symbol = "5",
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f),
                                    onClick = { viewModel.onAction(Actions.Number(5)) }
                                )
                                CalculatorRoundButton(
                                    symbol = "6",
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f),
                                    onClick = { viewModel.onAction(Actions.Number(6)) }
                                )
                                CalculatorRoundButton(
                                    symbol = "-",
                                    backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
                                    foregroundColor = MaterialTheme.colorScheme.onSecondaryContainer,
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f),
                                    onClick = { viewModel.onAction(Actions.Operation(Operations.Subtract)) }
                                )
                            }
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                            ) {
                                CalculatorRoundButton(
                                    symbol = "1",
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f),
                                    onClick = { viewModel.onAction(Actions.Number(1)) }
                                )
                                CalculatorRoundButton(
                                    symbol = "2",
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f),
                                    onClick = { viewModel.onAction(Actions.Number(2)) }
                                )
                                CalculatorRoundButton(
                                    symbol = "3",
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f),
                                    onClick = { viewModel.onAction(Actions.Number(3)) }
                                )
                                CalculatorRoundButton(
                                    symbol = "+",
                                    backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
                                    foregroundColor = MaterialTheme.colorScheme.onSecondaryContainer,
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f),
                                    onClick = { viewModel.onAction(Actions.Operation(Operations.Add)) }
                                )
                            }
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                            ) {
                                CalculatorRoundButton(
                                    symbol = "0",
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f),
                                    onClick = { viewModel.onAction(Actions.Number(0)) }
                                )
                                CalculatorRoundButton(
                                    symbol = ".",
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f),
                                    onClick = { viewModel.onAction(Actions.Fraction) }
                                )
                                CalculatorRoundButton(
                                    symbol = "⌦",
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f),
                                    onClick = { viewModel.onAction(Actions.Delete) }
                                )
                                CalculatorRoundButton(
                                    symbol = "=",
                                    backgroundColor = MaterialTheme.colorScheme.primaryContainer,
                                    foregroundColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f),
                                    onClick = { viewModel.onAction(Actions.Calculate) }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
