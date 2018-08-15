package app.challange.code.r6h2lle11p.presentation.giphy.views

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import app.challange.code.r6h2lle11p.R
import com.bumptech.glide.Glide
import com.giphy.sdk.core.models.Media
import java.util.*

class GifGridView : RecyclerView {

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    private fun init() {
        layoutManager = GridLayoutManager(context, context.resources.getInteger(R.integer.grid_size))
        adapter = GifGridViewAdapter()
    }

    fun setLoadListener(loadListener: InfiniteScrollListener.LoadListener) {
        val infiniteScrollListener = InfiniteScrollListener(layoutManager, loadListener)
        addOnScrollListener(infiniteScrollListener)
    }

    fun setItems(mediaResponse: List<Media>) {
        (adapter as GifGridViewAdapter).setItems(mediaResponse)
    }

    private inner class GifGridViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        private val items = ArrayList<Media>()

        fun setItems(newItems: List<Media>) {
            items.clear()
            items.plusAssign(newItems)
            notifyDataSetChanged()
        }

        override fun getItemCount(): Int {
            return items.count()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            return GifGridViewHolder(LayoutInflater.from(context).inflate(R.layout.item_grid_gif, parent, false))
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            (holder as GifGridViewHolder).bind(items[position])
        }

        inner class GifGridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            fun bind(media: Media) {
                Glide.with(context)
                    .load(media.images.downsizedMedium.gifUrl)
                    .into(itemView as ImageView)
            }

        }

    }

}
