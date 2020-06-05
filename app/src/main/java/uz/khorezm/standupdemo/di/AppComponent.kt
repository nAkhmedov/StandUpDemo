package uz.khorezm.standupdemo.di

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import uz.khorezm.standupdemo.KhorezmApp
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBuilder::class
    ]
)
interface AppComponent : AndroidInjector<KhorezmApp> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<KhorezmApp?>()
}