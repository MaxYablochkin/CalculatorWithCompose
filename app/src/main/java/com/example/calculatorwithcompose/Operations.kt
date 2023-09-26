package com.example.calculatorwithcompose

sealed class Operations(val symbol: String) {
    object Add : Operations(symbol = "+")
    object Subtract : Operations(symbol = "-")
    object Multiply : Operations(symbol = "*")
    object Divide : Operations(symbol = "÷")
    object Percent : Operations(symbol = "%")
    object Pow : Operations(symbol = "^")
}