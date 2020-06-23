package eu.kanade.tachiyomi.ui.recent_updates

import android.support.v7.widget.RecyclerView
import android.text.format.DateUtils
import android.view.View
import android.widget.TextView
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.AbstractHeaderItem
import eu.davidea.flexibleadapter.items.IFlexible
import eu.davidea.viewholders.FlexibleViewHolder
import eu.kanade.tachiyomi.R
import java.util.*

class DateItem(val date: Date) : AbstractHeaderItem<DateItem.Holder>() {

    override fun getLayoutRes(): Int {
        return R.layout.recent_chapters_section_item
    }

    override fun createViewHolder(view: View, adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>): Holder {
        return Holder(view, adapter)
    }

    override fun bindViewHolder(adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>, holder: Holder, position: Int, payloads: List<Any?>?) {
        holder.bind(this)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other is DateItem) {
            return date == other.date
        }
        return false
    }

    override fun hashCode(): Int {
        return date.hashCode()
    }

    class Holder(view: View, adapter: FlexibleAdapter<*>) : FlexibleViewHolder(view, adapter, true) {

        private val now = Date().time

        val section_text: TextView = view.findViewById(R.id.section_text)

        fun bind(item: DateItem) {
            section_text.text = DateUtils.getRelativeTimeSpanString(item.date.time, now, DateUtils.DAY_IN_MILLIS)
        }
    }
}