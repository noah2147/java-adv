package thread.executor

import util.MyLogger.Companion.log
import java.util.concurrent.ExecutorService
import java.util.concurrent.ThreadPoolExecutor

class ExecutorUtils {

    companion object {

        @JvmStatic
        fun printState(executorService: ExecutorService) {
            if(executorService is ThreadPoolExecutor ){
                (executorService as ThreadPoolExecutor).also { poolExecutor ->
                    log("[pool= ${poolExecutor.poolSize}, " +
                            "active= ${poolExecutor.activeCount}, " +
                            "queuedTasks= ${poolExecutor.queue.size}, " +
                            "completedTask= ${poolExecutor.completedTaskCount}]"
                    )
                }
            }else{
                log(executorService)
            }
        }

        @JvmStatic
        fun printState(executorService: ExecutorService, taskName: String) {
            if(executorService is ThreadPoolExecutor ){
                (executorService as ThreadPoolExecutor).also { poolExecutor ->
                    log("[pool= ${poolExecutor.poolSize}, " +
                            "active= ${poolExecutor.activeCount}, " +
                            "queuedTasks= ${poolExecutor.queue.size}, " +
                            "completedTask= ${poolExecutor.completedTaskCount}]"
                    )
                }
            }else{
                log("$taskName -> $executorService")
            }
        }
    }
}