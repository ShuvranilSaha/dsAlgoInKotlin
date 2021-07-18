package avlTree

fun main() {
    "repeated insertion in sequence" example {
        val tree = AVLTree<Int>()
        (0..14).forEach {
            tree.insert(it)
        }
        print(tree)
    }
}