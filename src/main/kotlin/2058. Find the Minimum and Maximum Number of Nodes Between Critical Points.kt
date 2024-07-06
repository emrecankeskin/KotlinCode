/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Q2058 {
    fun nodesBetweenCriticalPoints(head: ListNode?): IntArray {
        val ans = mutableListOf<Int>()
        var prev = head
        var ptr = head?.next
        var fast = ptr?.next
        var idx: Int = 1


        while (fast != null){

            if(ptr!!.`val` < prev!!.`val` && ptr.`val` < fast.`val` ||
                ptr.`val` > prev.`val` && ptr.`val` > fast.`val`){
                ans.add(idx)
            }
            idx++
            prev = ptr
            ptr = fast
            fast = fast.next

        }
        if(ans.size < 2) return intArrayOf(-1,-1)

        val mx = ans.last() - ans.first()
        var mn = Int.MAX_VALUE
        for(i in 1..ans.lastIndex){
            val dist = ans[i] - ans[i-1]
            mn = minOf(mn,dist)
        }

        return intArrayOf(mn,mx)
    }
}