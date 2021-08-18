package trie

fun main() {
    "insert and contains" example {
        val trie = Trie<Char>()
        trie.insert("cute".toList())
        if (trie.contains("cute".toList())) {
            print("cute is in the trie")
        }
    }

    "prefix matching" example {
        val trie = Trie<Char>().apply {
            insert("car")
            insert("card")
            insert("care")
            insert("cared")
            insert("cars")
            insert("carbs")
            insert("carapace")
            insert("cargo")
        }
        println("\nCollections starting with \"car\"")
        val prefixedWithCar = trie.collections("car")
        println(prefixedWithCar)
        println("\nCollections starting with \"care\"")
        val prefixedWithCare = trie.collections("care")
        println(prefixedWithCare)
    }
}