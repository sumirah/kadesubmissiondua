package id.go.lombokbaratkab.sumirah.sumirahsubmissiondua.Detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import id.go.lombokbaratkab.sumirah.sumirahsubmissiondua.Api.ApiRepository
import id.go.lombokbaratkab.sumirah.sumirahsubmissiondua.Api.TheSportDBApi
import id.go.lombokbaratkab.sumirah.sumirahsubmissiondua.Model.Match
import id.go.lombokbaratkab.sumirah.sumirahsubmissiondua.Model.TeamResponses
import id.go.lombokbaratkab.sumirah.sumirahsubmissiondua.R
import kotlinx.android.synthetic.main.activity_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MatchDetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val match = intent.getParcelableExtra<Match>("MATCH_OBJECT")
        text_detail_match_date.text = match.eventDate
        detail_club_home_name.text = match.homeTeam
        detail_club_away_name.text = match.awayTeam
        detail_club_home_score.text = match.homeScore
        detail_club_away_score.text = match.awayScore
        detail_club_home_goals.text = match.homeGoalDetails
        detail_club_away_goals.text = match.awayGoalDetails
        detail_club_home_gk.text = match.homeGoalKeeper
        detail_club_away_gk.text = match.awayGoalDetails
        detail_club_home_df.text = match.homeDefense
        detail_club_away_df.text = match.awayDefense
        detail_club_home_mf.text = match.homeMidfield
        detail_club_away_mf.text = match.awayMidfield


    //Ambil Logo
        ApiRepository.retrofit
                .create(TheSportDBApi::class.java)
                .getClubDetailById(match.homeId)
                .enqueue(object : Callback<TeamResponses> {
                    override fun onFailure(call: Call<TeamResponses>, t: Throwable) {

                    }

                    override fun onResponse(call: Call<TeamResponses>, response: Response<TeamResponses>) {
                        val imgUrl = response.body()?.teams?.get(0)?.teamBadge
                        Glide.with(this@MatchDetailActivity).load(imgUrl).into(img_detail_club_home_logo)
                    }

                })

        ApiRepository.retrofit.create(TheSportDBApi::class.java)
                .getClubDetailById(match.awayId)
                .enqueue(object : Callback<TeamResponses> {
                    override fun onFailure(call: Call<TeamResponses>, t: Throwable) {

                    }

                    override fun onResponse(call: Call<TeamResponses>, response: Response<TeamResponses>) {
                        val imgUrl = response.body()?.teams?.get(0)?.teamBadge
                        Glide.with(this@MatchDetailActivity).load(imgUrl).into(img_detail_club_away_logo)
                    }

                })
    }

}


