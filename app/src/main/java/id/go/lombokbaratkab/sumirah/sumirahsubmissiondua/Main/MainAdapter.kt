package id.go.lombokbaratkab.sumirah.sumirahsubmissiondua.Main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import id.go.lombokbaratkab.sumirah.sumirahsubmissiondua.Model.Match
import id.go.lombokbaratkab.sumirah.sumirahsubmissiondua.R
import org.jetbrains.anko.find

class MainAdapter(private val context: Context, private val events: List<Match>, val listener: (Match) -> Unit): RecyclerView.Adapter<EventViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
            EventViewHolder(LayoutInflater.from(context).inflate(R.layout.eventlist_item, parent, false))


    override fun getItemCount(): Int = events.size

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bindItem(events[position], listener)
    }
}

class EventViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val home_Team: TextView = view.find(R.id.daftar_home_name)
    private val event_Date: TextView = view.find(R.id.daftar_date_event)
    private val home_Score: TextView = view.find(R.id.daftar_home_score)
    private val away_Score: TextView = view.find(R.id.daftar_away_score)
    private val away_Team: TextView = view.find(R.id.daftar_away_name)

    fun bindItem(events: Match, listener: (Match) -> Unit) {
        home_Team.text = events.homeTeam
        event_Date.text = events.eventDate
        home_Score.text = events.homeScore
        away_Score.text = events.awayScore
        away_Team.text = events.awayTeam

        itemView.setOnClickListener {
            listener(events)
        }
    }

}