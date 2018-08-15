package app.challange.code.r6h2lle11p.presentation.di

import android.arch.lifecycle.ViewModelProvider
import app.challange.code.r6h2lle11p.presentation.core.ViewModelFactory
import app.challange.code.r6h2lle11p.presentation.giphy.TrendingGifActivity
import app.challange.code.r6h2lle11p.presentation.giphy.TrendingGifActivitySubModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesModule {

    @ContributesAndroidInjector(modules = [TrendingGifActivitySubModule::class])
    abstract fun bindTrendingGifActivity(): TrendingGifActivity

    /* VIEW MODEL FACTORY */

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}
