package app.challange.code.r6h2lle11p.presentation.giphy

import android.arch.lifecycle.Observer
import android.os.Bundle
import app.challange.code.r6h2lle11p.R
import app.challange.code.r6h2lle11p.presentation.core.BaseActivity
import app.challange.code.r6h2lle11p.presentation.giphy.views.InfiniteScrollListener
import kotlinx.android.synthetic.main.activity_trending_giphy.*

class TrendingGifActivity : BaseActivity<TrendingGifViewModel>(), InfiniteScrollListener.LoadListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initContentObservable()
        initInfiniteScrolling()
        initViewModel()
    }

    private fun initContentObservable() {
        viewModel.mediaResponseObservable.observe(this, Observer {
            it?.let {
                gif_grid_view.setItems(it)
            }
        })
    }

    private fun initInfiniteScrolling() {
        gif_grid_view.setLoadListener(this)
    }

    private fun initViewModel() {
        viewModel.loadMore()
    }

    override fun loadMore() {
        viewModel.loadMore()
    }

    override fun getLayoutId() = R.layout.activity_trending_giphy

    override fun constructViewModel() = TrendingGifViewModel::class.java
}
