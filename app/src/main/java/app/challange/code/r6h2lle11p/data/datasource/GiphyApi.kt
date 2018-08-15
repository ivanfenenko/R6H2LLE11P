package app.challange.code.r6h2lle11p.data.datasource

import com.giphy.sdk.core.models.enums.MediaType
import com.giphy.sdk.core.network.api.GPHApiClient
import com.giphy.sdk.core.network.response.ListMediaResponse
import io.reactivex.Single
import javax.inject.Inject

class GiphyApi @Inject constructor(private var giphyClient: GPHApiClient) {

    fun loadTrending(offset: Int, limit: Int): Single<ListMediaResponse> {
        return Single.create({
            giphyClient.trending(
                MediaType.gif, limit, offset, null
            ) { result, e ->
                if (result == null) {
                    it.onError(e)
                } else {
                    it.onSuccess(result)
                }
            }
        })
    }

}
