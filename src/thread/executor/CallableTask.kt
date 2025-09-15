package thread.executor

import util.MyLogger.Companion.log
import util.ThreadUtils.Companion.sleep
import java.util.concurrent.Callable

class CallableTask(
    val name: String,
    val sleepMs: Int = 1000
) : Callable<Int>{
    override fun call(): Int? {
        log("$name 실행")
        sleep(sleepMs.toLong())
        log("$name 완료 return = $sleepMs")
        return sleepMs
    }
}