package com.example.kotlin_practise.models

data class Trainee (val name: String, val age: Int, val currentStage: Int, val codeReviewScores: List<Int>)

val trainee1 = Trainee("Alice", 23, 1, listOf(1, 1, 2))
val trainee2 = Trainee("Bob", 25, 2, listOf(2, 1, 0))
val trainee3 = Trainee("Charlie", 22, 1, listOf(0, 0, 1))
val trainee4 = Trainee("David", 24, 3, listOf(1, 1, 1))
val trainee5 = Trainee("Emma", 22, 2, listOf(5, 5, 4))
val trainee6 = Trainee("Frank", 26, 1, listOf(3, 3, 4))
val trainee7 = Trainee("Grace", 23, 2, listOf(4, 5, 5))
val trainee8 = Trainee("Henry", 25, 3, listOf(5, 4, 3))

val traineesList = mutableListOf(trainee1, trainee2, trainee3, trainee4, trainee5, trainee6, trainee7, trainee8)