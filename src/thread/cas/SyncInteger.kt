package thread.cas

class SyncInteger(
    var value: Int = 0
) : IncrementInteger {

    @Synchronized
    override fun increment() {
        this.value++
    }
    @Synchronized
    override fun get(): Int = value
}