package thread.bounded

import util.MyLogger.Companion.log
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.BlockingQueue
import java.util.concurrent.TimeUnit

class BoundedQueueV6_4(
    val max:Int,
    val queue: BlockingQueue<String> = ArrayBlockingQueue(max)
) : BoundedQueue{

    override fun put(data: String){
        queue.add(data)
    }

    override fun take(): String?{
        return queue.remove()
    }

    override fun toString(): String = this.queue.toString()
}