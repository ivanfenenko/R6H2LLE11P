package app.challange.code.r6h2lle11p.domain

import io.reactivex.Scheduler
import javax.inject.Inject

class RxSchedulers @Inject constructor(val io: Scheduler, val androidMainThread: Scheduler)
