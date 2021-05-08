package linkedList

import Node

class LinkedList<T> : Iterable<T>, Collection<T>, MutableIterable<T>, MutableCollection<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    override var size = 0
    override fun iterator(): MutableIterator<T> {
        return LinkedListIterator(this)
    }

    override fun add(element: T): Boolean {
        append(element)
        return true
    }

    override fun addAll(elements: Collection<T>): Boolean {
        for (element in elements) {
            append(element)
        }
        return true
    }

    override fun clear() {
        head = null
        tail = null
        size = 0
    }

    override fun remove(element: T): Boolean {
        val iterator = iterator()
        while (iterator.hasNext()) {
            val item = iterator.next()

            if (item == element) {
                iterator.remove()
                return true
            }
        }
        return false
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        var result = false
        for (element in elements) {
            result = remove(element) || result
        }
        return result
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        var result = false
        val iterator = this.iterator()
        while (iterator.hasNext()) {
            val item = iterator.next()
            if (!elements.contains(item)) {
                iterator.remove()
                result = true
            }
        }
        return result
    }

    override fun isEmpty(): Boolean {
        return size == 0
    }

    override fun toString(): String {
        return if (isEmpty()) {
            "Empty List"
        } else {
            head.toString()
        }
    }

    fun push(value: T): LinkedList<T> {
        head = Node(value = value, next = head)
        if (tail == null) {
            tail = head;
        }
        size++
        return this
    }

    fun append(value: T) {
        // 1
        /* Like before, if the list is empty, you’ll need to update both head and tail to the
           new node. Since append on an empty list is functionally identical to push , you
           invoke push to do the work for you.
        */
        if (isEmpty()) {
            push(value)
            return
        }
        // 2
        /* In all other cases, you create a new node after the current tail node. tail will
           never be null here because you’ve already handled the case where the list is
           empty in the if statement.
        */
        tail?.next = Node(value = value)
        // 3
        // Since this is tail-end insertion, your new node is also the tail of the list.
        tail = tail?.next
        size++
    }

    fun insertNodeAt(index: Int): Node<T>? {
        // 1
        var currentNode = head
        var currentIndex = 0
        // 2
        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode

    }

    fun insert(value: T, afterNode: Node<T>): Node<T> {
        /* In the case where this method is called with the tail node, you call the
functionally equivalent append method. This takes care of updating tail . */
        if (tail == afterNode) {
            append(value)
            return tail!!
        }
        /* Otherwise, you create a new node and link its next property to the next node of
the list. */
        val newNode = Node(value = value, next = afterNode.next)
        /* You reassign the next value of the specified node to link it to the new node that
you just created. */
        afterNode.next = newNode
        size++
        return newNode
    }

    fun pop(): T? {
        if (!isEmpty()) size--
        val result = head?.value
        head = head?.next

        if (isEmpty()) {
            tail = null
        }
        return result
    }

    fun removeLast(): T? {
        // If head is null , there’s nothing to remove, so you return null .
        val head = head ?: null
        /* If the list only consists of one node, removeLast is functionally equivalent to
           pop . Since pop will handle updating the head and tail references, you can
           delegate this work to the pop function.
        */
        if (head?.next == null) return pop()
        /* At this point, you know that you’ll be removing a node, so you update the size of
           the list accordingly.
        */
        size--

        var prev = head
        var current = head

        var next = current.next
        /* You keep searching for the next node until current.next is null . This signifies
           that current is the last node of the list.
        */
        while (next != null) {
            prev = current
            current = next
            next = current.next
        }
        /* Since current is the last node, you disconnect it using the prev.next reference.
           You also make sure to update the tail reference.
        */
        prev?.next = null
        tail = prev
        return current?.value
    }

    fun removeAfter(node: Node<T>): T? {
        val result = node.next?.value
        if (node.next == tail) {
            tail = node
        }

        if (node.next != null) {
            size--
        }
        node.next = node.next?.next
        return result
    }

    override fun contains(element: T): Boolean {
        for (item in this) {
            return item == element
        }
        return false
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        for (searched in elements) {
            if (!contains(searched))
                return false
        }
        return true
    }
}