data class Node<T>(var value: T, var next: Node<T>? = null) {
    override fun toString(): String {
        return if (next != null) {
            "$value -> ${next.toString()}"
        } else {
            "$value"
        }
    }

    fun printInReverse() {
        this.next?.printInReverse()
        if (this.next != null) {
            print(" -> ")
        }
        print(this.value.toString())
    }
}