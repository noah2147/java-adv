package thread.cas

import java.util.concurrent.atomic.AtomicInteger

class MyAtomicInteger(
    val atomicInteger: AtomicInteger = AtomicInteger(0)
) : IncrementInteger {
    override fun increment() {
        atomicInteger.incrementAndGet()
    }
    override fun get(): Int = atomicInteger.get()
}