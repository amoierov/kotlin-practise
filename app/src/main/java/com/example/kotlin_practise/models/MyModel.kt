package com.example.kotlin_practise.models

import java.io.FileDescriptor

data class MyModel(val userName: String,
                   val picture: Boolean,
                   val descriptor: String,
                   val signature: String,
                   val tags: List<String> = emptyList())