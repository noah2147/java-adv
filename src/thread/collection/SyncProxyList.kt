package thread.collection

open class SyncProxyList (
    val target: SimpleList,
) : SimpleList{

    @Synchronized
    override fun size(): Int = target.size()

    @Synchronized
    override fun add(data: Any?) {
        target.add(data)
    }

    @Synchronized
    override operator fun get(index: Int): Any? = target.get(index)

    @Synchronized
    override fun toString(): String = target.toString()
}
