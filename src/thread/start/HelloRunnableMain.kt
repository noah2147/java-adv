package thread.start

class HelloRunnable : Runnable {
    override fun run() {
        println("Thread name : ${Thread.currentThread().name} run()")
    }
}

fun main(){
    println("Thread name : ${Thread.currentThread().name} main() start")
    val helloRunnable = HelloRunnable()
    val thread = Thread(helloRunnable)
    thread.start()
    println("Thread name : ${Thread.currentThread().name} main() end")
}