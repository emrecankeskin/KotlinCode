class Q1508 {
    fun rangeSum(nums: IntArray, n: Int, left: Int, right: Int): Int {
        val arr = LongArray((n*(n+1)) / 2){0}
        var ptr = 0
        var ans = 0L

        for(i in nums.indices){
            var count: Long = 0
            for(j in i until nums.size){
                count += nums[j]
                arr[ptr++] = count
            }
        }
        arr.sort()

        for(i in left-1 until right){
            ans += arr[i]
        }

        return ans.mod(1_000_000_007)
    }
}