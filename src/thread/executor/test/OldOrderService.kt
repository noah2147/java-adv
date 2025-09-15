package thread.executor.test

import util.MyLogger.Companion.log
import util.ThreadUtils.Companion.sleep

class OldOrderService {

    fun order(orderNo: String){
        val inventoryWork = InventoryWork(orderNo)
        val shippingWork = ShippingWork(orderNo)
        val accountingWork = AccountingWork(orderNo)

        // 작업 요청
        if(inventoryWork.call() && shippingWork.call() && accountingWork.call()){
            log("모든 주문 처리가 성공적으로 완료 ")
        }else{
            log("일부 작업이 실패 ")
        }
    }

    class InventoryWork(
        val orderNo: String
    ){
        fun call(): Boolean{
            log("재고 업데이트 $orderNo")
            sleep(1000)
            return true
        }
    }

    class ShippingWork(
        val orderNo: String
    ){
        fun call(): Boolean{
            log("배송 시스템 알림 $orderNo")
            sleep(1000)
            return true
        }
    }

    class AccountingWork(
        val orderNo: String
    ){
        fun call(): Boolean{
            log("회계 시스템 업데이트 $orderNo")
            sleep(1000)
            return true
        }
    }
}