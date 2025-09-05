package thread.control.yield

import util.ThreadUtils.Companion.sleep

class YieldMain {
}


fun main() {
    val threadCount = 1000
    repeat(threadCount) {
        Thread{
            repeat(10){it->
                println("${Thread.currentThread().name} - $it")

                //1. empty

                // sleep(1)
//                Thread.yield()
            }
        }.start()
    }
}