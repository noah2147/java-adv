package util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MyLogger {

    companion object {

        private val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

        @JvmStatic
        fun log(obj: Any) {
            val time: String = LocalDateTime.now().format(formatter)
            println("%s [%9s] %s\n".format(time, Thread.currentThread().name, obj))
        }
    }
}