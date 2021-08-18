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
        storedList.add(list)
    }

    fun contains(list: List<Key>): Boolean {
        var current = root
        list.forEach {
            val child = current.children[it] ?: return false
            current = child
        }
        return current.isTerminating
    }

    fun remove(collection: List<Key>) {
        var current = root
        collection.forEach {
            val child = current.children[it] ?: return
            current = child
        }

        if (!current.isTerminating) return

        current.isTerminating = false
//        storedList.remove(list)

        val parent = current.parent
        while (parent != null && current.children.isEmpty() && !current.isTerminating) {
            parent.children.remove(current.key)
            current = parent
        }
    }

    fun collections(prefix: List<Key>): List<List<Key>> {
        var current = root
        prefix.forEach {
            val child = current.children[it] ?: return emptyList()
            current = child
        }
        return collections(prefix, current)
    }

    private fun collections(prefix: List<Key>, node: TrieNode<Key>?): List<List<Key>> {
        val results = mutableListOf<List<Key>>()
        if (node?.isTerminating == true) {
            results.add(prefix)
        }
        node?.children?.forEach { (key, node) ->
            results.addAll(collections(prefix + key, node))
        }
        return results
    }

    private val storedList: MutableSet<List<Key>> = mutableSetOf()
    private val list: List<List<Key>>
        get() = storedList.toList()

    val count: Int
        get() = storedList.count()
    val isEmpty: Boolean
        get() = storedList.isEmpty()
}