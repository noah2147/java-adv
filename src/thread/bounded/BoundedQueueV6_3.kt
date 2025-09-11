package thread.bounded

import util.MyLogger.Companion.log
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.BlockingQueue
import java.util.concurrent.TimeUnit

class BoundedQueueV6_3(
    val max:Int,
    val queue: BlockingQueue<String> = ArrayBlockingQueue(max)
) : BoundedQueue{

    override fun put(data: String){
        try {
            val result = queue.offer(data, 1, TimeUnit.NANOSECONDS)
            log("저장 시도 결과 = $result")
        }catch (e : InterruptedException){
            throw RuntimeException(e)
        }
    }

    override fun take(): String?{
        try {
            return queue.poll(2, TimeUnit.SECONDS)
        }catch (e : InterruptedException){
            throw RuntimeException(e)
        }
    }

    override fun toString(): String = this.queue.toString()
}