package id.go.lombokbaratkab.sumirah.sumirahsubmissiondua.Api

import id.go.lombokbaratkab.sumirah.sumirahsubmissiondua.Model.MatchesResponses
import id.go.lombokbaratkab.sumirah.sumirahsubmissiondua.Model.TeamResponses
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TheSportDBApi {
    @GET("/api/v1/json/1/eventspastleague.php?id=4328")
    fun getPrevMatch(): Call<MatchesResponses>

    @GET("/api/v1/json/1/eventsnextleague.php?id=4328")
    fun getNextMatch(): Call<MatchesResponses>

    @GET("api/v1/json/1/lookupteam.php")
    fun getClubDetailById(@Query("id") id: String?): Call<TeamResponses>

}