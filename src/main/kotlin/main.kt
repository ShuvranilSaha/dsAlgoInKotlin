import binarySearchTrees.BinarySearchTree
import binaryTrees.BinaryNode
import linkedList.LinkedList
import linkedList.Node
import queue.ArrayListQueue
import queue.RingBufferQueue
import queue.StackQueue
import stack.StackImpl
import tree.TreeNode

fun main() {
    // node test
    val node1 = Node(value = 1)
    val node2 = Node(value = 2)
    val node3 = Node(value = 3)

    node1.next = node2
    node2.next = node3

    println(node1)
}