package app.challange.code.r6h2lle11p.domain

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object Rx {

    fun defaultSchedulers(): RxSchedulers = RxSchedulers(Schedulers.io(), AndroidSchedulers.mainThread())

}
