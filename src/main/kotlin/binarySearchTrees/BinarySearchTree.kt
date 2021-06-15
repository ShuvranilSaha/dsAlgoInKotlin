package binarySearchTrees

import binaryTrees.BinaryNode

class BinarySearchTree<T : Comparable<T>>() {
    var root: BinaryNode<T>? = null
    override fun toString() = root?.toString() ?: "empty Tree"

    // Insert
    fun insert(value: T) {
        root = insert(root, value)
    }

    private fun insert(node: BinaryNode<T>?, value: T): BinaryNode<T> {
        node ?: return BinaryNode(value)
        if (value < node.value) {
            node.leftChild = insert(node.leftChild, value)
        } else {
            node.rightChild = insert(node.rightChild, value)
        }
        return node
    }

    // finding element
    fun contains(value: T): Boolean {
        root ?: return false
        var found = false
        root?.traverseInOrder {
            if (value == it) {
                found = true
            }
        }
        return found
    }
    /*
    1. Start by setting current to the root node.
    2. While current is not null , check the current node’s value.
    3. If the value is equal to what you’re trying to find, return true .
    4. Otherwise, decide whether you’re going to check the left or right child.
     */

    // optimized finding element
    fun optimizedContains(value: T): Boolean {
        var current = root
        while (current != null) {
            if (current.value == value) {
                return true
            }
            current = if (value < current.value) {
                current.leftChild
            } else {
                current.rightChild
            }
        }
        return false
    }
}