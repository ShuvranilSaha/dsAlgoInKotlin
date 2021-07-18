package trie

class Trie<Key> {
    private val root = TrieNode<Key>(key = null, parent = null)

    fun insert(list: List<Key>) {
        var current = root
        list.forEach {
            if (current.children[it] == null) {
                current.children[it] = TrieNode(it, current)
            }
            current = current.children[it]!!
        }
        current.isTerminating = true
    }

    fun contains(list: List<Key>): Boolean {
        var current = root
        list.forEach {
            val child = current.children[it] ?: return false
            current = child
        }
        return current.isTerminating
    }
}