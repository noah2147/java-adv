package thread.bounded

import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.BlockingQueue

class BoundedQueueV6_1(
    val queue: BlockingQueue<String>
) : BoundedQueue{

    constructor(max: Int) : this(ArrayBlockingQueue(max))

    override fun put(data: String) {
        try {
            queue.put(data)
        }catch (e : InterruptedException){
            throw RuntimeException(e)
        }
    }

    override fun take(): String? {
        try {
            return queue.take()
        }catch (e : InterruptedException){
            throw RuntimeException(e)
        }
    }

    override fun toString(): String = this.queue.toString()
}