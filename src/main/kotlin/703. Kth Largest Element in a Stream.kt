import java.util.PriorityQueue

class KthLargest(k: Int, nums: IntArray) {
    private val pq = PriorityQueue<Int>()
    private var k = 0
    init{
        this.k = k
        for(i in nums){
            add(i)
        }
    }

    fun add(`val`: Int): Int {
        // always keep k elements and first element is the kth biggest element
        if(pq.size < k){
            pq.offer(`val`)
        }else if (pq.peek() < `val`){
            // if it is bigger than smallest one change it
            pq.poll()
            pq.offer(`val`)
        }
        return pq.peek()
    }

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = KthLargest(k, nums)
 * var param_1 = obj.add(`val`)
 */