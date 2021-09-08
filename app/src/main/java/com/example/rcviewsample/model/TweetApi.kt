package com.example.rcviewsample.model

data class TweetApi(
    val ids: Int,
    val username: String,
    val displayName: String,
    val quote: Quote?,
    val image: String?,
    val avatar: String,
    val text: String
)

data class Quote(val username: String, val text: String)

sealed class Tweet {
    fun getId(): Int {
        return when (this) {
            is TweetSimple -> this.ids
            is TweetQuote -> this.ids
            is TweetImage -> this.ids
        }
    }
}

data class TweetSimple(
    val ids: Int,
    val username: String,
    val displayName: String,
    val avatar: String?,
    val text: String,
    val viewType: Int = 0
) : Tweet()

data class TweetQuote(
    val ids: Int,
    val username: String,
    val displayName: String,
    val avatar: String,
    val text: String,
    val quote: Quote?,
    val viewType: Int = 1
) : Tweet()

data class TweetImage(
    val ids: Int,
    val username: String,
    val displayName: String,
    val avatar: String,
    val text: String,
    val image: String,
    val viewType: Int = 2
) : Tweet()

