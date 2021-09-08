package com.example.rcviewsample.model

class TweetMapper {
    fun mapApiToUi(api: TweetApi): Tweet {
        return when {
            api.quote != null -> TweetQuote(
                api.ids,
                api.username,
                api.displayName,
                api.avatar,
                api.text,
                api.quote
            )
            api.image != null -> TweetImage(
                api.ids,
                api.username,
                api.displayName,
                api.avatar,
                api.text,
                api.image
            )
            else -> TweetSimple(api.ids, api.username, api.displayName, api.avatar, api.text)
        }
    }
}