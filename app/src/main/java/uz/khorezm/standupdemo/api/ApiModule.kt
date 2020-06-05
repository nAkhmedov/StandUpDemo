package uz.khorezm.standupdemo.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import uz.khorezm.standupdemo.KhorezmApp
import uz.khorezm.standupdemo.utils.constants.AppConstants
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class ApiModule {
    @Provides
    @Singleton
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    fun provideOkHttpCache(application: KhorezmApp): Cache {
        val cacheSize = 10 * 1024 * 1024 // 10 MiB
        return Cache(application.cacheDir, cacheSize.toLong())
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(cache: Cache): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        return httpClient.cache(cache)
            .followRedirects(true)
            .followSslRedirects(true)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideTimeServiceApi(client: OkHttpClient, gson: Gson): TimeApiService {
        return Retrofit.Builder()
            .baseUrl(AppConstants.TIME_SERVICE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build().create(TimeApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideReserveTimeServiceApi(
        client: OkHttpClient,
        gson: Gson
    ): TimeApiServiceReserve {
        return Retrofit.Builder()
            .baseUrl(AppConstants.TIME_SERVICE_URL_RESERVE)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build().create(TimeApiServiceReserve::class.java)
    }
}