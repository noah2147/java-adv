package thread.start.test

import util.MyLogger.Companion.log
import java.lang.Thread.sleep


fun main() {

    class MyRunnable(
        private val name: String,
        private val time: Long
    ) : Runnable {
        override fun run() {
            while (true){
                log("$name : run()")
                try {
                    sleep(time)
                }catch (e : InterruptedException){
                    throw RuntimeException(e)
                }
            }
        }
    }

    val threadA = Thread(MyRunnable("A", 1000), "ThreadA")
    val threadB = Thread(MyRunnable("B", 500), "ThreadB")

    threadA.start()
    threadB.start()
}