package uz.khorezm.standupdemo.di

import android.content.Context
import dagger.Module
import dagger.Provides
import uz.khorezm.standupdemo.KhorezmApp
import uz.khorezm.standupdemo.data.DataManager
import uz.khorezm.standupdemo.data.DataRepository
import uz.khorezm.standupdemo.data.remote.RemoteDataManager
import uz.khorezm.standupdemo.data.remote.RemoteDataRepository
import uz.khorezm.standupdemo.utils.rx.AppSchedulerProvider
import uz.khorezm.standupdemo.utils.rx.SchedulerProvider
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: KhorezmApp): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideDataManager(dataManager: DataManager): DataRepository {
        return dataManager
    }

    @Provides
    @Singleton
    fun provideRemoteDataManager(remoteDataManager: RemoteDataManager): RemoteDataRepository {
        return remoteDataManager
    }

    @Provides
    @Singleton
    fun provideSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }


}