package uz.khorezm.standupdemo.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import uz.khorezm.standupdemo.ui.databinding.DataBindingFragment
import uz.khorezm.standupdemo.ui.livedata.LiveDataFragment
import uz.khorezm.standupdemo.ui.main.MainActivity
import uz.khorezm.standupdemo.ui.main.ViewBindingFragment
import uz.khorezm.standupdemo.ui.rxjava.RxJavaFragment

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector()
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun bindViewBindingFragment(): ViewBindingFragment

    @ContributesAndroidInjector
    abstract fun bindDataBindingFragment(): DataBindingFragment

    @ContributesAndroidInjector
    abstract fun bindLiveDataFragment(): LiveDataFragment

    @ContributesAndroidInjector
    abstract fun bindRxJavaFragment(): RxJavaFragment

}
