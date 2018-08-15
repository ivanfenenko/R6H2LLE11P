package app.challange.code.r6h2lle11p

import app.challange.code.r6h2lle11p.domain.RxSchedulers
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class TestRxProvider {

    companion object {

        fun provideRxSchedulers(
            io: Scheduler = Schedulers.trampoline(),
            androidMainThread: Scheduler = Schedulers.trampoline()
        ): RxSchedulers {
            return RxSchedulers(io, androidMainThread)
        }

    }

}
