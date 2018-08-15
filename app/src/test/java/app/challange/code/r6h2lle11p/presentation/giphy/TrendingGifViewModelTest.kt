package app.challange.code.r6h2lle11p.presentation.giphy

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.Observer
import app.challange.code.r6h2lle11p.domain.interactors.trending.LoadTrendingUseCase
import com.giphy.sdk.core.models.Media
import com.giphy.sdk.core.network.response.ListMediaResponse
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentCaptor

class TrendingGifViewModelTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    private val loadTrendingUseCaseMock = mock<LoadTrendingUseCase>()

    private val mediaResponseObservableMock = mock<Observer<List<Media>>>()
    private val loadTrendingUseCaseParamsCaptor = ArgumentCaptor.forClass(LoadTrendingUseCase.Params::class.java)

    private lateinit var testedClass: TrendingGifViewModel
    private lateinit var useCaseObserver: TrendingGifViewModel.LoadTrendingUseCaseSubscriber

    @Before
    fun setUp() {
        testedClass = TrendingGifViewModel(loadTrendingUseCaseMock)
        testedClass.mediaResponseObservable.observeForever(mediaResponseObservableMock)
        useCaseObserver = testedClass.LoadTrendingUseCaseSubscriber()
    }

    @Test
    fun `When load is called, then load trending use case is executed`() {
        testedClass.loadMore()

        verify(loadTrendingUseCaseMock).execute(any(), loadTrendingUseCaseParamsCaptor.capture())
        assertThat(testedClass.paginationData.isLoading).isTrue()
        assertThat(loadTrendingUseCaseParamsCaptor.value.offset).isEqualTo(0)
    }

    @Test
    fun `Given successful response, when results are loaded, then data is being posted`() {
        val mediaResponse = ListMediaResponse()
        val mediaList = arrayListOf(Media(), Media())
        mediaResponse.data = mediaList

        useCaseObserver.onSuccess(mediaResponse)

        verify(mediaResponseObservableMock).onChanged(mediaList)
        assertThat(testedClass.paginationData.isLoading).isFalse()
        assertThat(testedClass.paginationData.offset()).isEqualTo(mediaList.size)
    }

    @Test
    fun `Given error response, when results are loaded, then error is posted`() {
        val exception = UnsupportedOperationException()

        useCaseObserver.onError(exception)

        assertThat(testedClass.paginationData.isLoading).isFalse()
    }

    @Test
    fun `When view model is cleared, then use cases are disposed`() {
        testedClass.onCleared()

        verify(loadTrendingUseCaseMock).dispose()
    }

}
