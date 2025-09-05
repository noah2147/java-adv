package thread.bounded

interface BoundedQueue {
    fun put(data: String)
    fun take(): String?
}