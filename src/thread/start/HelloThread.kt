package thread.start

class HelloThread : Thread (){

    override fun run() {
        println("${Thread.currentThread().name} : run()")
    }
}