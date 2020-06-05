package uz.khorezm.standupdemo.ui.databinding

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class DataBindingViewModel @Inject constructor(

): ViewModel() {

    var count = ObservableField(0)

    fun increment() {
        count.set(count.get()?.plus(1))
    }
}