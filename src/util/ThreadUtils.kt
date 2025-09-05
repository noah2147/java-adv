package util

import util.MyLogger.Companion.log

abstract class ThreadUtils {

    companion object{
        @JvmStatic
        fun sleep(millis: Long){
            try {
                Thread.sleep(millis)
            }catch (e : InterruptedException){
                log("인터럽트 발생 ${e.message}")
                throw RuntimeException(e)
            }
        }
    }
}