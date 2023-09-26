package com.example.calculatorwithcompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    var state: State by mutableStateOf(State())

    fun onAction(action: Actions) {
        when (action) {
            is Actions.Number -> enterNumber(action.number)
            is Actions.Delete -> delete()
            is Actions.Clear -> state = State()
            is Actions.Operation -> enterOperation(action.operation)
            is Actions.Fraction -> enterFraction()
            is Actions.Calculate -> calculate()
        }
    }

    private fun enterOperation(operation: Operations) {
        if (state.num1.isNotBlank()) {
            state = state.copy(operation = operation)
        }
    }

    private fun calculate() {
        val num1 = state.num1.toDoubleOrNull()
        val num2 = state.num2.toDoubleOrNull()
        if (num1 != null && num2 != null) {
            val result = when (state.operation) {
                is Operations.Add -> num1 + num2
                is Operations.Subtract -> num1 - num2
                is Operations.Multiply -> num1 * num2
                is Operations.Divide -> num1 / num2
                is Operations.Percent -> (num1 / 100) * num2
                is Operations.Pow -> Math.pow(num1, num2)
                null -> return
            }
            state = state.copy(
                num1 = result.toString().take(10),
                num2 = "",
                operation = null
            )
        }
    }

    private fun delete() {
        when {
            state.num2.isNotBlank() -> state = state.copy(num2 = state.num2.dropLast(1))
            state.operation != null -> state = state.copy(operation = null)
            state.num1.isNotBlank() -> state = state.copy(num1 = state.num1.dropLast(1))
        }
    }

    private fun enterFraction() {
        if (state.operation == null && !state.num1.contains(".") && state.num1.isNotBlank()) {
            state = state.copy(num1 = state.num1 + ".")
            return
        } else if (!state.num2.contains(".") && state.num2.isNotBlank()) {
            state = state.copy(num2 = state.num2 + ".")
        }
    }

    private fun enterNumber(number: Int) {
        if (state.operation == null) {
            if (state.num1.length >= MAX_NUM_LENGTH) {
                return
            }
            state = state.copy(num1 = state.num1 + number)
            return
        }
        if (state.num2.length >= MAX_NUM_LENGTH) {
            return
        }
        state = state.copy(num2 = state.num2 + number)
    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }
}