package binaryTrees

typealias Visitor<T> = (T) -> Unit

class BinaryNode<T>(private val value: T) {
    var leftChild: BinaryNode<T>? = null
    var rightChild: BinaryNode<T>? = null


    // inOrderTraversal
    fun traverseInOrder(visit: Visitor<T>) {
        leftChild?.traverseInOrder(visit)
        visit(value)
        rightChild?.traverseInOrder(visit)
    }

    // Pre-Order traversal
    fun traversePreOrder(visit: Visitor<T>) {
        visit(value)
        leftChild?.traversePreOrder(visit)
        rightChild?.traversePreOrder(visit)
    }

    // Post-Order traversal
    fun traversePostOrder(visit: Visitor<T>) {
        leftChild?.traversePostOrder(visit)
        rightChild?.traversePostOrder(visit)
        visit(value)
    }

    override fun toString() = diagram(this)

    private fun diagram(binaryNode: BinaryNode<T>?, top: String = "", root: String = "", bottom: String = ""): String {
        return binaryNode?.let {
            if (binaryNode.leftChild == null && binaryNode.rightChild == null) {
                "$root${binaryNode.value}\n"
            } else {
                diagram(binaryNode.rightChild, "$top ", "$top┌──", "$top│ ") +
                        root + "${binaryNode.value}\n" + diagram(
                    binaryNode.leftChild,
                    "$bottom│ ",
                    "$bottom└──",
                    "$bottom "
                )
            }
        } ?: "${root}null\n"
    }
}