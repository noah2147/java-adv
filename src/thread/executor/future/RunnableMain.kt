package thread.executor.future

import util.MyLogger.Companion.log
import util.ThreadUtils.Companion.sleep
import kotlin.random.Random

fun main() {

    class MyRunnable(
        var value: Int = 0
    ): Runnable {
        override fun run() {
            log("Runnable start")
            sleep(2000)
            value = Random.nextInt(10)
            log("create value = $value")
            log("Runnable end")
        }
    }

    val task = MyRunnable()
    val thread = Thread(task, "thread-1")
    thread.start()
    thread.join()
    val result = task.value
    log("result value = $result")
}