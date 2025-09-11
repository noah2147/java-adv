package thread.cas

import java.util.concurrent.atomic.AtomicInteger

fun main() {

    val atomicInteger = AtomicInteger(0)
    println("start value = ${atomicInteger.get()}")

    val result1 = atomicInteger.compareAndSet(0, 1)
    println("compareAndSet result1 = $result1 value = ${atomicInteger.get()}")

    val result2 = atomicInteger.compareAndSet(0, 1)
    println("compareAndSet result2 = $result2 value = ${atomicInteger.get()}")
}