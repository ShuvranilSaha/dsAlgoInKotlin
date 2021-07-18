package stack

interface Stack<Element> {
    fun push(element: Element)
    fun pop(): Element?
    fun peek(): Element?
    val count: Int
    val isEmpty: Boolean
        get() = count == 0
}
