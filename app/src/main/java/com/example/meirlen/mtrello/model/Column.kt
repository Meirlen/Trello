package com.example.meirlen.mtrello.model

data class Column(
    val id: String,
    val name: String,
    val closed: Boolean,
    val idBoard: String,
    val pos: Int,
    val subscribed: Boolean,
    val cards: List<Card>
)

data class Card(
    val name: String
)

