package thread.executor.test

fun main() {
    val orderNo = "Order#1234"
    val orderService = NewOrderService()
    orderService.order(orderNo)
}