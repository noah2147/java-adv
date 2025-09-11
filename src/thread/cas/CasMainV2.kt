package thread.cas

import util.MyLogger.Companion.log
import java.util.concurrent.atomic.AtomicInteger

fun main() {

    val atomicInteger = AtomicInteger(0)
    println("start value = ${atomicInteger.get()}")

    fun incrementAndGet(atomicInteger: AtomicInteger): Int {
        var getValue = 0
        var result = false
        do{
            getValue = atomicInteger.get()
            log("getValue = $getValue")
            result = atomicInteger.compareAndSet(getValue, getValue + 1)
            log("compareAndSet result = $result")
        }while (!result)
        return getValue+1
    }
    val resultValue1 = incrementAndGet(atomicInteger)
    println("resultValue1 = $resultValue1")

    val resultValue2 = incrementAndGet(atomicInteger)
    println("resultValue2 = $resultValue2")
}