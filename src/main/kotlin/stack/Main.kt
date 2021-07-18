package stack

fun main() {
    // stack
    val stack = StackImpl<Int>().apply {
        push(1)
        push(2)
        push(3)
        push(4)
    }
    print(stack)
    val poppedElement = stack.pop()
    if (poppedElement != null) {
        println("popped:  $poppedElement")
    }
    print(stack)
}