package app.challange.code.r6h2lle11p.presentation.giphy

import android.arch.lifecycle.ViewModel
import app.challange.code.r6h2lle11p.presentation.di.BaseActivityBindingModule
import app.challange.code.r6h2lle11p.presentation.core.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class TrendingGifActivitySubModule :
    BaseActivityBindingModule<TrendingGifActivity> {

    @Binds
    @IntoMap
    @ViewModelKey(TrendingGifViewModel::class)
    abstract fun bindContentDetailsActivityViewModel(contentDetailActivityViewModel: TrendingGifViewModel): ViewModel

}
