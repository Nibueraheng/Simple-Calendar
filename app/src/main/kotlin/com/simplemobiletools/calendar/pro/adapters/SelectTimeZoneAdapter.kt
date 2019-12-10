package com.simplemobiletools.calendar.pro.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.simplemobiletools.calendar.pro.R
import com.simplemobiletools.calendar.pro.activities.SimpleActivity
import com.simplemobiletools.calendar.pro.models.MyTimeZone
import com.simplemobiletools.commons.views.MyRecyclerView
import kotlinx.android.synthetic.main.item_select_time_zone.view.*
import java.util.*

class SelectTimeZoneAdapter(val activity: SimpleActivity, val timeZones: ArrayList<MyTimeZone>, recyclerView: MyRecyclerView, val itemClick: (Any) -> Unit) :
        RecyclerView.Adapter<SelectTimeZoneAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = activity.layoutInflater.inflate(R.layout.item_select_time_zone, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val timeZone = timeZones[position]
        holder.bindView(timeZone)
    }

    override fun getItemCount() = timeZones.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindView(timeZone: MyTimeZone): View {
            itemView.apply {
                item_time_zone_title.text = timeZone.zoneName
                item_select_time_zone_holder.setOnClickListener {
                    itemClick(timeZone)
                }
            }

            return itemView
        }
    }
}