package queue

class RingBuffer<T>(size: Int) {
    private val list = arrayListOf<T>()
    fun write(element: T) {

    }

    fun read(): T? {
        return list.getOrNull(0)
    }

    val first: T? = null
    val count: Int = 0
}