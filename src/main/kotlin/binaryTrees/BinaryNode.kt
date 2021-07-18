package binaryTrees

import kotlin.math.max

typealias Visitor<T> = (T) -> Unit

class BinaryNode<T: Comparable<T>>(var value: T) {
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

    // challenge 1: find the height of the tree
    fun findHeight(node: BinaryNode<T>? = this): Int {
        return node?.let {
            1 + max(findHeight(node.leftChild), findHeight(node.rightChild))
        } ?: -1
    }

    // challenge 2: serialization of binaryTree
    private fun traversePreOrderWithNull(visit: Visitor<T?>) {
        visit(value)
        leftChild?.traversePreOrderWithNull(visit) ?: visit(null)
        rightChild?.traversePreOrderWithNull(visit) ?: visit(null)
    }

    fun serialize(node: BinaryNode<T>? = this): MutableList<T?> {
        val list = mutableListOf<T?>()
        node?.traversePreOrderWithNull {
            list.add(it)
        }
        return list
    }

    // deserialize with timeComplexity O(n2)
    fun deserialize(list: MutableList<T?>): BinaryNode<T?>? {
        // 1
        val rootValue = list.removeAt(0) ?: return null
        // 2
        val root = BinaryNode<T?>(rootValue)
        root.leftChild = deserialize(list)
        root.rightChild = deserialize(list)
        return root
    }

    // fin min node in a tree
    val min: BinaryNode<T>
        get() = leftChild?.min ?: this

    val isBinarySearchTree: Boolean
        get() = isBst(this, min = null, max = null)

    private fun isBst(tree: BinaryNode<T>?, min: T?, max: T?): Boolean {
        tree ?: return true

        if (min != null && tree.value <= min) {
            // need to check
            return false
        } else if (max != null && tree.value > max) {
            // need to check
            return false
        }

        return isBst(tree.leftChild, min, tree.value) && isBst(tree.rightChild, tree.value, max)
    }

    override fun equals(other: Any?): Boolean {
        return if (other != null && other is BinaryNode<*>) {
            this.value == other.value && this.leftChild == other.leftChild && this.rightChild == other.rightChild
        } else {
            false
        }
    }

    override fun hashCode(): Int {
        var result = value.hashCode()
        result = 31 * result + (leftChild?.hashCode() ?: 0)
        result = 31 * result + (rightChild?.hashCode() ?: 0)
        result = 31 * result + min.hashCode()
        result = 31 * result + isBinarySearchTree.hashCode()
        return result
    }
}