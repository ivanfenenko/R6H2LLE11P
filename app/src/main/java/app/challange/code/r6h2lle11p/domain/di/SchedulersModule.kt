package app.challange.code.r6h2lle11p.domain.di

import app.challange.code.r6h2lle11p.domain.Rx
import app.challange.code.r6h2lle11p.domain.RxSchedulers
import dagger.Module
import dagger.Provides

@Module
class SchedulersModule {

    @Provides
    fun provideDefaultRxSchedulers(): RxSchedulers = Rx.defaultSchedulers()

}
