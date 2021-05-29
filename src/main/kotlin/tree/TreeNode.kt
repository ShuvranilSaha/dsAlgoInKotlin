package tree

import queue.ArrayListQueue

class TreeNode<T>(val value: T) {
    private val children: MutableList<TreeNode<T>> = mutableListOf()

    fun add(child: TreeNode<T>) = children.add(child)

    // depthFirstTraversal
    fun forEachDepthFirst(visit: Visitor<T>) {
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
            node.children.forEach { queue.enqueue(it) }
            node = queue.dequeue()
        }
    }

    // search
    fun search(value: T): TreeNode<T>? {
        var result: TreeNode<T>? = null

        forEachLevelOrder {
            if (it.value == value) {
                result = it
            }
        }

        return result
    }

    // challenge
    /*
    Print the values in a tree in an order based on their level. Nodes belonging to the
    same level should be printed on the same line. For example, consider the following
    tree:

                                    15
                              1     17     20
                            1 5 0    2    5 7

        solution:
        1. You begin by initializing a Queue data structure to facilitate the level-order
        traversal. You also create nodesLeftInCurrentLevel to keep track of the
        number of nodes you’ll need to work on before you print a new line.
        2. Your level-order traversal continues until your queue is empty.
        3. Inside the first while loop, you begin by setting nodesLeftInCurrentLevel to
        the current elements in the queue.
        4. Using another while loop, you dequeue the first nodesLeftInCurrentLevel
        number of elements from the queue. Every element you dequeue is printed
        without establishing a new line. You also enqueue all the children of the node.
        5. At this point, you generate the new line using println() . In the next iteration,
        nodesLeftInCurrentLevel is updated with the count of
     */
    fun printEachLevel() {
        // 1
        val queue = ArrayListQueue<TreeNode<T>>()
        var nodesLeftInCurrentLevel = 0
        queue.enqueue(this)
        // 2
        while (queue.isEmpty.not()) {
            // 3
            nodesLeftInCurrentLevel = queue.count
            while (nodesLeftInCurrentLevel > 0) {
                //
                val node = queue.dequeue()
                node?.let {
                    print("${node.value}, ")
                    node.children.forEach { queue.enqueue(it) }
                    nodesLeftInCurrentLevel--
                } ?: break
            }
            // 5
            println()
        }
    }
}

typealias Visitor<T> = (TreeNode<T>) -> Unit