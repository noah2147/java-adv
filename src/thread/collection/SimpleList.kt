package thread.collection

interface SimpleList {
    fun size(): Int
    fun add(data: Any?)
    fun get(index: Int): Any?
}