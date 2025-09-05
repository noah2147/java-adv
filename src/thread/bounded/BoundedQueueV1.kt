package thread.bounded

import util.MyLogger.Companion.log

class BoundedQueueV1(
    val queue: ArrayDeque<String> = ArrayDeque(),
    val max: Int
) : BoundedQueue{

    @Synchronized
    override fun put(data: String) {

        if(this.queue.size == this.max){
            log("[put] queue is full $data")
            return
        }
        queue.add(data)
    }

    @Synchronized
    override fun take(): String? {
        if(this.queue.isEmpty()){
            return null
        }
        return this.queue.removeFirst()
    }

    override fun toString(): String = this.queue.toString()
}