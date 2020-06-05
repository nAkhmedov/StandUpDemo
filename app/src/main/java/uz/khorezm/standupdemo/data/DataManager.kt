package uz.khorezm.standupdemo.data

import io.reactivex.Maybe
import uz.khorezm.standupdemo.data.model.WorldTime
import uz.khorezm.standupdemo.data.remote.RemoteDataRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManager @Inject constructor(
    private val remoteDataRepo: RemoteDataRepository
) : DataRepository {

    override fun getWorldTimeNow(): Maybe<WorldTime> {
        return remoteDataRepo.getWorldTimeNow()
    }

    override fun getWorldTimeNowReserve(): Maybe<WorldTime> {
        return remoteDataRepo.getWorldTimeNowReserve()
    }
}