package app.challange.code.r6h2lle11p.data.repository

import app.challange.code.r6h2lle11p.data.datasource.GiphyApi
import app.challange.code.r6h2lle11p.data.repository.TrendingRepositoryImpl
import app.challange.code.r6h2lle11p.domain.common.Constants
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test

class TrendingRepositoryImplTest {

    private val giphyApiMock = mock<GiphyApi>()

    private lateinit var testedClass: TrendingRepositoryImpl

    @Before
    fun setUp() {
        testedClass = TrendingRepositoryImpl(giphyApiMock)
    }

    @Test
    fun `Given default page and offset, when trending is called, then api is executed with params`() {
        testedClass.loadTrending(0)

        verify(giphyApiMock).loadTrending(0, Constants.DEFAULT_PAGE_SIZE)
    }

}
