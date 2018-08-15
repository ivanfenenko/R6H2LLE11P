package app.challange.code.r6h2lle11p.data.di

import android.content.Context
import app.challange.code.r6h2lle11p.R
import com.giphy.sdk.core.network.api.GPHApiClient
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    fun provideGiphyApi(context: Context) = GPHApiClient(context.getString(R.string.giphy_api_key))

}
