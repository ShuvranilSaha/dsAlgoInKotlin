package stack

import com.sun.org.apache.xpath.internal.operations.Bool

interface Stack<Element> {
    fun push(element: Element)
    fun pop(): Element?
    fun peek(): Element?
    val count: Int
        get
    val isEmpty: Boolean
        get() = count == 0
}
