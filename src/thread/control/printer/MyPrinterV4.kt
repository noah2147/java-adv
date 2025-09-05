package thread.control.printer

import util.MyLogger.Companion.log
import util.ThreadUtils.Companion.sleep
import java.util.Queue
import java.util.Scanner
import java.util.concurrent.ConcurrentLinkedQueue

class MyPrinterV4(
    var jobQueue: Queue<String> = ConcurrentLinkedQueue(),

    @Volatile
    var checkCount: Int=0
) : Runnable {
    override fun run() {

        while (!Thread.interrupted()) {
            checkCount++
            if (jobQueue.isEmpty()) {
//                Thread.yield() // before 218485670 after 7814304
                continue
            }
            try {
                val job = jobQueue.poll()
                log("출력 시작 $job , 대기 문서 $jobQueue")
                Thread.sleep(3000)
                log("출력 완료 $job")
            }catch (e : InterruptedException){
                log("인터럽트 발생")
                break
            }
        }
        log("프린터 종료")
        log("check Count = $checkCount")
    }

    fun addJob(input: String) {
        jobQueue.add(input)
    }
}

fun main(){
    val printer = MyPrinterV4()
    val printerThread = Thread(printer, " printerV4")
    printerThread.start()

    val userInput = Scanner(System.`in`)
    while (true){
        log("프린터할 문서를 입력하세요 종료 (q)")
        val input = userInput.nextLine()
        if (input == "q"){
            printerThread.interrupt()
            break
        }
        printer.addJob(input)
    }
}