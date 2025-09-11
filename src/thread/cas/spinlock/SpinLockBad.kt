package thread.cas.spinlock

import util.MyLogger.Companion.log
import util.ThreadUtils.Companion.sleep

class SpinLockBad (
    @Volatile
    var lock: Boolean = false
){
    fun lock() {
        log("락 획득 시도")
        while (true){
            if(!lock){
                sleep(100)
                lock = true
                break
            }else{
                log("락 획득 실패 - 스핀 대기")
            }
        }
        log("락 획득 완료")
    }

    fun unLock(){
        lock = false
        log("락 반납 완료")
    }
}