package trie

fun main() {
    "insert and contains" example {
        val trie = Trie<Char>()
        trie.insert("cute".toList())
        if (trie.contains("cute".toList())) {
            print("cute is in the trie")
        }
    }
}