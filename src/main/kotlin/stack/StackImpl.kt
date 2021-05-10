package stack

import java.util.*

class StackImpl<Element : Any> : Stack<Element> {
    private val storage = arrayListOf<Element>()

    override fun toString() = buildString {
        appendLine("------top----")
        storage.asReversed().forEach {
            appendLine("$it")
        }
        appendLine("--------")
    }

    override fun push(element: Element) {
        storage.add(element)
    }

    override fun pop(): Element? {
        if (isEmpty) {
            return null
        }
        return storage.removeAt(storage.size - 1)
    }

    override fun peek(): Element? {
        return storage.lastOrNull()
    }

    override val count: Int
        get() = storage.size

    companion object {
        fun <Element : Any> create(items: Iterable<Element>): Stack<Element> {
            val stack = StackImpl<Element>()
            for (item in items) {
                stack.push(item)
            }
            return stack
        }
    }

    fun <T : Any> LinkedList<T>.printInReverse() {
        val stack = StackImpl<T>()

        for (node in this) {
            stack.push(node)
        }
        var node = stack.pop()
        while (node != null) {
            println(node)
            node = stack.pop()
        }
    }

    fun String.checkParenthesis(): Boolean {
        val stack = StackImpl<Char>()

        for (character in this) {
            when (character) {
                '(' -> stack.push(character)
                ')' -> if (stack.isEmpty) {
                    return false
                } else {
                    stack.pop()
                }
            }
        }
        return stack.isEmpty
    }
}