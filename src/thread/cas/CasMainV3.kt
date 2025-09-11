package thread.cas

import util.MyLogger.Companion.log
import util.ThreadUtils.Companion.sleep
import java.util.concurrent.atomic.AtomicInteger

fun main() {
    val THREAD_COUNT = 2

    val atomicInteger = AtomicInteger(0)
    println("start value = ${atomicInteger.get()}")

    fun incrementAndGet(atomicInteger: AtomicInteger): Int {
        var getValue = 0
        var result = false
        do{
            getValue = atomicInteger.get()
            sleep(100)
            log("getValue = $getValue")
            result = atomicInteger.compareAndSet(getValue, getValue + 1)
            log("compareAndSet result = $result")
        }while (!result)
        return getValue+1
    }

    val runnable = Runnable {
        incrementAndGet(atomicInteger)
    }

    val threads = ArrayList<Thread>()
    repeat(THREAD_COUNT) {
        val thread = Thread(runnable)
        threads.add(thread)
        thread.start()
    }

    for (thread in threads) {
        thread.join()
    }

    atomicInteger.get().also {
        println("result value = $it")
    }
}