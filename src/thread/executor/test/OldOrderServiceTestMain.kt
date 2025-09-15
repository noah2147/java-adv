package thread.executor.test

fun main() {
    val orderNo = "Order#1234"
    val orderService = OldOrderService()
    orderService.order(orderNo)
}