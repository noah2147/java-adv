package thread.start

import util.MyLogger.Companion.log

fun main() {
    log("main() start")

    val helloRunnable = HelloRunnable()

    val thread1 = Thread(helloRunnable)
    thread1.start()

    val thread2 = Thread(helloRunnable)
    thread2.start()

    val thread3 = Thread(helloRunnable)
    thread3.start()

    log("main() end")
}