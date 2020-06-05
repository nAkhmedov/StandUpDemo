package uz.khorezm.standupdemo.utils

import org.joda.time.DateTime
import java.util.*

class TimeUtils {

    companion object {

        const val WORLD_TIME_FORMAT = "yyyy-MM-dd'T'HH:mmZ"

        fun getStringFormatWithLocal(
            dateTime: DateTime?,
            timeFormat: String?
        ): String? {
            return dateTime?.toString(timeFormat, Locale.US)
        }
    }
}