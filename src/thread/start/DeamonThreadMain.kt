package thread.start

class DeamonThread : Thread(){

    override fun run() {
        println("${Thread.currentThread().name} : run() start")
        try {
            Thread.sleep(1000)
        }catch (e : InterruptedException){
            throw RuntimeException(e)
        }

        println("${Thread.currentThread().name} : run() end")
    }
}

fun main(){

    println("${Thread.currentThread().name} : main() start")
    val deamonThread = DeamonThread()
    deamonThread.isDaemon = true
    deamonThread.start()
    println("${Thread.currentThread().name} : main() end")
}