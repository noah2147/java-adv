package thread.control

import thread.start.HelloRunnable
import util.MyLogger.Companion.log

fun main() {

    val mainThread = Thread.currentThread()
    log("mainThread = $mainThread")
    log("mainThread.threadId() = ${mainThread.threadId()}")
    log("mainThread.name = ${mainThread.name}")
    log("mainThread.Priority = ${mainThread.priority}")
    log("mainThread.threadGroup = ${mainThread.threadGroup}")
    log("mainThread.state = ${mainThread.state}")

    val myThread = Thread(HelloRunnable(), "MyThread")
    log("myThread = $myThread")
    log("myThread.threadId() = ${myThread.threadId()}")
    log("myThread.name = ${myThread.name}")
    log("myThread.Priority = ${myThread.priority}")
    log("myThread.threadGroup = ${myThread.threadGroup}")
    log("myThread.state = ${myThread.state}")
}

class ThreadInfoMain {
}