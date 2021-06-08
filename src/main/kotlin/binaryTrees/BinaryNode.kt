package binaryTrees

typealias Visitor<T> = (T) -> Unit

class BinaryNode<T>(val value: T) {
    var leftChild: BinaryNode<T>? = null
    var rightChild: BinaryNode<T>? = null

    override fun toString() = diagram(this)

    private fun diagram(binaryNode: BinaryNode<T>?, top: String = "", root: String = "", bottom: String = ""): String {
        return binaryNode?.let {
            if (binaryNode.leftChild == null && binaryNode.rightChild == null) {
                "$root${binaryNode.value}\n"
            } else {
                diagram(binaryNode.rightChild, "$top ", "$top┌──", "$top│ ")+
                        root + "${binaryNode.value}\n" + diagram(binaryNode.leftChild, "$bottom│ ", "$bottom└──", "$bottom ")
            }
        } ?: "${root}null\n"
    }
}