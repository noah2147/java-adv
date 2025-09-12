package thread.collection

import util.MyLogger.Companion.log

fun main() {
//    test(BasicList())
//    test(SyncList())
    test(SyncProxyList(BasicList()))
    test(SyncProxyList(BasicList()))
}

private fun test(list: SimpleList) {
    log("${list.javaClass.simpleName}")

    // A를 리스트에 저장하는 코드
    val addA = {
        list.add("A")
        log("Thread-1: list.add(A)")
    }

    // B를 리스트에 저장하는 코드
    val addB = {
        list.add("B")
        log("Thread-2: list.add(B)")
    }

    val thread1 = Thread(addA, "Thread-1")
    val thread2 = Thread(addB, "Thread-2")

    thread1.start()
    thread2.start()

    thread1.join()
    thread2.join()

    log(list.toString())
}