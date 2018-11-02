package id.go.lombokbaratkab.sumirah.sumirahsubmissiondua.Main

import id.go.lombokbaratkab.sumirah.sumirahsubmissiondua.Model.Match

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showEventList(data: List<Match>)
}