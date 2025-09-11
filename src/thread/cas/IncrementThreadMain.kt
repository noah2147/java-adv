package thread.cas

import util.ThreadUtils.Companion.sleep
import kotlin.jvm.Throws

const val THREAD_COUNT: Int = 1000
fun main(){
//    test(BasicInteger())
//    test(VolatileInteger())
//    test(SyncInteger())
    test(MyAtomicInteger())

}

@Throws(InterruptedException::class)
fun test(incrementInteger: IncrementInteger){

    val runnable = Runnable {
        sleep(10)
        incrementInteger.increment()
    }

    val threads = ArrayList<Thread>()
    repeat(THREAD_COUNT) {
        Thread(runnable)
            .also { threads.add(it)}
            .also { it.start() }
    }
    println("${threads.size} loop count")
    threads.forEach { it.join() }

    val result = incrementInteger.get()
    println("${incrementInteger.javaClass.simpleName} result: $result")
}