

var li = ListNode(5)
var v = li.`val`

class ListNode(var `val`: Int) {
var next: ListNode? = null
}

class Q2181 {
    fun mergeNodes(head: ListNode?): ListNode? {
        var sum: Int = 0
        var ptr: ListNode? = head
        val ans: ListNode = ListNode(0)
        var ansPtr: ListNode = ans
        ptr = ptr?.next
        while(ptr != null){
            if(ptr.`val` == 0){
                ansPtr.next = ListNode(sum)
                ansPtr = ansPtr.next!!
                sum = 0
            }
            sum += ptr.`val`
            ptr = ptr.next
        }


        return ans.next
    }
}