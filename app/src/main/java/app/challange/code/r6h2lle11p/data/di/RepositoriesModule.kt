package app.challange.code.r6h2lle11p.data.di

import app.challange.code.r6h2lle11p.data.repository.TrendingRepositoryImpl
import app.challange.code.r6h2lle11p.domain.repository.TrendingRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoriesModule {

    @Binds
    abstract fun bindTrendingRepository(trendingRepository: TrendingRepositoryImpl): TrendingRepository

}
