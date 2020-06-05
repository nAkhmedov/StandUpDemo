package uz.khorezm.standupdemo.data.model

import com.google.gson.annotations.SerializedName
import org.joda.time.DateTime
import uz.khorezm.standupdemo.utils.TimeUtils

data class WorldTime(
        @SerializedName("currentDateTime", alternate = ["utc_datetime"])
        val dateTime: String?
) {
    companion object {
        fun getDeviceCurrentTime(): WorldTime {
            return WorldTime(TimeUtils.getStringFormatWithLocal(DateTime.now(), TimeUtils.WORLD_TIME_FORMAT))
        }
    }
}