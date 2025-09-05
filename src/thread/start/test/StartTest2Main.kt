package thread.start.test

import util.MyLogger.Companion.log
import java.lang.Thread.sleep

class CounterRunnable : Runnable{
    override fun run() {
        (1..5)
            .forEach { it->
                log("value: $it")
                try {
                    sleep(1000)
                }catch (e : InterruptedException){
                    throw RuntimeException(e)
                }
            }
    }
}

fun main() {
    val thread = Thread(CounterRunnable())
    thread.start()
}