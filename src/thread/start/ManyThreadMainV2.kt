package thread.start

import util.MyLogger.Companion.log

fun main() {
    log("main() start")

    val helloRunnable = HelloRunnable()

    (0..<100).forEach { _ -> Thread(helloRunnable).start() }

    log("main() end")
}