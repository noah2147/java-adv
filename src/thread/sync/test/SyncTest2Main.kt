package thread.sync.test

import util.MyLogger.Companion.log

fun main() {

    class MyCounter{
        fun count(){
            var localValue:Int = 0
            repeat(1000){localValue++}
            log("결과 : $localValue")
        }
    }


    val counter = MyCounter()
    val task = Runnable {
        counter.count()
    }

    val t1 = Thread(task, "t1")
    val t2 = Thread(task, "t2")

    t1.start()
    t2.start()
}