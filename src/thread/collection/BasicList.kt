package thread.collection

import util.ThreadUtils.Companion.sleep

open class BasicList (
    val capacity: Int = DEFAULT_CAPACITY,
    val elementData: Array<Any?> = Array(capacity){null},
    var size: Int = 0
) : SimpleList{

    override fun size(): Int = this.size

    override fun add(data: Any?) {
        elementData[this.size] = data
        sleep(100)
        this.size++
    }

    override operator fun get(index: Int): Any? = elementData[index]

    override fun toString(): String{
        val printString = """
            ${elementData.contentToString()}
            size: $size
            capacity: $capacity
        """.trimIndent()
        return printString
    }

    companion object{
        const val DEFAULT_CAPACITY = 5
    }
}
