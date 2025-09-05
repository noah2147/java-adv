package thread.control

import util.MyLogger.Companion.log

fun main() {

    val thread = Thread({
        try {
            log("start")
            log("myThead.state2 = ${Thread.currentThread().state}")
            log("sleep() start")
            Thread.sleep(3000)
            log("sleep() end")
            log("myThread.state4 = ${Thread.currentThread().state}")
            log("end")
        } catch (e: InterruptedException) {
            throw RuntimeException(e)
        }
    }, "myThread")

    log("myThread.state1 = ${thread.state}")
    log("myThread.start()")
    thread.start()
    Thread.sleep(1000)
    log("myThread.state3 = ${thread.state}")
    Thread.sleep(4000)
    log("myThread.state5 = ${thread.state}")
    log("end")
}