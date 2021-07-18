package avlTree

import kotlin.math.max


class AVLTree<T> {
    private fun leftRotate(node: AVLNode<T>): AVLNode<T> {
        val pivot = node.rightChild!!
        node.rightChild = pivot.leftChild
        pivot.leftChild = node

        node.height = max(node.leftHeight, node.rightHeight) + 1
        pivot.height = max(pivot.leftHeight, pivot.rightHeight) + 1

        return pivot
    }

    private fun rightRotate(node: AVLNode<T>): AVLNode<T> {
        val pivot = node.rightChild!!
        node.leftChild = pivot.rightChild
        pivot.rightChild = node
        node.height = max(node.leftHeight, node.rightHeight) + 1
        pivot.height = max(pivot.leftHeight, pivot.rightHeight) + 1
        return pivot
    }

    private fun rightLeftRotate(node: AVLNode<T>): AVLNode<T> {
        val rightChild = node.rightChild ?: return node
        node.leftChild = rightRotate(rightChild)
        return leftRotate(node)
    }

    private fun leftRightRotate(node: AVLNode<T>): AVLNode<T> {
        val leftChild = node.leftChild ?: return node
        node.rightChild = leftRotate(leftChild)
        return rightRotate(node)
    }
}