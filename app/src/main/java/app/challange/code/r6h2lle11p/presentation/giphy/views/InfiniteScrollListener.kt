package app.challange.code.r6h2lle11p.presentation.giphy.views

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import app.challange.code.r6h2lle11p.domain.common.Constants

class InfiniteScrollListener(
    private val layoutManager: RecyclerView.LayoutManager,
    private val loadListener: LoadListener
) : RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
        checkAndLoadMore()
    }

    private fun checkAndLoadMore() {
        val lastVisibleItemPosition = when (layoutManager) {
            is LinearLayoutManager -> layoutManager.findLastVisibleItemPosition()
            is GridLayoutManager -> layoutManager.findLastVisibleItemPosition()
            else -> 0
        }
        if (isVisiblePageThresholdBreached(lastVisibleItemPosition)) {
            loadListener.loadMore()
        }
    }

    private fun isVisiblePageThresholdBreached(lastVisibleItemPosition: Int): Boolean {
        val visibleThreshold = lastVisibleItemPosition + Constants.DEFAULT_PAGE_SIZE
        return visibleThreshold > layoutManager.itemCount
    }

    interface LoadListener {

        fun loadMore()

    }

}
