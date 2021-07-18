package queue

fun main() {
    // queue
    val queue = ArrayListQueue<String>().apply {
        enqueue("Neil")
        enqueue("Abhishek")
        enqueue("Prasenjit")
    }
    println(queue)
    queue.dequeue()
    println(queue)
    println("Next up is ${queue.peek()}")

    val queue1 = RingBufferQueue<String>(10).apply {
        enqueue("Neil")
        enqueue("Abhishek")
        enqueue("Prasenjit")
    }

    println(queue1)
    queue1.dequeue()
    println(queue1)
    println("Next up: ${queue1.peek()}")

    val queue3 = StackQueue<String>().apply {
        enqueue("Prasenjit")
        enqueue("Abhishek")
        enqueue("Neil")
    }
    println(queue3)
    queue3.dequeue()
    println(queue3)
    println("Next up: ${queue3.peek()}")
}