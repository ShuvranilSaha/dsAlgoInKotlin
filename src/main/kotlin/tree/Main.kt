package tree

fun main() {
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
