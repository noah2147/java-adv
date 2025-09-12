package thread.collection

class SyncList: BasicList() {

    @Synchronized
    override fun size(): Int {
        return super.size()
    }

    @Synchronized
    override fun add(data: Any?) {
        super.add(data)
    }

    @Synchronized
    override fun get(index: Int): Any? {
        return super.get(index)
    }

    @Synchronized
    override fun toString(): String {
        return super.toString()
    }
}