package id.go.lombokbaratkab.sumirah.sumirahsubmissiondua.Model

import com.google.gson.annotations.SerializedName

data class Team(
        @SerializedName("strTeamBadge")
        var teamBadge: String? = null,

        @SerializedName("idTeam")
        var teamId: String? = null

)