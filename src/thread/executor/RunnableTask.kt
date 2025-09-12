package thread.executor

import util.MyLogger.Companion.log
import util.ThreadUtils.Companion.sleep

class RunnableTask(
    val name: String,
    val sleepMs: Long = 1000
) : Runnable {

    override fun run() {
        log("${this.name} start")
        sleep(sleepMs)
        log("${this.name} end")
    }
}