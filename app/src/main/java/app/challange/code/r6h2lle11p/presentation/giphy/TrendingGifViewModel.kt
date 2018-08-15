package app.challange.code.r6h2lle11p.presentation.giphy

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import app.challange.code.r6h2lle11p.domain.interactors.trending.LoadTrendingUseCase
import app.challange.code.r6h2lle11p.presentation.giphy.model.PaginationData
import com.giphy.sdk.core.models.Media
import com.giphy.sdk.core.network.response.ListMediaResponse
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

open class TrendingGifViewModel @Inject constructor(
    private val loadTrendingUseCase: LoadTrendingUseCase
) : ViewModel() {

    internal val mediaResponseObservable = MutableLiveData<List<Media>>()
    internal val haErrorObservable = MutableLiveData<Boolean>()

    val paginationData = PaginationData()

    fun loadMore() {
        if (!paginationData.isLoading) {
            paginationData.isLoading = true
            loadTrendingUseCase.execute(
                LoadTrendingUseCaseSubscriber(),
                LoadTrendingUseCase.Params.withOffset(paginationData.offset())
            )
        }
    }

    internal inner class LoadTrendingUseCaseSubscriber : DisposableSingleObserver<ListMediaResponse>() {

        override fun onSuccess(mediaResponse: ListMediaResponse) {
            paginationData.isLoading = false
            paginationData.data.plusAssign(mediaResponse.data)
            mediaResponseObservable.postValue(paginationData.data)
            haErrorObservable.postValue(false)
        }

        override fun onError(exception: Throwable) {
            paginationData.isLoading = false
            haErrorObservable.postValue(true)
        }

    }

    public override fun onCleared() {
        super.onCleared()
        loadTrendingUseCase.dispose()
    }

}
