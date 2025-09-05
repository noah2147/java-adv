package thread.sync.test

fun main() {

    class Counter(
        var count: Int = 0,
    ){
        fun increment() = this.count++
    }

    val counter = Counter()
    val task = Runnable {
        (0..<10000).forEach { _ -> counter.increment() }
    }

    val t1 = Thread(task)
    val t2 = Thread(task)

    t1.start()
    t2.start()
    t1.join()
    t2.join()
    println("결과 = ${counter.count}")


}