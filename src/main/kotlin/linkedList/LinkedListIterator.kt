package linkedList

class LinkedListIterator<T>(private val list: LinkedList<T>) : Iterator<T>, MutableIterator<T> {
    private var index = 0

    private var lastNode: Node<T>? = null

    override fun hasNext(): Boolean {
        return index < list.size
    }

    override fun remove() {
        if (index == 1) {
            list.pop()
        } else {
            val prevNode = list.insertNodeAt(index - 2) ?: return
            list.removeAfter(prevNode)
            lastNode = prevNode
        }
        index--
    }

    override fun next(): T {
        if (index >= list.size) throw IndexOutOfBoundsException()

        lastNode = if (index == 0) {
            list.insertNodeAt(0)
        } else {
            lastNode?.next
        }
        index++
        return lastNode!!.value
    }
}
