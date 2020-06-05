package uz.khorezm.standupdemo.ui.rxjava

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Maybe
import io.reactivex.disposables.CompositeDisposable
import org.joda.time.DateTime
import uz.khorezm.standupdemo.data.DataRepository
import uz.khorezm.standupdemo.data.model.WorldTime
import uz.khorezm.standupdemo.utils.TimeUtils
import uz.khorezm.standupdemo.utils.rx.SchedulerProvider
import javax.inject.Inject

class RxJavaViewModel @Inject constructor(
    private val repository: DataRepository,
    private val schedulerProvider: SchedulerProvider
) : ViewModel() {

    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    val dataLoading = ObservableBoolean()
    val currentTimeData = MutableLiveData<String>()

    fun getWorldCurrentTime() {

        dataLoading.set(true)
        val disposable = Maybe.concat(
            repository.getWorldTimeNow().onErrorComplete(),
            repository.getWorldTimeNowReserve().onErrorComplete()
        )
            .subscribeOn(schedulerProvider.io())
            .first(WorldTime.getDeviceCurrentTime())
            .doFinally { dataLoading.set(false) }
            .subscribe({ worldTime ->
                val deviceCurrentTime =
                    TimeUtils.getStringFormatWithLocal(DateTime.now(), TimeUtils.WORLD_TIME_FORMAT)
                val stringTimeFormat = worldTime.dateTime ?: deviceCurrentTime
                currentTimeData.postValue(stringTimeFormat)
            }, { error -> error.printStackTrace() })

        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}