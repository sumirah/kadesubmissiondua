package id.go.lombokbaratkab.sumirah.sumirahsubmissiondua.Model

import com.google.gson.annotations.SerializedName

data class MatchesResponses(
        @SerializedName("events") var events: MutableList<Match>)