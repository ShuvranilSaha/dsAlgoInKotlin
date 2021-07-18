package binarySearchTrees

fun main() {
    // BinarySearchTree
    val bst = BinarySearchTree<Int>()
    (0..4).forEach {
        bst.insert(it)
    }
    println(bst)

    val exampleTree = BinarySearchTree<Int>().apply {
        insert(3)
        insert(1)
        insert(4)
        insert(0)
        insert(2)
        insert(5)
    }
    println("building Bst")
    println(exampleTree)

    if (exampleTree.contains(5)) {
        println("found")
    } else {
        println("not found")
    }

    println("Tree before removal")
    println(exampleTree)
    exampleTree.remove(3)
    println("after removal")
    println(exampleTree)
}