package thread.bounded

import util.MyLogger.Companion.log
import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

class BoundedQueueV4(
    val lock: Lock = ReentrantLock(),
    val condition: Condition = lock.newCondition(),

    val queue: ArrayDeque<String> = ArrayDeque(),
    val max: Int
) : BoundedQueue{

    override fun put(data: String) {
        lock.lock()
        try {
            while (queue.size == max){
                log("[put] 큐가 가득 참. 생산자 대기 ")
                try {
                    condition.await()
                    log("[put] 생산자에서 깨어남")
                }catch (e : InterruptedException){
                    throw RuntimeException(e)
                }
            }
            queue.add(data)
            log("[put] 생산자 데이터 저장, signal() 호출")
            condition.signal()
        }finally {
            lock.unlock()
        }
    }

    override fun take(): String? {
        lock.lock()
        try {
            while (queue.isEmpty()) {
                log("[take] 큐에 데이터가 없음, 소비자 대기 ")
                try {
                    condition.await()
                    log("[take] 소비자 깨어남")
                } catch (e: InterruptedException) {
                    throw RuntimeException(e)
                }
            }
            val polledData = this.queue.removeFirst()
            log("[take] 소비자 데이터 획득, signal() 호출")
            condition.signal()
            return polledData
        }finally {
            lock.unlock()
        }
    }

    override fun toString(): String = this.queue.toString()
}