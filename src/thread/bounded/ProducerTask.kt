package thread.bounded

import util.MyLogger.Companion.log

class ProducerTask (
    val queue: BoundedQueue,
    var request: String
) : Runnable{
    override fun run() {
        log("[생산 시도] $request -> $queue")
        queue.put(request)
        log("[생산 완료] $request -> $queue")
    }
}