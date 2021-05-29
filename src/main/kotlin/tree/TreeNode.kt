package tree

import queue.ArrayListQueue

class TreeNode<T>(val value: T) {
    private val children: MutableList<TreeNode<T>> = mutableListOf()

    fun add(child: TreeNode<T>) = children.add(child)

    // depthFirstTraversal
    fun forEachDepthFirst(visit: Visitor<T>){
        visit(this)
        children.forEach {
            it.forEachDepthFirst(visit)
        }
    }
    // levelOrderTraversal
    fun forEachLevelOrder(visit: Visitor<T>) {
        visit(this)
        val queue = ArrayListQueue<TreeNode<T>>()
        children.forEach { queue.enqueue(it) }
        var node = queue.dequeue()
        while (node != null) {
            visit(node)
            node.children.forEach{queue.enqueue(it)}
            node = queue.dequeue()
        }
    }
}

typealias Visitor<T> = (TreeNode<T>) -> Unit