package thread.control.printer

import util.MyLogger.Companion.log
import util.ThreadUtils.Companion.sleep
import java.util.Queue
import java.util.Scanner
import java.util.concurrent.ConcurrentLinkedQueue

class MyPrinterV2(
    var work: Boolean = true,
    var jobQueue: Queue<String> = ConcurrentLinkedQueue()
) : Runnable {
    override fun run() {

        while (work) {
            if (jobQueue.isEmpty()) {
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
    }

    fun addJob(input: String) {
        jobQueue.add(input)
    }
}

fun main(){
    val printer = MyPrinterV2()
    val printerThread = Thread(printer, " printerV2")
    printerThread.start()

    val userInput = Scanner(System.`in`)
    while (true){
        log("프린터할 문서를 입력하세요 종료 (q)")
        val input = userInput.nextLine()
        if (input == "q"){
            printer.work = false
            printerThread.interrupt()
            break
        }
        printer.addJob(input)
    }
}