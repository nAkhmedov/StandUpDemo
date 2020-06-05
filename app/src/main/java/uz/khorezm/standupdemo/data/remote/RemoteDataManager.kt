package uz.khorezm.standupdemo.data.remote

import io.reactivex.Maybe
import uz.khorezm.standupdemo.api.TimeApiService
import uz.khorezm.standupdemo.api.TimeApiServiceReserve
import uz.khorezm.standupdemo.data.model.WorldTime
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataManager @Inject constructor(
    private val timeServiceApi: TimeApiService,
    private val timServiceApiReserve: TimeApiServiceReserve
) : RemoteDataRepository {

    override fun getWorldTimeNow(): Maybe<WorldTime> {
        return timeServiceApi.getWorldTimeNow()
    }

    override fun getWorldTimeNowReserve(): Maybe<WorldTime> {
        return timServiceApiReserve.getWorldTimeNow()
    }
}