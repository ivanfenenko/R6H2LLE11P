package app.challange.code.r6h2lle11p.domain.interactors.trending

import app.challange.code.r6h2lle11p.TestRxProvider.Companion.provideRxSchedulers
import app.challange.code.r6h2lle11p.domain.repository.TrendingRepository
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test

class LoadTrendingUseCaseTest {

    private val trendingRepositoryMock = mock<TrendingRepository>()

    private lateinit var testedClass: LoadTrendingUseCase

    @Before
    fun setUp() {
        testedClass = LoadTrendingUseCase(trendingRepositoryMock, provideRxSchedulers())
    }

    @Test
    fun `Given offset, when use case is built, then repository is triggered with params`() {
        val params = LoadTrendingUseCase.Params.withOffset(10)

        testedClass.buildUseCaseObservable(params)

        verify(trendingRepositoryMock).loadTrending(params.offset)
    }

}
