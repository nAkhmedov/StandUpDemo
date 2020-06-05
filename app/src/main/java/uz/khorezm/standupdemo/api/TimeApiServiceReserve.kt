package uz.khorezm.standupdemo.api

import io.reactivex.Maybe
import retrofit2.http.GET
import uz.khorezm.standupdemo.data.model.WorldTime

interface TimeApiServiceReserve {
    @GET("UTC")
    fun getWorldTimeNow(): Maybe<WorldTime>
}