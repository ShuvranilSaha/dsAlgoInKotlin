package avlTree

class AVLNode<T> {
    var leftChild: AVLNode<T>? = null
    var rightChild: AVLNode<T>? = null
    var height = 0
    val leftHeight: Int
        get() = leftChild?.height ?: -1
    val rightHeight: Int
        get() = rightChild?.height ?: -1

    val balanceFactor: Int
        get() = leftHeight - rightHeight

}