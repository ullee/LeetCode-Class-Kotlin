package utils

class ListNode(
    var `val`: Int = -1,
    var next: ListNode? = null
) {
    override fun toString(): String {
        return "$`val` -> ${next.toString()}"
    }

    fun toList(): List<Int> {
        val result = mutableListOf<Int>()
        var isFirstIndex = true
        fun recursion(node: ListNode?): List<Int> {
            if (isFirstIndex) {
                isFirstIndex = false
                node?.`val`?.also {
                    result.add(it)
                    recursion(node)
                }
            } else {
                node?.next?.also {
                    result.add(it.`val`)
                    recursion(it)
                } ?: return result
            }
            return result
        }
        return recursion(this)
    }

    companion object {
        fun from(nodes: List<Int>): ListNode {
            val node = ListNode()
            nodes.reversed().forEach {
                val temp = ListNode(it)
                temp.next = node.next
                node.next = temp
            }
            return node.next!!
        }
    }
}