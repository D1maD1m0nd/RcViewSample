package com.example.rcviewsample.model

import kotlin.random.Random

class Twitter {
    companion object {
        fun generateTweets(): List<TweetApi> {
            val tweets = ArrayList<TweetApi>()
            for (i in 0..Random.nextInt(20, 40)) {
                val id = Random.nextInt(0, 50000)
                when (Random.nextInt(0, 3)) {
                    0 -> {
                        tweets.add(
                            TweetApi(
                                id,
                                "@d1mad1mo0nd",
                                "d1m0nd",
                                null,
                                "https://i.ytimg.com/vi/IrGG5B-ZSAQ/hqdefault.jpg",
                                "https://m.buro247.ua/images/2020/11/1605705745433959.jpg",
                                "MySampleTEXT1"
                            )
                        )
                    }
                    1 -> {
                        tweets.add(
                            TweetApi(
                                id,
                                "@d1mad1mo0nd",
                                "d1m0nd",
                                Quote("@mukasa", "MySampleTEXT2"),
                                null,
                                "https://m.buro247.ua/images/2020/11/1605705745433959.jpg",
                                "MySampleTEXT444"
                            )
                        )
                    }
                    else -> {
                        tweets.add(
                            TweetApi(
                                id,
                                "@d1mad1mo0nd",
                                "d1m0nd",
                                null,
                                null,
                                "https://m.buro247.ua/images/2020/11/1605705745433959.jpg",
                                "MySampleTEXT3"
                            )
                        )
                    }
                }
            }
            return tweets
        }
    }
}