package linkedList

fun main () {
    // linkedList test
    val list = LinkedList<Int>()
    list.push(3).push(2).push(1)
    println(" Before inserting $list")

    var middleNode = list.insertNodeAt(1)!!
    for (i in 1..3) {
        middleNode = list.insert(-1 * i, middleNode)
    }
    println("After inserting $list")

    val poppedValue = list.pop()
    println("After popping list: $list")
    println("popped Value $poppedValue")

    println("Before removing list $list")
    val removedValue = list.removeLast();
    println("after remove list: $list")
    println("remove value is $removedValue")


    println("before removing at particular index: $list")
    val index = 1;
    val node = list.insertNodeAt(index - 1)!!
    val removedParticular = list.removeAfter(node)

    println("After removing index $index: $list")
    println("particular removed value $removedParticular")

    val list2 = LinkedList<Int>().apply {
        push(3)
        push(2)
        push(1)
    }
    println(list2)

    for (item in list2) {
        println("Double ${item * 2}")
    }


    val list3: MutableCollection<Int> = LinkedList<Int>().apply {
        add(3)
        add(2)
        add(1)
    }
    println(list3)
    list3.remove(1)
    println(list3)

    val list4: MutableCollection<Int> = LinkedList<Int>().apply {
        add(3)
        add(2)
        add(1)
        add(4)
        add(5)
    }

    println(list4)
    list4.retainAll(listOf(3, 4, 5))
    println(list4)

    val list5: MutableCollection<Int> = LinkedList<Int>().apply {
        add(3)
        add(2)
        add(1)
        add(4)
        add(5)
    }

    println(list5)
    list5.removeAll(listOf(3, 4, 5))
    println(list5)

    val list6 = LinkedList<Int>()
    list6.add(3)
    list6.add(2)
    list6.add(1)
    list6.add(4)
    list6.add(5)

    println(list6)
    list6.printInReverse()

    val list7 = LinkedList<Int>().apply {
        add(3)
        add(2)
        add(1)
        add(4)
        add(5)
    }

    println(list7)
    println(list7.getMiddle()?.value)
}