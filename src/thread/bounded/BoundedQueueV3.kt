package thread.bounded

import util.MyLogger.Companion.log

class BoundedQueueV3(
    val queue: ArrayDeque<String> = ArrayDeque(),
    val max: Int
) : BoundedQueue{

    @Synchronized
    override fun put(data: String) {

        while (queue.size == max){
            log("[put] 큐가 가득 참. 생산자 대기 ")
            try {
                (this as Object).wait() // runnable -> waiting
                log("[put] 생산자에서 깨어남")
            }catch (e : InterruptedException){
                throw RuntimeException(e)
            }
        }

        queue.add(data)
        log("[put] 생산자 데이터 저장, notify 호출")
        (this as Object).notify()
    }

    @Synchronized
    override fun take(): String? {

        while (queue.isEmpty()) {
            log("[take] 큐에 데이터가 없음, 소비자 대기 ")
            try {
                (this as Object).wait()
                log("[take] 소비자 깨어남")
            } catch (e: InterruptedException) {
                throw RuntimeException(e)
            }
        }
        val polledData = this.queue.removeFirst()
        log("[take] 소비자 데이터 획득, notify 호출")
        (this as Object).notify()
        return polledData
    }

    override fun toString(): String = this.queue.toString()
}