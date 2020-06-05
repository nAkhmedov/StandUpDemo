package uz.khorezm.standupdemo.data.remote

import io.reactivex.Maybe
import uz.khorezm.standupdemo.data.model.WorldTime

interface RemoteDataRepository {
    fun getWorldTimeNow(): Maybe<WorldTime>

    fun getWorldTimeNowReserve(): Maybe<WorldTime>

}