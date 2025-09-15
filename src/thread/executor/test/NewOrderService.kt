package thread.executor.test

import util.MyLogger.Companion.log
import util.ThreadUtils.Companion.sleep
import java.util.concurrent.Callable
import java.util.concurrent.Executors

class NewOrderService {

    fun order(orderNo: String){
        val inventoryWork = InventoryWork(orderNo)
        val shippingWork = ShippingWork(orderNo)
        val accountingWork = AccountingWork(orderNo)

        val es = Executors.newFixedThreadPool(10)
        val taskList = mutableListOf(inventoryWork, shippingWork, accountingWork)
        val futures = es.invokeAll(taskList)

        var cond = true
        futures.forEach { it ->
            val value = it.get()
            cond = cond && value
        }

        if(cond){
            log("모든 주문 처리가 성공적으로 완료 ")
        }else{
            log("일부 작업이 실패 ")
        }

        es.close()
    }

    class InventoryWork(
        val orderNo: String
    ) : Callable<Boolean> {
        override fun call(): Boolean{
            log("재고 업데이트 $orderNo")
            sleep(1000)
            return true
        }
    }

    class ShippingWork(
        val orderNo: String
    ) : Callable<Boolean>{
        override fun call(): Boolean{
            log("배송 시스템 알림 $orderNo")
            sleep(1000)
            return true
        }
    }

    class AccountingWork(
        val orderNo: String
    ) : Callable<Boolean>{
        override fun call(): Boolean{
            log("회계 시스템 업데이트 $orderNo")
            sleep(1000)
            return true
        }
    }
}