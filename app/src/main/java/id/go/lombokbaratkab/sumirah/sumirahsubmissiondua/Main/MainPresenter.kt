package id.go.lombokbaratkab.sumirah.sumirahsubmissiondua.Main

import com.google.gson.Gson
import id.go.lombokbaratkab.sumirah.sumirahsubmissiondua.Api.ApiRepository

class MainPresenter(private val view: MainView,
                    private val apiRepository: ApiRepository,
                    private val gson: Gson) {

    fun getEventList(matchschedule: String?) {

    }
}