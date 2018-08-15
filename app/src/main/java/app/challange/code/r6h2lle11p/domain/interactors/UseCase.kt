package app.challange.code.r6h2lle11p.domain.interactors

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class UseCase {

    private var disposables: CompositeDisposable? = null

    fun initDisposable(disposable: Disposable) {
        disposables = CompositeDisposable()
        disposables?.add(disposable)
    }

    fun dispose() {
        disposables?.let { if (!it.isDisposed) it.dispose() }
    }

}
