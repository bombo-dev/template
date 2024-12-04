package time

import java.time.ZonedDateTime
import java.util.TimeZone

object DateTimeUtils {

    const val DEFAULT_ZONE_ID = "Asia/Seoul"
    val DEFAULT_TIME_ZONE = TimeZone.getTimeZone(DEFAULT_ZONE_ID)

    fun now(): ZonedDateTime {
        return ZonedDateTime.now(DEFAULT_TIME_ZONE.toZoneId())
    }
}
