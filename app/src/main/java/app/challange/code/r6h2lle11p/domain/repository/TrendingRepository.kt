package app.challange.code.r6h2lle11p.domain.repository

import app.challange.code.r6h2lle11p.domain.common.Constants
import com.giphy.sdk.core.network.response.ListMediaResponse
import io.reactivex.Single

interface TrendingRepository {

    fun loadTrending(offset: Int, limit: Int = Constants.DEFAULT_PAGE_SIZE): Single<ListMediaResponse>

}
