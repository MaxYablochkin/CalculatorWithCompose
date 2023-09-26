package com.example.calculatorwithcompose

sealed class Actions {
    object Clear : Actions()
    object Delete : Actions()
    object Calculate : Actions()
    object Fraction : Actions()
    data class Number(val number: Int) : Actions()
    data class Operation(val operation: Operations) : Actions()
}