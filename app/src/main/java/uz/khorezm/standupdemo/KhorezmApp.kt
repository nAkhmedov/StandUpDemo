package uz.khorezm.standupdemo

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import uz.khorezm.standupdemo.di.DaggerAppComponent

class KhorezmApp : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out KhorezmApp?> {
        return DaggerAppComponent.builder().create(this)
    }
}