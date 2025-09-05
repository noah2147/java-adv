package thread.start

import util.MyLogger.Companion.log


fun main(){

    log("main() start")

    Thread{
        log("run1()")
    }.start()

    val runnable = Runnable { log("run2()") }
    Thread(runnable).start()
    log("main() end")
}
