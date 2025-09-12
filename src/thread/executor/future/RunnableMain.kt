package thread.executor.future

import thread.start.Outer
import util.MyLogger.Companion.log
import util.ThreadUtils.Companion.sleep
import kotlin.random.Random

fun main() {

    class MyRunnable(
        var value: Int
    ): Runnable {
        override fun run() {

            log("Runnable start")
            sleep(2000)
            this.value = Random.nextInt()
            log()
            log("Runnable end")
        }
    }
}