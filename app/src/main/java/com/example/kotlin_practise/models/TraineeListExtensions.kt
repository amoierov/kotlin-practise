package com.example.kotlin_practise.models

fun List<Int>.calculateAverage(): Double {
    if (this.isEmpty()) {
        return 0.0
    }

    val sum = this.sum()
    return sum.toDouble() / this.size
}
fun MutableList<Trainee>.remoteTrainees(): MutableList<Trainee>
= this.filter { it.codeReviewScores.calculateAverage() >= 3.5 }.toMutableList()

fun MutableList<Trainee>.promoteTrainees(): MutableList<Trainee>
= this.filter { it.codeReviewScores.calculateAverage() >= 3.5 }.map { it.copy(currentStage = (it.currentStage + 1 )) }.toMutableList()

fun MutableList<Trainee>.printTrainees(stage: Int): MutableList<Trainee> {
    val filteredTrainees = this.filter { it.currentStage <= stage }.toMutableList()
    println("Trainees at stage $stage:")
    for (trainee in filteredTrainees) {
        println("${trainee.name} - Average Score: ${trainee.codeReviewScores.calculateAverage()}")
    }
    return filteredTrainees
}