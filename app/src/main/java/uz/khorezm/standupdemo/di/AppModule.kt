package uz.khorezm.standupdemo.di

import android.content.Context
import dagger.Module
import dagger.Provides
import uz.khorezm.standupdemo.KhorezmApp
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: KhorezmApp): Context {
        return application
    }
}