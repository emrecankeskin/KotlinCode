import java.util.PriorityQueue

class Q912 {
    fun sortArray(nums: IntArray): IntArray {
        var ans = IntArray(nums.size)
        var ptr = 0
        val pq = PriorityQueue<Int>()
        nums.forEach { pq.offer(it) }

        while(pq.isNotEmpty()){
            ans[ptr++] = pq.poll()
        }
        return ans
    }
}