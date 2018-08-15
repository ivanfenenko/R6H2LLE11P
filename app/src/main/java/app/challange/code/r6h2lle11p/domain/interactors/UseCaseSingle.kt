package app.challange.code.r6h2lle11p.domain.interactors

import app.challange.code.r6h2lle11p.domain.RxSchedulers
import io.reactivex.Single
import io.reactivex.observers.DisposableSingleObserver

abstract class UseCaseSingle<Object, in Params> constructor(private val rxSchedulers: RxSchedulers) : UseCase() {

    internal abstract fun buildUseCaseObservable(params: Params): Single<Object>

    @Suppress("UNCHECKED_CAST")
    fun execute(observer: DisposableSingleObserver<Object>, params: Params? = null) {
        return try {
            val single = buildUseCaseObservable(params ?: Unit as Params)
                .subscribeOn(rxSchedulers.io)
                .observeOn(rxSchedulers.androidMainThread)
            initDisposable(single.subscribeWith(observer))
        } catch (cce: ClassCastException) {
            throw ClassCastException("The use case encountered an error while building a signle user case.")
        }
    }

}
