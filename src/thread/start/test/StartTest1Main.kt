package thread.start.test

import util.MyLogger.Companion.log

class CounterThread : Thread() {

    override fun run() {
        (1..5)
            .forEach { it->
                log("value: $it")
                try {
                    sleep(100)
                }catch (e : InterruptedException){
                    throw RuntimeException(e)
                }
            }
    }
}

fun main() {
    val counterThread = CounterThread()
    counterThread.start()
}