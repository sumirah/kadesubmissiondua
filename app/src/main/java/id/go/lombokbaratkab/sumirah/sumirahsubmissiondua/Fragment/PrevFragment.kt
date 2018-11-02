package id.go.lombokbaratkab.sumirah.sumirahsubmissiondua.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.go.lombokbaratkab.sumirah.sumirahsubmissiondua.Api.ApiRepository
import id.go.lombokbaratkab.sumirah.sumirahsubmissiondua.Api.TheSportDBApi
import id.go.lombokbaratkab.sumirah.sumirahsubmissiondua.Detail.MatchDetailActivity
import id.go.lombokbaratkab.sumirah.sumirahsubmissiondua.Model.Match
import id.go.lombokbaratkab.sumirah.sumirahsubmissiondua.Model.MatchesResponses
import id.go.lombokbaratkab.sumirah.sumirahsubmissiondua.R
import kotlinx.android.synthetic.main.fragment_prev.*
import org.jetbrains.anko.support.v4.startActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PrevFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_prev, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val service = ApiRepository.retrofit.create(TheSportDBApi::class.java).getPrevMatch()
        service.enqueue(object : Callback<MatchesResponses> {
            override fun onFailure(call: Call<MatchesResponses>, t: Throwable) {
                Log.e("ERROR_RESPONSE", t.localizedMessage)
            }

            override fun onResponse(call: Call<MatchesResponses>, response: Response<MatchesResponses>) {
                response.body()?.events?.let {
                    initRecyclerView(it)
                }
            }

        })
    }



    private fun initRecyclerView(list: MutableList<Match>) {
        rv_prev.layoutManager = LinearLayoutManager(context)
        val adapter = PrevRecyclerViewAdapter(list) { match ->
            startActivity<MatchDetailActivity>("MATCH_OBJECT" to match)
        }
        rv_prev.adapter = adapter
    }
}