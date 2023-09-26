package com.example.calculatorwithcompose

data class State(
    val num1: String = "",
    val num2: String = "",
    val operation: Operations? = null
)