package thread.cas

class BasicInteger(
    var value: Int = 0
) : IncrementInteger {
    override fun increment() {
        this.value++
    }
    override fun get(): Int = value
}