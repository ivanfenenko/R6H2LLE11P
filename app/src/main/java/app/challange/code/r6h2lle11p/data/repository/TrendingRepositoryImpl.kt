package app.challange.code.r6h2lle11p.data.repository

import app.challange.code.r6h2lle11p.data.datasource.GiphyApi
import app.challange.code.r6h2lle11p.domain.repository.TrendingRepository
import com.giphy.sdk.core.network.response.ListMediaResponse
import io.reactivex.Single
import javax.inject.Inject

class TrendingRepositoryImpl @Inject constructor(private var giphyApi: GiphyApi) : TrendingRepository {

    override fun loadTrending(offset: Int, limit: Int): Single<ListMediaResponse> {
        return giphyApi.loadTrending(offset, limit)
    }

}
