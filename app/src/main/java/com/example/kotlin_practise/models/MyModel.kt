package com.example.kotlin_practise.models

data class MyModel(val userName: String,
                   val picture: Boolean,
                   val description: String,
                   val signature: String,
                   val tags: List<String> = emptyList())

val modelInstance1 = MyModel("adele@gmail.com", false, "Hello, it's me\n" +
        "I was wondering if after all these years you'd like to meet\n" +
        "To go over everything\n" +
        "They say that time's supposed to heal ya, but i ain't done much healing", "Adele's GRAMMY History", listOf("Easy on Me",
    "Skyfall", "Hello", "When We Were Young", "Remedy", "Send My Love(To Your New Lover)", "Rolling in the Deep")
)

val modelInstance2 = MyModel("cortisol@body.com", true, "An ancient discipline, ", "Yoga has the ability to reduce stress by diminishing mental discomfort", listOf("Ashtanga",
    "Iyengar", "Bikram", "Yin", "Kundalini")
)

val modelInstance3 = MyModel("cortisol@body.com", true, "An ancient discipline, Yoga is a concept that comes from a Sanskrit word\n " +
        "meaning 'union'. It combines bodily processes with breathing techniques, meditation, and mental\n" +
        "exercises in order to bring a sense of calm and composure in life", "Yoga has the ability to reduce stress by diminishing mental discomfort", listOf("Ashtanga",
    "Iyengar", "Bikram", "Yin", "Kundalini")
)

val modelInstance4 = MyModel("adele@gmail.com", false, "Hello, it's me\n" +
        "I was wondering if after all these years you'd like to meet\n" +
        "To go over everything\n" +
        "They say that time's supposed to heal ya, but i ain't done much healing", "Adele's GRAMMY History", listOf("Easy on Me",
    "Skyfall", "Hello", "When We Were Young", "Remedy", "Send My Love(To Your New Lover)", "Rolling in the Deep")
)