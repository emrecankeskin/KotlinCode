import java.util.*

class Q1636 {
    fun frequencySort(nums: IntArray): IntArray {
        val result = IntArray(nums.size) { -1 }
        val pq = PriorityQueue(compareBy<IntArray> { it[1] }.thenBy { -it[0] })
        val mp = mutableMapOf<Int, Int>()
        var index = 0

        for(a in nums) {
            mp[a] = mp.getOrDefault(a,0) + 1
        }

        for((k,v) in mp) {
            pq.offer(intArrayOf(k,v))
        }

        while(pq.isNotEmpty()) {
            val curr = pq.poll()
            repeat(curr[1]) {
                result[index] = curr[0]
                index++
            }
        }

        return result
    }
}