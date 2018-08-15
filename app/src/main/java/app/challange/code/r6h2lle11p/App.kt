package app.challange.code.r6h2lle11p

import dagger.android.DaggerApplication

class App : DaggerApplication() {

    override fun applicationInjector() = DaggerAppComponent.builder()
        .application(this)
        .build()

}
