package thread.executor.future

import util.MyLogger.Companion.log
import util.ThreadUtils.Companion.sleep
import java.util.concurrent.Callable
import java.util.concurrent.CancellationException
import java.util.concurrent.ExecutionException
import java.util.concurrent.Executors
import java.util.concurrent.Future

fun main() {

    val mayInterruptIfRunning =
//        true
        false

    class MyTask(): Callable<String> {
        override fun call(): String {
            try {
                (0..<9).forEach {
                    log("작업중 $it")
                    Thread.sleep(1000)
                }
            }catch (e : InterruptedException){
                log("인터럽트 발생")
                return "interrupted"
            }
            return "Completed"
        }
    }

    val es = Executors.newFixedThreadPool(1)
    val future = es.submit(MyTask())
    log("Future.state : ${future.state()}")

    sleep(3000)

    log("future.cancel(${mayInterruptIfRunning}) 호출")
    val cancelResult1 = future.cancel(mayInterruptIfRunning)
    log("Future.state: ${future.state()}")
    log("cancel(${mayInterruptIfRunning}) result: $cancelResult1")

    try {
        log("Future result: ${future.get()}")
    }catch (e: CancellationException){
        log("Future는 이미 취소 되었습니다.")
    }catch (e: Exception) {
        when (e) {
            is InterruptedException, is ExecutionException -> {
                e.printStackTrace()
            }
            else -> throw e
        }
    }

    es.close()
}