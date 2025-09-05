package thread.bounded

import util.MyLogger.Companion.log
import util.ThreadUtils.Companion.sleep

fun main(){
    val queue = BoundedQueueV1(max = 2)

//    produceFirst(queue)
    consumerFirst(queue)

}

fun produceFirst(queue: BoundedQueue){

    log("== [생산자 먼저 실행] 시작 ${queue.javaClass.simpleName}")
    val threads = ArrayList<Thread>()
    startProducer(queue, threads)
    printAllState(queue, threads)
    startConsumer(queue, threads)
    printAllState(queue, threads)
    log("== [생산자 먼저 실행] 종료, ${queue.javaClass.simpleName}")
}

fun consumerFirst(queue: BoundedQueue){

    log("== [소비자 먼저 실행] 시작 ${queue.javaClass.simpleName}")
    val threads = ArrayList<Thread>()
    startConsumer(queue, threads)
    printAllState(queue, threads)
    startProducer(queue, threads)
    printAllState(queue, threads)
    log("== [소비자 먼저 실행] 종료, ${queue.javaClass.simpleName}")
}

fun startProducer(queue: BoundedQueue, threads: MutableList<Thread>){
    println()
    log("생산자 시작")
    (1..3).forEach { it->
        val producer: Thread = Thread(ProducerTask(queue, "data $it"), "producer $it")
        threads.add(producer)
        producer.start()
        sleep(100)
    }
}

fun startConsumer(queue: BoundedQueue, threads: MutableList<Thread>){
    println()
    log("소비자 시작")
    (1..3).forEach { it ->
        val consumer: Thread = Thread(ConsumerTask(queue), "consumer $it")
        threads.add(consumer)
        consumer.start()
        sleep(100)
    }
}

fun printAllState(queue: BoundedQueue, threads: MutableList<Thread>){
    println()
    log("현재 상태 출력, 큐 데이터 : $queue")
    threads.forEach { it->
        log("${it.name} : ${it.state}")
    }
}