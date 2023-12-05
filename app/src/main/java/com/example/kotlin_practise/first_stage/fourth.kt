package com.example.kotlin_practise.first_stage

fun List<Int>.decorateEvenElements(): List<Int> {
    return mapIndexed { index, value -> if (index % 2 != 0) value * 2 else value }
}

interface ListDecorator {
    fun decorate(list: List<Int>): List<Int>
}

class EvenElementDoublingDecorator : ListDecorator {
    override fun decorate(list: List<Int>): List<Int> {
        return list.mapIndexed { index, value ->
            if (index % 2 != 0) value * 2 else value }
    }
}

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(numbers.decorateEvenElements().toString())
    val numbersDoubling = listOf(1, 2, 3, 4, 5, 6, 18, 2931, 2931, 2931, 2931, 2931, 2931)
    val decorator = EvenElementDoublingDecorator()
    println(decorator.decorate(numbersDoubling).toString())
}