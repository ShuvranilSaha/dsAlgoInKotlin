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

    // linkedList test
    val list = LinkedList<Int>()
    list.push(3).push(2).push(1)
    println(" Before inserting $list")

    var middleNode = list.insertNodeAt(1)!!
    for (i in 1..3) {
        middleNode = list.insert(-1 * i, middleNode)
    }
    println("After inserting $list")

    val poppedValue = list.pop()
    println("After popping list: $list")
    println("popped Value $poppedValue")

    println("Before removing list $list")
    val removedValue = list.removeLast();
    println("after remove list: $list")
    println("remove value is $removedValue")


    println("before removing at particular index: $list")
    val index = 1;
    val node = list.insertNodeAt(index - 1)!!
    val removedParticular = list.removeAfter(node)

    println("After removing index $index: $list")
    println("particular removed value $removedParticular")

    val list2 = LinkedList<Int>()
    list2.push(3)
    list2.push(2)
    list2.push(1)

    println(list2)

    for (item in list2) {
        println("Double ${item * 2}")
    }


    val list3: MutableCollection<Int> = LinkedList()
    list3.add(3)
    list3.add(2)
    list3.add(1)

    println(list3)
    list3.remove(1)
    println(list3)

    val list4: MutableCollection<Int> = LinkedList()
    list4.add(3)
    list4.add(2)
    list4.add(1)
    list4.add(4)
    list4.add(5)

    println(list4)
    list4.retainAll(listOf(3, 4, 5))
    println(list4)

    val list5: MutableCollection<Int> = LinkedList()
    list5.add(3)
    list5.add(2)
    list5.add(1)
    list5.add(4)
    list5.add(5)

    println(list5)
    list5.removeAll(listOf(3, 4, 5))
    println(list5)

    val list6 = LinkedList<Int>()
    list6.add(3)
    list6.add(2)
    list6.add(1)
    list6.add(4)
    list6.add(5)

    println(list6)
    list6.printInReverse()

    val list7 = LinkedList<Int>()
    list7.add(3)
    list7.add(2)
    list7.add(1)
    list7.add(4)
    list7.add(5)

    println(list7)
    println(list7.getMiddle()?.value)

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

    // queue
    val queue = ArrayListQueue<String>().apply {
        enqueue("Neil")
        enqueue("Abhishek")
        enqueue("Prasenjit")
    }
    println(queue)
    queue.dequeue()
    println(queue)
    println("Next up is ${queue.peek()}")

    val queue1 = RingBufferQueue<String>(10).apply {
        enqueue("Neil")
        enqueue("Abhishek")
        enqueue("Prasenjit")
    }

    println(queue1)
    queue1.dequeue()
    println(queue1)
    println("Next up: ${queue1.peek()}")

    val queue3 = StackQueue<String>().apply {
        enqueue("Prasenjit")
        enqueue("Abhishek")
        enqueue("Neil")
    }
    println(queue3)
    queue3.dequeue()
    println(queue3)
    println("Next up: ${queue3.peek()}")

    // Tree
    val hot = TreeNode("Hot")
    val cold = TreeNode("cold")
    TreeNode("Beverages").run {
        add(hot)
        add(cold)
    }
    // depthFirstSearchTraversal
    val tree = makeBeverageTree()
    tree.forEachDepthFirst { println(it.value) }
    print("---------------------")
    println()
    tree.forEachLevelOrder { println(it.value) }

    print("--------------------")
    println()
    tree.search("ginger ale")?.let {
        println("Found node: ${it.value}")
    }
    println()
    tree.search("WKD blue")?.let {
        println("Found node: ${it.value}")
    } ?: println("could not find wkd blue")

    tree.printEachLevel()

    // Binary Trees
    val zero = BinaryNode(0)
    val one = BinaryNode(1)
    val five = BinaryNode(5)
    val seven = BinaryNode(7)
    val eight = BinaryNode(8)
    val nine = BinaryNode(9)

    seven.leftChild = one
    one.leftChild = zero
    one.rightChild = five
    seven.rightChild = nine
    nine.leftChild = eight

    println(seven)
    seven.traverseInOrder {
        println(it)
    }
    print("-------------------")
    println()
    seven.traversePreOrder {
        println(it)
    }
    print("-------------------")
    println()
    seven.traversePostOrder {
        println(it)
    }
}

fun makeBeverageTree(): TreeNode<String> {
    val tree = TreeNode("Beverages")

    val hot = TreeNode("hot")
    val cold = TreeNode("cold")
    val tea = TreeNode("tea")
    val coffee = TreeNode("coffee")
    val chocolate = TreeNode("cocoa")
    val blackTea = TreeNode("black")
    val greenTea = TreeNode("green")
    val chaiTea = TreeNode("chai")
    val soda = TreeNode("soda")
    val milk = TreeNode("milk")
    val gingerAle = TreeNode("ginger ale")
    val bitterLemon = TreeNode("bitter lemon")
    tree.add(hot)
    tree.add(cold)
    hot.add(tea)
    hot.add(coffee)
    hot.add(chocolate)
    cold.add(soda)
    cold.add(milk)
    tea.add(blackTea)
    tea.add(greenTea)
    tea.add(chaiTea)
    soda.add(gingerAle)
    soda.add(bitterLemon)

    return tree
}
