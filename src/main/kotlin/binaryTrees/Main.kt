package binaryTrees

fun main() {
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
    println("---------------------")
    println(seven.findHeight(seven))
    println("---------------------")

    println(seven)
    val array = seven.serialize()
    println(array)
    println(seven.deserialize(array))
}