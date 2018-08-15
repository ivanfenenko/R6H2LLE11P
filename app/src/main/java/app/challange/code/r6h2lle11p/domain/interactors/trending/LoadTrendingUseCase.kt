package app.challange.code.r6h2lle11p.domain.interactors.trending

import app.challange.code.r6h2lle11p.domain.RxSchedulers
import app.challange.code.r6h2lle11p.domain.interactors.UseCaseSingle
import app.challange.code.r6h2lle11p.domain.repository.TrendingRepository
import com.giphy.sdk.core.network.response.ListMediaResponse
import io.reactivex.Single
import javax.inject.Inject

class LoadTrendingUseCase @Inject constructor(
    private val trendingRepository: TrendingRepository,
    rxSchedulers: RxSchedulers
) : UseCaseSingle<ListMediaResponse, LoadTrendingUseCase.Params>(rxSchedulers) {

    override fun buildUseCaseObservable(params: Params): Single<ListMediaResponse> {
        return trendingRepository.loadTrending(params.offset)
    }

    class Params constructor(val offset: Int) {

        companion object {

            fun withOffset(offset: Int): Params {
                return Params(offset)
            }

        }

    }

}
