package app.challange.code.r6h2lle11p

import android.content.Context
import app.challange.code.r6h2lle11p.App
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideContext(app: App): Context = app

}
