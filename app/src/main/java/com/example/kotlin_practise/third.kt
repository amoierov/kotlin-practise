package com.example.kotlin_practise


fun removeElement(numbers: IntArray, number: Int): IntArray {
    return numbers.filter { it != number }.toIntArray()
}

fun main() {
    val numbers = intArrayOf(1, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10)
    println(removeElement(numbers, 3).contentToString())
    println(removeElement(numbers, 9).contentToString())
    println(removeElement(numbers, 10).contentToString())
}