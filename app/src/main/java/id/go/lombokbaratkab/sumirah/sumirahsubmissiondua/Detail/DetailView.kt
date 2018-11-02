package id.go.lombokbaratkab.sumirah.sumirahsubmissiondua.Detail

interface DetailView {
    fun showLoading()
    fun hideLoading()
    fun showBadge (homeBadge: String, awayBadge: String)
}