package thread.cas

const val COUNT: Long = 100_100_100L
fun main() {
    performanceTest(BasicInteger())
    performanceTest(VolatileInteger())
    performanceTest(SyncInteger())
    performanceTest(MyAtomicInteger())
}

fun performanceTest(incrementInteger: IncrementInteger) {
    val startMs = System.currentTimeMillis()
    repeat(COUNT.toInt()) {
        incrementInteger.increment()
    }
    val endMs = System.currentTimeMillis()
    println("${incrementInteger.javaClass.simpleName} ${endMs - startMs} ms")
}