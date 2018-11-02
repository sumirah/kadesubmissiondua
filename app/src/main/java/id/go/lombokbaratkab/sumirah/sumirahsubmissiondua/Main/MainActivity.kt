package id.go.lombokbaratkab.sumirah.sumirahsubmissiondua.Main

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.widget.ProgressBar
import android.widget.Spinner
import id.go.lombokbaratkab.sumirah.sumirahsubmissiondua.Fragment.NextFragment
import id.go.lombokbaratkab.sumirah.sumirahsubmissiondua.Fragment.PrevFragment
import id.go.lombokbaratkab.sumirah.sumirahsubmissiondua.Model.Match
import id.go.lombokbaratkab.sumirah.sumirahsubmissiondua.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var events: MutableList<Match> = mutableListOf()
    private lateinit var listEvent: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var spinner: Spinner
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var presenter: MainPresenter
    private lateinit var adapter: MainAdapter
    private lateinit var eventType : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setupTab()

    }

    private fun setupTab() {
        val adapter = MainViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(PrevFragment(), "Prev Match")
        adapter.addFragment(NextFragment(), "Next Match")
        main_viewpager.adapter = adapter

        main_tabs.setupWithViewPager(main_viewpager)
        main_tabs.getTabAt(0)?.setIcon(R.drawable.ic_access_time_black_24dp)
        main_tabs.getTabAt(1)?.setIcon(R.drawable.ic_flag_black_24dp)

    }
}