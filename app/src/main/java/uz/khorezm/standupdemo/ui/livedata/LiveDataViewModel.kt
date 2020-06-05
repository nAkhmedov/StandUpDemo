package uz.khorezm.standupdemo.ui.livedata

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject
import kotlin.random.Random

class LiveDataViewModel @Inject constructor(

): ViewModel() {

    val fishNames = MutableLiveData<String>()
    private val arrayFishes = arrayOf("Sazan", "Laqqa", "Ilon baliq", "Oq baliq", "Chovoq", "Sudak")
    private val random = Random(0)

    fun start() {
        val timer = object : CountDownTimer(10000, 1000) {
            override fun onFinish() {
                fishNames.value = ""

            }

            override fun onTick(millisUntilFinished: Long) {
                val randomIndex = random.nextInt(arrayFishes.size - 1)
                fishNames.value = arrayFishes[randomIndex]
            }
        }
        timer.start()
    }
}