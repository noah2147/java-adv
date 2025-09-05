package thread.start.test

import util.MyLogger.Companion.log
import java.lang.Thread.sleep

fun main() {
    Thread{
        (1..5)
            .forEach { it->
                log("value: $it")
                try {
                    sleep(1000)
                }catch (e : InterruptedException){
                    throw RuntimeException(e)
                }
            }
    }.also { it.start() }
}