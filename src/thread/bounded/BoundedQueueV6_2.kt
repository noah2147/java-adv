package thread.bounded

import util.MyLogger.Companion.log
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.BlockingQueue

class BoundedQueueV6_2(
    val max:Int,
    val queue: BlockingQueue<String> = ArrayBlockingQueue(max)
) : BoundedQueue{

    override fun put(data: String){
        val result = queue.offer(data)
        log("저장 시도 결과 = $result")
    }

    override fun take(): String? = queue.poll()

    override fun toString(): String = this.queue.toString()
}