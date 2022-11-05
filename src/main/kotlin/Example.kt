import utils.ListNode

fun main(args: Array<String>) {
    val mock = listOf(1, 2, 3)
    val listNode = ListNode.from(mock)
    println(listNode)
    val list = listNode.toList()
    println(list)
}