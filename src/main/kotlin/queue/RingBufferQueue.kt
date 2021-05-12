package queue

class RingBufferQueue<T>(size: Int) : Queue<T> {
    private val ringBuffer: RingBuffer<T> = RingBuffer(size)
    override fun enqueue(element: T): Boolean {
        ringBuffer.write(element)
        return true
    }

    override fun dequeue(): T? = ringBuffer.first

    override val count: Int
        get() = ringBuffer.count

    override fun peek(): T? = if (isEmpty) null else ringBuffer.read()

    override fun toString(): String = ringBuffer.toString()

}