package com.example.kotlin_practise.models

data class Trainee (val name: String, val age: Int, val currentStage: Int, val codeReviewScores: List<Int>)

private fun calculateAverage(numbers: List<Int>): Double {
    if (numbers.isEmpty()) {
        return 0.0
    }

    val sum = numbers.sum()
    return sum.toDouble() / numbers.size
}
fun remoteTrainees(trainee: MutableList<Trainee>): MutableList<Trainee> = trainee.filter { calculateAverage(it.codeReviewScores) >= 3.5 }.toMutableList()

/**
 * Promote trainees
 * Функция it.copy создает копию объекта Trainee, но с обновленным значением currentStage
 * @param trainees
 */
fun promoteTrainees(trainees: MutableList<Trainee>): MutableList<Trainee> = trainees.filter { calculateAverage(it.codeReviewScores) >= 3.5 }.map { it.copy(currentStage = (it.currentStage + 1 )) }.toMutableList()

fun printTrainees(trainees: MutableList<Trainee>, stage: Int): MutableList<Trainee> {
    val filteredTrainees = trainees.filter { it.currentStage <= stage }.toMutableList()

    println("Trainees at stage $stage:")
    for (trainee in filteredTrainees) {
        println("${trainee.name} - Average Score: ${calculateAverage(trainee.codeReviewScores)}")
    }
    return filteredTrainees
}

val trainee1 = Trainee("Alice", 23, 1, listOf(1, 1, 2))
val trainee2 = Trainee("Bob", 25, 2, listOf(2, 1, 0))
val trainee3 = Trainee("Charlie", 22, 1, listOf(0, 0, 1))
val trainee4 = Trainee("David", 24, 3, listOf(1, 1, 1))
val trainee5 = Trainee("Emma", 22, 2, listOf(5, 5, 4))
val trainee6 = Trainee("Frank", 26, 1, listOf(3, 3, 4))
val trainee7 = Trainee("Grace", 23, 2, listOf(4, 5, 5))
val trainee8 = Trainee("Henry", 25, 3, listOf(5, 4, 3))

val traineesList = mutableListOf(trainee1, trainee2, trainee3, trainee4, trainee5, trainee6, trainee7, trainee8)