package thread.start

fun main() {

    println("${Thread.currentThread().name} : main()")
    val helloThread = HelloThread()
    println("${Thread.currentThread().name} : start() 호출 전 ")
    helloThread.start()
    println("${Thread.currentThread().name} : start() 호출 후")
    println("${Thread.currentThread().name} : main() end")
}