package com.example.rcviewsample.data.remote.quest

import com.example.rcviewsample.data.remote.common.RemoteListItem
import com.google.gson.annotations.SerializedName

data class QuestListResponse(val items: List<QuestItem>)

data class QuestItem(
    val questId: String,

    @SerializedName("questName")
    val name: String,

    @SerializedName("questSubtitle")
    val subtitle: String,

    @SerializedName("questImage")
    val image: String,

    @SerializedName("description")
    val item: List<RemoteListItem>
)
