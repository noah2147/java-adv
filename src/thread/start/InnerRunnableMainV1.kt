package thread.start

import util.MyLogger.Companion.log


class Outer{

    class MyRunnable : Runnable{
        override fun run() {
            log("run()")
        }
    }
}

fun main(){

    log("main() start")
    val runnable = Outer.MyRunnable()
    Thread(runnable).start()
    log("main() end")
}
