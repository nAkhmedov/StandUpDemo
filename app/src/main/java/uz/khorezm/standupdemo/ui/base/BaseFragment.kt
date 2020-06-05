package uz.khorezm.standupdemo.ui.base

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import uz.khorezm.standupdemo.utils.createFactory
import javax.inject.Inject

abstract class BaseFragment<M: ViewModel>: DaggerFragment() {

    @Inject
    protected lateinit var mViewModel: M

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModelFactory = mViewModel.createFactory()
        ViewModelProvider(this, viewModelFactory).get(mViewModel.javaClass)
    }
}