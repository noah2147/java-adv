package thread.bounded

import util.MyLogger.Companion.log
import util.ThreadUtils.Companion.sleep

class BoundedQueueV2(
    val queue: ArrayDeque<String> = ArrayDeque(),
    val max: Int
) : BoundedQueue{

    @Synchronized
    override fun put(data: String) {

        while (queue.size == max){
            log("[put] 큐가 가득 참. 생산자 대기 ")
            sleep(1000)
        }
        queue.add(data)
    }

    @Synchronized
    override fun take(): String? {

        while (queue.isEmpty()){
            log("[take] 큐에 데이터가 없음, 소비자 대기 ")
            sleep(1000)
        }
        return this.queue.removeFirst()
    }

    override fun toString(): String = this.queue.toString()
}