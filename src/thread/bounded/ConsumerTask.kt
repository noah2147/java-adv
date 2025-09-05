package thread.bounded

import util.MyLogger.Companion.log

class ConsumerTask (
    val queue: BoundedQueue
) : Runnable{
    override fun run() {
        log("[소비 시도]    ? <- $queue")
        log("[소비 완료] $${queue.take()} <- $queue")
    }
}